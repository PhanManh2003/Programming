const fs = require('fs');

const requestHandler = (req, res) => {
  const url = req.url;
  const method = req.method;
  if (url === '/') {
    res.write('<html>');
    res.write('<head><title>Enter Message</title><head>');
    res.write(
      '<body><form action="/message" method="POST"><input type="text" name="message"><button type="submit">Send</button></form></body>'
    );
    res.write('</html>');
    return res.end();
  }
  if (url === '/message' && method === 'POST') {
    const body = [];
    req.on('data', chunk => {
      console.log(chunk);
      body.push(chunk);
    });
    return req.on('end', () => {
      const parsedBody = Buffer.concat(body).toString();
      const message = parsedBody.split('=')[1];
      fs.writeFile('message.txt', message, err => { 
        res.statusCode = 302;
        res.setHeader('Location', '/');
        return res.end();
      });
    });
  }
  res.setHeader('Content-Type', 'text/html');
  res.write('<html>');
  res.write('<head><title>My First Page</title><head>');
  res.write('<body><h1>Hello from my Node.js Server!</h1></body>');
  res.write('</html>');
  res.end();
};

// module.exports = requestHandler; // xuất duy nhất 1 đối tượng

// cách 1: xuất nhiều ( dùng mỗi cái này thôi)
// module.exports = {
//     handler: requestHandler,
//     someText: 'Some hard coded text'
// };

// cách 2 : xuất nhiều
// module.exports.handler = requestHandler;
// module.exports.someText = 'Some text';

// cách 3: xuất nhiều 
exports.handler = requestHandler;
exports.someText = 'Some hard coded text';

// - CommonJS không có khái niệm chính thức riêng biệt như ES6 về default export và named export.
// - Trong CommonJS, tất cả các exports đều là named exports thông qua module.exports hoặc exports.
// - chỉ có duy nhất lệnh module.exports = <value> để xuất một giá trị duy nhất.