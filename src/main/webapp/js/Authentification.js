window.onload = function(){
    var token;
    var id;
    var role;
    token = localStorage.getItem("token");
    id = localStorage.getItem("id");
    role =localStorage.getItem("role");
    console.log(id+":"+token);
    if(id && token){
        $("#auth").css("display","none");
        $("#registration").css("display","none");
        $("#lk").css("display","block");
        if(role == 1){
            $("#admin").css("display","block");
        }
    }

};

var  authentification = function () {

    var response;
    var auth = $('#authentication');
    var msg   = auth.serialize();
    $.ajax({
        type: 'POST',
        url: '/shop/auth',
        data: msg,
        success: function(data) {

            response=data;
            localStorage.setItem("token",response.token);
            localStorage.setItem("id",response.id);
            localStorage.setItem("role",response.role);
            location.reload();
        },
        error:  function(xhr, str){
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
};

var exit = function (){

    var token = localStorage.getItem("token");
    var id = localStorage.getItem("id");

    $.ajax({
        type: 'POST',
        url: '/shop/exit',
        data: {
            id: id,
            token:token
        },
        success: function(data) {

            //var response=data;
            localStorage.removeItem("token");
            localStorage.removeItem("id");
            location.reload();
        },
        error:  function(xhr, str){
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    })
};