package com.data.session10.model;


import java.util.List;

public class Project {
    private String name;
    private String description;
    private List<Document> documents;

    public Project(String name, String description, List<Document> documents) {
        this.name = name;
        this.description = description;
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
