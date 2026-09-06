const params = new URLSearchParams(window.location.search);
const categoryId = params.get("categoryId");
console.log("Category Id : ",categoryId);

const foodContainer = document.getElementById("foodContainer");

fetch("http://localhost:8080/food/category/${categoryId}")
.then(response => response.json())
.then(foods => {
    console.log(foods);
    foods.forEach(food => {
        const card = document.createElement("div");
        card.classList.add("food-card");

        card.innerHTML = `
        <img class="food-img" src="${food.imageUrl}" alt="${food.name}">

        <div class="food-details-container">
            <h3>${food.name}</h3>
            <p class="food-description">${food.description}</p>
            <div class="food-info">
                <span class="food-rating">⭐ ${food.rating} Ratings</span>
                <span class="food-price">₹ ${food.price}</span>
            </div>
            <div class="food-buttons-container">
                <button class="food-order-btn">Order now</button>
                <button class="food-cart-btn"><i class="fa-solid fa-cart-plus fa-lg" style="color: rgb(0, 0, 0);"></i></button>
            </div>
        </div> `;
        foodContainer.appendChild(card);
    });
})
.catch(error => {
    console.error("Error loading foods:",error);
});