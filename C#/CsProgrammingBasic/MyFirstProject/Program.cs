using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyFirstProject
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // namespace gần giống với package trong Java hoặc một cách tổ chức thư mục logic. 
            // 1 project chỉ dc có 1 hàm Main và 1 class chứa hàm Main
            string name = "Nguyen Van A";  
            Console.WriteLine(name); // Console là 1 class trong thư viện System namespace của .NET Framework


            // I, DATA TYPE
            // 1. Value types: byte, short, int, long, float, double, decimal (16byte), char, bool, enum, struct, nullable
            // 2. Reference types: class, interface, delegate, string, array, object, dynamic
            // ------------- delegate: là kiểu dữ liệu dùng để tham chiếu đến các phương thức
            // ------------- dynamic: là kiểu dữ liệu có thể chứa bất kỳ kiểu dữ liệu nào, được kiểm tra tại runtime
            //-----------------------------------
            //  Cả string(chỉ là alias) và String đều là kiểu tham chiếu, đại diện cho chuỗi ký tự trong .NET.
            //  (trong Java thì chỉ có String)
        }
    }
}
