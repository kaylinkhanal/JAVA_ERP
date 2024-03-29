// $("#documentType").change(function () {
//     $('#documentTemplate').empty().append('<option selected="selected" value="">Choose...</option>');
//     $("#documentPreview").css('visibility', 'hidden')
//     let documentType = $("#documentType").val();
//     if (documentType) {
//         $.ajax({
//             url: "${${pageContext.request.contextPath}/cb}/document/findDocumentTemplates/"+documentType,
//             type: "GET",
//             success: function (response) {
//                 let select = document.getElementById("documentTemplate");
//                 response.forEach(function (element) {
//                     let opt = element.documentName
//                     let el = document.createElement("option");
//                     el.textContent = opt;
//                     el.value = element.documentId;
//                     select.appendChild(el);
//                 });
//             },
//             error:  function(XMLHttpRequest) {
//                 console.error("Something went wrong");
//             }
//         });
//     }
// });
//
// $("#documentTemplate").change(function () {
//     $("#documentPreview").css('visibility', 'hidden')
//     let documentType = $("#documentType").val();
//     let documentTemplate = $("#documentTemplate").val();
//     if (documentType && documentTemplate) {
//         $.ajax({
//             url: "${${pageContext.request.contextPath}/cb}/document/getTemplate/"+ documentTemplate+"/" +documentType,
//             type: "GET",
//             success: function (response) {
//                 const documentDiv = document.querySelector('#documentPreview');
//                 documentDiv.innerHTML = response
//                 $("#documentPreview").css('visibility', 'visible')
//                 $("#documentPreview").css('border', '1px solid black')
//             },
//             error:  function(XMLHttpRequest) {
//                 console.error("Something went wrong");
//             }
//         });
//     }
// });

// function previewDocument() {
//     let executorName = $("#executorName").val();
//     let nationality = $("#nationality").val();
//     let contactNumber = $("#contactNumber").val();
//     let dateOfBirth = $("#dateOfBirth").val();
//     let documentType = $("#documentType").val();
//     let documentTemplate = $("#documentTemplate").val();
//     let passportNumber = $("#passportNumber").val();
//     let effectiveDateFrom = $("#effectiveDateFrom").val();
//     let effectiveDateTo = $("#effectiveDateTo").val();
//     let address = $("#address").val();
//     if (documentType && documentTemplate && address && effectiveDateTo && effectiveDateFrom &&
//         passportNumber && dateOfBirth && contactNumber && nationality && executorName) {
//         $.ajax({
//             url: "${${pageContext.request.contextPath}/cb}/document/printTemplate",
//             type: "POST",
//             data: {
//                 executorName: executorName,
//                 nationality: nationality,
//                 contactNumber: contactNumber,
//                 dateOfBirth: dateOfBirth,
//                 passportNumber: passportNumber,
//                 effectiveDateFrom: effectiveDateFrom,
//                 effectiveDateTo: effectiveDateTo,
//                 address: address,
//                 documentId: documentTemplate
//             },
//             success: function (response) {
//                 printDocument(response)
//             },
//             error:  function(XMLHttpRequest) {
//                 console.error("Something went wrong");
//             }
//         });
//     } else {
//         alert("Fields are empty")
//     }
// }

// function caseDocumentPreview(caseId) {
//     debugger
//     let documentTemplateId = $('#document').val();
//     openPage("${${pageContext.request.contextPath}/cb}/document/caseDocumentPreview?caseId="+caseId+"&templateId="+documentTemplateId);
// }

// function previewDocument() {
//     let executorName = "${caseDto.customer.fullName != null ? caseDto.customer.fullName : caseDto.customer.companyName  }";
//     let nationality = "${caseDto.customer.address.country.countryName}";
//     let contactNumber = "${caseDto.customer.address.phone1}";
//     let dateOfBirth = "${caseDto.customer.dateOfBirth}";
//     let passportNumber = "${caseDto.customer.idPassportNo}";
//     // let effectiveDateFrom = $("#effectiveDateFrom").val();
//     // let effectiveDateTo = $("#effectiveDateTo").val();
//     let address = "${caseDto.customer.address.addressNo}";
//     $.ajax({
//         url: "${${pageContext.request.contextPath}/cb}/document/printTemplate",
//         type: "POST",
//         data: {
//             executorName: executorName,
//             nationality: nationality,
//             contactNumber: contactNumber,
//             dateOfBirth: dateOfBirth,
//             passportNumber: passportNumber,
//             // effectiveDateFrom: effectiveDateFrom,
//             // effectiveDateTo: effectiveDateTo,
//             address: address,
//             documentId: documentTemplate
//         },
//         success: function (response) {
//             printDocument(response)
//         },
//         error:  function(XMLHttpRequest) {
//             console.error("Something went wrong");
//         }
//     });
// }
    //     url: "${${pageContext.request.contextPath}/cb}/document/caseDocumentPreview?caseId="+caseId+"&templateId="+documentTemplateId,
    //     type: "GET",
    //     success: function () {
    //         debugger
    //         alert("success")
    //     },
    //     error:  function(XMLHttpRequest) {
    //         console.error("Something went wrong");
    //     }
    // });
    // openPage("${${pageContext.request.contextPath}/cb}/document/caseDocumentPreview?caseId="+caseId+"&templateId="+documentTemplateId);


function previewDocument() {
    let executorName = "${caseDto.customer.fullName != null ? caseDto.customer.fullName : caseDto.customer.companyName  }";
    let nationality = "${caseDto.customer.address.get(0).country.countryName}";
    let contactNumber = "${caseDto.customer.address != null ? caseDto.customer.address.get(0).phone1 : caseDto.customer.site.get(0).phone1}";
    let dateOfBirth = "${caseDto.customer.dateOfBirth != null ? caseDto.customer.dateOfBirth : caseDto.customer.registerDate}";
    let passportNumber = "${caseDto.customer.idPassportNo != null ? caseDto.customer.idPassportNo : caseDto.customer.taxId}";
    let email = "${caseDto.customer.email != null ? caseDto.customer.email : caseDto.customer.website}";
    let caseId = "${caseDto.caseId}";
    // let effectiveDateFrom = $("#effectiveDateFrom").val();
    // let effectiveDateTo = $("#effectiveDateTo").val();
    let address = "${caseDto.customer.address != null ? caseDto.customer.address.get(0).addressNo : caseDto.customer.site.get(0).address}";
    $.ajax({
        url: "${${pageContext.request.contextPath}/cb}/document/printTemplate",
        type: "POST",
        data: {
            caseId: caseId,
            executorName: executorName,
            nationality: nationality,
            contactNumber: contactNumber,
            dateOfBirth: dateOfBirth,
            passportNumber: passportNumber,
            email: email,
            // effectiveDateFrom: effectiveDateFrom,
            // effectiveDateTo: effectiveDateTo,
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
}

function printBlankDocument(documentId) {
    $.ajax({
        url: "${${pageContext.request.contextPath}/cb}/document/printTemplate/",
        type: "POST",
        data: {
            documentId: documentId
        },
        success: function (response) {
            if (response) {
                printDocument(response)
            } else alert("Something went wrong")
        },
        error:  function(XMLHttpRequest) {
            console.error("Something went wrong");
        }
    });
}