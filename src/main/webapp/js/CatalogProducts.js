
var hideButton = function () {

    $(".buttonsProduct").hide();
    console.log("hide btn");

    createCardProduct(hideAdmin);
};
var hideAdmin = function () {
    if(role!=1){
        $(".admin_block").hide();
        $(".user_block").show()
    }
};
var basket = [];

var addBasket = function(id){
    basket.push(id);
    $(".basket").show("slow");
    for(var i=0;i<basket.length;i++) {
        console.log(basket);
    }
    $(".count_product").hide("slow");

    $(".count_product").html(basket.length)
    $(".count_product").show("slow");

};

