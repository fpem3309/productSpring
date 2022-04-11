package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="mainproduct")
public class MainBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="mainProductId")
    private int mainProductId;
    @Column(name = "mainProductTitle")
    private String mainProductTitle;
    @Column(name = "mainProductContent")
    private String mainProductContent;
    @Column(name = "mainProductHit")
    private int mainProductHit;
    @Column(name = "mainProductDate")
    private String mainProductDate;
    @Column(name = "mainProductCategory")
    private String mainProductCategory;

    public String getMainProductCategory() {
        return mainProductCategory;
    }

    public void setMainProductCategory(String mainProductCatagory) {
        this.mainProductCategory = mainProductCatagory;
    }

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

    public int getMainProductHit() {
        return mainProductHit;
    }

    public void setMainProductHit(int mainProductHit) {
        this.mainProductHit = mainProductHit;
    }

    public String getMainProductDate() {
        return mainProductDate;
    }

    public void setMainProductDate(String mainProductDate) {
        this.mainProductDate = mainProductDate;
    }
}
