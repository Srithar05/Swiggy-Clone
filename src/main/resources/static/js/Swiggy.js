function gotoDownload(){
    document.getElementById("download-img").scrollIntoView({
        behavior:"smooth",
        block:"start"
    })
}

var overlaycontainer = document.querySelector(".overlay-container")
var authsection = document.querySelector(".auth-section")
var signinphno = document.getElementById("signin-phno")
function login()
{
    overlaycontainer.style.display = "block";
    authsection.style.display = "block";
    document.body.style.overflow = "hidden";
    authsection.style.animationName = "signin-open";
    signinphno.focus();
}

function closelogin(){
    authsection.style.animationName = "signin-close";
    overlaycontainer.style.display = "none";

    setTimeout(()=>{
        authsection.style.display = "none";
        document.body.style.overflow = "auto";
    },450);
}

var signinpage = document.getElementById("signin-page")
var signuppage = document.getElementById("signup-page")
var signupnamefocus = document.getElementById("signup-name")
function signup(){
    signinpage.style.display = "none";
    signuppage.style.display = "block";
    signupnamefocus.focus();
}
function signin(){
    signinpage.style.display = "block";
    signuppage.style.display = "none";
    document.getElementById("signup-failed-msg").innerText = "";
    document.getElementById("signup-btn").innerText = "CONTINUE";
    signinphno.focus();
}

function validateSignup(){
    var signupname = document.getElementById("signup-name").value.trim()
    var signupphno = document.getElementById("signup-phno").value.trim()
    var signupemail = document.getElementById("signup-email").value.trim()
    var signuppassword = document.getElementById("signup-password").value.trim()
    var signupnamelabel = document.getElementById("signup-name-label")
    var signupphnolabel = document.getElementById("signup-phno-label")
    var signupemaillabel = document.getElementById("signup-email-label")
    var signuppswlabel = document.getElementById("signup-psw-label")
    var isValid = true;

    document.getElementById("name-error").innerText = ""    
    document.getElementById("phno-error").innerText = ""    
    document.getElementById("email-error").innerText = ""    
    document.getElementById("password-error").innerText = ""    
    signupnamelabel.classList.remove("label-error");
    signupphnolabel.classList.remove("label-error");
    signupemaillabel.classList.remove("label-error");
    signuppswlabel.classList.remove("label-error");

    if(signupname === ""){
        document.getElementById("name-error").innerText = "Please enter your name";
        signupnamelabel.classList.add("label-error");
        isValid = false;
    }

    if(signupphno === ""){
        document.getElementById("phno-error").innerText = "Please enter your phone number";
        signupphnolabel.classList.add("label-error");
        isValid = false;
    }
    else if(signupphno.length !== 10){
        document.getElementById("phno-error").innerText = "Please enter valid phone number";
        signupphnolabel.classList.add("label-error");
        isValid = false;
    }

    if(signupemail === ""){
        document.getElementById("email-error").innerText = "Please enter your email";
        signupemaillabel.classList.add("label-error");
        isValid = false;
    }
    else if(!signupemail.includes("@")){
        document.getElementById("email-error").innerText = "Please enter valid email";
        signupemaillabel.classList.add("label-error");
        isValid = false;
    }

    if(signuppassword === ""){
        document.getElementById("password-error").innerText = "Please enter password";
        signuppswlabel.classList.add("label-error");
        isValid = false;
    }
    else if(signuppassword.length < 6){
        document.getElementById("password-error").innerText = "Password must be 6 characters minimum";
        signuppswlabel.classList.add("label-error");
        isValid = false;
    }

    return isValid;
}

async function signupContinue(){
    var signupfailedMsg = document.getElementById("signup-failed-msg");
    var signupBtn = document.getElementById("signup-btn");
    var isValid = validateSignup();

    if(!isValid)
    {
        return;
    }

    var userData = {
        userName : document.getElementById("signup-name").value.trim(),
        phone : document.getElementById("signup-phno").value.trim(),
        email : document.getElementById("signup-email").value.trim(),
        password : document.getElementById("signup-password").value.trim()
    }

    signupfailedMsg.innerText = ""
    signupBtn.innerText = "CONTINUE"

    try {
        let response = await fetch("http://localhost:8080/auth/register",{
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify(userData),
        });
        var data = await response.json();
        console.log("Signup completed")
        console.log(data)
        if(response.ok)
        {
            document.getElementById("success-msg").style.display = "block";
            setTimeout(()=>{
                signin();
            },2000);
        }
        else if(data.message === "Email already exists")
        {
            document.getElementById("email-error").innerText = "Email already registered";
            signupemaillabel.classList.add("label-error");
        }

    } catch (error) {
        signupfailedMsg.innerText = "Signup failed. Please try again.";
        signupBtn.innerHTML = "TRY AGAIN";
    }
}

var foodleftarrow = document.getElementById("food-leftarrow")
var foodrightarrow = document.getElementById("food-rightarrow")

var foodlines = document.getElementById("food-lines-container")
function foodscrollright(){
    foodlines.scrollBy({left:480, behavior:"smooth"});
}
function foodscrollleft(){
    foodlines.scrollBy({left:-480, behavior:"smooth"});
}
foodlines.addEventListener("scroll",()=>{
    if(foodlines.scrollLeft === 0)
    {
        foodleftarrow.style.opacity = 0.6;
    }
    else
    {
        foodleftarrow.style.opacity = 1;
    }
    if(foodlines.scrollLeft + foodlines.clientWidth >= foodlines.scrollWidth)
    {
        foodrightarrow.style.opacity = 0.6;
    }
    else
    {
        foodrightarrow.style.opacity = 1;
    }
})

var groceryleftarrow = document.getElementById("grocery-leftarrow")
var groceryrightarrow = document.getElementById("grocery-rightarrow")

var grocerieslines = document.getElementById("main-groceries-container")
function groceriesscrollright(){
    grocerieslines.scrollBy({left:500, behavior:"smooth"});
}
function groceriesscrollleft(){
    grocerieslines.scrollBy({left:-500, behavior:"smooth"});
}
grocerieslines.addEventListener("scroll",()=>{
    if(grocerieslines.scrollLeft === 0)
    {
        groceryleftarrow.style.opacity = 0.6;
    }
    else
    {
        groceryleftarrow.style.opacity = 1;
    }
    if(grocerieslines.scrollLeft + grocerieslines.clientWidth >= grocerieslines.scrollWidth)
    {
        groceryrightarrow.style.opacity = 0.6;
    }
    else
    {
        groceryrightarrow.style.opacity = 1;
    }
})

let isFoodOpen = false
function showfoodcities(){
    const morecitiesbtn = document.getElementById("more-cities-btn")
    const citiescontainer = document.getElementById("cities-container")
    const extrafoodcities = document.querySelectorAll(".extra-food-cities")
    if(isFoodOpen = !isFoodOpen)
    {
        extrafoodcities.forEach(e=>e.style.display="block");
        citiescontainer.appendChild(morecitiesbtn);
        morecitiesbtn.innerHTML = 'Show Less <i class="fa-solid fa-angle-up fa-lg rotated" id="toggle-icon" style="color: #FF5200;"></i>';
    }
    else
    {
        extrafoodcities.forEach(e=>e.style.display="none");
        morecitiesbtn.innerHTML = 'Show More <i class="fa-solid fa-angle-down fa-lg rotated" id="toggle-icon" style="color: #FF5200;"></i>';
    }
}


let isGroceryOpen = false
function showgrocerycities(){
    const moregrocerycitiesbtn = document.getElementById("more-grocery-cities-btn")
    const grocerycitiescontainer = document.getElementById("grocery-cities-container")
    const extragrocerycities = document.querySelectorAll(".extra-grocery-cities")
    if(isGroceryOpen = !isGroceryOpen)
    {
        extragrocerycities.forEach(e=>e.style.display="block");
        grocerycitiescontainer.appendChild(moregrocerycitiesbtn);
        moregrocerycitiesbtn.innerHTML = 'Show Less <i class="fa-solid fa-angle-up fa-lg rotated" id="toggle-icon" style="color: #FF5200;"></i>';
    }
    else
    {
        extragrocerycities.forEach(e=>e.style.display="none");
        moregrocerycitiesbtn.innerHTML = 'Show More <i class="fa-solid fa-angle-down fa-lg rotated" id="toggle-icon" style="color: #FF5200;"></i>';
    }
}


