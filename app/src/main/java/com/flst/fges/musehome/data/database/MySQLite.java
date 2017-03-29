package com.flst.fges.musehome.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.flst.fges.musehome.data.database.manager.CollectionDetailsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.CollectionManagerSQLite;
import com.flst.fges.musehome.data.database.manager.EvenementManagerSQLite;
import com.flst.fges.musehome.data.database.manager.HerbiersManagerSQLite;
import com.flst.fges.musehome.data.database.manager.InstrumentsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.JardinBotaniqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.MaterielPedagogiqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.MineralogieCristallographieManagerSQLite;
import com.flst.fges.musehome.data.database.manager.OuvragesCartesDocumentsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PaleontologieAnimaleManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PaleontologieVegetaleManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PetrographieManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PhysiqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.TypothequeManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieInvertebresAutresManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieInvertebresInsectesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieInvertebresMollusqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresAutresManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresMammiferesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresOiseauxManagerSQLIte;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresPoissonsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresPrimatesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresReptileManagerSQLite;

/**
 * Created by LAMOOT Alexandre on 03/03/2017.
 */

public class MySQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db.musehome.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static MySQLite sInstance;

    public static synchronized MySQLite getInstance(Context context) {
        if (sInstance == null) { sInstance = new MySQLite(context); }
        return sInstance;
    }

    private MySQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Création de la base de données
        // on exécute ici les requêtes de création des tables
        sqLiteDatabase.execSQL(CollectionManagerSQLite.CREATE_TABLE_COLLECTION); // création table "collection"
        sqLiteDatabase.execSQL(CollectionDetailsManagerSQLite.CREATE_TABLE); // création table "collection detail"
        sqLiteDatabase.execSQL(EvenementManagerSQLite.CREATE_TABLE_EVENEMENT); // création table "events"
        sqLiteDatabase.execSQL(HerbiersManagerSQLite.CREATE_TABLE); // création table "Herbiers"
        sqLiteDatabase.execSQL(InstrumentsManagerSQLite.CREATE_TABLE); // création table "Instruments"
        sqLiteDatabase.execSQL(JardinBotaniqueManagerSQLite.CREATE_TABLE); // création table "JardinBotanique"
        sqLiteDatabase.execSQL(MaterielPedagogiqueManagerSQLite.CREATE_TABLE); // création table "materiel pedagogique"
        sqLiteDatabase.execSQL(MineralogieCristallographieManagerSQLite.CREATE_TABLE); // création table "MineralogieCristallographie"
        sqLiteDatabase.execSQL(OuvragesCartesDocumentsManagerSQLite.CREATE_TABLE); // création table "OuvragesCartesDocuments"
        sqLiteDatabase.execSQL(PaleontologieAnimaleManagerSQLite.CREATE_TABLE); // création table "PaleontologieAnimale"
        sqLiteDatabase.execSQL(PaleontologieVegetaleManagerSQLite.CREATE_TABLE); // création table "PaleontologieVegetale"
        sqLiteDatabase.execSQL(PetrographieManagerSQLite.CREATE_TABLE); // création table "Petrographie"
        sqLiteDatabase.execSQL(PhysiqueManagerSQLite.CREATE_TABLE); // création table "Physique"
        sqLiteDatabase.execSQL(TypothequeManagerSQLite.CREATE_TABLE); // création table "Typotheque"
        sqLiteDatabase.execSQL(ZoologieInvertebresAutresManagerSQLite.CREATE_TABLE); // création table "ZoologieInvertebresAutres"
        sqLiteDatabase.execSQL(ZoologieInvertebresInsectesManagerSQLite.CREATE_TABLE); // création table "ZoologieInvertebresInsectes"
        sqLiteDatabase.execSQL(ZoologieInvertebresMollusqueManagerSQLite.CREATE_TABLE); // création table "ZoologieInvertebresMollusque"
        sqLiteDatabase.execSQL(ZoologieVertebresAutresManagerSQLite.CREATE_TABLE); // création table "ZoologieVertebresAutres"
        sqLiteDatabase.execSQL(ZoologieVertebresMammiferesManagerSQLite.CREATE_TABLE); // création table "ZoologieVertebresMammiferes"
        sqLiteDatabase.execSQL(ZoologieVertebresOiseauxManagerSQLIte.CREATE_TABLE); // création table "ZoologieVertebresOiseaux"
        sqLiteDatabase.execSQL(ZoologieVertebresPoissonsManagerSQLite.CREATE_TABLE); // création table "ZoologieVertebresPoissons"
        sqLiteDatabase.execSQL(ZoologieVertebresPrimatesManagerSQLite.CREATE_TABLE); // création table "ZoologieVertebresPrimates"
        sqLiteDatabase.execSQL(ZoologieVertebresReptileManagerSQLite.CREATE_TABLE); // création table "ZoologieVertebresReptile"
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
    }
}
