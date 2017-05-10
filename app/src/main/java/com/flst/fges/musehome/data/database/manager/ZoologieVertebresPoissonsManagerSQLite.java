package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieVertebresPoissons;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieVertebresPoissonsManagerSQLite {

    static private ZoologieVertebresPoissonsManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieVertebresPoissonsManagerSQLite(ctx);
        }
    }

    static public ZoologieVertebresPoissonsManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieVertebresPoissonsManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieVertebresPoissons(ZoologieVertebresPoissons object) {
        try {
            getHelper().getZoologieVertebresPoissonsDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieVertebresPoissons(ZoologieVertebresPoissons object) {
        try {
            getHelper().getZoologieVertebresPoissonsDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieVertebresPoissons(ZoologieVertebresPoissons object){
        try {
            getHelper().getZoologieVertebresPoissonsDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieVertebresPoissons> getAllZoologieVertebresPoissons() {
        try {
            return (ArrayList<ZoologieVertebresPoissons>) getHelper().getZoologieVertebresPoissonsDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieVertebresPoissons getZoologieVertebresPoissonsById(Integer id){
        try {
            return getHelper().getZoologieVertebresPoissonsDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
