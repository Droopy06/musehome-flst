package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.MaterielPedagogique;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class MaterielPedagogiqueManagerSQLite {

    static private MaterielPedagogiqueManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new MaterielPedagogiqueManagerSQLite(ctx);
        }
    }

    static public MaterielPedagogiqueManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public MaterielPedagogiqueManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addMaterielPedagogique(MaterielPedagogique object) {
        try {
            getHelper().getMaterielPedagogiqueDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMaterielPedagogique(MaterielPedagogique object) {
        try {
            getHelper().getMaterielPedagogiqueDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMaterielPedagogique(MaterielPedagogique object){
        try {
            getHelper().getMaterielPedagogiqueDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MaterielPedagogique> getAllMaterielPedagogique() {
        try {
            return (ArrayList<MaterielPedagogique>) getHelper().getMaterielPedagogiqueDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MaterielPedagogique getMaterielPedagogiqueById(Integer id){
        try {
            return getHelper().getMaterielPedagogiqueDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
