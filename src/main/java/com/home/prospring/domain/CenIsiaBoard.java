package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="indiaboard")
public class CenIsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="CenIsiaId")
    private int CenIsiaId;
    @Column(name = "CenIsiaTitle")
    private String CenIsiaTitle;
    @Column(name = "CenIsiaContent")
    private String CenIsiaContent;
    @Column(name = "CenIsiaHit")
    private int CenIsiaHit;
    @Column(name = "CenIsiaDate")
    private String CenIsiaDate;
    @Column(name = "CenIsiaCategory")
    private String CenIsiaCategory;

    public int getCenIsiaId() {
        return CenIsiaId;
    }

    public void setCenIsiaId(int cenIsiaId) {
        CenIsiaId = cenIsiaId;
    }

    public String getCenIsiaTitle() {
        return CenIsiaTitle;
    }

    public void setCenIsiaTitle(String cenIsiaTitle) {
        CenIsiaTitle = cenIsiaTitle;
    }

    public String getCenIsiaContent() {
        return CenIsiaContent;
    }

    public void setCenIsiaContent(String cenIsiaContent) {
        CenIsiaContent = cenIsiaContent;
    }

    public int getCenIsiaHit() {
        return CenIsiaHit;
    }

    public void setCenIsiaHit(int cenIsiaHit) {
        CenIsiaHit = cenIsiaHit;
    }

    public String getCenIsiaDate() {
        return CenIsiaDate;
    }

    public void setCenIsiaDate(String cenIsiaDate) {
        CenIsiaDate = cenIsiaDate;
    }

    public String getCenIsiaCategory() {
        return CenIsiaCategory;
    }

    public void setCenIsiaCategory(String cenIsiaCategory) {
        CenIsiaCategory = cenIsiaCategory;
    }
}
