package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.PaleontologieAnimale;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class PaleontologieAnimaleManagerSQLite {

    static private PaleontologieAnimaleManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new PaleontologieAnimaleManagerSQLite(ctx);
        }
    }

    static public PaleontologieAnimaleManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public PaleontologieAnimaleManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addPaleontologieAnimale(PaleontologieAnimale object) {
        try {
            getHelper().getPaleontologieAnimaleDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePaleontologieAnimale(PaleontologieAnimale object) {
        try {
            getHelper().getPaleontologieAnimaleDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePaleontologieAnimale(PaleontologieAnimale object){
        try {
            getHelper().getPaleontologieAnimaleDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PaleontologieAnimale> getAllPaleontologieAnimale() {
        try {
            return (ArrayList<PaleontologieAnimale>) getHelper().getPaleontologieAnimaleDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PaleontologieAnimale getPaleontologieAnimaleById(Integer id){
        try {
            return getHelper().getPaleontologieAnimaleDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
