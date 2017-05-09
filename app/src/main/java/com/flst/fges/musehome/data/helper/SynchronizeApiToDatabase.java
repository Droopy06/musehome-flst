package com.flst.fges.musehome.data.helper;

import android.content.Context;

/**
 * Created by LAMOOT Alexandre on 09/05/2017.
 */

public interface SynchronizeApiToDatabase {

    void initialize(int drawable,int idNotify,String contentTitle,
                    String contentText,Class aClass,Context context,long timestamp);
    Integer getCollectionsApi();
    Integer getCollectionDetailsApi();
    Integer getDefaultClassCollectionApi();
    Integer getEvenementsApi();
    Integer getHerbiersApi();
    Integer getInstrumentsApi();
    Integer getJardinBotaniqueApi();
    Integer getMaterielPedagogiqueApi();
    Integer getMineralogieCristallographieApi();
    Integer getOuvragesCartesDocumentsApi();
    Integer getPaleontologieAnimaleApi();
    Integer getPaleontologieVegetaleApi();
    Integer getPetrographieApi();
    Integer getPhysiqueApi();
    Integer getTypothequeApi();
    Integer getZoologieInvertebresAutresApi();
    Integer getZoologieInvertebresInsectesApi();
    Integer getZoologieInvertebresMollusquesApi();
    Integer getZoologieVertebresAutresApi();
    Integer getZoologieVertebresMammiferesApi();
    Integer getZoologieVertebresOiseauxApi();
    Integer getZoologieVertebresPoissonsApi();
    Integer getZoologieVertebresPrimatesApi();
    Integer getZoologieVertebresReptileApi();
    void getAllNotificationsToUser();
    void addNotification(String table,Integer result);
}
