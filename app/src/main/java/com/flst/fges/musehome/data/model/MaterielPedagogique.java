package com.flst.fges.musehome.data.model;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
@DatabaseTable(tableName = "materiel_pedagogique")
public class MaterielPedagogique extends DefaultClassCollection{

    public MaterielPedagogique() {
    }

    public MaterielPedagogique(String id, String collection, String picture, String name) {
        super(id, collection, picture, name);
    }
}
