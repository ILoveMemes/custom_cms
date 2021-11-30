package com.example.cmsexample.models;

import javax.persistence.*;

@Entity
@Table(name = "common")
public class Common {

    @Id
    @Column(name = "id")
    //@SequenceGenerator(name = "hibernateSeq", sequenceName = "HIBERNATE_SEQUENCE", allocationSize = 1)
    //@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "hibernateSeq")
    private int id;

    @Column(name = "siteIcon")
    private int siteIcon;

    @Column(name = "siteCaption")
    private String siteCaption;

    @Column(name = "onPageCaption")
    private String onPageCaption;

    @Column(name = "backgroundPicture")
    private int backgroundPicture;

    @Column(name = "firstPicture")
    private int firstPicture;

    @Column(name = "topText")
    private String topText;

    @Column(name = "transBtnText")
    private String transBtnText;

    @Column(name = "transBtnRef")
    private String transBtnRef;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteIcon() {
        return siteIcon;
    }

    public void setSiteIcon(int siteIcon) {
        this.siteIcon = siteIcon;
    }

    public String getSiteCaption() {
        return siteCaption;
    }

    public void setSiteCaption(String siteCaption) {
        this.siteCaption = siteCaption;
    }

    public String getOnPageCaption() {
        return onPageCaption;
    }

    public void setOnPageCaption(String onPageCaption) {
        this.onPageCaption = onPageCaption;
    }

    public int getBackgroundPicture() {
        return backgroundPicture;
    }

    public void setBackgroundPicture(int backgroundPicture) {
        this.backgroundPicture = backgroundPicture;
    }

    public int getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(int firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getTransBtnText() {
        return transBtnText;
    }

    public void setTransBtnText(String transBtnText) {
        this.transBtnText = transBtnText;
    }

    public String getTransBtnRef() {
        return transBtnRef;
    }

    public void setTransBtnRef(String transBtnRef) {
        this.transBtnRef = transBtnRef;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
