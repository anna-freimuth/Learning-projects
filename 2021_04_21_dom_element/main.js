document.addEventListener("DOMContentLoaded",function(){
    let marsText = document.querySelector(".mars")
    marsText.id = "first-text"
    console.log(marsText.id)

    //make text red/non red while clicking on it
    marsText.addEventListener("click",function (event){
        marsText.classList.toggle("red");
       // event.target.classList.toggle("red");         //if there is no link
    });
});

