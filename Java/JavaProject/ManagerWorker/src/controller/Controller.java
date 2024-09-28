package controller;

import business.ManagerSalaryHistory;
import business.ManagerWorker;
import business.WorkerInputter;
import entity.SalaryHistory;
import entity.SalaryStatus;
import entity.Worker;
import java.util.Date;
import utils.Validator;

public class Controller {

    // Reference variables to business objects
    private ManagerSalaryHistory histories;
    private ManagerWorker workers;
    private WorkerInputter inputter;

    public Controller() {
        histories = new ManagerSalaryHistory();
        workers = new ManagerWorker();
    }

    public Worker addWorker() throws Exception {
        inputter = new WorkerInputter();
        Worker worker = inputter.inputWorker();
        if (workers.addWorker(worker)) {
            return worker;
        }
        throw new Exception("Cannot add worker.");
    }

    public SalaryHistory upSalary() throws Exception {
        String code = Validator.getString("Enter id: ",
                "Invalid!", "[Ww]\\d+").toUpperCase();
        double amount = Validator.getDouble("Enter up amount: ",
                "Must > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        Worker worker = workers.changeSalary(code, SalaryStatus.UP, amount);
        SalaryHistory history = new SalaryHistory(worker,
                worker.getSalary(), SalaryStatus.UP, new Date());
        if (histories.addSalaryHistory(history)) {
            return history;
        } else {
            throw new Exception("Cannot increase salary");
        }
    }

    public SalaryHistory downSalary() throws Exception {
        String code = Validator.getString("Enter id: ",
                "Invalid!", "[Ww]\\d+").toUpperCase();
        double amount = Validator.getDouble("Enter down amount: ",
                "Must > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
        Worker worker = workers.changeSalary(code, SalaryStatus.DOWN, amount);
        SalaryHistory history = new SalaryHistory(worker,
                worker.getSalary(), SalaryStatus.DOWN, new Date());

        if (histories.addSalaryHistory(history)) {
            return history;
        } else {
            throw new Exception("Cannot decrease salary");
        }
    }

    public void showHistory() throws Exception {
        String result = histories.toString();
        if (result == null) {
            throw new Exception("History is empty");
        } else {
            System.out.println("-------------------- "
                    + "Display Information Salary"
                    + " --------------------");
            System.out.println(result);
        }
    }

    public void saveWorker() {
        try {
            workers.saveFile("worker.dat");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void saveSalaryHistory() {
        try {
            histories.saveFile("history.dat");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void readFile() {
        try {
            workers.readFile("worker.dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            histories.readFile("history.dat");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
