import java.util.LinkedList;
import java.util.Scanner;


class Task {

    private final int id;
    private final String description;
    private final int priority; 
    private boolean completed;

    public Task(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {

        String priorityText;

        priorityText = switch (priority) {
            case 1 -> "High";
            case 2 -> "Medium";
            default -> "Low";
        };

        return "ID: " + id +
                " ,Description: " + description +
                " , Priority: " + priorityText +
                " , Completed: " + completed;
    }
}



public class TaskManager {

    private final LinkedList<Task> tasks = new LinkedList<>();
    private int idCounter = 1;

    
    public void addTask(String description, int priority) {

        Task task = new Task(idCounter++, description, priority);

        
        if (priority == 1) {
            tasks.addFirst(task); 
        } else {
            tasks.addLast(task); 
        }

        System.out.println("Task added successfully.");
    }

    
    public void completeTask(int id) {

        for (Task t : tasks) {
            if (t.getId() == id) {
                t.markCompleted();
                tasks.remove(t); 
                System.out.println("Task completed and removed.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    
    public void getNextTask() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        Task next = tasks.peek();
        System.out.println("Next Task:");
        System.out.println(next);
    }

    //  All Tasks
    public void displayTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks");
            return;
        }

        System.out.println("\n list");

        for (Task t : tasks) {
            System.out.println(t);
        }

        
        System.out.println("Total Tasks: " + tasks.size());
    }


    // MAIN METHOD
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        int choice;

        do {
            System.out.println("\n TASK ");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. View Next Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    System.out.println("Priority (1=High, 2=Medium, 3=Low): ");
                    int priority = scanner.nextInt();
                    manager.addTask(desc, priority);
                }
                case 2 -> {
                    System.out.print("Enter task ID to complete: ");
                    manager.completeTask(scanner.nextInt());
                }
                case 3 -> manager.getNextTask();
                case 4 -> manager.displayTasks();
                case 5 -> System.out.println("Exiting");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
