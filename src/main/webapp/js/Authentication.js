var token;
var id;
var role;
var i = 0;
var auth = function(){

    token = localStorage.getItem("token");
    id = localStorage.getItem("id");
    role =localStorage.getItem("role");
    console.log(id+":"+token+":"+role);
    if(id && token){
        $("#auth").css("display","none");
        $("#registration").css("display","none");
        $("#lk").css("display","block");
        $("#profile").attr("href","/profile/"+id);
        if(role == 1){
            $("#admin").css("display","block");
        }
        console.log(i);
    }
    i++;

};
var  authentication = function () {

    var response;
    var auth = $('#authentication');
    var msg   = auth.serialize();
    $.ajax({
        type: 'POST',
        url: '/auth',
        data: msg,
        success: function(data) {

            response=data;
            if(!response.error) {
                localStorage.setItem("token", response.token);
                localStorage.setItem("id", response.id);
                localStorage.setItem("role", response.role);
                location.reload();
            }else {
                alert("ошибка входа");
            }
        },
        error:  function(xhr, str){
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
};

var logout = function (){

    var token = localStorage.getItem("token");
    var id = localStorage.getItem("id");

    $.ajax({
        type: 'POST',
        url: '/exit',
        data: {
            id: id,
            token:token
        },
        success: function(data) {

            //var response=data;
            localStorage.removeItem("token");
            localStorage.removeItem("id");
            localStorage.removeItem("role");
            location.reload();
        },
        error:  function(xhr, str){
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    })
};