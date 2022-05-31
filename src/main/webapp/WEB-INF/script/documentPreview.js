$("#documentType").change(function () {
    let documentType = $("#documentType").val();
    if (documentType) {
        $.ajax({
            url: "${pageContext.request.contextPath}/document/findDocumentTemplates/"+documentType,
            type: "GET",
            success: function (response) {
                $('#documentTemplate').empty().append('<option selected="selected" value="">Choose...</option>');
                let select = document.getElementById("documentTemplate");
                response.forEach(function (element) {
                    let opt = element.documentName
                    let el = document.createElement("option");
                    el.textContent = opt;
                    el.value = element.documentId;
                    select.appendChild(el);
                });
            },
            error:  function(XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});

$("#documentTemplate").change(function () {
    let documentType = $("#documentType").val();
    let documentTemplate = $("#documentTemplate").val();
    if (documentType && documentTemplate) {
        $.ajax({
            url: "${pageContext.request.contextPath}/document/getTemplate/"+ documentTemplate+"/" +documentType,
            type: "GET",
            success: function (response) {
                const documentDiv = document.querySelector('#documentPreview');
                documentDiv.innerHTML = response
                $("#documentPreview").css('visibility', 'visible')
                $("#documentPreview").css('border', '1px solid black')
            },
            error:  function(XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});

function previewDocument() {
    let executorName = $("#executorName").val();
    let nationality = $("#nationality").val();
    let contactNumber = $("#contactNumber").val();
    let dateOfBirth = $("#dateOfBirth").val();
    let documentType = $("#documentType").val();
    let documentTemplate = $("#documentTemplate").val();
    let passportNumber = $("#passportNumber").val();
    let effectiveDateFrom = $("#effectiveDateFrom").val();
    let effectiveDateTo = $("#effectiveDateTo").val();
    let address = $("#address").val();
    if (documentType && documentTemplate && address && effectiveDateTo && effectiveDateFrom &&
        passportNumber && dateOfBirth && contactNumber && nationality && executorName) {
        $.ajax({
            url: "${pageContext.request.contextPath}/document/printTemplate",
            type: "POST",
            data: {
                executorName: executorName,
                nationality: nationality,
                contactNumber: contactNumber,
                dateOfBirth: dateOfBirth,
                passportNumber: passportNumber,
                effectiveDateFrom: effectiveDateFrom,
                effectiveDateTo: effectiveDateTo,
                address: address,
                documentId: documentTemplate
            },
            success: function (response) {
                printDocument(response)
            },
            error:  function(XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    } else {
        alert("Fields are empty")
    }
}