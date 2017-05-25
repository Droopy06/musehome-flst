package com.flst.fges.musehome.data.model;

/**
 * Created by LAMOOT Alexandre on 02/04/2017.
 */

public class Persons {

    private String name;
    private String lastName;
    private String mail;
    private int img;
    private int type;
    public static final int OVERSIGHT_TYPE=0;
    public static final int DEVELOPER_TYPE=1;

    public Persons() {
    }

    public Persons(String name, String lastName, String mail, int img,int type) {
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.img = img;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
