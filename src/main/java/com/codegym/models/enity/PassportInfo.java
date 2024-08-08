package com.codegym.models.enity;


import jakarta.persistence.*;

@Entity
public class PassportInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String signedBy;

    public PassportInfo() {
    }

    public PassportInfo(String country, String signedBy) {
        this.country = country;
        this.signedBy = signedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }
}
