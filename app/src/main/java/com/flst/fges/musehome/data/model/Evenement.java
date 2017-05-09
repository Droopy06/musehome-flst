package com.flst.fges.musehome.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@DatabaseTable(tableName = "evenement")
public class Evenement {

    @DatabaseField(generatedId = true)
    protected Integer id;
    private String titre;
    private String miniDescr;
    private String imageuri;
    private String miniimageuri;
    private String twitter;
    private String facebook;
    private String go;


    public Evenement() {
    }

    public Evenement(String titre, String miniDescr, String imageuri, String miniimageuri, String twitter, String facebook, String go) {
        this.titre = titre;
        this.miniDescr = miniDescr;
        this.imageuri = imageuri;
        this.miniimageuri = miniimageuri;
        this.twitter = twitter;
        this.facebook = facebook;
        this.go = go;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMiniDescr() {
        return miniDescr;
    }

    public void setMiniDescr(String miniDescr) {
        this.miniDescr = miniDescr;
    }

    public String getImageuri() {
        return imageuri;
    }

    public void setImageuri(String imageuri) {
        this.imageuri = imageuri;
    }

    public String getMiniimageuri() {
        return miniimageuri;
    }

    public void setMiniimageuri(String miniimageuri) {
        this.miniimageuri = miniimageuri;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGo() {
        return go;
    }

    public void setGo(String go) {
        this.go = go;
    }
}
