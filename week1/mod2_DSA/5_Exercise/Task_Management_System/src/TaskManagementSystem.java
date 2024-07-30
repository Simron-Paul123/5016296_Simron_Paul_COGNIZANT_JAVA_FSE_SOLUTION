/*
 * 
 * Exercise 5: Task Management System
Scenario: 
You are developing a task management system where tasks need to be added, deleted, and traversed efficiently.
Steps:
1.	Understand Linked Lists:
o	Explain the different types of linked lists (Singly Linked List, Doubly Linked List).
2.	Setup:
o	Create a class Task with attributes like taskId, taskName, and status.
3.	Implementation:
o	Implement a singly linked list to manage tasks.
o	Implement methods to add, search, traverse, and delete tasks in the linked list.
4.	Analysis:
o	Analyze the time complexity of each operation.
o	Discuss the advantages of linked lists over arrays for dynamic data.

 */
class Task {
    String taskId;
    String taskName;
    String status;
    Task next;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Task head;

    public TaskManagementSystem() {
        head = null;
    }

    public void addTask(Task task) {
        task.next = head;
        head = task;
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId.equals(taskId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteTask(String taskId) {
        Task current = head;
        Task previous = null;

        while (current != null && !current.taskId.equals(taskId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found");
            return;
        }

        if (previous == null) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current.taskName);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        Task t1 = new Task("1", "Task 1", "Incomplete");
        Task t2 = new Task("2", "Task 2", "Complete");

        tms.addTask(t1);
        tms.addTask(t2);

        tms.traverseTasks();

        tms.deleteTask("1");
        tms.traverseTasks();
    }
}
