package com.data.session01.Bai8;

public class Task {
    private int id;
    private String jobName;
    private String status; // "Completed", "Doing"

    public Task(int id, String jobName, String status) {
        this.id = id;
        this.jobName = jobName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
