package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.DefaultClassCollection;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class DefaultClassCollectionManagerSQLite {

    static private DefaultClassCollectionManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new DefaultClassCollectionManagerSQLite(ctx);
        }
    }

    static public DefaultClassCollectionManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private DefaultClassCollectionManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addDefaultClassCollection(DefaultClassCollection object) {
        try {
            getHelper().getDefaultClassCollectionDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDefaultClassCollection(DefaultClassCollection object) {
        try {
            getHelper().getDefaultClassCollectionDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDefaultClassCollection(DefaultClassCollection object){
        try {
            getHelper().getDefaultClassCollectionDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DefaultClassCollection> getAllDefaultClassCollection() {
        try {
            return (ArrayList<DefaultClassCollection>) getHelper().getDefaultClassCollectionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DefaultClassCollection getDefaultClassCollectionById(Integer id){
        try {
            return getHelper().getDefaultClassCollectionDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
