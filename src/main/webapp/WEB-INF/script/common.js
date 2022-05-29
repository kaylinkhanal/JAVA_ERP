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

function covertHtmlToPdf() {
  var pdf = new jsPDF();
  pdf.text(5, 5, 'You figure out formatting');
  pdf.text(30, 30, 'Name: '+ name_val);
  pdf.text(60, 60, 'Emp ID: '+ empid_val);
  pdf.text(90, 90, 'Age: '+ age_val);
  pdf.save('hello_world.pdf');
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

