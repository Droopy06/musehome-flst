package com.flst.fges.musehome.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.flst.fges.musehome.data.database.manager.CollectionManagerSQLite;
import com.flst.fges.musehome.data.database.manager.EvenementManagerSQLite;

/**
 * Created by LAMOOT Alexandre on 03/03/2017.
 */

public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db.musehome.sqlite";
    private static final int DATABASE_VERSION = 4;
    private static MySQLite sInstance;

    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) { sInstance = new MySQLite(context); }
        return sInstance;
    }

    private MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Création de la base de données
        // on exécute ici les requêtes de création des tables
        sqLiteDatabase.execSQL(CollectionManagerSQLite.CREATE_TABLE_COLLECTION); // création table "collection"
        sqLiteDatabase.execSQL(EvenementManagerSQLite.CREATE_TABLE_EVENEMENT); // création table "events"
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        // Mise à jour de la base de données
        // méthode appelée sur incrémentation de DATABASE_VERSION
        // on peut faire ce qu'on veut ici, comme recréer la base :
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CollectionManagerSQLite.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EvenementManagerSQLite.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
