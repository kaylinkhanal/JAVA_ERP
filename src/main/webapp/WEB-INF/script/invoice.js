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
    let tbody = $('#customerTable').children('tbody');
    $.ajax({
        url: "${pageContext.request.contextPath}/customers",
        type: "GET",
        success: function(response) {
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

$('#addItem').click(function () {
    $("#itemSearchModal").modal({
        backdrop: 'static',
        keyboard: false
    });
    $.ajax({
        url: "${pageContext.request.contextPath}/invoice/itemList",
        type: "GET",
        success: function (response) {
            let tbody = $('#itemTable').children('tbody');
            let table = tbody.length ? tbody : $('#itemTable');
            tbody.empty();
            response.forEach(function (element) {
                tbody.append('<tr value=' + element.itemId +'><td><input type="checkbox" id="selectedItem" value=' + element.itemId + '></td>' +
                    '<td>' + element.itemId + '</td><td>' + element.itemName + '</td><td>' + element.itemPartName + '</td></tr>');
            });
        },
        error: function (XMLHttpRequest) {
            console.error("Something went wrong");
        }
    });
});

$('#addDeposit').click(function () {
    $("#depositSearchModal").modal({
        backdrop: 'static',
        keyboard: false
    });
    let caseId = getParameterByName('caseId');
    $.ajax({
        url: "${pageContext.request.contextPath}/invoice/depositList?caseId="+caseId,
        type: "GET",
        success: function (response) {
            let tbody = $('#depositTable').children('tbody');
            let table = tbody.length ? tbody : $('#depositTable');
            tbody.empty();
            response.forEach(function (element) {
                tbody.append('<tr value=' + element.depositId +'><td><input type="checkbox" id="selectedItem" value=' + element.depositId + '></td>' +
                    '<td>' + element.depositId + '</td><td>' + element.depositTitle + '</td><td>' + element.caseRemark + '</td></tr>');
            });
        },
        error: function (XMLHttpRequest) {
            console.error("Something went wrong");
        }
    });
});


$('#addInstallment').click(function () {
    $("#installmentSearchModal").modal({
        backdrop: 'static',
        keyboard: false
    });
    let caseId = getParameterByName('caseId');
    console.log(caseId)
    $.ajax({
        url: "${pageContext.request.contextPath}/invoice/installmentList?caseId="+caseId,
        type: "GET",
        success: function (response) {
            let tbody = $('#installmentTable').children('tbody');
            let table = tbody.length ? tbody : $('#installmentTable');
            tbody.empty();
            response.forEach(function (element) {
                tbody.append('<tr value=' + element.installmentId +'><td><input type="checkbox" id="selectedItem" value=' + element.installmentId + '></td>' +
                    '<td>' + element.installmentId + '</td><td>' + element.installmentTitle + '</td><td>' + element.installmentNumber + '</td></tr>');
            });
        },
        error: function (XMLHttpRequest) {
            console.error("Something went wrong");
        }
    });
});

$("#itemTable").on('click', 'tr', function (e) {
    e.preventDefault();
    let id = $(this).attr('value');
    console.log(id)
    if (id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/invoice/findItem/" + id,
            type: "GET",
            success: function (response) {
                $("#itemSearchModal .close").click();
                $("#itemDiv").css('display', 'block')
                $('#itemName').html(response.itemName);
                $('#item').html(response.itemId);
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});

$("#itemClose").click(function () {
    $("#item").css('display', 'none')
});
$("#installmentClose").click(function () {
    $("#installment").css('display', 'none')
});
$("#depositClose").click(function () {
    $("#deposit").css('display', 'none')
});

$("#installmentTable").on('click', 'tr', function (e) {
    e.preventDefault();
    let id = $(this).attr('value');
    if (id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/invoice/findInstallment/" + id,
            type: "GET",
            success: function (response) {
                $("#installmentSearchModal .close").click();
                $('#installmentTitle').html(response.installmentTitle);
                $("#installment").css('display', 'block')
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});

$("#depositTable").on('click', 'tr', function (e) {
    e.preventDefault();
    let id = $(this).attr('value');
    console.log(id)
    if (id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/invoice/findDeposit/" + id,
            type: "GET",
            success: function (response) {
                $("#depositSearchModal .close").click();
                $('#depositTitle').html(response.depositTitle);
                $("#deposit").css('display', 'block')
            },
            error: function (XMLHttpRequest) {
                console.error("Something went wrong");
            }
        });
    }
});