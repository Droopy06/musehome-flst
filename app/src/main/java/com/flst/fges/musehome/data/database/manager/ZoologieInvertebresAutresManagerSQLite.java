package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieInvertebresAutresManagerSQLite {

    static private ZoologieInvertebresAutresManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieInvertebresAutresManagerSQLite(ctx);
        }
    }

    static public ZoologieInvertebresAutresManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieInvertebresAutresManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieInvertebresAutres(ZoologieInvertebresAutres object) {
        try {
            getHelper().getZoologieInvertebresAutresDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieInvertebresAutres(ZoologieInvertebresAutres object) {
        try {
            getHelper().getZoologieInvertebresAutresDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieInvertebresAutres(ZoologieInvertebresAutres object){
        try {
            getHelper().getZoologieInvertebresAutresDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieInvertebresAutres> getAllZoologieInvertebresAutres() {
        try {
            return (ArrayList<ZoologieInvertebresAutres>) getHelper().getZoologieInvertebresAutresDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieInvertebresAutres getZoologieInvertebresAutresById(Integer id){
        try {
            return getHelper().getZoologieInvertebresAutresDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
