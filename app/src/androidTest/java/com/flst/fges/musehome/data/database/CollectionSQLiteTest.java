package com.flst.fges.musehome.data.database;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.flst.fges.musehome.data.database.manager.CollectionManagerSQLite;
import com.flst.fges.musehome.data.factory.CollectionFactory;
import com.flst.fges.musehome.data.model.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by LAMOOT Alexandre on 03/03/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CollectionSQLiteTest {

    private CollectionManagerSQLite mDataSource;

    @Before
    public void setUp(){
        mDataSource = new CollectionManagerSQLite(InstrumentationRegistry.getTargetContext());
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
        mDataSource.deleteAllCollections();
        ArrayList<Collection> collections = CollectionFactory.getAllCollections();
        for(int i = 0;i < collections.size();i++)
            mDataSource.addCollection(collections.get(i));

        ArrayList<Collection> collectionses = mDataSource.getAllCollections();
        assertEquals(collections.size(),collectionses.size());
    }

    @Test
    public void testDeleteAll() {
        mDataSource.deleteAllCollections();
        ArrayList<Collection> collectionses = mDataSource.getAllCollections();
        assertEquals(0,collectionses.size());
    }

    @Test
    public void testDeleteOnlyOne() {
        mDataSource.deleteAllCollections();
        ArrayList<Collection> collections = CollectionFactory.getAllCollections();
        for(int i = 0;i < collections.size();i++)
            mDataSource.addCollection(collections.get(i));
        mDataSource.deleteCollection(collections.get(0));
        assertEquals(collections.size()-1,mDataSource.getAllCollections().size());
        assertEquals(null,mDataSource.getCollectionByName(collections.get(0).getNom()).getNom());
    }

    @Test
    public void testAddAndDelete() {
        mDataSource.deleteAllCollections();
        ArrayList<Collection> collections = CollectionFactory.getAllCollections();
        mDataSource.addCollection(collections.get(0));
        assertEquals(1,mDataSource.getAllCollections().size());
        mDataSource.deleteCollection(collections.get(0));
        assertEquals(0,mDataSource.getAllCollections().size());
    }
}
