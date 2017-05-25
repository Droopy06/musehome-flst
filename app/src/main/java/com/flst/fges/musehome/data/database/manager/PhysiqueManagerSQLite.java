package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.Physique;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class PhysiqueManagerSQLite {

    static private PhysiqueManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new PhysiqueManagerSQLite(ctx);
        }
    }

    static public PhysiqueManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public PhysiqueManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addPhysique(Physique object) {
        try {
            getHelper().getPhysiqueDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePhysique(Physique object) {
        try {
            getHelper().getPhysiqueDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePhysique(Physique object){
        try {
            getHelper().getPhysiqueDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Physique> getAllPhysique() {
        try {
            return (ArrayList<Physique>) getHelper().getPhysiqueDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Physique getPhysiqueById(Integer id){
        try {
            return getHelper().getPhysiqueDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
