package business;

import entity.SalaryHistory;
import entity.Worker;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerSalaryHistory {

    private List<SalaryHistory> list;

    public ManagerSalaryHistory() {
        list = new ArrayList<>();
    }

    // getter setter
    public List<SalaryHistory> getList() {
        return list;
    }

    public void setList(List<SalaryHistory> list) {
        this.list = list;
    }

    // ko cần check duplicate vì luôn khác date
    public boolean addSalaryHistory(SalaryHistory history) {
        return list.add(history);
    }

    private void sortById() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return null;
        }
        sortById();
        String str = String.format("%7s%10s%10s%10s%10s%15s\n", "Code",
                "Name", "Age", "Salary", "Status", "Date");
        for (SalaryHistory salaryHistory : list) {
            str += salaryHistory.toString();
        }
        return str;
    }

    // File
    public void saveFile(String file) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List salary history is empty. Cannot save");
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));

            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            throw new Exception("Error to save " + file);
        }
    }

    public void readFile(String file) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    SalaryHistory history = (SalaryHistory) ois.readObject();
                    list.add(history);

                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception("File " + file + " is empty or not exist."
            );
        }
    }
}
