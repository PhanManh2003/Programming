package business;

import entity.Worker;
import utils.Validator;

public class WorkerInputter {
    
    private Worker worker;
    
    public WorkerInputter() {
        worker = new Worker();
    }
    
    public Worker inputWorker() {
        worker.setId(Validator.getString("Enter id: ",
                "Invalid!", "[Ww]\\d+").toUpperCase());
        worker.setName(Validator.getString("Enter name: ",
                "Invalid!", "[a-zA-Z\\s]+").trim());
        worker.setAge(Validator.getInt("Enter age: ",
                "Must be 18->50", "Invalid!", 18, 50));
        worker.setSalary(Validator.getDouble("Enter salary: ",
                "Must > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE));
        worker.setWorkLocation(Validator.getString("Enter work location: ",
                "Invalid!", "[A-Za-z0-9\\s]+"));
        return worker;
    }
}
