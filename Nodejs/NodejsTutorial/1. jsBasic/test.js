console.log("A");

setTimeout(() => console.log("B"), 0);

Promise.resolve().then(() => console.log("C"));

console.log("D");
// event loop xử lí microtask queue (promise) trước, sau đó mới đến macrotask queue (setTimeout)
// Kết quả in ra: A D C B