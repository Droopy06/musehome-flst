package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model. Evenement;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class EvenementManagerSQLite {

    static private EvenementManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new EvenementManagerSQLite(ctx);
        }
    }

    static public EvenementManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public EvenementManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addEvenement(Evenement object) {
        try {
            getHelper().getEvenementDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEvenement(Evenement object) {
        try {
            getHelper().getEvenementDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvenement(Evenement object){
        try {
            getHelper().getEvenementDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Evenement> getAllEvenement() {
        try {
            return (ArrayList<Evenement>) getHelper().getEvenementDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Evenement getEvenementById(Integer id){
        try {
            return getHelper().getEvenementDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
