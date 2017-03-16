package com.flst.fges.musehome.data.database.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flst.fges.musehome.data.database.MySQLite;
import com.flst.fges.musehome.data.model.Evenement;

import java.util.ArrayList;

/**
 * Created by Olive on 04/03/2017.
 */

public class EvenementManagerSQLite {
    public static final String TABLE_NAME = "evenement";
    public static final String KEY_TITRE="titre";
    public static final String KEY_MINIDESCR="miniDescr";
    public static final String KEY_IMAGEURI="imageuri";
    public static final String KEY_MINIIMAGEURI="miniimageuri";
    public static final String KEY_TWITTER="twitter";
    public static final String KEY_FACEBOOK="facebook";
    public static final String KEY_GO="go";
        public static final String CREATE_TABLE_EVENEMENT = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_TITRE+" TEXT," +
            " "+KEY_MINIDESCR+" TEXT," +
            " "+KEY_IMAGEURI+" TEXT," +
            " "+KEY_MINIIMAGEURI+" TEXT," +
            " "+KEY_TWITTER+" TEXT," +
            " "+KEY_FACEBOOK+" TEXT," +
            " "+KEY_GO+" TEXT" +
            ");";
    private MySQLite mySQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public EvenementManagerSQLite(Context context) {
        mySQLite = MySQLite.getInstance(context);
    }

    public void open() {
        //on ouvre la table en lecture/écriture
        db = mySQLite.getWritableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addEvent(Evenement evenement) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_TITRE, evenement.getTitre());
        values.put(KEY_MINIDESCR, evenement.getMiniDescr());
        values.put(KEY_IMAGEURI,evenement.getImageuri());
        values.put(KEY_MINIIMAGEURI,evenement.getImageuri());
        values.put(KEY_FACEBOOK,evenement.getFacebook());
        values.put(KEY_TWITTER,evenement.getTwitter());
        /*values.put(KEY_GO,evenement.getGo());*/

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int updateEvent(Evenement evenement) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_TITRE, evenement.getTitre());
        values.put(KEY_MINIDESCR, evenement.getMiniDescr());
        values.put(KEY_IMAGEURI,evenement.getImageuri());
        values.put(KEY_MINIIMAGEURI,evenement.getImageuri());
        values.put(KEY_FACEBOOK,evenement.getFacebook());
        values.put(KEY_TWITTER,evenement.getTwitter());
        values.put(KEY_GO,evenement.getGo());

        String where = KEY_TITRE+" = ?";
        String[] whereArgs = {evenement.getTitre()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int deleteEvent(Evenement evenement) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_TITRE+" = ?";
        String[] whereArgs = {evenement.getTitre()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public void deleteAllEvents() {

        db.delete(TABLE_NAME, null, null);
    }

    public Evenement getEventByTitre(String titre) {
        // Retourne l'evenement dont le titre est passé en paramètre

        Evenement evenement = new Evenement();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_TITRE+"= '"+titre+"'", null);
        if (c.moveToFirst()) {
            evenement.setTitre(c.getString(c.getColumnIndex(KEY_TITRE)));
            evenement.setMiniDescr(c.getString(c.getColumnIndex(KEY_MINIDESCR)));
            evenement.setFacebook(c.getString(c.getColumnIndex(KEY_FACEBOOK)));
            evenement.setImageuri(c.getString(c.getColumnIndex(KEY_IMAGEURI)));
            evenement.setTwitter(c.getString(c.getColumnIndex(KEY_TWITTER)));
            evenement.setGo(c.getString(c.getColumnIndex(KEY_GO)));
            evenement.setMiniimageuri(c.getString(c.getColumnIndex(KEY_MINIIMAGEURI)));
            c.close();
        }

        return evenement;
    }

    public ArrayList<Evenement> getAllEvent() {
        ArrayList<Evenement> evenements = new ArrayList<>();
        // sélection de tous les enregistrements de la table
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Evenement evenement = new Evenement();
            evenement.setTitre(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_TITRE)));
            evenement.setMiniDescr(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_MINIDESCR)));
            evenement.setFacebook(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_FACEBOOK)));
            evenement.setImageuri(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_IMAGEURI)));
            evenement.setTwitter(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_TWITTER)));
            evenement.setGo(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_GO)));
            evenement.setMiniimageuri(c.getString(c.getColumnIndex(EvenementManagerSQLite.KEY_MINIIMAGEURI)));
            evenements.add(evenement);

        }
        return evenements;
    }

}
