package model;

import java.util.ArrayList;
import java.util.List;


// Represents a list of different tasks

public class ToDoList {

    private final List<Task> taskSet;

    public ToDoList() {

        taskSet = new ArrayList<>();
    }

    public List<Task> getTasks() {

        return taskSet;
    }

    // EFFECTS: returns the number of completed tasks in a list of tasks
    //          if no tasks are completed it will return 0
    public int retrieveNumberCompletedTasks() {
        int count = 0;
        for (Task t : taskSet) {
            if (t.getStatus()) {
                count++;
            }
        }
        return count;
    }

    // EFFECTS: returns the number of incomplete tasks in a list of tasks
    //          if no tasks are incomplete it will return 0
    public int retrieveNumberIncompleteTasks() {
        int count = 0;
        for (Task t : taskSet) {
            if (!t.getStatus()) {
                count++;
            }
        }
        return count;
    }

    // MODIFIES: this
    // EFFECTS: inserts a task into task set unless the tasks is
    //          already the list, in which case nothing happens
    public void insert(Task task) {
        if (!taskSet.contains(task)) {
            taskSet.add(task);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a task is in the task set, unless
    //          the task is not in the set, then it will do nothing
    public void remove(Task task) {
        taskSet.remove(task);
    }

    // EFFECTS: returns the size of the task list
    public int size() {
        return taskSet.size();
    }

    // EFFECTS: returns true if the inputted task is contained within the task set
    //          returns false otherwise
    public boolean contains(Task t) {
        return taskSet.contains(t);
    }

}
