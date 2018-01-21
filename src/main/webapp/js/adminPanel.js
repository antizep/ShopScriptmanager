var resizeCount = 0;
var adminLoad = function(){

    $.get('./html/AdminPanel.html', function (data) {
        $('#content_table').html(data);
    });
};

var loadContent = function(loadForm,callback){
    $.get(loadForm, function (data) {
        $('#body_table').html(data);
        if(callback!=null) {
            
            callback();
        }
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
        var highesText = 0;
        var highesImage = 0;
        $('.col-md-3 ', this).each(function(){
            if($(this).height() > highestBox) {
                highestBox = $(this).height();
            }
        });

        $('.card-block',this).each(function () {
            if($(this).height() > highesText) {
                highesText = $(this).height();
            }
        });

        $('.image',this).each(function () {
            if($(this).height() > highesImage){
                highesImage = $(this).height()
            }
        });
        console.log("image"+highesImage);
        $('.image',this).height(highesImage);
        $('.card-block',this).height(highesText);
        //$('.col-md-3 ',this).height(highestBox);
    });
    resizeCount++;
    console.log("resized"+resizeCount);
};


var createCardProduct = function (callback) {
    var pattern = $(".card").get(0).outerHTML;
    //console.log(pattern);
    var rsp;
    $.ajax({
        url: "/SelectProducts",
        async:false,


        type: "GET",
        data: "id="+id+"&token="+token,
        success: function (data) {
            rsp = data.products;
            console.log(data);
            return rsp;
        },
        error: function (xhr, str) {
            console.log("что то пошло не так")
        },
        dataType: "json"
    });


    for(var i=0;i<rsp.length;i++){
        var product  = pattern;
        product = product.replace(/@NameProduct/g,rsp[i].productByProduct.name);
        var description = rsp[i].productByProduct.description;
        if(description.length> 64){
            description = description.slice(0,64)+ " ...";
        }
        product = product.replace(/@Description/g,description);

        var purchase = rsp[i].productByProduct.purchase;
        var saling= rsp[i].productByProduct.selling;

        product = product.replace(/@Price/g,saling);

        product = product.replace(/@Image/,"/img/"+rsp[i].productByProduct.id+"/1.jpg");
//todo у продукта дефалт изображение иначе лишние запросы к серверу
        product = product.replace(/@Id/,rsp[i].id);
        if(purchase) {

            var profit = saling-purchase;
            product = product.replace(/@Purchase/g, purchase);
            product = product.replace(/@Profit/g,profit);
            product = product.replace(/@Provider/g,rsp[i].providerByProvider.name);


        }

        $("#Products").append(product);
    }
    console.log("loaden");
    //resizeCardProduct();

    if(callback!=null) {
        callback();
    }
};





