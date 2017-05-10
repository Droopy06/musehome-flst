package com.flst.fges.musehome.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.model.CollectionDetails;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.data.model.Evenement;
import com.flst.fges.musehome.data.model.Herbiers;
import com.flst.fges.musehome.data.model.Instruments;
import com.flst.fges.musehome.data.model.JardinBotanique;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.flst.fges.musehome.data.model.MineralogieCristallographie;
import com.flst.fges.musehome.data.model.OuvragesCartesDocuments;
import com.flst.fges.musehome.data.model.PaleontologieAnimale;
import com.flst.fges.musehome.data.model.PaleontologieVegetale;
import com.flst.fges.musehome.data.model.Petrographie;
import com.flst.fges.musehome.data.model.Physique;
import com.flst.fges.musehome.data.model.Typotheque;
import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;
import com.flst.fges.musehome.data.model.ZoologieInvertebresInsectes;
import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;
import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;
import com.flst.fges.musehome.data.model.ZoologieVertebresMammiferes;
import com.flst.fges.musehome.data.model.ZoologieVertebresOiseaux;
import com.flst.fges.musehome.data.model.ZoologieVertebresPoissons;
import com.flst.fges.musehome.data.model.ZoologieVertebresPrimates;
import com.flst.fges.musehome.data.model.ZoologieVertebresReptile;
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
    private Dao<Collection, Integer> mCollectionDAO = null;
    private Dao<CollectionDetails, Integer> mCollectionDetailsDAO = null;
    private Dao<Evenement, Integer> mEvenementDAO = null;
    private Dao<Herbiers, Integer> mHerbiersDAO = null;
    private Dao<Instruments, Integer> mInstrumentsDAO = null;
    private Dao<JardinBotanique, Integer> mJardinBotaniqueDAO = null;
    private Dao<MineralogieCristallographie, Integer> mMineralogieCristallographieDAO = null;
    private Dao<OuvragesCartesDocuments, Integer> mOuvragesCartesDocumentsDAO = null;
    private Dao<PaleontologieAnimale, Integer> mPaleontologieAnimaleDAO = null;
    private Dao<PaleontologieVegetale, Integer> mPaleontologieVegetaleDAO = null;
    private Dao<Petrographie, Integer> mPetrographieDAO = null;
    private Dao<Physique, Integer> mPhysiqueDAO = null;
    private Dao<Typotheque, Integer> mTypothequeDAO = null;
    private Dao<ZoologieInvertebresAutres, Integer> mZoologieInvertebresAutresDAO = null;
    private Dao<ZoologieInvertebresInsectes, Integer> mZoologieInvertebresInsectesDAO = null;
    private Dao<ZoologieInvertebresMollusques, Integer> mZoologieInvertebresMollusquesDAO = null;
    private Dao<ZoologieVertebresAutres, Integer> mZoologieVertebresAutresDAO = null;
    private Dao<ZoologieVertebresMammiferes, Integer> mZoologieVertebresMammiferesDAO = null;
    private Dao<ZoologieVertebresOiseaux, Integer> mZoologieVertebresOiseauxDAO = null;
    private Dao<ZoologieVertebresPoissons, Integer> mZoologieVertebresPoissonsDAO = null;
    private Dao<ZoologieVertebresPrimates, Integer> mZoologieVertebresPrimatesDAO = null;
    private Dao<ZoologieVertebresReptile, Integer> mZoologieVertebresReptileDAO = null;

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
            TableUtils.createTable(connectionSource, Collection.class);
            TableUtils.createTable(connectionSource, CollectionDetails.class);
            TableUtils.createTable(connectionSource, Evenement.class);
            TableUtils.createTable(connectionSource, Herbiers.class);
            TableUtils.createTable(connectionSource, Instruments.class);
            TableUtils.createTable(connectionSource, JardinBotanique.class);
            TableUtils.createTable(connectionSource, MineralogieCristallographie.class);
            TableUtils.createTable(connectionSource, OuvragesCartesDocuments.class);
            TableUtils.createTable(connectionSource, PaleontologieAnimale.class);
            TableUtils.createTable(connectionSource, PaleontologieVegetale.class);
            TableUtils.createTable(connectionSource, Petrographie.class);
            TableUtils.createTable(connectionSource, Physique.class);
            TableUtils.createTable(connectionSource, Typotheque.class);
            TableUtils.createTable(connectionSource, ZoologieInvertebresAutres.class);
            TableUtils.createTable(connectionSource, ZoologieInvertebresInsectes.class);
            TableUtils.createTable(connectionSource, ZoologieInvertebresMollusques.class);
            TableUtils.createTable(connectionSource, ZoologieVertebresAutres.class);
            TableUtils.createTable(connectionSource, ZoologieVertebresMammiferes.class);
            TableUtils.createTable(connectionSource, ZoologieVertebresOiseaux.class);
            TableUtils.createTable(connectionSource, ZoologieVertebresPoissons.class);
            TableUtils.createTable(connectionSource, ZoologieVertebresPrimates.class);
            TableUtils.createTable(connectionSource, ZoologieVertebresReptile.class);
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
            TableUtils.dropTable(connectionSource, Collection.class, true);
            TableUtils.dropTable(connectionSource, CollectionDetails.class, true);
            TableUtils.dropTable(connectionSource, Evenement.class, true);
            TableUtils.dropTable(connectionSource, Herbiers.class, true);
            TableUtils.dropTable(connectionSource, Instruments.class, true);
            TableUtils.dropTable(connectionSource, JardinBotanique.class, true);
            TableUtils.dropTable(connectionSource, MineralogieCristallographie.class, true);
            TableUtils.dropTable(connectionSource, OuvragesCartesDocuments.class, true);
            TableUtils.dropTable(connectionSource, PaleontologieAnimale.class, true);
            TableUtils.dropTable(connectionSource, PaleontologieVegetale.class, true);
            TableUtils.dropTable(connectionSource, Petrographie.class, true);
            TableUtils.dropTable(connectionSource, Physique.class, true);
            TableUtils.dropTable(connectionSource, Typotheque.class, true);
            TableUtils.dropTable(connectionSource, ZoologieInvertebresAutres.class, true);
            TableUtils.dropTable(connectionSource, ZoologieInvertebresInsectes.class, true);
            TableUtils.dropTable(connectionSource, ZoologieInvertebresMollusques.class, true);
            TableUtils.dropTable(connectionSource, ZoologieVertebresAutres.class, true);
            TableUtils.dropTable(connectionSource, ZoologieVertebresMammiferes.class, true);
            TableUtils.dropTable(connectionSource, ZoologieVertebresOiseaux.class, true);
            TableUtils.dropTable(connectionSource, ZoologieVertebresPoissons.class, true);
            TableUtils.dropTable(connectionSource, ZoologieVertebresPrimates.class, true);
            TableUtils.dropTable(connectionSource, ZoologieVertebresReptile.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<Collection, Integer> getCollectionDao() throws SQLException {
        if (mCollectionDAO == null) {
            mCollectionDAO = getDao(Collection.class);
        }
        return mCollectionDAO;
    }
    public Dao<CollectionDetails, Integer> getCollectionDetailsDao() throws SQLException {
        if (mCollectionDetailsDAO == null) {
            mCollectionDetailsDAO = getDao(CollectionDetails.class);
        }
        return mCollectionDetailsDAO;
    }

    public Dao<DefaultClassCollection, Integer> getDefaultClassCollectionDao() throws SQLException {
        if (mDefaultClassCollectionDAO == null) {
            mDefaultClassCollectionDAO = getDao(DefaultClassCollection.class);
        }
        return mDefaultClassCollectionDAO;
    }

    public Dao<Evenement, Integer> getEvenementDao() throws SQLException {
        if (mEvenementDAO == null) {
            mEvenementDAO = getDao(Evenement.class);
        }
        return mEvenementDAO;
    }

    public Dao<Herbiers, Integer> getHerbiersDao() throws SQLException {
        if (mHerbiersDAO == null) {
            mHerbiersDAO = getDao(Herbiers.class);
        }
        return mHerbiersDAO;
    }

    public Dao<Instruments, Integer> getInstrumentsDao() throws SQLException {
        if (mInstrumentsDAO == null) {
            mInstrumentsDAO = getDao(Instruments.class);
        }
        return mInstrumentsDAO;
    }

    public Dao<JardinBotanique, Integer> getJardinBotaniqueDao() throws SQLException {
        if (mJardinBotaniqueDAO == null) {
            mJardinBotaniqueDAO = getDao(JardinBotanique.class);
        }
        return mJardinBotaniqueDAO;
    }

    public Dao<MaterielPedagogique, Integer> getMaterielPedagogiqueDao() throws SQLException {
        if (mMaterielPedagogiqueDAO == null) {
            mMaterielPedagogiqueDAO = getDao(MaterielPedagogique.class);
        }
        return mMaterielPedagogiqueDAO;
    }

    public Dao<MineralogieCristallographie, Integer> getMineralogieCristallographieDao() throws SQLException {
        if (mMineralogieCristallographieDAO == null) {
            mMineralogieCristallographieDAO = getDao(MineralogieCristallographie.class);
        }
        return mMineralogieCristallographieDAO;
    }

    public Dao<OuvragesCartesDocuments, Integer> getOuvragesCartesDocumentsDao() throws SQLException {
        if (mOuvragesCartesDocumentsDAO == null) {
            mOuvragesCartesDocumentsDAO = getDao(OuvragesCartesDocuments.class);
        }
        return mOuvragesCartesDocumentsDAO;
    }

    public Dao<PaleontologieAnimale, Integer> getPaleontologieAnimaleDao() throws SQLException {
        if (mPaleontologieAnimaleDAO == null) {
            mPaleontologieAnimaleDAO = getDao(PaleontologieAnimale.class);
        }
        return mPaleontologieAnimaleDAO;
    }

    public Dao<PaleontologieVegetale, Integer> getPaleontologieVegetaleDao() throws SQLException {
        if (mPaleontologieVegetaleDAO == null) {
            mPaleontologieVegetaleDAO = getDao(PaleontologieVegetale.class);
        }
        return mPaleontologieVegetaleDAO;
    }

    public Dao<Petrographie, Integer> getPetrographieDao() throws SQLException {
        if (mPetrographieDAO == null) {
            mPetrographieDAO = getDao(Petrographie.class);
        }
        return mPetrographieDAO;
    }

    public Dao<Physique, Integer> getPhysiqueDao() throws SQLException {
        if (mPhysiqueDAO == null) {
            mPhysiqueDAO = getDao(Physique.class);
        }
        return mPhysiqueDAO;
    }

    public Dao<Typotheque, Integer> getTypothequeDao() throws SQLException {
        if (mTypothequeDAO == null) {
            mTypothequeDAO = getDao(Typotheque.class);
        }
        return mTypothequeDAO;
    }

    public Dao<ZoologieInvertebresAutres, Integer> getZoologieInvertebresAutresDao() throws SQLException {
        if (mZoologieInvertebresAutresDAO == null) {
            mZoologieInvertebresAutresDAO = getDao(ZoologieInvertebresAutres.class);
        }
        return mZoologieInvertebresAutresDAO;
    }

    public Dao<ZoologieInvertebresInsectes, Integer> getZoologieInvertebresInsectesDao() throws SQLException {
        if (mZoologieInvertebresInsectesDAO == null) {
            mZoologieInvertebresInsectesDAO = getDao(ZoologieInvertebresInsectes.class);
        }
        return mZoologieInvertebresInsectesDAO;
    }

    public Dao<ZoologieInvertebresMollusques, Integer> getZoologieInvertebresMollusquesDao() throws SQLException {
        if (mZoologieInvertebresMollusquesDAO == null) {
            mZoologieInvertebresMollusquesDAO = getDao(ZoologieInvertebresMollusques.class);
        }
        return mZoologieInvertebresMollusquesDAO;
    }

    public Dao<ZoologieVertebresAutres, Integer> getZoologieVertebresAutresDao() throws SQLException {
        if (mZoologieVertebresAutresDAO == null) {
            mZoologieVertebresAutresDAO = getDao(ZoologieVertebresAutres.class);
        }
        return mZoologieVertebresAutresDAO;
    }

    public Dao<ZoologieVertebresMammiferes, Integer> getZoologieVertebresMammiferesDao() throws SQLException {
        if (mZoologieVertebresMammiferesDAO == null) {
            mZoologieVertebresMammiferesDAO = getDao(ZoologieVertebresMammiferes.class);
        }
        return mZoologieVertebresMammiferesDAO;
    }

    public Dao<ZoologieVertebresOiseaux, Integer> getZoologieVertebresOiseauxDao() throws SQLException {
        if (mZoologieVertebresOiseauxDAO == null) {
            mZoologieVertebresOiseauxDAO = getDao(ZoologieVertebresOiseaux.class);
        }
        return mZoologieVertebresOiseauxDAO;
    }

    public Dao<ZoologieVertebresPoissons, Integer> getZoologieVertebresPoissonsDao() throws SQLException {
        if (mZoologieVertebresPoissonsDAO == null) {
            mZoologieVertebresPoissonsDAO = getDao(ZoologieVertebresPoissons.class);
        }
        return mZoologieVertebresPoissonsDAO;
    }

    public Dao<ZoologieVertebresPrimates, Integer> getZoologieVertebresPrimatesDao() throws SQLException {
        if (mZoologieVertebresPrimatesDAO == null) {
            mZoologieVertebresPrimatesDAO = getDao(ZoologieVertebresPrimates.class);
        }
        return mZoologieVertebresPrimatesDAO;
    }

    public Dao<ZoologieVertebresReptile, Integer> getZoologieVertebresReptileDao() throws SQLException {
        if (mZoologieVertebresReptileDAO == null) {
            mZoologieVertebresReptileDAO = getDao(ZoologieVertebresReptile.class);
        }
        return mZoologieVertebresReptileDAO;
    }
    /********** part end **********/

    public void clearDatabase(){
        mContext.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void close() {
        mMaterielPedagogiqueDAO = null;
        mDefaultClassCollectionDAO = null;
        mCollectionDAO = null;
        mCollectionDetailsDAO = null;
        mEvenementDAO = null;
        mHerbiersDAO = null;
        mInstrumentsDAO = null;
        mJardinBotaniqueDAO = null;
        mMineralogieCristallographieDAO = null;
        mOuvragesCartesDocumentsDAO = null;
        mPaleontologieAnimaleDAO = null;
        mPaleontologieVegetaleDAO = null;
        mPetrographieDAO = null;
        mPhysiqueDAO = null;
        mTypothequeDAO = null;
        mZoologieInvertebresAutresDAO = null;
        mZoologieInvertebresInsectesDAO = null;
        mZoologieInvertebresMollusquesDAO = null;
        mZoologieVertebresAutresDAO = null;
        mZoologieVertebresMammiferesDAO = null;
        mZoologieVertebresOiseauxDAO = null;
        mZoologieVertebresPoissonsDAO = null;
        mZoologieVertebresPrimatesDAO = null;
        mZoologieVertebresReptileDAO = null;
        super.close();
    }
}