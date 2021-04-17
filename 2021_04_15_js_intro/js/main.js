console.log("Hello world")

let a;  //undefined
let b = a;  //undefined
let c = null;

function f1(){
    console.log("inside f1");
}

const d = 10;
let f2 = function f2(number){
    return number * 2;
}
let e = f2(d)

console.log(`e equals to ${e}`)
e = f2;
console.log(e(d))
