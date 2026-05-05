var overlaycontainer = document.querySelector(".overlay-container")
var signinpage = document.querySelector(".signin-page")
var signininput = document.getElementById("signin-phno")
function login()
{
    overlaycontainer.style.display = "block";
    signinpage.style.display = "block";
    document.body.style.overflow = "hidden";
    signinpage.style.animationName = "signin-open";
    signininput.focus();
}

var closesymbol = document.querySelector("material-symbols-outlined")
function closelogin(){
    signinpage.style.animationName = "signin-close";
    overlaycontainer.style.display = "none";

    setTimeout(()=>{
        signinpage.style.display = "none";
        document.body.style.overflow = "auto";
    },900);
}

var foodlines = document.getElementById("food-lines-container")
function foodscrollright()
{
    foodlines.scrollBy({left:480, behavior:"smooth"})
}
function foodscrollleft()
{
    foodlines.scrollBy({left:-480, behavior:"smooth"})
}

var grocerieslines = document.getElementById("main-groceries-container")
function groceriesscrollright()
{
    console.log("left arrow working")
    grocerieslines.scrollBy({left:500, behavior:"smooth"})
}
function groceriesscrollleft()
{
    console.log("right arrow working")
    grocerieslines.scrollBy({left:-500, behavior:"smooth"})
}