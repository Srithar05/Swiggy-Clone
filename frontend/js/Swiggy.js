/*Cold start the backend*/
fetch("https://swiggy-clone-fg8k.onrender.com/user/start")
    .then(response => {
        console.log("Backend status:", response.status);
    })
    .catch(error => {
        console.log("Backend is starting...");
    });
    
function gotoDownload(){
    document.getElementById("side-navbar-open").style.left = "-50%";
    document.getElementById("download-img").scrollIntoView({
        behavior:"smooth",
        block:"start"
    })
}

function Opennavbar()
{
    document.querySelector(".side-navbar").style.left = "0";
}

function Closenavbar()
{
    document.querySelector(".side-navbar").style.left = "-50%";
}

function login()
{
    var overlaycontainer = document.querySelector(".overlay-container");
    var authsection = document.querySelector(".auth-section");
    var signinphno = document.getElementById("signin-phno");

    overlaycontainer.style.display = "block";
    authsection.style.display = "block";
    document.body.style.overflow = "hidden";
    authsection.style.animationName = "signin-open";
    signinphno.focus();
}
function mobilelogin(){
    var overlaycontainersm = document.querySelector(".overlay-container");
    var authsectionsm = document.querySelector(".auth-section");
    var signinphnosm = document.getElementById("signin-phno");

    document.getElementById("side-navbar-open").style.left = "-50%";
    document.getElementById("side-navbar-open").style.transition = "0.5s";
    overlaycontainersm.style.display = "block";
    authsectionsm.style.display = "block";
    document.body.style.overflow = "hidden";
    authsectionsm.style.animationName = "signin-open";
    signinphnosm.focus();
}

function validateSignin(){
    var signinphoneno = document.getElementById("signin-phno").value.trim();
    var signinpsw = document.getElementById("signin-password").value.trim();
    var signinphnolabel = document.getElementById("signin-phno-label");
    var signinpswlabel = document.getElementById("signin-psw-label");
    var isValidSignin = true;

    document.getElementById("signin-phno-error").innerText = ""    
    document.getElementById("signin-psw-error").innerText = ""    
    signinphnolabel.classList.remove("label-error");
    signinpswlabel.classList.remove("label-error");
    
    if(signinphoneno === ""){
        document.getElementById("signin-phno-error").innerText = "Please enter your phone number"
        signinphnolabel.classList.add("label-error")
        isValidSignin = false;
    }
    else if(signinphoneno.length !== 10){
        document.getElementById("signin-phno-error").innerText = "Please enter valid phone number"
        signinphnolabel.classList.add("label-error")
        isValidSignin = false;
    } 

    if(signinpsw === ""){
        document.getElementById("signin-psw-error").innerText = "Please enter password";
        signinpswlabel.classList.add("label-error");
        isValidSignin = false;
    }
    else if(signinpsw.length < 6){
       document.getElementById("signin-psw-error").innerText = "Password must be 6 characters minimum";
        signinpswlabel.classList.add("label-error");
        isValidSignin = false;
    }
    else if(!/^[a-zA-Z0-9@#$]*$/.test(signinpsw)){
       document.getElementById("signin-psw-error").innerText = "Password can only contain letters, numbers and @ $ # symbols";
        signinpswlabel.classList.add("label-error");
        isValidSignin = false;
    }

    return isValidSignin;
}

async function loginContinue(){
    var signinfailedmsg = document.getElementById("signin-failed-msg")
    var loginBtn = document.getElementById("login-btn");
    var successmsg = document.getElementById("success-msg")
    var isValidSignin = validateSignin();
    if(!isValidSignin)
    {
        return;
    }

    var loginData = {
        phone : document.getElementById("signin-phno").value.trim(),
        password : document.getElementById("signin-password").value.trim()
    }

    loginBtn.disabled = true ; 
    loginBtn.innerText = "Login..."

    signinfailedmsg.innerText = ""
    try{
        let response = await fetch("https://swiggy-clone-fg8k.onrender.com/auth/login",{
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify(loginData)
        });

        var data = await response.json();
        if(response.status === 200)
        {
            console.log(data)
            successmsg.innerText = "Login successfull"
            successmsg.style.display = "block";
            document.getElementById("signin-btn").style.display = "none";
            document.getElementById("profile-btn").style.display = "flex";
            document.getElementById("profilename").innerText = data.data.userName;
            setTimeout(()=>{
                closelogin();
                successmsg.innerText = ""
                successmsg.style.display = "none";
            },2000);
        }
        else if(response.status === 404)
        {
            signinfailedmsg.innerText = data.message;
            document.getElementById("signin-phno-label").classList.add("label-error")
        }
        else if(response.status === 401)
        {
            signinfailedmsg.innerText = data.message;
            document.getElementById("signin-psw-label").classList.add("label-error")
        }
    }
    catch(error){
        signinfailedMsg.innerText = "Login failed. Please try again.";
    }
    finally{
        loginBtn.disabled = false ; 
        loginBtn.innerText = "LOGIN"
    }
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
    document.getElementById("signin-phno").focus();
}

function resetAuthForm() {
    document.getElementById("signup-name").value = "";
    document.getElementById("signup-phno").value = "";
    document.getElementById("signup-email").value = "";
    document.getElementById("signup-password").value = "";
    document.getElementById("signin-phno").value = "";
    document.getElementById("signin-password").value = "";
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
    else if(!/^[a-zA-Z0-9@#$]*$/.test(signuppassword)){
        document.getElementById("password-error").innerText = "Password can only contain letters, numbers and @ $ # symbols";
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

    signupBtn.disabled = true ; 
    signupBtn.innerText = "Registering..."

    signupfailedMsg.innerText = ""

    try {
        let response = await fetch("https://swiggy-clone-fg8k.onrender.com/auth/register",{
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify(userData)
        });
        var data = await response.json();
        if(response.status === 201)
        {
            console.log(data)
            document.getElementById("success-msg").style.display = "block";
            resetAuthForm();
            setTimeout(()=>{
                signin();
            },2000);
            setTimeout(()=>{
                document.getElementById("success-msg").style.display = "none";
            },4000);
        }
        else if(response.status === 409)
        {
            console.log(data)
            if(data.message === "Email already registered! Please login.")
            {
                document.getElementById("signup-failed-msg").innerText = data.message;
                document.getElementById("signup-email-label").classList.add("label-error");
            }
            if(data.message === "Phone number already registered! Please login.")
            {
                document.getElementById("signup-failed-msg").innerText = data.message;
                document.getElementById("signup-phno-label").classList.add("label-error");
            }
        }
    } catch (error) {
        signupfailedMsg.innerText = "Signup failed. Please try again.";
        signupBtn.innerHTML = "TRY AGAIN";
    }
    finally{
        signupBtn.disabled = false ; 
        signupBtn.innerText = "CONTINUE"
    }
}


function closelogin(){
    var overlaycontainercl = document.querySelector(".overlay-container");
    var authsectioncl = document.querySelector(".auth-section");
    
    authsectioncl.style.animationName = "signin-close";
    overlaycontainercl.style.display = "none";

    setTimeout(()=>{
        authsectioncl.style.display = "none";
        document.body.style.overflow = "auto";
        resetAuthForm();
    },450);
    document.getElementById("name-error").innerText = ""    
    document.getElementById("phno-error").innerText = ""    
    document.getElementById("email-error").innerText = ""    
    document.getElementById("password-error").innerText = ""    
    document.getElementById("signin-phno-error").innerText = ""
    document.getElementById("signin-psw-error").innerText = ""
    document.getElementById("signup-name-label").classList.remove("label-error");
    document.getElementById("signup-phno-label").classList.remove("label-error");
    document.getElementById("signup-email-label").classList.remove("label-error");
    document.getElementById("signup-psw-label").classList.remove("label-error");
    document.getElementById("signin-phno-label").classList.remove("label-error");
    document.getElementById("signin-psw-label").classList.remove("label-error");
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

const categoryCards = document.querySelectorAll(".food-pic");
categoryCards.forEach(card => {
    card.addEventListener("click",()=>{
        const categoryId = card.dataset.categoryId;
        window.location.href = `collections.html?categoryId=${categoryId}`;
    });
});

let isFoodOpen = false
function showfoodcities(){
    const morecitiesbtn = document.getElementById("more-cities-btn")
    const citiescontainer = document.getElementById("cities-container")
    const extrafoodcities = document.querySelectorAll(".extra-food-cities")
    if(isFoodOpen = !isFoodOpen)
    {
        extrafoodcities.forEach(e=>e.style.display="flex");
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
        extragrocerycities.forEach(e=>e.style.display="flex");
        grocerycitiescontainer.appendChild(moregrocerycitiesbtn);
        moregrocerycitiesbtn.innerHTML = 'Show Less <i class="fa-solid fa-angle-up fa-lg rotated" id="toggle-icon" style="color: #FF5200;"></i>';
    }
    else
    {
        extragrocerycities.forEach(e=>e.style.display="none");
        moregrocerycitiesbtn.innerHTML = 'Show More <i class="fa-solid fa-angle-down fa-lg rotated" id="toggle-icon" style="color: #FF5200;"></i>';
    }
}


