const cart = document.getElementById("cart");
let inCart = 0;
function addToCart(){
    inCart+=1;
    cart.innerHTML ='<img src="cart.png" alt="cart" style="height: 1.3em; width: 1.3em; filter:invert(100%);"> Cart :  '+inCart;
}