var adminLoad = function(){

    $.get('AdminPanel.html', function (data) {
        $('#content_table').html(data);
    });

    //$("").html("Ябаааать");
};

var loadAddproductForm = function(){
    $.get('AddProductForm.html', function (data) {
        $('#body_table').html(data);
    });
};




