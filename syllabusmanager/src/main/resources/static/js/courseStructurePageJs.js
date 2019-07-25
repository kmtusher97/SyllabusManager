
function loadFormData() {
    var courseContentTableRowCount = document.getElementById("courseContentTable").rows.length;

    var contentBundleList = [];

    for(var i = 0; i < courseContentTableRowCount - 1; i++) {
        var textArea = {
            title : $('#textArea_'.concat(i, '_field1Name')).val(),
            textBody : "Empty Text Body"
        };

        var fields = [];
        var countOfFieldNamesOfTable = document.getElementById('table_'.concat(i, 'FieldNameTable')).rows[0].cells.length;

        for(var j = 0; j < countOfFieldNamesOfTable; j++) {
            var tableContentFieldName = $('#contentTable'.concat(i, 'FieldName', j)).val();
            fields.push(tableContentFieldName);
        }

        var table = {
            title : $('#table_'.concat(i, '_field1Name')).val(),
            fields : fields,
            rows : []
        };

        var contentBundle = {
            selected : $('#contentSelector_'.concat(i)).val(),
            textArea : textArea,
            table : table
        };

        contentBundleList.push(contentBundle);
    }

    var courseStructure = {
        name : $("#courseStructureName").val(),
        contentBundleList : contentBundleList
    };

    return courseStructure;
}



function changeContentType(id) {
    var textArea = document.getElementById('textArea_'.concat(id));
    var table = document.getElementById('table_'.concat(id));

    var selectedContentType = document.getElementById('contentSelector_'.concat(id)).value;

    if (selectedContentType == 1) {         // table selected
        textArea.style.display = "none";
        table.style.display = "block";
    }
    else if (selectedContentType == 0) {  // textArea selected
        table.style.display = "none";
        textArea.style.display = "block";
    }
}

$(document).ready(function() {

    $("#courseStructureDesignForm").on("change", function() {
        postViaAjax();
    });

    function postViaAjax() {
        var courseStructure = loadFormData();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/cs/autoSave",
            data : JSON.stringify(courseStructure),
            dataType : 'json'
        });
    }
})