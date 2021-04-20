function Animal(hasFur,suit){

   let _hasFur=hasFur;

   // this.enableFur=function (){
   //     _hasFur=true;
   //  }
   //  this.disableFur=function (){
   //      _hasFur=false;
   //  }
    this.setHasFur=function (hasFur){
        _hasFur=hasFur;
    }
    this.hasFur=function (){
        return _hasFur;
    }
    this.suit=suit;
}
//let animals = new Animal(true);

function Rabbit(hasFur,earsLength,suit){
    Animal.call(this,hasFur,suit); // calls the Animal function and injects 'this' as a context
    this.earsLength= earsLength;
}
let functionalRabbit = new Rabbit(true,20,"grey")
