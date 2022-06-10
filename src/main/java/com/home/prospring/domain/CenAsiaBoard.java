package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="cenasiaboard")
public class CenAsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="cenasiaId")
    private int cenasiaId;
    @Column(name = "cenasiaTitle")
    private String cenasiaTitle;
    @Column(name = "cenasiaContent")
    private String cenasiaContent;
    @Column(name = "cenasiaHit")
    private int cenasiaHit;
    @Column(name = "cenasiaDate")
    private String cenasiaDate;
    @Column(name = "cenasiaCategory")
    private String cenasiaCategory;
    @Column(name= "filename")
    private String filename;
    @Column(name= "filepath")
    private String filepath;

    public int getCenasiaId() {
        return cenasiaId;
    }

    public void setCenasiaId(int cenasiaId) {
        this.cenasiaId = cenasiaId;
    }

    public String getCenasiaTitle() {
        return cenasiaTitle;
    }

    public void setCenasiaTitle(String cenasiaTitle) {
        this.cenasiaTitle = cenasiaTitle;
    }

    public String getCenasiaContent() {
        return cenasiaContent;
    }

    public void setCenasiaContent(String cenasiaContent) {
        this.cenasiaContent = cenasiaContent;
    }

    public int getCenasiaHit() {
        return cenasiaHit;
    }

    public void setCenasiaHit(int cenasiaHit) {
        this.cenasiaHit = cenasiaHit;
    }

    public String getCenasiaDate() {
        return cenasiaDate;
    }

    public void setCenasiaDate(String cenasiaDate) {
        this.cenasiaDate = cenasiaDate;
    }

    public String getCenasiaCategory() {
        return cenasiaCategory;
    }

    public void setCenasiaCategory(String cenasiaCategory) {
        this.cenasiaCategory = cenasiaCategory;
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
}
