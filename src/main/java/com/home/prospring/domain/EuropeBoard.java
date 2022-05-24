package com.home.prospring.domain;


import javax.persistence.*;

@Entity
@Table(name="europeboard")
public class EuropeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK
    @Column(name="europeId")
    private int europeId;
    @Column(name = "europeTitle")
    private String europeTitle;
    @Column(name = "europeContent")
    private String europeContent;
    @Column(name = "europeHit")
    private int europeHit;
    @Column(name = "europeDate")
    private String europeDate;
    @Column(name = "europeCategory")
    private String europeCategory;

    public int getEuropeId() {
        return europeId;
    }

    public void setEuropeId(int europeId) {
        this.europeId = europeId;
    }

    public String getEuropeTitle() {
        return europeTitle;
    }

    public void setEuropeTitle(String europeTitle) {
        this.europeTitle = europeTitle;
    }

    public String getEuropeContent() {
        return europeContent;
    }

    public void setEuropeContent(String europeContent) {
        this.europeContent = europeContent;
    }

    public int getEuropeHit() {
        return europeHit;
    }

    public void setEuropeHit(int europeHit) {
        this.europeHit = europeHit;
    }

    public String getEuropeDate() {
        return europeDate;
    }

    public void setEuropeDate(String europeDate) {
        this.europeDate = europeDate;
    }

    public String getEuropeCategory() {
        return europeCategory;
    }

    public void setEuropeCategory(String europeCategory) {
        this.europeCategory = europeCategory;
    }
}
