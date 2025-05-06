package com.data.session01.Bai8;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;
    private int nextId = 1;

    private TaskManager() {
        tasks = new ArrayList<>();
        tasks.add(new Task(nextId++, "Design Website", "Completed"));
        tasks.add(new Task(nextId++, "Develop Application", "Doing"));
        tasks.add(new Task(nextId++, "Test Software", "Completed"));
    }

    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void addTask(String jobName) {
        tasks.add(new Task(nextId++, jobName, "Doing"));
    }

    public void changeStatus(int id, String newStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(newStatus);
                break;
            }
        }
    }
}
