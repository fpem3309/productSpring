package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="ncamericaboard")
public class NCAmericaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="ncAmericaId")
    private int ncAmericaId;
    @Column(name = "ncAmericaTitle")
    private String ncAmericaTitle;
    @Column(name = "ncAmericaContent")
    private String ncAmericaContent;
    @Column(name = "ncAmericaHit")
    private int ncAmericaHit;
    @Column(name = "ncAmericaDate")
    private String ncAmericaDate;
    @Column(name = "ncAmericaCategory")
    private String ncAmericaCategory;

    public int getNcAmericaId() {
        return ncAmericaId;
    }

    public void setNcAmericaId(int ncAmericaId) {
        this.ncAmericaId = ncAmericaId;
    }

    public String getNcAmericaTitle() {
        return ncAmericaTitle;
    }

    public void setNcAmericaTitle(String ncAmericaTitle) {
        this.ncAmericaTitle = ncAmericaTitle;
    }

    public String getNcAmericaContent() {
        return ncAmericaContent;
    }

    public void setNcAmericaContent(String ncAmericaContent) {
        this.ncAmericaContent = ncAmericaContent;
    }

    public int getNcAmericaHit() {
        return ncAmericaHit;
    }

    public void setNcAmericaHit(int ncAmericaHit) {
        this.ncAmericaHit = ncAmericaHit;
    }

    public String getNcAmericaDate() {
        return ncAmericaDate;
    }

    public void setNcAmericaDate(String ncAmericaDate) {
        this.ncAmericaDate = ncAmericaDate;
    }

    public String getNcAmericaCategory() {
        return ncAmericaCategory;
    }

    public void setNcAmericaCategory(String ncAmericaCategory) {
        this.ncAmericaCategory = ncAmericaCategory;
    }
}
