const http = require('http'); // sẽ tìm trong node_modules trước nếu ko có / hay ./
const fs = require('fs');

const server = http.createServer((req, res) => {
    const url = req.url;
    const method = req.method;
    if (url === '/') {
        res.write('<html>');
        res.write('<head><title>My First Page</title></head>');
        res.write('<body><form action="/message" method="POST"><input type="text" name="message"> <button type="submit">Send</button> </form></body>');
        res.write('</html>');
        return res.end();
    }

    if (url === '/message' && method === 'POST') {
        // 'data' → xảy ra mỗi khi stream nhận được một phần dữ liệu (chunk).

        // 'end' → xảy ra khi stream nhận xong toàn bộ dữ liệu.
        const body = []; // body chính là mảng các buffer
        req.on('data', (chunk) => {
            body.push(chunk);
        });
        return req.on('end', () => {
            const parsedBody = Buffer.concat(body).toString(); // chuyển đổi mảng chunk thành chuỗi
            const message = parsedBody.split('=')[1]; // lấy giá trị sau dấu '='
            console.log(message);
            fs.writeFile('message.txt', message, (err) => {
                res.statusCode = 302; // 302: Found, chuyển hướng
                res.setHeader('Location', '/'); // chuyển hướng về trang chủ
                return res.end(); // dừng việc thực thi tiếp theo
            });

        });

    }
    res.setHeader('Content-Type', 'text/html'); // set header cho response
    res.write('<html>');
    res.write('<head><title>My First Page</title></head>');
    res.write('<body><h1>Hello from my Node.js server!</h1></body>');
    res.write('</html>');
    res.end(); // kết thúc response
})

server.listen(3000); // lắng nghe cổng 3000