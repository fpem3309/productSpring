package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="esasiaboard")
public class ESAsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="esasiaId")
    private int esasiaId;
    @Column(name = "esasiaTitle")
    private String esasiaTitle;
    @Column(name = "esasiaContent")
    private String esasiaContent;
    @Column(name = "esasiaHit")
    private int esasiaHit;
    @Column(name = "esasiaDate")
    private String esasiaDate;
    @Column(name = "esasiaCategory")
    private String esasiaCategory;

    public int getEsasiaId() {
        return esasiaId;
    }

    public void setEsasiaId(int esasiaId) {
        this.esasiaId = esasiaId;
    }

    public String getEsasiaTitle() {
        return esasiaTitle;
    }

    public void setEsasiaTitle(String esasiaTitle) {
        this.esasiaTitle = esasiaTitle;
    }

    public String getEsasiaContent() {
        return esasiaContent;
    }

    public void setEsasiaContent(String esasiaContent) {
        this.esasiaContent = esasiaContent;
    }

    public int getEsasiaHit() {
        return esasiaHit;
    }

    public void setEsasiaHit(int esasiaHit) {
        this.esasiaHit = esasiaHit;
    }

    public String getEsasiaDate() {
        return esasiaDate;
    }

    public void setEsasiaDate(String esasiaDate) {
        this.esasiaDate = esasiaDate;
    }

    public String getEsasiaCategory() {
        return esasiaCategory;
    }

    public void setEsasiaCategory(String esasiaCategory) {
        this.esasiaCategory = esasiaCategory;
    }
}
