package com.flst.fges.musehome.data.model;

/**
 * Created by LAMOOT Alexandre on 02/04/2017.
 */

public class Persons {

    private String name;
    private String lastName;
    private String mail;
    private int img;

    public Persons() {
    }

    public Persons(String name, String lastName, String mail, int img) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
