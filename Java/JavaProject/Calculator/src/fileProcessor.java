
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 

public class fileProcessor {

    private BufferedReader reader;
    private String FilePath;

    public void openFile(String filePath) {
        try {
            reader = new BufferedReader(new FileReader(filePath));
            if (filePath != null || filePath.isEmpty()) {
                System.out.println("File opened successfully");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    public void readFile() throws IOException{
        String line ;
        try {
            while ((line = reader.readLine()) != null) {                
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        } finally {
            reader.close();
        }
    }
    
    public void processFile() throws IOException{
        openFile(FilePath);
        System.out.println("Processing file...");
        if (FilePath == null) {
            System.out.println("Invalid file path");
            return;
        } 
        readFile();
    }
    
     
    
}
