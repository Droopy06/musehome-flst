package com.flst.fges.musehome.data.database;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.flst.fges.musehome.data.database.manager.DefaultClassCollectionManagerSQLite;
import com.flst.fges.musehome.data.database.manager.MaterielPedagogiqueManagerSQLite;
import com.flst.fges.musehome.data.factory.DefaultClassCollectionFactory;
import com.flst.fges.musehome.data.model.DefaultClassCollection;

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
public class DefaultClassSQLiteTest {
    private DefaultClassCollectionManagerSQLite mDataSource;

    @Before
    public void setUp(){
        mDataSource = new DefaultClassCollectionManagerSQLite(InstrumentationRegistry.getTargetContext());
        mDataSource.open();
    }

    @After
    public void finish() {
        mDataSource.close();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(mDataSource);
    }

   @Test
    public void testShouldAddExpenseType() throws Exception {
       Log.w("CREATE", MaterielPedagogiqueManagerSQLite.CREATE_TABLE);
        mDataSource.deleteAllElementCollections();
        ArrayList<DefaultClassCollection> collections = DefaultClassCollectionFactory.getAllDefaultClassCollection();
        for(int i = 0;i < collections.size();i++)
            mDataSource.addElementCollection(collections.get(i));

        ArrayList<DefaultClassCollection> collectionses = mDataSource.getAllElementCollections();
        assertEquals(collections.size(),collectionses.size());
    }

    @Test
    public void testDeleteAll() {
        mDataSource.deleteAllElementCollections();
        ArrayList<DefaultClassCollection> defaultClassCollections = mDataSource.getAllElementCollections();
        assertEquals(0,defaultClassCollections.size());
    }

    @Test
    public void testDeleteOnlyOne() {
        mDataSource.deleteAllElementCollections();
        ArrayList<DefaultClassCollection> collections = DefaultClassCollectionFactory.getAllDefaultClassCollection();
        for(int i = 0;i < collections.size();i++)
            mDataSource.addElementCollection(collections.get(i));
        mDataSource.deleteElementCollection(collections.get(0));
        assertEquals(collections.size()-1,mDataSource.getAllElementCollections().size());
        assertEquals(null,mDataSource.getElementCollectionById((collections.get(0).getId())));
    }

    @Test
    public void testAddAndDelete() {
        mDataSource.deleteAllElementCollections();
        ArrayList<DefaultClassCollection> collections = DefaultClassCollectionFactory.getAllDefaultClassCollection();
        mDataSource.addElementCollection(collections.get(0));
        assertEquals(1,mDataSource.getAllElementCollections().size());
        mDataSource.deleteElementCollection(collections.get(0));
        assertEquals(0,mDataSource.getAllElementCollections().size());
    }
}
