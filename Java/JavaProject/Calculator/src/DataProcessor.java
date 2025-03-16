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
        writer.close();
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
