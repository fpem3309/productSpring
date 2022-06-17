package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name = "esasiaboard")
public class ESAsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name = "esasiaId")
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
    @Column(name = "filename")
    private String filename;
    @Column(name = "filepath")
    private String filepath;
    @Column(name = "tubelink")
    private String tubelink;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getTubelink() {
        return tubelink;
    }

    public void setTubelink(String tubelink) {
        this.tubelink = tubelink;
    }
}
