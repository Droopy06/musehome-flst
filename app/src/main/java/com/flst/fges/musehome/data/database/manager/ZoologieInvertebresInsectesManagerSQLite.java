package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieInvertebresInsectes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieInvertebresInsectesManagerSQLite {

    static private ZoologieInvertebresInsectesManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieInvertebresInsectesManagerSQLite(ctx);
        }
    }

    static public ZoologieInvertebresInsectesManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieInvertebresInsectesManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieInvertebresInsectes(ZoologieInvertebresInsectes object) {
        try {
            getHelper().getZoologieInvertebresInsectesDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieInvertebresInsectes(ZoologieInvertebresInsectes object) {
        try {
            getHelper().getZoologieInvertebresInsectesDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieInvertebresInsectes(ZoologieInvertebresInsectes object){
        try {
            getHelper().getZoologieInvertebresInsectesDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieInvertebresInsectes> getAllZoologieInvertebresInsectes() {
        try {
            return (ArrayList<ZoologieInvertebresInsectes>) getHelper().getZoologieInvertebresInsectesDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieInvertebresInsectes getZoologieInvertebresInsectesById(Integer id){
        try {
            return getHelper().getZoologieInvertebresInsectesDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
