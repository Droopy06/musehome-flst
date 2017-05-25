package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.Collection;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class CollectionManagerSQLite {

    static private CollectionManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new CollectionManagerSQLite(ctx);
        }
    }

    static public CollectionManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public CollectionManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addCollection(Collection object) {
        try {
            getHelper().getCollectionDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCollection(Collection object) {
        try {
            getHelper().getCollectionDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCollection(Collection object){
        try {
            getHelper().getCollectionDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Collection> getAllCollection() {
        try {
            return (ArrayList<Collection>) getHelper().getCollectionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection getCollectionById(Integer id){
        try {
            return getHelper().getCollectionDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
