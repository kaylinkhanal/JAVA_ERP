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

