
/*games*/
let cart = [];
let total = 0;

function addToCart(productName, productPrice, productId) {
    const product = { name: productName, price: productPrice, id: productId };
    cart.push(product);
    total += productPrice;
    updateCart();
}

function removeFromCart(productId) {
    const productIndex = cart.findIndex(product => product.id === productId);
    if (productIndex !== -1) {
        total -= cart[productIndex].price;
        cart.splice(productIndex, 1);
    }
    updateCart();
}

function updateCart() {
    const cartItems = document.getElementById('cart-items');
    const totalElement = document.getElementById('cart-total');
    
    cartItems.innerHTML = '';
    cart.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.name} - $${item.price.toFixed(2)}`;
        const removeButton = document.createElement('button');
        removeButton.textContent = 'Eliminar';
        removeButton.onclick = () => removeFromCart(item.id);
        li.appendChild(removeButton);
        cartItems.appendChild(li);
    });
    
    totalElement.textContent = total.toFixed(2);
}

document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', event => {
        const productItem = event.target.closest('.game-item');
        const productId = parseInt(productItem.getAttribute('data-id'), 10);
        const productName = productItem.querySelector('h2').textContent;
        const productPrice = parseFloat(productItem.querySelector('p').textContent.substring(1));
        addToCart(productName, productPrice, productId);
    });
});

document.addEventListener("DOMContentLoaded", function() {
    const carouselItems = document.querySelectorAll(".carousel-item");
    const prevButton = document.querySelector(".carousel-button.prev");
    const nextButton = document.querySelector(".carousel-button.next");
    let currentIndex = 0;

    // Función para mostrar el elemento actual y ocultar los demás
    function showCurrentSlide() {
        carouselItems.forEach((item, index) => {
            if (index === currentIndex) {
                item.classList.add("active");
            } else {
                item.classList.remove("active");
            }
        });
    }

    // Función para ir al slide anterior
    function showPrevSlide() {
        currentIndex = (currentIndex === 0) ? carouselItems.length - 1 : currentIndex - 1;
        showCurrentSlide();
    }

    // Función para ir al siguiente slide
    function showNextSlide() {
        currentIndex = (currentIndex === carouselItems.length - 1) ? 0 : currentIndex + 1;
        showCurrentSlide();
    }

    // Event listeners para los botones de navegación
    prevButton.addEventListener("click", function() {
        showPrevSlide();
    });
    nextButton.addEventListener("click", function() {
        showNextSlide();
    });

    // Mostrar el primer slide al cargar la página
    showCurrentSlide();
});
