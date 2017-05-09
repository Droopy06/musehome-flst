package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.Instruments;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class InstrumentsManagerSQLite {

    static private InstrumentsManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new InstrumentsManagerSQLite(ctx);
        }
    }

    static public InstrumentsManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public InstrumentsManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addInstruments(Instruments object) {
        try {
            getHelper().getInstrumentsDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateInstruments(Instruments object) {
        try {
            getHelper().getInstrumentsDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInstruments(Instruments object){
        try {
            getHelper().getInstrumentsDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Instruments> getAllInstruments() {
        try {
            return (ArrayList<Instruments>) getHelper().getInstrumentsDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Instruments getInstrumentsById(Integer id){
        try {
            return getHelper().getInstrumentsDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
