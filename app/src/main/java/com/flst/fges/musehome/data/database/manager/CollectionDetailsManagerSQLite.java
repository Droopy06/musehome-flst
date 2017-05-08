package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.CollectionDetails;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class CollectionDetailsManagerSQLite {

    static private CollectionDetailsManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new CollectionDetailsManagerSQLite(ctx);
        }
    }

    static public CollectionDetailsManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private CollectionDetailsManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addCollectionDetails(CollectionDetails object) {
        try {
            getHelper().getCollectionDetailsDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCollectionDetails(CollectionDetails object) {
        try {
            getHelper().getCollectionDetailsDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCollectionDetails(CollectionDetails object){
        try {
            getHelper().getCollectionDetailsDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CollectionDetails> getAllCollectionDetails() {
        try {
            return (ArrayList<CollectionDetails>) getHelper().getCollectionDetailsDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CollectionDetails getCollectionDetailsById(Integer id){
        try {
            return getHelper().getCollectionDetailsDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
