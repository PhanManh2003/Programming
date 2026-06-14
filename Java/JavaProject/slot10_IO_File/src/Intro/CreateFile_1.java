package Intro;

import java.io.File;
import java.io.IOException;

/*
 Using the File class you can:
    - Check if a file or directory exists.
    - Create a directory if it does not exist.
    - Read the length of a file.
    - Rename or move a file.
    - Delete a file.
    - Check if path is file or directory.
    - Read list of files in a directory.
=> Để quản lí thư mục ,, tệp , đường dẫn
  
   Before you can do anything with the file system or File class,
you must obtain a File instance. 
      File file = new File(“D:\\Documents\\inputfile.txt");
   hoặc     File file = new File(new File(“D:\\Documents", "Homework"), "data.txt"); 
       

  
 Method of file object:
 - fileA.getName(), getPath() , getAbsolutePath(), getParent(), length()
 - fileA.exists() -> check exists
 - fileA.isFile(), isDirectory() 
 - fileA.createNewFile(): tạo file
 - fileA.mkdir(): tạo 1 folder
 - fileA.mkdirs(): tạo nhiều folder lồng nhau 
 -      VD: File folder =
    new File("D:\\A\\B\\C");  => chưa có A,B thì tạo luôn
 - fileA.delete() : xoá file hoặc folder rỗng ( chỉ folder rỗng mới xoá dc)
 
- renameTo(), listFiles(), lastModified()
 */
public class CreateFile_1 {

    public static void main(String[] args) {
        try {

            File file = new File("D:\\newfile.txt");

            if (file.createNewFile()) {
                /* Khi được gọi, phương thức createNewFile() sẽ kiểm tra xem tệp có tồn tại hay không. 
       Nếu tệp chưa tồn tại, nó sẽ tạo một tệp mới và trả về true. Nếu tệp đã tồn tại, nó sẽ trả về false. */
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
