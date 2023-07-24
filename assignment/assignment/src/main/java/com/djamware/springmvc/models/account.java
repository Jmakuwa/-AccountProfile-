package com.djamware.springmvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accName;

    private String accSurname;

    private String accImageData;

    private Double accImage;

    public account() {
    }

    public account(String accName, String accSurname, String accImageData, Double accImage) {
        this.accName = accName;
        this.accSurname = accSurname;
        this.accImageData = accImageData;
        this.accImage = accImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getaccName() {
        return accName;
    }

    public void setaccName(String accName) {
        this.accName = accName;
    }

    public String getaccSurname() {
        return accSurname;
    }

    public void setaccSurname(String accSurname) {
        this.accSurname = accSurname;
    }

    public String getaccImageData() {
        return accImageData;
    }

    public void setaccImageData(String accImageData) {
        this.accImageData = accImageData;
    }

    public Double getaccImage() {
        return  accImage;
    }

    public void setaccImage(Double accImage) {
        this. accImage =  accImage;
    }

}