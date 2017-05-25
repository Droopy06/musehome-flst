package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.PaleontologieVegetale;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class PaleontologieVegetaleManagerSQLite {

    static private PaleontologieVegetaleManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new PaleontologieVegetaleManagerSQLite(ctx);
        }
    }

    static public PaleontologieVegetaleManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public PaleontologieVegetaleManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addPaleontologieVegetale(PaleontologieVegetale object) {
        try {
            getHelper().getPaleontologieVegetaleDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePaleontologieVegetale(PaleontologieVegetale object) {
        try {
            getHelper().getPaleontologieVegetaleDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePaleontologieVegetale(PaleontologieVegetale object){
        try {
            getHelper().getPaleontologieVegetaleDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PaleontologieVegetale> getAllPaleontologieVegetale() {
        try {
            return (ArrayList<PaleontologieVegetale>) getHelper().getPaleontologieVegetaleDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PaleontologieVegetale getPaleontologieVegetaleById(Integer id){
        try {
            return getHelper().getPaleontologieVegetaleDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
