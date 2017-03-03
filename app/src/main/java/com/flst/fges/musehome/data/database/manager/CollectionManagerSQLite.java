package com.flst.fges.musehome.data.database.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flst.fges.musehome.data.database.MySQLite;
import com.flst.fges.musehome.data.model.Collection;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 03/03/2017.
 */

public class CollectionManagerSQLite {

    private static final String TABLE_NAME = "collection";
    public static final String KEY_NAME="name";
    public static final String KEY_FAMILY="famille";
    public static final String KEY_URI="uri";
    public static final String KEY_URI_ADMIN="uriadmin";
    public static final String KEY_IMG="img";
    public static final String CREATE_TABLE_COLLECTION = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_NAME+" TEXT," +
            " "+KEY_FAMILY+" TEXT," +
            " "+KEY_URI+" TEXT," +
            " "+KEY_URI_ADMIN+" TEXT," +
            " "+KEY_IMG+" TEXT" +
            ");";
    private MySQLite mySQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public CollectionManagerSQLite(Context context) {
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

    public long addCollection(Collection collection) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, collection.getNom());
        values.put(KEY_FAMILY, collection.getFamille());
        values.put(KEY_URI, collection.getUri());
        values.put(KEY_URI_ADMIN, collection.getUriadmin());
        values.put(KEY_IMG, collection.getImg());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int updateCollection(Collection collection) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, collection.getNom());
        values.put(KEY_FAMILY, collection.getFamille());
        values.put(KEY_URI, collection.getUri());
        values.put(KEY_URI_ADMIN, collection.getUriadmin());
        values.put(KEY_IMG, collection.getImg());

        String where = KEY_NAME+" = ?";
        String[] whereArgs = {collection.getNom()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int deleteCollection(Collection collection) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_NAME+" = ?";
        String[] whereArgs = {collection.getNom()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public void deleteAllCollections() {

        db.delete(TABLE_NAME, null, null);
    }

    public Collection getCollectionByName(String name) {
        // Retourne l'animal dont l'id est passé en paramètre

        Collection collection = new Collection();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_NAME+"= '"+name+"'", null);
        if (c.moveToFirst()) {
            collection.setNom(c.getString(c.getColumnIndex(KEY_NAME)));
            collection.setFamille(c.getString(c.getColumnIndex(KEY_FAMILY)));
            collection.setUri(c.getString(c.getColumnIndex(KEY_URI)));
            collection.setUriadmin(c.getString(c.getColumnIndex(KEY_URI_ADMIN)));
            collection.setImg(c.getString(c.getColumnIndex(KEY_IMG)));
            c.close();
        }

        return collection;
    }

    public ArrayList<Collection> getAllCollections() {
        ArrayList<Collection> collections = new ArrayList<>();
        // sélection de tous les enregistrements de la table
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Collection collection = new Collection();
            collection.setNom(cursor.getString(cursor.getColumnIndex(CollectionManagerSQLite.KEY_NAME)));
            collection.setFamille(cursor.getString(cursor.getColumnIndex(CollectionManagerSQLite.KEY_NAME)));
            collection.setUri(cursor.getString(cursor.getColumnIndex(CollectionManagerSQLite.KEY_NAME)));
            collection.setUriadmin(cursor.getString(cursor.getColumnIndex(CollectionManagerSQLite.KEY_NAME)));
            collection.setImg(cursor.getString(cursor.getColumnIndex(CollectionManagerSQLite.KEY_NAME)));
            // The Cursor is now set to the right position
            collections.add(collection);
        }
        return collections;
    }

}