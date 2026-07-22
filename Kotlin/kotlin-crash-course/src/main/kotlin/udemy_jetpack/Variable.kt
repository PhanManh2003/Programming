package udemy_jetpack

const val ok = "OKE"
fun main() {
//    lateinit chỉ áp dụng cho reference type, thường dùng cho attribute trong class khi bạn
    // ko muốn khởi tạo giá trị cho attribute khi khai báo hoặc trong constructor.
    // Compiler tin là bạn sẽ gán sau.
    // Nếu sau này bạn tạo object mà ko gán rồi dùng biến thì vẫn lỗi.


    // muốn biến lưu null thì thêm dấu ?
    var l: Long? = null

    var o : Any = "world"
    var newO = (o as String).uppercase() // phải ép kiểu về String
    println("$newO")
    print(ok)
}

// const val là cách khai báo hằng số , chỉ áp dụng cho kiểu dạng primitive và String.
// hằng số chỉ dc khai báo ở top level, companion object, singleton object.
// compiler biết giá trị của hằng số lúc compile-time

