package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="measiaboard")
public class MEAsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="measiaId")
    private int measiaId;
    @Column(name = "measiaTitle")
    private String measiaTitle;
    @Column(name = "measiaContent")
    private String measiaContent;
    @Column(name = "measiaHit")
    private int measiaHit;
    @Column(name = "measiaDate")
    private String measiaDate;
    @Column(name = "measiaCategory")
    private String measiaCategory;

    public int getMeasiaId() {
        return measiaId;
    }

    public void setMeasiaId(int measiaId) {
        this.measiaId = measiaId;
    }

    public String getMeasiaTitle() {
        return measiaTitle;
    }

    public void setMeasiaTitle(String measiaTitle) {
        this.measiaTitle = measiaTitle;
    }

    public String getMeasiaContent() {
        return measiaContent;
    }

    public void setMeasiaContent(String measiaContent) {
        this.measiaContent = measiaContent;
    }

    public int getMeasiaHit() {
        return measiaHit;
    }

    public void setMeasiaHit(int measiaHit) {
        this.measiaHit = measiaHit;
    }

    public String getMeasiaDate() {
        return measiaDate;
    }

    public void setMeasiaDate(String measiaDate) {
        this.measiaDate = measiaDate;
    }

    public String getMeasiaCategory() {
        return measiaCategory;
    }

    public void setMeasiaCategory(String measiaCategory) {
        this.measiaCategory = measiaCategory;
    }
}
