package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="meAsiaboard")
public class MeAsiaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="meAsiaId")
    private int meAsiaId;
    @Column(name = "meAsiaTitle")
    private String meAsiaTitle;
    @Column(name = "meAsiaContent")
    private String meAsiaContent;
    @Column(name = "meAsiaHit")
    private int meAsiaHit;
    @Column(name = "meAsiaDate")
    private String meAsiaDate;
    @Column(name = "meAsiaCategory")
    private String meAsiaCategory;

    public int getMeAsiaId() {
        return meAsiaId;
    }

    public void setMeAsiaId(int meAsiaId) {
        this.meAsiaId = meAsiaId;
    }

    public String getMeAsiaTitle() {
        return meAsiaTitle;
    }

    public void setMeAsiaTitle(String meAsiaTitle) {
        this.meAsiaTitle = meAsiaTitle;
    }

    public String getMeAsiaContent() {
        return meAsiaContent;
    }

    public void setMeAsiaContent(String meAsiaContent) {
        this.meAsiaContent = meAsiaContent;
    }

    public int getMeAsiaHit() {
        return meAsiaHit;
    }

    public void setMeAsiaHit(int meAsiaHit) {
        this.meAsiaHit = meAsiaHit;
    }

    public String getMeAsiaDate() {
        return meAsiaDate;
    }

    public void setMeAsiaDate(String meAsiaDate) {
        this.meAsiaDate = meAsiaDate;
    }

    public String getMeAsiaCategory() {
        return meAsiaCategory;
    }

    public void setMeAsiaCategory(String meAsiaCategory) {
        this.meAsiaCategory = meAsiaCategory;
    }
}
