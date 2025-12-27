const cart = document.getElementById("cart");
let inCart = 0;
function addToCart() {
    inCart += 1;
    cart.innerHTML = '<img src="cart.png" alt="cart" id="cart-img"> Cart :  ' + inCart;
}
function createCard(card) {
    const cardDiv = document.createElement('div');
    const img = document.createElement('img');
    const name = document.createElement('p');
    const price = document.createElement('p');
    const addToCartB = document.createElement('button');
    const fav = document.createElement('button');

    cardDiv.className = 'card';
    img.className = 'product-image';
    img.src = card.img;
    img.alt = card.name;
    name.className = 'name';
    name.innerText = card.name;
    price.className = 'price';
    price.innerText = '$' + card.price;
    addToCartB.className = 'cart-button';
    addToCartB.innerText = 'Add To Cart';
    addToCartB.onclick = function () { addToCart(); };
    fav.className = 'fav-button';
    fav.innerText = '♡';
    cardDiv.appendChild(img);
    cardDiv.appendChild(name);
    cardDiv.appendChild(price);
    cardDiv.appendChild(addToCartB);
    cardDiv.appendChild(fav);
    document.getElementById('cards').appendChild(cardDiv);
}

fetch('https://pc-store-3p6m.onrender.com/api/avl').then(response => response.json()).then(dataList => {
      dataList.forEach(data => {
          createCard(data); 
      });
  }).catch(error => console.error("Error:", error));