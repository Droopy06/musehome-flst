package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieVertebresPrimates;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieVertebresPrimatesManagerSQLite {

    static private ZoologieVertebresPrimatesManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieVertebresPrimatesManagerSQLite(ctx);
        }
    }

    static public ZoologieVertebresPrimatesManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private ZoologieVertebresPrimatesManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieVertebresPrimates(ZoologieVertebresPrimates object) {
        try {
            getHelper().getZoologieVertebresPrimatesDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieVertebresPrimates(ZoologieVertebresPrimates object) {
        try {
            getHelper().getZoologieVertebresPrimatesDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieVertebresPrimates(ZoologieVertebresPrimates object){
        try {
            getHelper().getZoologieVertebresPrimatesDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieVertebresPrimates> getAllZoologieVertebresPrimates() {
        try {
            return (ArrayList<ZoologieVertebresPrimates>) getHelper().getZoologieVertebresPrimatesDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieVertebresPrimates getZoologieVertebresPrimatesById(Integer id){
        try {
            return getHelper().getZoologieVertebresPrimatesDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
