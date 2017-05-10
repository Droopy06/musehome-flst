package com.flst.fges.musehome.data.helper;

import android.content.Context;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.model.CollectionDetails;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.data.model.Evenement;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 09/05/2017.
 */

public interface SynchronizeApiToDatabase {

    void initialize(int drawable, int idNotify, String contentTitle,
                    String contentText, Class aClass, Context context, AHBottomNavigation ahBottomNavigation, long timestamp);
    void getCollectionsApi();
    void getCollectionDetailsApi();
    void getDefaultClassCollectionApi();
    void getEvenementsApi();
    void getHerbiersApi();
    void getInstrumentsApi();
    void getJardinBotaniqueApi();
    void getMaterielPedagogiqueApi();
    void getMineralogieCristallographieApi();
    void getOuvragesCartesDocumentsApi();
    void getPaleontologieAnimaleApi();
    void getPaleontologieVegetaleApi();
    void getPetrographieApi();
    void getPhysiqueApi();
    void getTypothequeApi();
    void getZoologieInvertebresAutresApi();
    void getZoologieInvertebresInsectesApi();
    void getZoologieInvertebresMollusquesApi();
    void getZoologieVertebresAutresApi();
    void getZoologieVertebresMammiferesApi();
    void getZoologieVertebresOiseauxApi();
    void getZoologieVertebresPoissonsApi();
    void getZoologieVertebresPrimatesApi();
    void getZoologieVertebresReptileApi();
    void getAllNotificationsToUser();
    void addNotification(String table,Integer result);
    <T extends DefaultClassCollection> T getObjectCollection(List<T> array, String id,Class<T> tClass) throws IllegalAccessException, InstantiationException;
    Collection getCollection(List<Collection> collections,String name);
    CollectionDetails getCollectionDetails(List<CollectionDetails> collectionDetailses,String name);
    Evenement getEvent(List<Evenement> evenements,String title);
}
