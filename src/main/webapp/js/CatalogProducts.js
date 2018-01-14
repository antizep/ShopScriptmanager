
var hideButton = function () {

    $(".buttonsProduct").hide();
    console.log("hide btn");

    createCardProduct(null);
};
loadContent("html/AllProduct.html",hideButton);
