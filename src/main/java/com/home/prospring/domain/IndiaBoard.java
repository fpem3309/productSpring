package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="indiaboard")
public class IndiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="indiaId")
    private int indiaId;
    @Column(name = "indiaTitle")
    private String indiaTitle;
    @Column(name = "indiaContent")
    private String indiaContent;
    @Column(name = "indiaHit")
    private int indiaHit;
    @Column(name = "indiaDate")
    private String indiaDate;
    @Column(name = "indiaCategory")
    private String indiaCategory;

    public int getIndiaId() {
        return indiaId;
    }

    public void setIndiaId(int indiaId) {
        this.indiaId = indiaId;
    }

    public String getIndiaTitle() {
        return indiaTitle;
    }

    public void setIndiaTitle(String indiaTitle) {
        this.indiaTitle = indiaTitle;
    }

    public String getIndiaContent() {
        return indiaContent;
    }

    public void setIndiaContent(String indiaContent) {
        this.indiaContent = indiaContent;
    }

    public int getIndiaHit() {
        return indiaHit;
    }

    public void setIndiaHit(int indiaHit) {
        this.indiaHit = indiaHit;
    }

    public String getIndiaDate() {
        return indiaDate;
    }

    public void setIndiaDate(String indiaDate) {
        this.indiaDate = indiaDate;
    }

    public String getIndiaCategory() {
        return indiaCategory;
    }

    public void setIndiaCategory(String indiaCategory) {
        this.indiaCategory = indiaCategory;
    }
}
