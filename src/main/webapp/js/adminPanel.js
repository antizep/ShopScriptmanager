var adminLoad = function(){

    $.get('./html/AdminPanel.html', function (data) {
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
        url: '/addProvider',
        data: msg,
        success: function(data) {

            response=data;
            //location.reload();
        },
        error:  function(xhr, str){
            console.log('Возникла ошибка: ' + xhr.responseCode);
        }
    });
};


var addProviderFormProduct = function () {

        var providers =selectProvider();
      //  console.log(selectProvider());
        providers.forEach(function(item, i, arr) {
            var name = item.name;
            var minPay = item.minPay;
            var url = item.url;
            var id = item.id;
            $("#providers").prepend( $('<option value='+id+'>'+name+'|'+minPay+'|'+url+'</option>') );
            //console.log( name+minPay+url+id);
        });
};

var generateTableAllProviderTable = function () {
    var providers = selectProvider();

    providers.forEach(function(item, i, arr) {
        var name = item.name;
        var minPay = item.minPay;
        var url = item.url;
        var id = item.id;
        var remark = item.remark;
        $("#providerTable").append("<tr></tr>");
        $('#providerTable > tbody > tr:last').append(
            '<td>'+id+'</td>' +
            '<td>'+name+'</td>'+
            '<td>'+minPay+'</td>'+
            '<td>'+url+'</td>'+
            '<td>'+remark+'</td>'
        );
    });

};

var selectProvider = function () {
    var rsp;
    $.ajax({
        url: "/SelectProviders",
        async:false,


        type: "POST",
        data: "id="+id+"&token="+token,
        success: function (data) {
            if(data.authentication) {
                rsp = data;

            }else {
                logout()
            }
        },
        error: function (xhr, str) {
            console.log("что то пошло не так")
        },
        dataType: "json"
    });
    return rsp.providers;
};

var resizeCardProduct = function(){
    $('.container').each(function(){
        var highestBox = 0;
        $('.col-md-3 ', this).each(function(){
            if($(this).height() > highestBox) {
                highestBox = $(this).height();
            }
        });
        $('.col-md-3 ',this).height(highestBox);
    });
};





