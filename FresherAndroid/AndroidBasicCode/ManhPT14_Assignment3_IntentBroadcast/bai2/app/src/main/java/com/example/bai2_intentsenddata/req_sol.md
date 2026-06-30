# Write an application which:

- Has 2 activities A & B, in which A contains a list of {"Hello!", "Hi!", "Salut!",
"Hallo!", "Ciao!", "Ahoj!", "YAH sahs!", "Bog!", "Hej!", "Czesc!", "Ní hảo!",
"Kon’nichiwa!", "Annyeonghaseyo!", "Shalom!", "Sah-wahd-dee-kah!", "Merhaba!",
"Hujambo!", "Olá!"}

- Your mission is pass the above list from A to B using Intent.
- Then, display all above list items on a TextView or in Logcat
Objectives:
- Know how to use intent to send data between 2 Activities
Technical Requirements:
- Must use Intent

# Solution:

- Tạo 2 activity A và B
- Tạo intent với putExtra là list
- Truyền list qua intent rồi B nhận và hiển thị thông qua getExtra