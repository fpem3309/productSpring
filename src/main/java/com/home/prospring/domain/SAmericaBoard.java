package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="samericaboard")
public class SAmericaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="samericaId")
    private int samericaId;
    @Column(name = "samericaTitle")
    private String samericaTitle;
    @Column(name = "samericaContent")
    private String samericaContent;
    @Column(name = "samericaHit")
    private int samericaHit;
    @Column(name = "samericaDate")
    private String samericaDate;
    @Column(name = "samericaCategory")
    private String samericaCategory;

    public int getSamericaId() {
        return samericaId;
    }

    public void setSamericaId(int samericaId) {
        this.samericaId = samericaId;
    }

    public String getSamericaTitle() {
        return samericaTitle;
    }

    public void setSamericaTitle(String samericaTitle) {
        this.samericaTitle = samericaTitle;
    }

    public String getSamericaContent() {
        return samericaContent;
    }

    public void setSamericaContent(String samericaContent) {
        this.samericaContent = samericaContent;
    }

    public int getSamericaHit() {
        return samericaHit;
    }

    public void setSamericaHit(int samericaHit) {
        this.samericaHit = samericaHit;
    }

    public String getSamericaDate() {
        return samericaDate;
    }

    public void setSamericaDate(String samericaDate) {
        this.samericaDate = samericaDate;
    }

    public String getSamericaCategory() {
        return samericaCategory;
    }

    public void setSamericaCategory(String samericaCategory) {
        this.samericaCategory = samericaCategory;
    }
}
