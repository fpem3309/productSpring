package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="mainproduct")
public class MainBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    private int mainProductId;
    @Column(name = "mainProductTitle")
    private String mainProductTitle;
    @Column(name = "mainProductContent")
    private String mainProductContent;
    @Column(name = "mainProductDate")
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
