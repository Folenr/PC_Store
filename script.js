const cart = document.getElementById("cart");
let inCart = 0;
function addToCart() {
    inCart += 1;
    cart.innerHTML = '<img src="cart.png" alt="cart" id="cart-img"> Cart :  ' + inCart;
}
function fav(button) {
    console.log('3' - 3);
    if (button.innerText == '♥') {
        button.innerText = '♡'
        button.parentNode.style.order = parseInt(button.parentNode.style.order) + 3;
    } else {
        button.innerText = '♥'
        button.parentNode.style.order = button.parentNode.style.order - 3;
    }
}
function createCard(card) {
    const cardDiv = document.createElement('div');
    const img = document.createElement('img');
    const soldOut = document.createElement('div');
    const name = document.createElement('p');
    const price = document.createElement('p');
    const addToCartB = document.createElement('button');
    const favB = document.createElement('button');

    cardDiv.className = 'card';
    img.className = 'product-image';
    img.src = card.img;
    img.alt = card.name;
    soldOut.className = 'sold-out';
    soldOut.innerText = 'Out of Stock';
    name.className = 'name';
    name.innerText = card.name;
    price.className = 'price';
    price.innerText = '$' + card.price;
    if (card.quantity > 0) {
        soldOut.style.visibility = 'hidden';
        cardDiv.style.order = '5';
    } else {
        cardDiv.style.order = '6';
        card.discount = 0;
    }
    if (card.discount > 0) {
        price.innerHTML = '<span class="strikethrough">$' + card.price + '</span> $' + card.discount;
        cardDiv.style.order = '4';
    }
    addToCartB.className = 'cart-button';
    addToCartB.innerText = 'Add To Cart';
    addToCartB.onclick = function () { addToCart(); };
    favB.className = 'fav-button';
    favB.innerText = '♡';
    favB.onclick = function () { fav(this); };
    cardDiv.appendChild(img);
    cardDiv.appendChild(soldOut);
    cardDiv.appendChild(name);
    cardDiv.appendChild(price);
    cardDiv.appendChild(addToCartB);
    cardDiv.appendChild(favB);
    document.getElementById('cards').appendChild(cardDiv);
}

fetch('https://pc-store-3p6m.onrender.com/api/avl').then(response => response.json()).then(dataList => {
    dataList.forEach(data => {
        createCard(data);
    });
}).catch(error => console.error("Error:", error));