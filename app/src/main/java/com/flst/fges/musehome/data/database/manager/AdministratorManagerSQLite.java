package com.flst.fges.musehome.data.database.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flst.fges.musehome.data.database.MySQLite;
import com.flst.fges.musehome.data.model.Administrator;

import java.util.ArrayList;

import static com.flst.fges.musehome.data.database.manager.CollectionManagerSQLite.KEY_NAME;

/**
 * Created by Olive on 04/03/2017.
 */

public class AdministratorManagerSQLite {
    private static final String TABLE_NAME = "administrator";
    public static final String KEY_EMAIL="email";
    public static final String KEY_FIRSTNAME="firstName";
    public static final String KEY_LASTNAME="lastName";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_ACTIVATED="activated";
    public static final String CREATE_TABLE_ADMINISTRATOR= "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_EMAIL+" TEXT," +
            " "+KEY_FIRSTNAME+" TEXT," +
            " "+KEY_LASTNAME+" TEXT," +
            " "+KEY_PASSWORD+" TEXT," +
            " "+KEY_ACTIVATED+" NUMERIC" +
            ");";
    private MySQLite mySQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public AdministratorManagerSQLite(Context context) {
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

    public long addAdministrator(Administrator admin) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, admin.getEmail());
        values.put(KEY_FIRSTNAME, admin.getFirstName());
        values.put(KEY_LASTNAME, admin.getLastName());
        values.put(KEY_PASSWORD, admin.getPassword());
        values.put(KEY_ACTIVATED, admin.isActivated());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int updateAdministrator(Administrator admini) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, admini.getEmail());
        values.put(KEY_FIRSTNAME, admini.getFirstName());
        values.put(KEY_LASTNAME, admini.getLastName());
        values.put(KEY_PASSWORD, admini.getPassword());
        values.put(KEY_ACTIVATED, admini.isActivated());

        String where = KEY_EMAIL+" = ?";
        String[] whereArgs = {admini.getEmail()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int deleteAdmini(Administrator admini) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_EMAIL+" = ?";
        String[] whereArgs = {admini.getEmail()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public Administrator getAdministratorByMail(String mail) {
        // Retourne l'administrateur dont l'email est passé en paramètre

        Administrator admini = new Administrator();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_EMAIL+"= '"+mail+"'", null);
        if (c.moveToFirst()) {
            admini.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
            admini.setFirstName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));
            admini.setLastName(c.getString(c.getColumnIndex(KEY_LASTNAME)));
            admini.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
            if(c.getColumnIndex(KEY_ACTIVATED)>0)
            admini.setActivated(true);
            else admini.setActivated(false);
            c.close();
        }

        return admini;
    }

    public ArrayList<Administrator> getAllAdministrators() {
        ArrayList<Administrator> administrators = new ArrayList<>();
        // sélection de tous les enregistrements de la table
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Administrator admini = new Administrator();
            admini.setEmail(cursor.getString(cursor.getColumnIndex(AdministratorManagerSQLite.KEY_EMAIL)));
            admini.setFirstName(cursor.getString(cursor.getColumnIndex(AdministratorManagerSQLite.KEY_FIRSTNAME)));
            admini.setLastName(cursor.getString(cursor.getColumnIndex(AdministratorManagerSQLite.KEY_LASTNAME)));
            admini.setPassword(cursor.getString(cursor.getColumnIndex(AdministratorManagerSQLite.KEY_PASSWORD)));
            if(cursor.getColumnIndex(AdministratorManagerSQLite.KEY_ACTIVATED)>0)
                admini.setActivated(true);
            else admini.setActivated(false);

            administrators.add(admini);
        }
        return administrators;
    }

}
