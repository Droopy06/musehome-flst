package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.OuvragesCartesDocuments;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class OuvragesCartesDocumentsManagerSQLite {

    static private OuvragesCartesDocumentsManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new OuvragesCartesDocumentsManagerSQLite(ctx);
        }
    }

    static public OuvragesCartesDocumentsManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public OuvragesCartesDocumentsManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addOuvragesCartesDocuments(OuvragesCartesDocuments object) {
        try {
            getHelper().getOuvragesCartesDocumentsDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOuvragesCartesDocuments(OuvragesCartesDocuments object) {
        try {
            getHelper().getOuvragesCartesDocumentsDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOuvragesCartesDocuments(OuvragesCartesDocuments object){
        try {
            getHelper().getOuvragesCartesDocumentsDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<OuvragesCartesDocuments> getAllOuvragesCartesDocuments() {
        try {
            return (ArrayList<OuvragesCartesDocuments>) getHelper().getOuvragesCartesDocumentsDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OuvragesCartesDocuments getOuvragesCartesDocumentsById(Integer id){
        try {
            return getHelper().getOuvragesCartesDocumentsDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
