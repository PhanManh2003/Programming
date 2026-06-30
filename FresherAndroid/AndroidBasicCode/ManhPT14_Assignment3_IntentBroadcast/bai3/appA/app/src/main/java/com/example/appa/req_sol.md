# Write 2 applications A & B, in which:
Application B can be started by application A by 2 ways:
 Way 1: Using startActivity with Intent
 Way 2: Using BroadcastReceiver

Objectives:
- Know how to use intent to start activity by two ways

Technical Requirements:
   Must use Intent
   Must use Broadcast Receiver

# solution
1. Tạo activity của A với 2 button cho 2 cách start app B
2. Cách 1:
    - Tạo intent để start app B
3. Cách 2:
   - đăng kí broadcast receiver ở B để nhận intent broadcast từ A
   - A sendBroadcast với intent khớp receiver ở B
   - B nhận được intent và start app B