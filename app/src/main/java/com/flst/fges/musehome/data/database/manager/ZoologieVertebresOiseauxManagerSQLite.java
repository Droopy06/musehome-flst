package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieVertebresOiseaux;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieVertebresOiseauxManagerSQLite {

    static private ZoologieVertebresOiseauxManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieVertebresOiseauxManagerSQLite(ctx);
        }
    }

    static public ZoologieVertebresOiseauxManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private ZoologieVertebresOiseauxManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieVertebresOiseaux(ZoologieVertebresOiseaux object) {
        try {
            getHelper().getZoologieVertebresOiseauxDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieVertebresOiseaux(ZoologieVertebresOiseaux object) {
        try {
            getHelper().getZoologieVertebresOiseauxDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieVertebresOiseaux(ZoologieVertebresOiseaux object){
        try {
            getHelper().getZoologieVertebresOiseauxDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieVertebresOiseaux> getAllZoologieVertebresOiseaux() {
        try {
            return (ArrayList<ZoologieVertebresOiseaux>) getHelper().getZoologieVertebresOiseauxDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieVertebresOiseaux getZoologieVertebresOiseauxById(Integer id){
        try {
            return getHelper().getZoologieVertebresOiseauxDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
