
function changeContentType(id) {
    var textArea = document.getElementById('textArea_'.concat(id));
    var table = document.getElementById('table_'.concat(id));

    var selectedContentType = document.getElementById('contentSelector_'.concat(id)).value;

    if (selectedContentType == 1) {         // table selected
        textArea.style.display = "none";
        table.style.display = "block";
    } else if (selectedContentType == 0) {  // textArea selected
        table.style.display = "none";
        textArea.style.display = "block";
    }
}