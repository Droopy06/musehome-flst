package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.ZoologieVertebresMammiferes;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class ZoologieVertebresMammiferesManagerSQLite {

    static private ZoologieVertebresMammiferesManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new ZoologieVertebresMammiferesManagerSQLite(ctx);
        }
    }

    static public ZoologieVertebresMammiferesManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public ZoologieVertebresMammiferesManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addZoologieVertebresMammiferes(ZoologieVertebresMammiferes object) {
        try {
            getHelper().getZoologieVertebresMammiferesDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZoologieVertebresMammiferes(ZoologieVertebresMammiferes object) {
        try {
            getHelper().getZoologieVertebresMammiferesDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteZoologieVertebresMammiferes(ZoologieVertebresMammiferes object){
        try {
            getHelper().getZoologieVertebresMammiferesDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ZoologieVertebresMammiferes> getAllZoologieVertebresMammiferes() {
        try {
            return (ArrayList<ZoologieVertebresMammiferes>) getHelper().getZoologieVertebresMammiferesDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ZoologieVertebresMammiferes getZoologieVertebresMammiferesById(Integer id){
        try {
            return getHelper().getZoologieVertebresMammiferesDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
