package com.flst.fges.musehome.data.model;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
public class Collection {
    private String nom;
    private String famille;
    private String uri;
    private String uriadmin;
    private String img;

    public Collection() {
    }

    public Collection(String nom, String famille, String img) {
        this.nom = nom;
        this.famille = famille;
        this.img = img;
    }

    public Collection(String nom, String famille, String uri, String uriadmin, String img) {
        this.nom = nom;
        this.famille = famille;
        this.uri = uri;
        this.uriadmin = uriadmin;
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUriadmin() {
        return uriadmin;
    }

    public void setUriadmin(String uriadmin) {
        this.uriadmin = uriadmin;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}