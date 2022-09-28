$(document).ready(function() {
    $('input[type="file"]').change(function(e) {
        var file = e.target.files[0].name;
        $("#documentName").val(file)
        console.log(file)
    });
});
$("#boxTable").on("click", "#selectButton", function() {
    let tbody = $('#bookingTable').children('tbody');
    let currentRow=$(this).closest("tr");
    let col1 = currentRow.find("td:eq(0)").text();
    let col2 = currentRow.find("td:eq(1)").text();
    let col3 = currentRow.find("td:eq(2)").text();
    let col4 = currentRow.find("td:eq(3)").text();
    let data = '    <tr class="item">\n' +
        '        <td class="name">'+col1+'</td>\n' +
        '        <td class="name">'+col2+'</td>\n' +
        '        <td class="name">'+col3+'</td>\n' +
        '        <td class="name">'+col4+'</td>\n' +
        '        <td>\n' +
        '            <button class="btn btn-info" id="removeButton">Remove</button>\n' +
        '        </td>\n' +
        '    </tr>';
    $(this).closest("tr").remove();
    // tbody.append(data);
    $('#bookingTable tr:last').after(data);
});

$("#bookingTable").on("click", "#removeButton", function() {
    $(this).closest("tr").remove();
});

$("#bookingForm").submit(async function(e) {
    if ($("#bookingTable tr.item").length == 0) {
        alert("Booking details can not be empty")
    } else {
        let booking = new Object();
        let bookingDetails = [];

        e.preventDefault(); // prevent actual form submit
        let formData = new FormData();
        let caseId = getParameterByName('caseId');
        let document = fileupload.files[0];
        if (document) {
            let documentName = fileupload.files[0].name;
            formData.append("document", document);
            formData.append("documentName", documentName);
        }
        console.log(booking)
        formData.append("caseId", caseId);
        formData.append("branch", $("#branch").val())
        formData.append("location", $("#location").val())
        // formData.append("bookingDetails", bookingDetails)
        const jsonData = JSON.stringify(bookingDetails);
        $.ajax({
            url: "${${pageContext.request.contextPath}/cb}/booking/save",
            enctype: 'multipart/form-data',
            type: "POST",
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: async function (response) {
                console.log(response)
                $("#bookingTable tr.item").each(function() {
                    debugger
                    let currentRow=$(this).closest("tr");
                    let dto = new Object();
                    dto.status = currentRow.find("td:eq(0)").text();
                    dto.bookingNumber = currentRow.find("td:eq(1)").text();
                    dto.size = currentRow.find("td:eq(2)").text();
                    dto.type = currentRow.find("td:eq(3)").text();
                    dto.bookingId = response
                    dto.caseId = caseId
                    bookingDetails.push(dto)
                    console.log(dto)
                });
                const jsonData = JSON.stringify(bookingDetails);
                if (bookingDetails.length !== 0) {
                    $.ajax({
                        url: "${${pageContext.request.contextPath}/cb}/booking/saveDetail",
                        type: "POST",
                        data: jsonData,
                        contentType: "application/json",
                        success: async function (response) {
                            console.log(response)
                            openPage("${${pageContext.request.contextPath}/cb}/case/list");
                        },
                        error: function (XMLHttpRequest) {
                            console.error("Something went wrong");
                        }
                    });
                }

            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }

});

function jsonToFormData(data) {
    const formData = new FormData();

    buildFormData(formData, data);

    return formData;
}

function buildFormData(formData, data, parentKey) {
    if (data && typeof data === 'object' && !(data instanceof Date) && !(data instanceof File)) {
        Object.keys(data).forEach(key => {
            buildFormData(formData, data[key], parentKey ? `${parentKey}[${key}]` : key);
        });
    } else {
        const value = data == null ? '' : data;

        formData.append(parentKey, value);
    }
}
