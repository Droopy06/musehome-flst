package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieVertebresReptile;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieVertebresReptileManagerSQLite {

    static private ZoologieVertebresReptileManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieVertebresReptileManagerSQLite(ctx);
        }
    }

    static public ZoologieVertebresReptileManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieVertebresReptileManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieVertebresReptile(ZoologieVertebresReptile object) {
        try {
            getHelper().getZoologieVertebresReptileDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieVertebresReptile(ZoologieVertebresReptile object) {
        try {
            getHelper().getZoologieVertebresReptileDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieVertebresReptile(ZoologieVertebresReptile object){
        try {
            getHelper().getZoologieVertebresReptileDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieVertebresReptile> getAllZoologieVertebresReptile() {
        try {
            return (ArrayList<ZoologieVertebresReptile>) getHelper().getZoologieVertebresReptileDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieVertebresReptile getZoologieVertebresReptileById(Integer id){
        try {
            return getHelper().getZoologieVertebresReptileDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
