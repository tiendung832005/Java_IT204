package com.data.session10.model;

public class UploadFile {
    private String fileName;
    private String description;
    private String cloudUrl;

    public UploadFile(String fileName, String description, String cloudUrl) {
        this.fileName = fileName;
        this.description = description;
        this.cloudUrl = cloudUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCloudUrl() {
        return cloudUrl;
    }

    public void setCloudUrl(String cloudUrl) {
        this.cloudUrl = cloudUrl;
    }
}
