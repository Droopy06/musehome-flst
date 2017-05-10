package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.Petrographie;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class PetrographieManagerSQLite {

    static private PetrographieManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new PetrographieManagerSQLite(ctx);
        }
    }

    static public PetrographieManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public PetrographieManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addPetrographie(Petrographie object) {
        try {
            getHelper().getPetrographieDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePetrographie(Petrographie object) {
        try {
            getHelper().getPetrographieDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePetrographie(Petrographie object){
        try {
            getHelper().getPetrographieDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Petrographie> getAllPetrographie() {
        try {
            return (ArrayList<Petrographie>) getHelper().getPetrographieDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Petrographie getPetrographieById(Integer id){
        try {
            return getHelper().getPetrographieDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
