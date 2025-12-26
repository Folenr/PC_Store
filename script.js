const cart = document.getElementById("cart");
let inCart = 0;
function addToCart(){
    inCart+=1;
    cart.innerHTML ='<img src="cart.png" alt="cart" id="cart-img"> Cart :  '+inCart;
}

const cardJ = JSON.parse('{"id":2,"name":"Rubik Cube","img":"Rubiks-Cube.jpg","price":15,"quantity":10}');
createCard(cardJ);
function createCard(card){
    const cardDiv = document.createElement('div');
    const img = document.createElement('img');
    const name = document.createElement('p');
    const price = document.createElement('p');
    const addToCartB = document.createElement('button');
    const fav = document.createElement('button');

    cardDiv.className = 'card';
    img.className = 'product-image';
    img.src = cardJ.img;
    img.alt = cardJ.name;
    name.className = 'name';
    name.innerText = cardJ.name;
    price.className = 'price';
    price.innerText = '$'+cardJ.price;
    addToCartB.className = 'cart-button';
    addToCartB.innerText = 'Add To Cart';
    addToCartB.onclick = function() {addToCart();};
    fav.className = 'fav-button';
    fav.innerText = '♡';
    cardDiv.appendChild(img);
    cardDiv.appendChild(name);
    cardDiv.appendChild(price);
    cardDiv.appendChild(addToCartB);
    cardDiv.appendChild(fav);
    document.getElementById('cards').appendChild(cardDiv);
}