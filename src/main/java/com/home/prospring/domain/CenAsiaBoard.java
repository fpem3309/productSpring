package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="cenAsiaboard")
public class CenAsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="cenAsiaId")
    private int cenAsiaId;
    @Column(name = "cenAsiaTitle")
    private String cenAsiaTitle;
    @Column(name = "cenAsiaContent")
    private String cenAsiaContent;
    @Column(name = "cenAsiaHit")
    private int cenAsiaHit;
    @Column(name = "cenAsiaDate")
    private String cenAsiaDate;
    @Column(name = "cenAsiaCategory")
    private String cenAsiaCategory;

    public int getCenAsiaId() {
        return cenAsiaId;
    }

    public void setCenAsiaId(int cenAsiaId) {
        this.cenAsiaId = cenAsiaId;
    }

    public String getCenAsiaTitle() {
        return cenAsiaTitle;
    }

    public void setCenAsiaTitle(String cenAsiaTitle) {
        this.cenAsiaTitle = cenAsiaTitle;
    }

    public String getCenAsiaContent() {
        return cenAsiaContent;
    }

    public void setCenAsiaContent(String cenAsiaContent) {
        this.cenAsiaContent = cenAsiaContent;
    }

    public int getCenAsiaHit() {
        return cenAsiaHit;
    }

    public void setCenAsiaHit(int cenAsiaHit) {
        this.cenAsiaHit = cenAsiaHit;
    }

    public String getCenAsiaDate() {
        return cenAsiaDate;
    }

    public void setCenAsiaDate(String cenAsiaDate) {
        this.cenAsiaDate = cenAsiaDate;
    }

    public String getCenAsiaCategory() {
        return cenAsiaCategory;
    }

    public void setCenAsiaCategory(String cenAsiaCategory) {
        this.cenAsiaCategory = cenAsiaCategory;
    }
}
