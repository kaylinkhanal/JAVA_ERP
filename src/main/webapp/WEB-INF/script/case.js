$(document).ready(function () {
    setDate('${caseDto.operatingDate}', 'operatingDate');
    setDate('${caseDto.proposalDate}', 'proposalDate');
    setDate('${caseDto.acceptanceDate}', 'acceptanceDate');
    setDate('${caseDto.validationDate}', 'validationDate');
    setDate('${caseDto.discardDate}', 'discardDate');
    setDate('${caseDto.closingDate}', 'closingDate');
    setDate('${caseDto.suspenseDate}', 'suspenseDate');
});
$('#close').click(function () {
    let tbody = $('#customerTable').children('tbody');
    tbody.empty();
    $('#keyword').val('');

});
// need to change search customer when changing this function
$('#select').click(function () {
    $("#searchModal").modal({
        backdrop: 'static',
        keyboard: false
    });
    $.ajax({
        url: "${${pageContext.request.contextPath}/cb}/customers",
        type: "GET",
        success: function (response) {
            let tbody = $('#customerTable').children('tbody');
            let table = tbody.length ? tbody : $('#customerTable');
            tbody.empty();
            response.forEach(function (element) {
                let customerName = element.companyName != null ? element.companyName : element.fullName;
                $('#customerName').val(customerName);
                $('#code').val(element.code);
                tbody.append('<tr value=' + element.customerId +'><td><input type="checkbox" id="selectedCustomer" value=' + element.customerId + '></td>' +
                    '<td>' + customerName + '</td><td>' + element.code + '</td><td>' + element.type + '</td></tr>');
            });
        },
        error: function (XMLHttpRequest) {
            console.error("Something went wrong");
        }
    });
    // $('#customerTable').DataTable({
    //     ajax: '${${pageContext.request.contextPath}/cb}/customers',
    //     columns: [
    //         { data: 'customerName' },
    //         { data: 'code' },
    //         { data: 'type' }
    //     ],
    // });
});

// need to change list customer when changing this function
$('#keyword').on("input", function () {
    let keyword = $('#keyword').val();
    let tbody = $('#customerTable').children('tbody');
    let table = tbody.length ? tbody : $('#customerTable');
    if (keyword) {
        $.ajax({
            url: "${${pageContext.request.contextPath}/cb}/searchCustomer?keyword=" + keyword,
            type: "GET",
            success: function (response) {
                tbody.empty();
                console.log(response.length)
                response.forEach(function (element) {
                    let customerName = element.companyName != null ? element.companyName : element.fullName;
                    tbody.append('<tr value=' + element.customerId +'><td>' +
                        '<input type="checkbox" id="selectedCustomer" class="selectedCustomer" ></td>' +
                        '<td>' + customerName + '</td>' +
                        '<td>' + element.code + '</td><td>' + element.type + '</td></tr>');
                });
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});

$(".table").on('click', 'tr', function (e) {
    $('#contactPerson').empty().append('<option selected="selected" value="">Choose...</option>');
    e.preventDefault();
    let id = $(this).attr('value');
    if (id) {
        $.ajax({
            url: "${${pageContext.request.contextPath}/cb}/findCustomer/" + id,
            type: "GET",
            success: function (response) {
                let customerName = response.companyName != null ? response.companyName: response.fullName;
                $("#searchModal .close").click();
                $('#code').html(response.code);
                // $('#customer').html(response.customerId);
                $('input[name="customer"]').val(response.customerId);
                $('#customerName').html(customerName);
                $('#customerInput').val(customerName);
                let select = document.getElementById("contactPerson");
                let contactPerson = response.contactPerson
                contactPerson.forEach(function (element) {
                    let opt = element.contactName
                    let el = document.createElement("option");
                    el.textContent = opt;
                    el.value = element.contactPersonId;
                    select.appendChild(el);
                });
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});

function filterCase() {
    let keyword = $("#searchKeyword").val();
    if (keyword) {
        let tbody = $('#caseTable').children('tbody');
        $.ajax({
            url: "${${pageContext.request.contextPath}/cb}/case/searchCase?keyword=" + keyword,
            type: "GET",
            success: function (response) {
                tbody.empty();
                response.forEach(function (element) {
                    let customerName = element.customer.companyName != null ? element.customer.companyName : element.customer.fullName;
                    tbody.append('<tr><td>' + element.caseId + '</td>' +
                            '<td>' + element.customer.code + '</td>' +
                            '<td>' + element.title + '</td>' +
                            '<td>' + customerName + '</td>' +
                            '<td>' + element.contactPerson.contactName + '</td>' +
                            '<td></td>' +
                            '<td>' + element.status + '</td>' +

                        '</tr>');
                });
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
}
