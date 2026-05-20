# AppThiLaiXe - Sequence Diagrams

Thư mục này chứa các sequence diagrams cho ứng dụng ôn thi lái xe Android.

## 📋 Danh sách Diagrams

### 1. Xác thực & Quản lý tài khoản
- **01-login.puml**: Đăng nhập hệ thống
- **02-register.puml**: Đăng ký tài khoản mới

### 2. Điều hướng & Trang chủ
- **03-home.puml**: Màn hình chính với các tùy chọn

### 3. Học tập
- **04-learning.puml**: Xem danh sách bài học theo chủ đề
- **05-category-questions.puml**: Học câu hỏi theo từng chủ đề cụ thể

### 4. Thi thử
- **06-exam.puml**: Làm bài thi thử với 25 câu hỏi, thời gian 45 phút
- **07-exam-result.puml**: Xem kết quả thi (đạt/không đạt)
- **08-answer-review.puml**: Xem chi tiết đáp án từng câu

## 🎨 Cách Sử dụng

### Option 1: PlantUML Online
1. Truy cập https://www.plantuml.com/plantuml/uml/
2. Copy nội dung từ file `.puml` bạn muốn vẽ
3. Paste vào editor
4. Nhấn Submit để xem kết quả

### Option 2: PlantText
1. Truy cập https://www.planttext.com/
2. Copy và paste nội dung file `.puml`
3. Diagram sẽ tự động render

### Option 3: VS Code Extension
1. Cài đặt extension "PlantUML" trong VS Code
2. Mở file `.puml`
3. Nhấn `Alt+D` để preview diagram

### Option 4: Android Studio Plugin
1. Cài đặt plugin "PlantUML integration" trong Android Studio
2. Mở file `.puml`
3. Click vào icon preview

## 📱 Tổng quan Ứng dụng

### Kiến trúc
- **Language**: Java
- **Database**: Room (SQLite)
- **Pattern**: Activity-based navigation
- **UI Components**: RecyclerView, Material Design

### Các Entity chính
1. **User**: Quản lý người dùng (userId, fullName, email, password)
2. **Lesson**: Chủ đề học tập (lessonId, lessonName, description)
3. **Question**: Câu hỏi (questionId, questionTitle, optionA-D, correctAnswer, explanation, imageUrl)
4. **Study**: Theo dõi tiến độ học (studyId, userId, questionId, timestamp)
5. **Test**: Đề thi (testId, testName, duration)
6. **AnswerReview**: Đánh giá câu trả lời (để hiển thị kết quả)

### Luồng chính của ứng dụng

1. **Đăng nhập/Đăng ký**
   - User có thể đăng nhập hoặc bỏ qua (skip)
   - Validation đầy đủ cho email, password
   - Lưu thông tin vào Room Database

2. **Màn hình Home**
   - Hiển thị 2 tùy chọn chính: Thi thử & Học ngay
   - Truyền userId qua các Activity

3. **Học tập theo chủ đề**
   - Hiển thị danh sách các bài học
   - Mỗi bài học có progress bar (tiến độ đã học)
   - Click vào bài học → Hiển thị câu hỏi từng câu
   - Chọn đáp án → Hiển thị đúng/sai + giải thích
   - Cập nhật tiến độ học vào database

4. **Thi thử**
   - 25 câu hỏi ngẫu nhiên
   - Thời gian: 45 phút
   - Countdown timer
   - Navigation: Previous/Next
   - Submit hoặc auto-submit khi hết giờ
   - Hiển thị kết quả: Đạt (>=80%) hoặc Không đạt

5. **Xem kết quả & Đáp án**
   - Thống kê: Tổng câu, đúng, sai, bỏ qua
   - Filter: Tất cả, Đúng, Sai
   - Hiển thị chi tiết từng câu với giải thích

## 🔄 Luồng dữ liệu

```
User Input → Activity → DAO → Room Database → DAO → Activity → UI Update
```

### Threading
- Các thao tác database được thực hiện trên background thread
- UI update trên main thread (runOnUiThread)
- Sử dụng Executors cho async operations

## 🎯 Tính năng nổi bật

1. **Học tập theo tiến độ**
   - Lưu lại câu hỏi đã học
   - Hiển thị progress bar cho mỗi bài học
   - Có thể học lại nhiều lần

2. **Thi thử chính thức**
   - Random 25 câu từ bộ đề
   - Timer đếm ngược
   - Tự động nộp bài khi hết giờ
   - Chấm điểm tự động

3. **Review chi tiết**
   - Xem lại tất cả câu trả lời
   - Filter theo trạng thái
   - Giải thích chi tiết cho mỗi câu
   - Màu sắc trực quan (xanh/đỏ/xám)

4. **UI/UX**
   - Material Design
   - Edge-to-edge layout
   - Progress indicators
   - Loading states
   - Error handling

## 📝 Mở rộng tương lai

- Lưu lịch sử thi vào database
- Thống kê chi tiết theo từng chủ đề
- Chia sẻ kết quả
- Đồng bộ dữ liệu online
- Notifications/Reminders
- Dark mode
- Multi-language support

## 🛠 Database Schema

```sql
-- Users table
CREATE TABLE users (
    userId INTEGER PRIMARY KEY AUTOINCREMENT,
    fullName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    createdAt TEXT DEFAULT CURRENT_TIMESTAMP
);

-- Lessons table
CREATE TABLE lessons (
    lessonId INTEGER PRIMARY KEY AUTOINCREMENT,
    lessonName TEXT NOT NULL,
    description TEXT,
    imageUrl TEXT
);

-- Questions table
CREATE TABLE questions (
    questionId INTEGER PRIMARY KEY AUTOINCREMENT,
    lessonId INTEGER,
    testId INTEGER,
    questionTitle TEXT NOT NULL,
    optionA TEXT NOT NULL,
    optionB TEXT NOT NULL,
    optionC TEXT NOT NULL,
    optionD TEXT NOT NULL,
    correctAnswer TEXT NOT NULL,
    explanation TEXT,
    imageUrl TEXT,
    FOREIGN KEY (lessonId) REFERENCES lessons(lessonId),
    FOREIGN KEY (testId) REFERENCES tests(testId)
);

-- Studies table (Progress tracking)
CREATE TABLE studies (
    studyId INTEGER PRIMARY KEY AUTOINCREMENT,
    userId INTEGER NOT NULL,
    questionId INTEGER NOT NULL,
    timestamp TEXT DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (questionId) REFERENCES questions(questionId)
);

-- Tests table
CREATE TABLE tests (
    testId INTEGER PRIMARY KEY AUTOINCREMENT,
    testName TEXT NOT NULL,
    duration INTEGER DEFAULT 45,
    totalQuestions INTEGER DEFAULT 25
);
```

## 📞 Contact

Nếu có thắc mắc về các diagrams hoặc luồng xử lý, vui lòng liên hệ team phát triển.
