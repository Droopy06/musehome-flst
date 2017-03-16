package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

/**
 * Created by ISEN on 04/03/2017.
 */

public class PaleontologieVegetaleManagerSQLite extends DefaultClassCollectionManagerSQLite {
    public PaleontologieVegetaleManagerSQLite(Context context){
        super(context);
        setTableName("paleontologieVegetale");
    }
}
