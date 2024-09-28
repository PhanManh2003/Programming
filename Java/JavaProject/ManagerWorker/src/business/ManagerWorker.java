package business;

import entity.SalaryStatus;
import entity.Worker;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManagerWorker {

    private List<Worker> list;

    public ManagerWorker() {
        list = new ArrayList<>();

    }

    // getter setter
    public List<Worker> getList() {
        return list;
    }

    public void setList(List<Worker> list) {
        this.list = list;
    }

    private Worker getWorker(String id) {
        for (Worker worker : list) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    private boolean isExisted(String id) {
        for (Worker worker : list) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean addWorker(Worker worker) throws Exception {
        if (isExisted(worker.getId())) {
            throw new Exception("Worker id is existed!");
        }
        return list.add(worker);
    }

    // 
    public Worker changeSalary(String code, SalaryStatus status,
            double amount) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List worker is empty! Cannot change salary");
        }
        if (!isExisted(code)) {
            throw new Exception("Cannot found code!");
        }
        if (amount <= 0) {
            throw new Exception("Money must >0");
        }
        Worker worker = getWorker(code);
        switch (status) {
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                break;
            case DOWN:
                if (worker.getSalary() < amount) {
                    throw new Exception("Cannot decrease " + amount
                            + " from salary since salary will be <0.");
                }
                worker.setSalary(worker.getSalary() - amount);
                break;
        }
        return worker;
    }

    // File
    public void saveFile(String file) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List worker is empty. Cannot save");
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
                    Worker worker = (Worker) ois.readObject();
                    list.add(worker);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new Exception("File " + file + " is empty or not exist.");
        }
    }

}
