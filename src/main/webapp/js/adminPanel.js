var adminLoad = function(){

    $.get('AdminPanel.html', function (data) {
        $('#content_table').html(data);
    });
};

var loadContent = function(loadForm){
    $.get(loadForm, function (data) {
        $('#body_table').html(data);
    });
};

var  addProvider = function () {
    $("#id").val(id);
    $("#token").val(token);

    var auth = $('#addProviderForm');
    var msg   = auth.serialize();
    $.ajax({
        type: 'POST',
        url: '/shop/addProvider',
        data: msg,
        success: function(data) {

            response=data;
            //location.reload();
        },
        error:  function(xhr, str){
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
};





