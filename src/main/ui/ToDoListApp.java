package ui;

import model.Task;
import model.ToDoList;
import java.util.Scanner;
import static model.TaskType.*;

// ToDoList application

public class ToDoListApp {

    private static ToDoList exampleTaskSet;
    private static final Task taskOne = new Task(true, "Doing dishes", "12/6/2023", CHORE);
    private static final Task taskTwo = new Task(true, "Finish assignment", "1/1/2024", SCHOOL);
    private static final Task taskThree = new Task(false, "Soccer", "2/2/2022", EXTRACURRICULAR);
    private static final Task taskFour = new Task(false, "210 Project", "17/10/2022", SCHOOL);
    private static final Task taskFive = new Task(false, "Mop floors", "20/10/2022", CHORE);

    private Scanner input = new Scanner(System.in);

    //EFFECTS: runs the todolist application
    public ToDoListApp() {
        runToDoListApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // CODE ORIGIN: taken from the TellerApp application, used for user input
    private void runToDoListApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    // CODE ORIGIN: taken from the TellerApp application, used for user input commands
    private void processCommand(String command) {
        if (command.equals("incomplete number")) {
            numberIncompleteTasks();
        } else if (command.equals("complete number")) {
            numberCompletedTasks();
        } else if (command.equals("view all tasks")) {
            printAllTasksInList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes a todolist with 5 tasks inside it
    // CODE ORIGIN: taken from TellerApp, used for Todolist initialization
    private void init() {
        exampleTaskSet = new ToDoList();
        exampleTaskSet.insert(taskOne);
        exampleTaskSet.insert(taskTwo);
        exampleTaskSet.insert(taskThree);
        exampleTaskSet.insert(taskFour);
        exampleTaskSet.insert(taskFive);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays a menu of options for user to choose
    private void displayMenu() {
        System.out.println("\nTo see all the tasks enter: 'view all tasks'");
        System.out.println("\nTo get the number of incomplete tasks: 'incomplete number'");
        System.out.println("\nTo get the number of complete tasks: 'complete number'");
        System.out.println("\nTo quit the program enter: 'q'");
    }

    // EFFECTS: prints all the tasks in the task list
    private void printAllTasksInList() {
        System.out.println("All the tasks in the list:");
        for (Task t : exampleTaskSet.getTasks()) {
            System.out.println(t.getTitle() + " has to be done by " + t.getDate());
        }
    }

    // EFFECTS: prints the total number of complete tasks in a task list
    private void numberCompletedTasks() {

        System.out.println("Total completed tasks in your list is: " + exampleTaskSet.retrieveNumberCompletedTasks());

    }

    // EFFECTS: prints the total number of incomplete tasks in a task list
    private void numberIncompleteTasks() {

        System.out.println("Total incomplete tasks in your list is: " + exampleTaskSet.retrieveNumberIncompleteTasks());

    }



}
