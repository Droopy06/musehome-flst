package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.JardinBotanique;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class JardinBotaniqueManagerSQLite {

    static private JardinBotaniqueManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new JardinBotaniqueManagerSQLite(ctx);
        }
    }

    static public JardinBotaniqueManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private JardinBotaniqueManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addJardinBotanique(JardinBotanique object) {
        try {
            getHelper().getJardinBotaniqueDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJardinBotanique(JardinBotanique object) {
        try {
            getHelper().getJardinBotaniqueDao().refresh(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJardinBotanique(JardinBotanique object){
        try {
            getHelper().getJardinBotaniqueDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<JardinBotanique> getAllJardinBotanique() {
        try {
            return (ArrayList<JardinBotanique>) getHelper().getJardinBotaniqueDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JardinBotanique getJardinBotaniqueById(Integer id){
        try {
            return getHelper().getJardinBotaniqueDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
