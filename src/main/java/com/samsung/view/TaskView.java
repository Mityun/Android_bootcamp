package com.samsung.view;

import com.samsung.domain.Author;
import com.samsung.domain.Importance;

public class TaskView{

    private String name;

    private int authorId;

    private int importanceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getImportanceId() {
        return importanceId;
    }

    public void setImportanceId(int importanceId) {
        this.importanceId = importanceId;
    }
}
