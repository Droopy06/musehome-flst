package com.flst.fges.musehome.data.database.manager;

import android.content.Context;

/**
 * Created by Olive on 04/03/2017.
 */

public class MaterielPedagogiqueManagerSQLite extends DefaultClassCollectionManagerSQLite{

    public MaterielPedagogiqueManagerSQLite(Context context){
        super(context);
        setTableName("materielPedagogique");
    }

}
