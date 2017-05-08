package com.flst.fges.musehome.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Alexandre LAMOOT on 08/05/2017
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME    = "musehome.db";
    private static final int    DATABASE_VERSION = 1;

    private Dao<DefaultClassCollection, Integer> mDefaultClassCollectionDAO = null;
    private Dao<MaterielPedagogique, Integer> mMaterielPedagogiqueDAO = null;

    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, DefaultClassCollection.class);
            TableUtils.createTable(connectionSource, MaterielPedagogique.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, DefaultClassCollection.class, true);
            TableUtils.dropTable(connectionSource, MaterielPedagogique.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<DefaultClassCollection, Integer> getDefaultClassCollectionDao() throws SQLException {
        if (mDefaultClassCollectionDAO == null) {
            mDefaultClassCollectionDAO = getDao(DefaultClassCollection.class);
        }
        return mDefaultClassCollectionDAO;
    }

    public Dao<MaterielPedagogique, Integer> getMaterielPedagogiqueDao() throws SQLException {
        if (mMaterielPedagogiqueDAO == null) {
            mMaterielPedagogiqueDAO = getDao(MaterielPedagogique.class);
        }
        return mMaterielPedagogiqueDAO;
    }

    /********** Mouvement part end **********/

    public void clearDatabase(){
        mContext.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void close() {
        mMaterielPedagogiqueDAO = null;
        mDefaultClassCollectionDAO = null;
        super.close();
    }
}