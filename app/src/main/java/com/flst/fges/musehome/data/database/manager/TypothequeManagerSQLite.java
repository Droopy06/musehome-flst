package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.Typotheque;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class TypothequeManagerSQLite {

    static private TypothequeManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new TypothequeManagerSQLite(ctx);
        }
    }

    static public TypothequeManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public TypothequeManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addTypotheque(Typotheque object) {
        try {
            getHelper().getTypothequeDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTypotheque(Typotheque object) {
        try {
            getHelper().getTypothequeDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTypotheque(Typotheque object){
        try {
            getHelper().getTypothequeDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Typotheque> getAllTypotheque() {
        try {
            return (ArrayList<Typotheque>) getHelper().getTypothequeDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Typotheque getTypothequeById(Integer id){
        try {
            return getHelper().getTypothequeDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
