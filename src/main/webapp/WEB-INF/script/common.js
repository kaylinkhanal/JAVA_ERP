function openPage(pageURL) {
    window.location.href = pageURL;
}

function getEditor(classSelector) {
  $("."+classSelector).richText({
         code:false,
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
    var existing = localStorage.getItem(key);
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

function previewDocument(selector, size) {
    const pathname = window.location.href;
    const divContents = $(selector).val();
    if (size) {
        const popupWin = window.open('', '_blank', 'width=992,height=600,location=1,status=1,scrollbars=1,left=100px');
        // popupWin.document.open();
        popupWin.document.write('<!DOCTYPE html><html><head><meta charset="UTF-8"><title></title>' +
            '<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"  media="print">' +
            '</head><body onload="window.print()">');
        popupWin.document.write(divContents);
        popupWin.document.write('</body></html>');
    } else {
        const popupWin = window.open('', '', 'width=100,height=100,location=1,status=1,scrollbars=1,left=100px');
        // popupWin.document.open();
        popupWin.document.write('<!DOCTYPE html><html><head><meta charset="UTF-8"><title></title>' );
        popupWin.document.write(divContents);
        popupWin.document.write('</body></html>');
    }
    popupWin.document.close();
}

