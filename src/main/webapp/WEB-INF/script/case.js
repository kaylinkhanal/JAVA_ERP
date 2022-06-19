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
        url: "${pageContext.request.contextPath}/customers",
        type: "GET",
        success: function (response) {
            response.forEach(function (element) {
                let customerName = element.companyName != null ? element.companyName : element.firstName +' ' + element.lastName;
                $('#customerName').val(customerName);
                $('#code').val(element.code);

                let tbody = $('#customerTable').children('tbody');
                let table = tbody.length ? tbody : $('#customerTable');
                tbody.append('<tr value=' + element.customerId +'><td><input type="checkbox" id="selectedCustomer" value=' + element.customerId + '></td>' +
                    '<td>' + customerName + '</td><td>' + element.code + '</td><td>' + element.type + '</td></tr>');
            });
        },
        error: function (XMLHttpRequest) {
            console.error("Something went wrong");
        }
    });
});

// need to change list customer when changing this function
$('#keyword').on("input", function () {
    let keyword = $('#keyword').val();
    let tbody = $('#customerTable').children('tbody');
    let table = tbody.length ? tbody : $('#customerTable');
    if (keyword) {
        $.ajax({
            url: "${pageContext.request.contextPath}/searchCustomer?keyword=" + keyword,
            type: "GET",
            success: function (response) {
                tbody.empty();
                response.forEach(function (element) {
                    let customerName = element.companyName != null ? element.companyName : element.firstName +' ' + element.lastName;
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
    e.preventDefault();
    let id = $(this).attr('value');
    if (id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/findCustomer/" + id,
            type: "GET",
            success: function (response) {
                let customerName = response.companyName != null ? response.companyName: response.firstName +' ' + response.lastName;
                $("#searchModal .close").click();
                $('#code').html(response.code);
                // $('#customer').html(response.customerId);
                $('input[name="customer"]').val(response.customerId);
                $('#customerName').html(customerName);
                $('#customerInput').val(customerName);
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});