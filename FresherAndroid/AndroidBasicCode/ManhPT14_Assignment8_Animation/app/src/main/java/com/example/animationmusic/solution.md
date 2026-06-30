
# Solution

2 Fragment điều hướng qua fragManager ở trong FragmentContentView

1. xđ cấu trúc project, file nào
2. tạo resource : img, video ,..
3. tạo xml
4. tạo code


FragmentA → click bài hát
→ FragmentB.newInstance(song)
→ FragmentB gọi MainActivity.playSong(song)
→ MediaPlayer tạo ở MainActivity
→ MiniPlayer hiển thị
→ Back về FragmentA
→ MediaPlayer vẫn chạy ở MainActivity 
→ MiniPlayer vẫn hiển thị 
→ Click MiniPlayer
→ Mở lại FragmentB 