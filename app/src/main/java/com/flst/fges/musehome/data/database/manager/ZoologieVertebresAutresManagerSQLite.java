package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieVertebresAutresManagerSQLite {

    static private ZoologieVertebresAutresManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieVertebresAutresManagerSQLite(ctx);
        }
    }

    static public ZoologieVertebresAutresManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieVertebresAutresManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieVertebresAutres(ZoologieVertebresAutres object) {
        try {
            getHelper().getZoologieVertebresAutresDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieVertebresAutres(ZoologieVertebresAutres object) {
        try {
            getHelper().getZoologieVertebresAutresDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieVertebresAutres(ZoologieVertebresAutres object){
        try {
            getHelper().getZoologieVertebresAutresDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieVertebresAutres> getAllZoologieVertebresAutres() {
        try {
            return (ArrayList<ZoologieVertebresAutres>) getHelper().getZoologieVertebresAutresDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieVertebresAutres getZoologieVertebresAutresById(Integer id){
        try {
            return getHelper().getZoologieVertebresAutresDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
