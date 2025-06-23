package module2.Algorithms_Data_Structures.TaskManagement;

public class TaskLL {
    class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // Add task at end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    // Traverse and display tasks
    public void traverseTasks() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Task list is empty.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Search by taskId
    public Task searchTask(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId() == id)
                return temp.task;
            temp = temp.next;
        }
        return null;
    }

    // Delete by taskId
    public boolean deleteTask(int id) {
        if (head == null) return false;

        if (head.task.getTaskId() == id) {
            head = head.next;
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.task.getTaskId() == id) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }
}

