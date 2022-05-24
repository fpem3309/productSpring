package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="ncamericaboard")
public class NCAmericaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="ncamericaId")
    private int ncamericaId;
    @Column(name = "ncamericaTitle")
    private String ncamericaTitle;
    @Column(name = "ncamericaContent")
    private String ncamericaContent;
    @Column(name = "ncamericaHit")
    private int ncamericaHit;
    @Column(name = "ncamericaDate")
    private String ncamericaDate;
    @Column(name = "ncamericaCategory")
    private String ncamericaCategory;

    public int getNcamericaId() {
        return ncamericaId;
    }

    public void setNcamericaId(int ncamericaId) {
        this.ncamericaId = ncamericaId;
    }

    public String getNcamericaTitle() {
        return ncamericaTitle;
    }

    public void setNcamericaTitle(String ncamericaTitle) {
        this.ncamericaTitle = ncamericaTitle;
    }

    public String getNcamericaContent() {
        return ncamericaContent;
    }

    public void setNcamericaContent(String ncamericaContent) {
        this.ncamericaContent = ncamericaContent;
    }

    public int getNcamericaHit() {
        return ncamericaHit;
    }

    public void setNcamericaHit(int ncamericaHit) {
        this.ncamericaHit = ncamericaHit;
    }

    public String getNcamericaDate() {
        return ncamericaDate;
    }

    public void setNcamericaDate(String ncamericaDate) {
        this.ncamericaDate = ncamericaDate;
    }

    public String getNcamericaCategory() {
        return ncamericaCategory;
    }

    public void setNcamericaCategory(String ncamericaCategory) {
        this.ncamericaCategory = ncamericaCategory;
    }
}
