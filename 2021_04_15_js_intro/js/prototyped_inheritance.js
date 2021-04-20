function PrototypedAnimal(hasFur) {
    this.hasFur = hasFur;
}

PrototypedAnimal.prototype.makeSound = function () {
    console.log("animal sound");
}
let prototypedAnimal = new PrototypedAnimal(true);

function PrototypedRabbit(hasFur,earLength) {
    PrototypedAnimal.call(this,hasFur);
    this.earLength = earLength;
}

PrototypedRabbit.prototype.__proto__= PrototypedAnimal.prototype;
let prototypedRabbit = new PrototypedRabbit(true,20);
