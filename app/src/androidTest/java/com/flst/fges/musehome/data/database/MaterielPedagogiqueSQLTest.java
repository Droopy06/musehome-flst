package com.flst.fges.musehome.data.database;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.flst.fges.musehome.data.database.manager.MaterielPedagogiqueManagerSQLite;
import com.flst.fges.musehome.data.factory.MaterielPedagogiqueFactory;
import com.flst.fges.musehome.data.model.MaterielPedagogique;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Olive on 08/03/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MaterielPedagogiqueSQLTest {
    private MaterielPedagogiqueManagerSQLite mDataSource;

    @Before
    public void setUp(){
        mDataSource = new MaterielPedagogiqueManagerSQLite(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void finish() {
    }

    @Test
    public void testPreConditions() {
        assertNotNull(mDataSource);
    }

    @Test
    public void testShouldAddExpenseType() throws Exception {
        ArrayList<MaterielPedagogique> pedagogiq = MaterielPedagogiqueFactory.getAllMaterielPedagogique();
        for(int i = 0;i < pedagogiq.size();i++)
            mDataSource.addMaterielPedagogique(pedagogiq.get(i));

        ArrayList<MaterielPedagogique> ped = mDataSource.getAllMaterielPedagogique();
        assertEquals(pedagogiq.size(),ped.size());
    }

    @Test
    public void testDeleteAll() {
        ArrayList<MaterielPedagogique> pedagogiq = mDataSource.getAllMaterielPedagogique();
        for(int i = 0;i < pedagogiq.size();i++)
            mDataSource.deleteMaterielPedagogique(pedagogiq.get(i));
        assertEquals(0,mDataSource.getAllMaterielPedagogique().size());
    }

    @Test
    public void testDeleteOnlyOne() {
        /*mDataSource.deleteAllElementCollections();
        ArrayList<MaterielPedagogique> materielPedagogiques =MaterielPedagogiqueFactory.getAllMaterielPedagogique();
        for(int i = 0;i < materielPedagogiques.size();i++)
            mDataSource.addElementCollection(materielPedagogiques.get(i));
        mDataSource.deleteElementCollection(materielPedagogiques.get(0));
        assertEquals(materielPedagogiques.size()-1,mDataSource.getAllElementCollections().size());
        //assertEquals(null,mDataSource.getElementCollectionById(materielPedagogiques.get(0).getId()).getId());*/
    }

    @Test
    public void testAddAndDelete() {
        /*mDataSource.deleteAllElementCollections();
        ArrayList<MaterielPedagogique> materielPedagogiques = MaterielPedagogiqueFactory.getAllMaterielPedagogique();
        mDataSource.addElementCollection(materielPedagogiques.get(0));
        assertEquals(1,mDataSource.getAllElementCollections().size());
        mDataSource.deleteElementCollection(materielPedagogiques.get(0));
        assertEquals(0,mDataSource.getAllElementCollections().size());*/
    }
}
