package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.Herbiers;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class HerbiersManagerSQLite {

    static private HerbiersManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new HerbiersManagerSQLite(ctx);
        }
    }

    static public HerbiersManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public HerbiersManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addHerbiers(Herbiers object) {
        try {
            getHelper().getHerbiersDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHerbiers(Herbiers object) {
        try {
            getHelper().getHerbiersDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHerbiers(Herbiers object){
        try {
            getHelper().getHerbiersDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Herbiers> getAllHerbiers() {
        try {
            return (ArrayList<Herbiers>) getHelper().getHerbiersDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Herbiers getHerbiersById(Integer id){
        try {
            return getHelper().getHerbiersDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
