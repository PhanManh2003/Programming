
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataProcessor {
    private int dataCount = 0;
    private boolean isProcessing;
    private BufferedWriter writer;

    public void InitializeProcess() {
        isProcessing = true;
        if (dataCount == 0 || isProcessing == false) {
            System.out.println("No data to process.");
            return;
        }
    }

    public void writeData(String data) {
        if (data != null && data.isEmpty()) {
            return;
        }
        try {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

    public void closeWriter() {
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DataProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processAllData() {
        InitializeProcess();
        if (dataCount > 100) {
            System.out.println("Processing too much data.");
            return;
        }
    }

    public void shutdown() {
        writer = null;
    }
}
