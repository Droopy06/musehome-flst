package com.flst.fges.musehome.data.database;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.flst.fges.musehome.data.database.manager.EvenementManagerSQLite;
import com.flst.fges.musehome.data.factory.EvenementFactory;
import com.flst.fges.musehome.data.model.Evenement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Olive on 07/03/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EventSQLiteTest {

    private EvenementManagerSQLite mDataSource;

    @Before
    public void setUp(){
        mDataSource = new EvenementManagerSQLite(InstrumentationRegistry.getTargetContext());
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
        //mDataSource.deleteAllEvents();
        ArrayList<Evenement> events = EvenementFactory.getAllEvenement();
        for(int i = 0;i < events.size();i++)
            mDataSource.addEvent(events.get(i));

        ArrayList<Evenement> evenements = mDataSource.getAllEvent();
        assertEquals(evenements.size(),events.size());
    }

    @Test
    public void testDeleteAll() {
        mDataSource.deleteAllEvents();
        ArrayList<Evenement> evnts = mDataSource.getAllEvent();
        assertEquals(0,evnts.size());
    }

    @Test
    public void testDeleteOnlyOne() {
        mDataSource.deleteAllEvents();
        ArrayList<Evenement> evenements = EvenementFactory.getAllEvenement();
        for(int i = 0;i < evenements.size();i++)
            mDataSource.addEvent(evenements.get(i));
        mDataSource.deleteEvent(evenements.get(0));
        assertEquals(evenements.size()-1,mDataSource.getAllEvent().size());
        assertEquals(null,mDataSource.getEventByTitre(evenements.get(0).getTitre()));
    }

    @Test
    public void testAddAndDelete() {
        mDataSource.deleteAllEvents();
        ArrayList<Evenement> evenements = EvenementFactory.getAllEvenement();
        mDataSource.addEvent(evenements.get(0));
        assertEquals(1,mDataSource.getAllEvent().size());
        mDataSource.deleteEvent(evenements.get(0));
        assertEquals(0,mDataSource.getAllEvent().size());
    }
}
