package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieInvertebresMollusquesManagerSQLite {

    static private ZoologieInvertebresMollusquesManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieInvertebresMollusquesManagerSQLite(ctx);
        }
    }

    static public ZoologieInvertebresMollusquesManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieInvertebresMollusquesManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieInvertebresMollusques(ZoologieInvertebresMollusques object) {
        try {
            getHelper().getZoologieInvertebresMollusquesDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieInvertebresMollusques(ZoologieInvertebresMollusques object) {
        try {
            getHelper().getZoologieInvertebresMollusquesDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieInvertebresMollusques(ZoologieInvertebresMollusques object){
        try {
            getHelper().getZoologieInvertebresMollusquesDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieInvertebresMollusques> getAllZoologieInvertebresMollusques() {
        try {
            return (ArrayList<ZoologieInvertebresMollusques>) getHelper().getZoologieInvertebresMollusquesDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieInvertebresMollusques getZoologieInvertebresMollusquesById(Integer id){
        try {
            return getHelper().getZoologieInvertebresMollusquesDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
