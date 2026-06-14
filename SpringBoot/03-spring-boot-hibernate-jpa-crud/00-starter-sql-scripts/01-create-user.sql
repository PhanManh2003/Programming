-- Drop user first if they exist
/*
'springstudent' → tên user MySQL
'%' → cho phép user này đăng nhập từ mọi host/IP
*/
DROP USER if exists 'springstudent'@'%' ;  

-- Now create user with prop privileges, % nghĩa là cho phép login từ mọi host/ip
CREATE USER 'springstudent'@'%' IDENTIFIED BY 'springstudent';

-- . nghĩa là mọi db và mọi table , * đầu là db, * sau là table
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';