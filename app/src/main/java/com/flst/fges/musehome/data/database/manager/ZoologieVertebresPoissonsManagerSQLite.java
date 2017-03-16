package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

/**
 * Created by Olive on 04/03/2017.
 */

public class ZoologieVertebresPoissonsManagerSQLite  extends DefaultClassCollectionManagerSQLite{
    public ZoologieVertebresPoissonsManagerSQLite(Context context) {
        super(context);
        setTableName("ZoologieVertebresPoissons");
    }
}
