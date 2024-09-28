package controller;

import business.ManagerTask;
import business.TaskInputter;
import entity.Task;
import utils.Validator;

public class Controller {

    private ManagerTask manager;
    private TaskInputter inputter;

    public Controller() {
        manager = new ManagerTask();
    }
    // add
    public int add() throws Exception{
        inputter = new TaskInputter();
        Task task = inputter.input();
        return manager.add(task.getTaskTypeID(), task.getRequirementName(), 
                task.getDate(), task.getPlanFrom(), task.getPlanTo(),
                task.getAssignee(), task.getReviewer());
    }
    
    // delete
    public Task delete() throws Exception{
        int ID = Validator.getInt("Enter taskID: ",  "OutOfRange!", 
                "Invalid!", Integer.MIN_VALUE, Integer.MAX_VALUE);
        return manager.deleteTaskByID(ID);
    }
    
    // show
    public void show() throws Exception{
        String str = manager.toString();
        if (str == null) {
            throw new Exception("Task list is empty!");
        }
        System.out.println(str);
    }
}
