// Callback bản chất chỉ là một hàm được truyền vào làm tham số để thực thi sau khi hàm bất đồng bộ kia hoàn tất.
const fetchData = callback => {
    const promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('Done'); // resolve sẽ trả về giá trị 'Done' cho promise
        }, 1500);
    });
    return promise;
}

setTimeout(() => {
    console.log('Timer is done!'); 
    fetchData().then(data => { // data nhận giá trị Done từ resolve
        console.log(data);
        return fetchData(); // trả về một promise mới
    }).then(data2 => { // data2 nhận giá trị Done từ promise mới
        console.log(data2);
    })
}, 1); // ít nhất sau 1ms, callback này mới dc đưa vào callback queue. dù siêu nhỏ thì cái setTimeout luôn chạy sau console.log

console.log('Hello');
console.log('Hi');

// mặc dù setTimeout dc gọi rất nhanh, nhưng nó sẽ không chạy ngay lập tức do cơ chế event loop trong JavaScript
// bởi vì chỉ khi callstack rỗng thì event loop mới xử lý các callback từ hàng đợi


//  hầu hết callback trong JavaScript (như của setTimeout, fetch, addEventListener…) được xử lý theo cơ chế bất đồng bộ.




// cụ thể hơn về promise với resolve và reject:
/**
function getUser(id) {
    return new Promise((resolve, reject) => {
        if (id > 0) {
            resolve({ id, name: 'John' });
        } else {
            reject('Invalid ID');
        }
    });
}

getUser(1)
    .then(user => console.log('User:', user)) // thành công
    .catch(err => console.error('Error:', err));

getUser(-1)
    .then(user => console.log('User:', user))
    .catch(err => console.error('Error:', err)); // lỗi: Invalid ID
 */


/**


🔑 Tóm gọn thứ tự chạy:

1- Code sync.

2- Microtask queue (Promise, queueMicrotask, nextTick).

3- Task queue (setTimeout, setInterval, I/O callbacks).



 - Task queue chính là Callback Queue, chứa các callback lớn hơn như setTimeout, setInterval, I/O callbacks, UI rendering, ...
- Microtask queue chứa các callback nhỏ hơn như Promise.then, Promise.catch, process.nextTick (Node.js), MutationObserver (trình duyệt), ...
 */

 /**
  * 
  * Các loại callback trong Nodejs :
  * Loại callback	        Khi nào chạy?	                                    Ví dụ
    * Đồng bộ	            Ngay trong hàm gọi                          Array.forEach, hàm map
    * Bất đồng bộ	        Sau khi tác vụ async hoàn thành	            setTimeout, Promise.then
  */