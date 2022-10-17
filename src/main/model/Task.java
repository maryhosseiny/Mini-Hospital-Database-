package model;

// Represents a task that has the following properties:
//   - whether it is completed or not represented by a boolean
//     if the task is complete, the status is true and if incomplete
//     the status is marked as false.
//   - task's title given by the user
//   - task due date also given by the user
//   - task type chosen between chores, school related tasks
//     extracurricular activities and exercise.

public class Task {

    private boolean status;    // the completion status of a task
                               // (true is completed and false is incomplete)
    private String title;      // the name of a task
    private String date;       // the due date for a task
    private TaskType type;     // the task type

    // REQUIRES: title has a non-zero length
    // MODIFIES: this
    // EFFECTS: constructs a task with
    //    - its completion status (marked false/incomplete),
    //    - its task title set to name and its due date set to givenDate
    //    - along with its given task type
    public Task(boolean status, String name, String givenDate, TaskType givenType) {
        this.status = status;
        this.title = name;
        this.date = givenDate;
        this.type = givenType;
    }

    //MODIFIES: this
    //EFFECTS: changes the status of a task
    //    - if complete, then status is true
    //    - if not complete, the status is false
    public void updateStatus(boolean newStatus) {
        this.status = newStatus;
    }

    //MODIFIES: this
    //EFFECTS: changes the old due date of a task to the new inputted date
    public void updateDate(String newDate) {
        this.date = newDate;
    }

    //MODIFIES: this
    //EFFECTS: changes the old title of a task to the new inputted title
    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }

    //MODIFIES: this
    //EFFECTS: changes the old task type to the new inputted type
    public void updateTaskType(TaskType newType) {
        this.type = newType;
    }

    // EFFECTS: returns the status of a task
    public boolean getStatus() {
        return status;
    }

    // EFFECTS: returns the description of a task
    public String getTitle() {
        return title;
    }

    //EFFECTS: returns the due date of a task
    public String getDate() {
        return date;
    }

    //EFFECTS: returns a task type
    public TaskType getTaskType() {
        return type;
    }

}
