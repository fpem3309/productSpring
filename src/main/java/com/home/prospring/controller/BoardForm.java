package com.home.prospring.controller;

public class BoardForm {
    private int id;
    private String category;
    private String title;
    private String content;
    private String date;
    private String tubelink;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTubelink() {
        return tubelink;
    }

    public void setTubelink(String tubelink) {
        this.tubelink = tubelink;
    }

}
