package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

import com.flst.fges.musehome.data.database.DatabaseHelper;
import com.flst.fges.musehome.data.model.MineralogieCristallographie;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class MineralogieCristallographieManagerSQLite {

    static private MineralogieCristallographieManagerSQLite instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new MineralogieCristallographieManagerSQLite(ctx);
        }
    }

    static public MineralogieCristallographieManagerSQLite getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    public MineralogieCristallographieManagerSQLite(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public void clearDatabase() {
        getHelper().clearDatabase();
    }

    public void addMineralogieCristallographie(MineralogieCristallographie object) {
        try {
            getHelper().getMineralogieCristallographieDao().createIfNotExists(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMineralogieCristallographie(MineralogieCristallographie object) {
        try {
            getHelper().getMineralogieCristallographieDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMineralogieCristallographie(MineralogieCristallographie object){
        try {
            getHelper().getMineralogieCristallographieDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MineralogieCristallographie> getAllMineralogieCristallographie() {
        try {
            return (ArrayList<MineralogieCristallographie>) getHelper().getMineralogieCristallographieDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MineralogieCristallographie getMineralogieCristallographieById(Integer id){
        try {
            return getHelper().getMineralogieCristallographieDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
