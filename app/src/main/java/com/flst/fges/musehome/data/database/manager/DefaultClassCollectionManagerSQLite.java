package com.flst.fges.musehome.data.database.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.flst.fges.musehome.data.database.MySQLite;
import com.flst.fges.musehome.data.model.DefaultClassCollection;

import java.util.ArrayList;

/**
 * Created by Olive on 04/03/2017.
 */

public class DefaultClassCollectionManagerSQLite {

    public static String KEY_ID="id";
    public static String KEY_COLLECTION="collection";
    public static String KEY_PICTURE="picture";
    public static String KEY_NAME="name";
    public static String KEY_GROUPE="groupe";
    public static String KEY_KIND="kind";
    public static String KEY_ESPECE="espece";
    public static String KEY_AUTHOR="author";
    public static String KEY_YEAR="year";
    public static String KEY_COUNTRY="country";
    public static String KEY_CITY="city";
    public static String KEY_PLACE="place";
    public static String KEY_NAMECOLLECTION="nameCollection";
    public static String KEY_MANIFOLD="manifold";
    public static String KEY_LOCALIZATION="localization";
    public static String KEY_ANNEXE1="annexe1";
    public static String KEY_ANNEXE2="annexe2";
    public static String KEY_ANNEXE3="annexe3";
    public static String KEY_ANNEXE4="annexe4";
    public static String KEY_ANNEXE5="annexe5";
    public static String KEY_ANNEXE6="annexe6";
    public static String KEY_ANNEXE7="annexe7";
    public static String KEY_ANNEXE8="annexe8";
    public static String KEY_ANNEXE9="annexe9";
    public static String KEY_ANNEXE10="annexe10";
    public static String KEY_ANNEXE11="annexe11";
    public static String KEY_ANNEXE12="annexe12";
    public static String KEY_ANNEXE13="annexe13";
    public static String KEY_ANNEXE14="annexe14";
    public static String KEY_ANNEXE15="annexe15";
    public static String KEY_ANNEXE16="annexe16";
    public static String KEY_ANNEXE17="annexe17";
    public static String KEY_ANNEXE18="annexe18";
    public static String KEY_ANNEXE19="annexe19";
    public static String KEY_ANNEXE20="annexe20";
    public static String KEY_ANNEXE21="annexe21";
    public static String KEY_ANNEXE22="annexe22";
    public static String KEY_ANNEXE23="annexe23";
    public static String KEY_ANNEXE24="annexe24";
    public static String KEY_ANNEXE25="annexe25";
    public static String KEY_ANNEXE26="annexe26";
    public static String KEY_ANNEXE27="annexe27";
    public static String KEY_ANNEXE28="annexe28";
    public static String KEY_ANNEXE29="annexe29";
    public static String KEY_ANNEXE30="annexe30";
    public static String KEY_ANNEXE31="annexe31";
    public static String KEY_ANNEXE32="annexe32";
    public static String KEY_ANNEXE33="annexe33";
    public static String KEY_ANNEXE34="annexe34";
    public static String KEY_ANNEXE35="annexe35";
    public static String KEY_ANNEXE36="annexe36";
    public static String KEY_ANNEXE37="annexe37";
    public static String KEY_ANNEXE38="annexe38";
    public static String KEY_ANNEXE39="annexe39";
    public static String KEY_ANNEXE40="annexe40";

    public static String TABLE_NAME = "defaultclasscollection";

    public static String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +
            " (" +
            " "+KEY_ID+" TEXT," +
            " "+KEY_COLLECTION+" TEXT," +
            " "+KEY_PICTURE+" TEXT," +
            " "+KEY_NAME+" TEXT," +
            " "+KEY_GROUPE+" TEXT," +
            " "+KEY_KIND+" TEXT," +
            " "+KEY_ESPECE+" TEXT," +
            " "+KEY_AUTHOR+" TEXT," +
            " "+KEY_YEAR+" TEXT," +
            " "+KEY_COUNTRY+" TEXT," +
            " "+KEY_CITY+" TEXT," +
            " "+KEY_PLACE+" TEXT," +
            " "+KEY_NAMECOLLECTION+" TEXT," +
            " "+KEY_MANIFOLD+" TEXT," +
            " "+KEY_LOCALIZATION+" TEXT," +
            " "+KEY_ANNEXE1+" TEXT," +
            " "+KEY_ANNEXE2+" TEXT," +
            " "+KEY_ANNEXE3+" TEXT," +
            " "+KEY_ANNEXE4+" TEXT," +
            " "+KEY_ANNEXE5+" TEXT," +
            " "+KEY_ANNEXE6+" TEXT," +
            " "+KEY_ANNEXE7+" TEXT," +
            " "+KEY_ANNEXE8+" TEXT," +
            " "+KEY_ANNEXE9+" TEXT," +
            " "+KEY_ANNEXE10+" TEXT," +
            " "+KEY_ANNEXE11+" TEXT," +
            " "+KEY_ANNEXE12+" TEXT," +
            " "+KEY_ANNEXE13+" TEXT," +
            " "+KEY_ANNEXE14+" TEXT," +
            " "+KEY_ANNEXE15+" TEXT," +
            " "+KEY_ANNEXE16+" TEXT," +
            " "+KEY_ANNEXE17+" TEXT," +
            " "+KEY_ANNEXE18+" TEXT," +
            " "+KEY_ANNEXE19+" TEXT," +
            " "+KEY_ANNEXE20+" TEXT," +
            " "+KEY_ANNEXE21+" TEXT," +
            " "+KEY_ANNEXE22+" TEXT," +
            " "+KEY_ANNEXE23+" TEXT," +
            " "+KEY_ANNEXE24+" TEXT," +
            " "+KEY_ANNEXE25+" TEXT," +
            " "+KEY_ANNEXE26+" TEXT," +
            " "+KEY_ANNEXE27+" TEXT," +
            " "+KEY_ANNEXE28+" TEXT," +
            " "+KEY_ANNEXE29+" TEXT," +
            " "+KEY_ANNEXE30+" TEXT," +
            " "+KEY_ANNEXE31+" TEXT," +
            " "+KEY_ANNEXE32+" TEXT," +
            " "+KEY_ANNEXE33+" TEXT," +
            " "+KEY_ANNEXE34+" TEXT," +
            " "+KEY_ANNEXE35+" TEXT," +
            " "+KEY_ANNEXE36+" TEXT," +
            " "+KEY_ANNEXE37+" TEXT," +
            " "+KEY_ANNEXE38+" TEXT," +
            " "+KEY_ANNEXE39+" TEXT," +
            " "+KEY_ANNEXE40+" TEXT" +
            ");";
    private MySQLite mySQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public DefaultClassCollectionManagerSQLite(Context context) {
        mySQLite = MySQLite.getInstance(context);
    }

    private static String getTableName() {
        return TABLE_NAME;
    }

    public void setTableName(String tableName) {
        TABLE_NAME = tableName;
        CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +
                " (" +
                " "+KEY_ID+" TEXT," +
                " "+KEY_COLLECTION+" TEXT," +
                " "+KEY_PICTURE+" TEXT," +
                " "+KEY_NAME+" TEXT," +
                " "+KEY_GROUPE+" TEXT," +
                " "+KEY_KIND+" TEXT," +
                " "+KEY_ESPECE+" TEXT," +
                " "+KEY_AUTHOR+" TEXT," +
                " "+KEY_YEAR+" TEXT," +
                " "+KEY_COUNTRY+" TEXT," +
                " "+KEY_CITY+" TEXT," +
                " "+KEY_PLACE+" TEXT," +
                " "+KEY_NAMECOLLECTION+" TEXT," +
                " "+KEY_MANIFOLD+" TEXT," +
                " "+KEY_LOCALIZATION+" TEXT," +
                " "+KEY_ANNEXE1+" TEXT," +
                " "+KEY_ANNEXE2+" TEXT," +
                " "+KEY_ANNEXE3+" TEXT," +
                " "+KEY_ANNEXE4+" TEXT," +
                " "+KEY_ANNEXE5+" TEXT," +
                " "+KEY_ANNEXE6+" TEXT," +
                " "+KEY_ANNEXE7+" TEXT," +
                " "+KEY_ANNEXE8+" TEXT," +
                " "+KEY_ANNEXE9+" TEXT," +
                " "+KEY_ANNEXE10+" TEXT," +
                " "+KEY_ANNEXE11+" TEXT," +
                " "+KEY_ANNEXE12+" TEXT," +
                " "+KEY_ANNEXE13+" TEXT," +
                " "+KEY_ANNEXE14+" TEXT," +
                " "+KEY_ANNEXE15+" TEXT," +
                " "+KEY_ANNEXE16+" TEXT," +
                " "+KEY_ANNEXE17+" TEXT," +
                " "+KEY_ANNEXE18+" TEXT," +
                " "+KEY_ANNEXE19+" TEXT," +
                " "+KEY_ANNEXE20+" TEXT," +
                " "+KEY_ANNEXE21+" TEXT," +
                " "+KEY_ANNEXE22+" TEXT," +
                " "+KEY_ANNEXE23+" TEXT," +
                " "+KEY_ANNEXE24+" TEXT," +
                " "+KEY_ANNEXE25+" TEXT," +
                " "+KEY_ANNEXE26+" TEXT," +
                " "+KEY_ANNEXE27+" TEXT," +
                " "+KEY_ANNEXE28+" TEXT," +
                " "+KEY_ANNEXE29+" TEXT," +
                " "+KEY_ANNEXE30+" TEXT," +
                " "+KEY_ANNEXE31+" TEXT," +
                " "+KEY_ANNEXE32+" TEXT," +
                " "+KEY_ANNEXE33+" TEXT," +
                " "+KEY_ANNEXE34+" TEXT," +
                " "+KEY_ANNEXE35+" TEXT," +
                " "+KEY_ANNEXE36+" TEXT," +
                " "+KEY_ANNEXE37+" TEXT," +
                " "+KEY_ANNEXE38+" TEXT," +
                " "+KEY_ANNEXE39+" TEXT," +
                " "+KEY_ANNEXE40+" TEXT" +
                ");";
    }

    public void open() {
        //on ouvre la table en lecture/écriture
        db = mySQLite.getWritableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addElementCollection(DefaultClassCollection collection) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_ID, collection.getId());
        values.put(KEY_COLLECTION, collection.getCollection());
        values.put(KEY_CITY, collection.getCity());
        values.put(KEY_COUNTRY, collection.getCountry());
        values.put(KEY_NAME, collection.getName());
        values.put(KEY_ESPECE, collection.getEspece());
        values.put(KEY_KIND, collection.getKind());
        values.put(KEY_AUTHOR, collection.getAuthor());
        values.put(KEY_YEAR, collection.getYear());
        values.put(KEY_LOCALIZATION, collection.getLocalization());
        values.put(KEY_GROUPE, collection.getGroupe());
        values.put(KEY_PICTURE, collection.getPicture());
        values.put(KEY_PLACE, collection.getPlace());
        values.put(KEY_NAMECOLLECTION, collection.getNameCollection());
        values.put(KEY_MANIFOLD, collection.getManifold());
        values.put(KEY_ANNEXE1, collection.getAnnexe1());
        values.put(KEY_ANNEXE2, collection.getAnnexe2());
        values.put(KEY_ANNEXE3, collection.getAnnexe3());
        values.put(KEY_ANNEXE4, collection.getAnnexe4());
        values.put(KEY_ANNEXE5, collection.getAnnexe5());
        values.put(KEY_ANNEXE6, collection.getAnnexe6());
        values.put(KEY_ANNEXE7, collection.getAnnexe7());
        values.put(KEY_ANNEXE8, collection.getAnnexe8());
        values.put(KEY_ANNEXE9, collection.getAnnexe9());
        values.put(KEY_ANNEXE10, collection.getAnnexe10());
        values.put(KEY_ANNEXE11, collection.getAnnexe11());
        values.put(KEY_ANNEXE12, collection.getAnnexe12());
        values.put(KEY_ANNEXE13, collection.getAnnexe13());
        values.put(KEY_ANNEXE14, collection.getAnnexe14());
        values.put(KEY_ANNEXE15, collection.getAnnexe15());
        values.put(KEY_ANNEXE16, collection.getAnnexe16());
        values.put(KEY_ANNEXE17, collection.getAnnexe17());
        values.put(KEY_ANNEXE18, collection.getAnnexe18());
        values.put(KEY_ANNEXE19, collection.getAnnexe19());
        values.put(KEY_ANNEXE20, collection.getAnnexe20());
        values.put(KEY_ANNEXE21, collection.getAnnexe21());
        values.put(KEY_ANNEXE22, collection.getAnnexe22());
        values.put(KEY_ANNEXE23, collection.getAnnexe23());
        values.put(KEY_ANNEXE24, collection.getAnnexe24());
        values.put(KEY_ANNEXE25, collection.getAnnexe25());
        values.put(KEY_ANNEXE26, collection.getAnnexe26());
        values.put(KEY_ANNEXE27, collection.getAnnexe27());
        values.put(KEY_ANNEXE28, collection.getAnnexe28());
        values.put(KEY_ANNEXE29, collection.getAnnexe29());
        values.put(KEY_ANNEXE30, collection.getAnnexe30());
        values.put(KEY_ANNEXE31, collection.getAnnexe31());
        values.put(KEY_ANNEXE32, collection.getAnnexe32());
        values.put(KEY_ANNEXE33, collection.getAnnexe33());
        values.put(KEY_ANNEXE34, collection.getAnnexe34());
        values.put(KEY_ANNEXE35, collection.getAnnexe35());
        values.put(KEY_ANNEXE36, collection.getAnnexe36());
        values.put(KEY_ANNEXE37, collection.getAnnexe37());
        values.put(KEY_ANNEXE38, collection.getAnnexe38());
        values.put(KEY_ANNEXE39, collection.getAnnexe39());
        values.put(KEY_ANNEXE40, collection.getAnnexe40());
        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(getTableName(),null,values);
    }

    public int updateElementCollection(DefaultClassCollection collection) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_ID, collection.getId());
        values.put(KEY_COLLECTION, collection.getCollection());
        values.put(KEY_CITY, collection.getCity());
        values.put(KEY_COUNTRY, collection.getCountry());
        values.put(KEY_NAME, collection.getName());
        values.put(KEY_ESPECE, collection.getEspece());
        values.put(KEY_KIND, collection.getKind());
        values.put(KEY_AUTHOR, collection.getAuthor());
        values.put(KEY_YEAR, collection.getYear());
        values.put(KEY_LOCALIZATION, collection.getLocalization());
        values.put(KEY_GROUPE, collection.getGroupe());
        values.put(KEY_PICTURE, collection.getPicture());
        values.put(KEY_PLACE, collection.getPlace());
        values.put(KEY_NAMECOLLECTION, collection.getNameCollection());
        values.put(KEY_MANIFOLD, collection.getManifold());
        values.put(KEY_ANNEXE1, collection.getAnnexe1());
        values.put(KEY_ANNEXE2, collection.getAnnexe2());
        values.put(KEY_ANNEXE3, collection.getAnnexe3());
        values.put(KEY_ANNEXE4, collection.getAnnexe4());
        values.put(KEY_ANNEXE5, collection.getAnnexe5());
        values.put(KEY_ANNEXE6, collection.getAnnexe6());
        values.put(KEY_ANNEXE7, collection.getAnnexe7());
        values.put(KEY_ANNEXE8, collection.getAnnexe8());
        values.put(KEY_ANNEXE9, collection.getAnnexe9());
        values.put(KEY_ANNEXE10, collection.getAnnexe10());
        values.put(KEY_ANNEXE11, collection.getAnnexe11());
        values.put(KEY_ANNEXE12, collection.getAnnexe12());
        values.put(KEY_ANNEXE13, collection.getAnnexe13());
        values.put(KEY_ANNEXE14, collection.getAnnexe14());
        values.put(KEY_ANNEXE15, collection.getAnnexe15());
        values.put(KEY_ANNEXE16, collection.getAnnexe16());
        values.put(KEY_ANNEXE17, collection.getAnnexe17());
        values.put(KEY_ANNEXE18, collection.getAnnexe18());
        values.put(KEY_ANNEXE19, collection.getAnnexe19());
        values.put(KEY_ANNEXE20, collection.getAnnexe20());
        values.put(KEY_ANNEXE21, collection.getAnnexe21());
        values.put(KEY_ANNEXE22, collection.getAnnexe22());
        values.put(KEY_ANNEXE23, collection.getAnnexe23());
        values.put(KEY_ANNEXE24, collection.getAnnexe24());
        values.put(KEY_ANNEXE25, collection.getAnnexe25());
        values.put(KEY_ANNEXE26, collection.getAnnexe26());
        values.put(KEY_ANNEXE27, collection.getAnnexe27());
        values.put(KEY_ANNEXE28, collection.getAnnexe28());
        values.put(KEY_ANNEXE29, collection.getAnnexe29());
        values.put(KEY_ANNEXE30, collection.getAnnexe30());
        values.put(KEY_ANNEXE31, collection.getAnnexe31());
        values.put(KEY_ANNEXE32, collection.getAnnexe32());
        values.put(KEY_ANNEXE33, collection.getAnnexe33());
        values.put(KEY_ANNEXE34, collection.getAnnexe34());
        values.put(KEY_ANNEXE35, collection.getAnnexe35());
        values.put(KEY_ANNEXE36, collection.getAnnexe36());
        values.put(KEY_ANNEXE37, collection.getAnnexe37());
        values.put(KEY_ANNEXE38, collection.getAnnexe38());
        values.put(KEY_ANNEXE39, collection.getAnnexe39());
        values.put(KEY_ANNEXE40, collection.getAnnexe40());

        String where = KEY_ID+" = ?";
        String[] whereArgs = {collection.getId()+""};

        return db.update(getTableName(), values, where, whereArgs);
    }

    public int deleteElementCollection(DefaultClassCollection collection) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID+" = ?";
        String[] whereArgs = {collection.getId()+""};

        return db.delete(getTableName(), where, whereArgs);
    }

    public void deleteAllElementCollections() {

        db.delete(getTableName(), null, null);
    }

    public DefaultClassCollection getElementCollectionById(String id) {
        // Retourne l'animal dont l'id est passé en paramètre

        DefaultClassCollection collection = new DefaultClassCollection();

        Cursor c = db.rawQuery("SELECT * FROM "+ getTableName() +" WHERE "+KEY_ID+"= '"+id+"'", null);
        if (c.moveToFirst()) {


            collection.setId(c.getString(c.getColumnIndex(KEY_ID)));
            collection.setNameCollection(c.getString(c.getColumnIndex(KEY_NAMECOLLECTION)));
            collection.setCollection(c.getString(c.getColumnIndex(KEY_COLLECTION)));
            collection.setCity(c.getString(c.getColumnIndex(KEY_CITY)));
            collection.setCountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));
            collection.setName(c.getString(c.getColumnIndex(KEY_NAME)));
            collection.setEspece(c.getString(c.getColumnIndex(KEY_ESPECE)));
            collection.setKind(c.getString(c.getColumnIndex(KEY_KIND)));
            collection.setAuthor(c.getString(c.getColumnIndex(KEY_AUTHOR)));
            collection.setYear(c.getString(c.getColumnIndex(KEY_YEAR)));
            collection.setLocalization(c.getString(c.getColumnIndex(KEY_LOCALIZATION)));
            collection.setGroupe(c.getString(c.getColumnIndex(KEY_GROUPE)));
            collection.setPicture(c.getString(c.getColumnIndex(KEY_PICTURE)));
            collection.setPlace(c.getString(c.getColumnIndex(KEY_PLACE)));
            collection.setManifold(c.getString(c.getColumnIndex(KEY_MANIFOLD)));

            collection.setAnnexe1(c.getString(c.getColumnIndex(KEY_ANNEXE1)));
            collection.setAnnexe2(c.getString(c.getColumnIndex(KEY_ANNEXE2)));
            collection.setAnnexe3(c.getString(c.getColumnIndex(KEY_ANNEXE3)));
            collection.setAnnexe4(c.getString(c.getColumnIndex(KEY_ANNEXE4)));
            collection.setAnnexe5(c.getString(c.getColumnIndex(KEY_ANNEXE5)));
            collection.setAnnexe6(c.getString(c.getColumnIndex(KEY_ANNEXE6)));
            collection.setAnnexe7(c.getString(c.getColumnIndex(KEY_ANNEXE7)));
            collection.setAnnexe8(c.getString(c.getColumnIndex(KEY_ANNEXE8)));
            collection.setAnnexe9(c.getString(c.getColumnIndex(KEY_ANNEXE9)));
            collection.setAnnexe10(c.getString(c.getColumnIndex(KEY_ANNEXE10)));

            collection.setAnnexe11(c.getString(c.getColumnIndex(KEY_ANNEXE11)));
            collection.setAnnexe12(c.getString(c.getColumnIndex(KEY_ANNEXE12)));
            collection.setAnnexe13(c.getString(c.getColumnIndex(KEY_ANNEXE13)));
            collection.setAnnexe14(c.getString(c.getColumnIndex(KEY_ANNEXE14)));
            collection.setAnnexe15(c.getString(c.getColumnIndex(KEY_ANNEXE15)));
            collection.setAnnexe16(c.getString(c.getColumnIndex(KEY_ANNEXE16)));
            collection.setAnnexe17(c.getString(c.getColumnIndex(KEY_ANNEXE17)));
            collection.setAnnexe18(c.getString(c.getColumnIndex(KEY_ANNEXE18)));
            collection.setAnnexe19(c.getString(c.getColumnIndex(KEY_ANNEXE19)));
            collection.setAnnexe20(c.getString(c.getColumnIndex(KEY_ANNEXE20)));

            collection.setAnnexe21(c.getString(c.getColumnIndex(KEY_ANNEXE21)));
            collection.setAnnexe22(c.getString(c.getColumnIndex(KEY_ANNEXE22)));
            collection.setAnnexe23(c.getString(c.getColumnIndex(KEY_ANNEXE23)));
            collection.setAnnexe24(c.getString(c.getColumnIndex(KEY_ANNEXE24)));
            collection.setAnnexe25(c.getString(c.getColumnIndex(KEY_ANNEXE25)));
            collection.setAnnexe26(c.getString(c.getColumnIndex(KEY_ANNEXE26)));
            collection.setAnnexe27(c.getString(c.getColumnIndex(KEY_ANNEXE27)));
            collection.setAnnexe28(c.getString(c.getColumnIndex(KEY_ANNEXE28)));
            collection.setAnnexe29(c.getString(c.getColumnIndex(KEY_ANNEXE29)));
            collection.setAnnexe30(c.getString(c.getColumnIndex(KEY_ANNEXE30)));

            collection.setAnnexe31(c.getString(c.getColumnIndex(KEY_ANNEXE31)));
            collection.setAnnexe32(c.getString(c.getColumnIndex(KEY_ANNEXE32)));
            collection.setAnnexe33(c.getString(c.getColumnIndex(KEY_ANNEXE33)));
            collection.setAnnexe34(c.getString(c.getColumnIndex(KEY_ANNEXE34)));
            collection.setAnnexe35(c.getString(c.getColumnIndex(KEY_ANNEXE35)));
            collection.setAnnexe36(c.getString(c.getColumnIndex(KEY_ANNEXE36)));
            collection.setAnnexe37(c.getString(c.getColumnIndex(KEY_ANNEXE37)));
            collection.setAnnexe38(c.getString(c.getColumnIndex(KEY_ANNEXE38)));
            collection.setAnnexe39(c.getString(c.getColumnIndex(KEY_ANNEXE39)));
            collection.setAnnexe40(c.getString(c.getColumnIndex(KEY_ANNEXE40)));


            c.close();
        }

        return collection;
    }

    public ArrayList<DefaultClassCollection> getAllElementCollections() {
        ArrayList<DefaultClassCollection> collections = new ArrayList<>();
        // sélection de tous les enregistrements de la table
        Cursor c = db.rawQuery("SELECT * FROM "+ getTableName(), null);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            DefaultClassCollection collection = new DefaultClassCollection();

            collection.setId(c.getString(c.getColumnIndex(KEY_ID)));
            collection.setNameCollection(c.getString(c.getColumnIndex(KEY_NAMECOLLECTION)));
            collection.setCollection(c.getString(c.getColumnIndex(KEY_COLLECTION)));
            collection.setCity(c.getString(c.getColumnIndex(KEY_CITY)));
            collection.setCountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));
            collection.setName(c.getString(c.getColumnIndex(KEY_NAME)));
            collection.setEspece(c.getString(c.getColumnIndex(KEY_ESPECE)));
            collection.setKind(c.getString(c.getColumnIndex(KEY_KIND)));
            collection.setAuthor(c.getString(c.getColumnIndex(KEY_AUTHOR)));
            collection.setYear(c.getString(c.getColumnIndex(KEY_YEAR)));
            collection.setLocalization(c.getString(c.getColumnIndex(KEY_LOCALIZATION)));
            collection.setGroupe(c.getString(c.getColumnIndex(KEY_GROUPE)));
            collection.setPicture(c.getString(c.getColumnIndex(KEY_PICTURE)));
            collection.setPlace(c.getString(c.getColumnIndex(KEY_PLACE)));
            collection.setManifold(c.getString(c.getColumnIndex(KEY_MANIFOLD)));

            collection.setAnnexe1(c.getString(c.getColumnIndex(KEY_ANNEXE1)));
            collection.setAnnexe2(c.getString(c.getColumnIndex(KEY_ANNEXE2)));
            collection.setAnnexe3(c.getString(c.getColumnIndex(KEY_ANNEXE3)));
            collection.setAnnexe4(c.getString(c.getColumnIndex(KEY_ANNEXE4)));
            collection.setAnnexe5(c.getString(c.getColumnIndex(KEY_ANNEXE5)));
            collection.setAnnexe6(c.getString(c.getColumnIndex(KEY_ANNEXE6)));
            collection.setAnnexe7(c.getString(c.getColumnIndex(KEY_ANNEXE7)));
            collection.setAnnexe8(c.getString(c.getColumnIndex(KEY_ANNEXE8)));
            collection.setAnnexe9(c.getString(c.getColumnIndex(KEY_ANNEXE9)));
            collection.setAnnexe10(c.getString(c.getColumnIndex(KEY_ANNEXE10)));

            collection.setAnnexe11(c.getString(c.getColumnIndex(KEY_ANNEXE11)));
            collection.setAnnexe12(c.getString(c.getColumnIndex(KEY_ANNEXE12)));
            collection.setAnnexe13(c.getString(c.getColumnIndex(KEY_ANNEXE13)));
            collection.setAnnexe14(c.getString(c.getColumnIndex(KEY_ANNEXE14)));
            collection.setAnnexe15(c.getString(c.getColumnIndex(KEY_ANNEXE15)));
            collection.setAnnexe16(c.getString(c.getColumnIndex(KEY_ANNEXE16)));
            collection.setAnnexe17(c.getString(c.getColumnIndex(KEY_ANNEXE17)));
            collection.setAnnexe18(c.getString(c.getColumnIndex(KEY_ANNEXE18)));
            collection.setAnnexe19(c.getString(c.getColumnIndex(KEY_ANNEXE19)));
            collection.setAnnexe20(c.getString(c.getColumnIndex(KEY_ANNEXE20)));

            collection.setAnnexe21(c.getString(c.getColumnIndex(KEY_ANNEXE21)));
            collection.setAnnexe22(c.getString(c.getColumnIndex(KEY_ANNEXE22)));
            collection.setAnnexe23(c.getString(c.getColumnIndex(KEY_ANNEXE23)));
            collection.setAnnexe24(c.getString(c.getColumnIndex(KEY_ANNEXE24)));
            collection.setAnnexe25(c.getString(c.getColumnIndex(KEY_ANNEXE25)));
            collection.setAnnexe26(c.getString(c.getColumnIndex(KEY_ANNEXE26)));
            collection.setAnnexe27(c.getString(c.getColumnIndex(KEY_ANNEXE27)));
            collection.setAnnexe28(c.getString(c.getColumnIndex(KEY_ANNEXE28)));
            collection.setAnnexe29(c.getString(c.getColumnIndex(KEY_ANNEXE29)));
            collection.setAnnexe30(c.getString(c.getColumnIndex(KEY_ANNEXE30)));

            collection.setAnnexe31(c.getString(c.getColumnIndex(KEY_ANNEXE31)));
            collection.setAnnexe32(c.getString(c.getColumnIndex(KEY_ANNEXE32)));
            collection.setAnnexe33(c.getString(c.getColumnIndex(KEY_ANNEXE33)));
            collection.setAnnexe34(c.getString(c.getColumnIndex(KEY_ANNEXE34)));
            collection.setAnnexe35(c.getString(c.getColumnIndex(KEY_ANNEXE35)));
            collection.setAnnexe36(c.getString(c.getColumnIndex(KEY_ANNEXE36)));
            collection.setAnnexe37(c.getString(c.getColumnIndex(KEY_ANNEXE37)));
            collection.setAnnexe38(c.getString(c.getColumnIndex(KEY_ANNEXE38)));
            collection.setAnnexe39(c.getString(c.getColumnIndex(KEY_ANNEXE39)));
            collection.setAnnexe40(c.getString(c.getColumnIndex(KEY_ANNEXE40)));

            // The Cursor is now set to the right position
            collections.add(collection);
        }
        return collections;
    }


}
