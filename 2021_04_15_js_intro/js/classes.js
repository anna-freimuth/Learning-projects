class AnimalClass{
    static animalNumber =0;
    static incrementAnimals(){
       // this.animalNumber++;
        Animal.animalNumber++;
    }
    _hasFur=false;
    constructor(hasFur) {
        Animal.incrementAnimals();
        this._hasFur = hasFur;
    }

    getFur(){
        return this._hasFur;
    }
}
let animalFromClass = new AnimalClass(true);

class RabbitClass extends AnimalClass{
    #earsLength;
    constructor(hasFur,earsLength) {
        super(hasFur);
        this.#earsLength= earsLength;
    }
    getEarsLength(){
        return this.#earsLength;
    }
    #somethingVeryPrivate(){
        console.log("private");
    }
}
let rabbitFromClass = new RabbitClass(true,20);
