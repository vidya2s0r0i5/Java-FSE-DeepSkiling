package module2.Algorithms_Data_Structures.TaskManagement;

public class Main {
    public static void main(String[] args) {
        TaskLL taskList = new TaskLL();

        taskList.addTask(new Task(1, "Design Pattern", "Completed"));
        taskList.addTask(new Task(2, "Implement Data Structures", "In Progress"));
        taskList.addTask(new Task(3, "Spring", "Pending"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        System.out.println("\nDeleting Task ID 2:");
        boolean deleted = taskList.deleteTask(2);
        System.out.println(deleted ? "Deleted successfully" : "Task not found");

        System.out.println("\nUpdated Task List:");
        taskList.traverseTasks();
    }
}

