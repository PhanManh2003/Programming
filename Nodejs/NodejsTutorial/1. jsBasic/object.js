const person = {
    name : "John",
    age: 30,
    greet() { // object method shorthand es6
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    }
}