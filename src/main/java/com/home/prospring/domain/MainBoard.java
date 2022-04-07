package com.home.prospring.domain;

public class MainBoard {
    private int mainProductId;
    private String mainProductTitle;
    private String mainProductContent;
    private String mainProductDate;

    public int getMainProductId() {
        return mainProductId;
    }

    public void setMainProductId(int mainProductId) {
        this.mainProductId = mainProductId;
    }

    public String getMainProductTitle() {
        return mainProductTitle;
    }

    public void setMainProductTitle(String mainProductTitle) {
        this.mainProductTitle = mainProductTitle;
    }

    public String getMainProductContent() {
        return mainProductContent;
    }

    public void setMainProductContent(String mainProductContent) {
        this.mainProductContent = mainProductContent;
    }

    public String getMainProductDate() {
        return mainProductDate;
    }

    public void setMainProductDate(String mainProductDate) {
        this.mainProductDate = mainProductDate;
    }
}
