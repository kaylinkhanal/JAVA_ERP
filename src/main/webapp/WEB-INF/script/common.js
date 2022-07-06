function openPage(pageURL) {
    window.location.href = pageURL;
}

function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    let regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

function getEditor(classSelector) {
  $("."+classSelector).richText({
         code:false,
         imageUpload:true,
         fileUpload:true,
         fonts:true,
           fontList: ["Arial",
             "Arial Black",
             "Comic Sans MS",
             "Courier New",
             "Geneva",
             "Georgia",
             "Helvetica",
             "Impact",
             "Lucida Console",
             "Tahoma",
             "Times New Roman",
             "Verdana"
           ],
           fontColor:true,
           fontSize:true,
     });
}

function setStorage(key, value) {
    let existing = localStorage.getItem(key);
    if (existing) {
        localStorage.removeItem(key);
    }
    localStorage.setItem(key, value);
}

function getStorage(key) {
    return localStorage.getItem(key);
}

function removeStorage(key) {
    localStorage.removeItem(key);
}

function printDocument(response) {
    const pathname = window.location.href;
    const divContents = response;
        const popupWin = window.open('', '_blank', 'width=992,height=600,location=1,status=1,scrollbars=1,left=100px');
        // popupWin.document.open();
        popupWin.document.write('<!DOCTYPE html><html><head><meta charset="UTF-8"><title></title>' +
            '<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"  media="print">' +
            '</head><body onload="window.print()">');
        popupWin.document.write(divContents);
        popupWin.document.write('</body></html>');
    popupWin.document.close();
}

function setDate(date, selector) {
    let d = new Date(date)
    let dateString = d.getFullYear() + "-" + ("0"+(d.getMonth()+1)).slice(-2) + "-" +
        ("0" + d.getDate()).slice(-2) ;
    $("#"+selector).val(dateString);
}

