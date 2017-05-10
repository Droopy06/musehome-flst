package com.flst.fges.musehome.data.helper;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.database.manager.CollectionDetailsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.CollectionManagerSQLite;
import com.flst.fges.musehome.data.database.manager.DefaultClassCollectionManagerSQLite;
import com.flst.fges.musehome.data.database.manager.EvenementManagerSQLite;
import com.flst.fges.musehome.data.database.manager.HerbiersManagerSQLite;
import com.flst.fges.musehome.data.database.manager.InstrumentsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.JardinBotaniqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.MaterielPedagogiqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.MineralogieCristallographieManagerSQLite;
import com.flst.fges.musehome.data.database.manager.OuvragesCartesDocumentsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PaleontologieAnimaleManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PaleontologieVegetaleManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PetrographieManagerSQLite;
import com.flst.fges.musehome.data.database.manager.PhysiqueManagerSQLite;
import com.flst.fges.musehome.data.database.manager.TypothequeManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieInvertebresAutresManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieInvertebresInsectesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieInvertebresMollusquesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresAutresManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresMammiferesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresOiseauxManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresPoissonsManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresPrimatesManagerSQLite;
import com.flst.fges.musehome.data.database.manager.ZoologieVertebresReptileManagerSQLite;
import com.flst.fges.musehome.data.manager.CollectionsDetailsManager;
import com.flst.fges.musehome.data.manager.CollectionsManager;
import com.flst.fges.musehome.data.manager.EvenementsManager;
import com.flst.fges.musehome.data.manager.HerbiersManager;
import com.flst.fges.musehome.data.manager.InstrumentsManager;
import com.flst.fges.musehome.data.manager.JardinBotaniqueManager;
import com.flst.fges.musehome.data.manager.MaterielPedagogiqueManager;
import com.flst.fges.musehome.data.manager.MineralogieCristallographieManager;
import com.flst.fges.musehome.data.manager.OuvragesCartesDocumentsManager;
import com.flst.fges.musehome.data.manager.PaleontologieAnimaleManager;
import com.flst.fges.musehome.data.manager.PaleontologieVegetaleManager;
import com.flst.fges.musehome.data.manager.PetrographieManager;
import com.flst.fges.musehome.data.manager.PhysiqueManager;
import com.flst.fges.musehome.data.manager.TypothequeManager;
import com.flst.fges.musehome.data.manager.ZoologieInvertebresAutresManager;
import com.flst.fges.musehome.data.manager.ZoologieInvertebresInsectesManager;
import com.flst.fges.musehome.data.manager.ZoologieInvertebresMollusquesManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresAutresManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresMammiferesManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresOiseauxManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresPoissonsManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresPrimatesManager;
import com.flst.fges.musehome.data.manager.ZoologieVertebresReptileManager;
import com.flst.fges.musehome.data.model.Collection;
import com.flst.fges.musehome.data.model.CollectionDetails;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.flst.fges.musehome.data.model.Evenement;
import com.flst.fges.musehome.data.model.Herbiers;
import com.flst.fges.musehome.data.model.Instruments;
import com.flst.fges.musehome.data.model.JardinBotanique;
import com.flst.fges.musehome.data.model.MaterielPedagogique;
import com.flst.fges.musehome.data.model.MineralogieCristallographie;
import com.flst.fges.musehome.data.model.OuvragesCartesDocuments;
import com.flst.fges.musehome.data.model.PaleontologieAnimale;
import com.flst.fges.musehome.data.model.PaleontologieVegetale;
import com.flst.fges.musehome.data.model.Petrographie;
import com.flst.fges.musehome.data.model.Physique;
import com.flst.fges.musehome.data.model.Typotheque;
import com.flst.fges.musehome.data.model.ZoologieInvertebresAutres;
import com.flst.fges.musehome.data.model.ZoologieInvertebresInsectes;
import com.flst.fges.musehome.data.model.ZoologieInvertebresMollusques;
import com.flst.fges.musehome.data.model.ZoologieVertebresAutres;
import com.flst.fges.musehome.data.model.ZoologieVertebresMammiferes;
import com.flst.fges.musehome.data.model.ZoologieVertebresOiseaux;
import com.flst.fges.musehome.data.model.ZoologieVertebresPoissons;
import com.flst.fges.musehome.data.model.ZoologieVertebresPrimates;
import com.flst.fges.musehome.data.model.ZoologieVertebresReptile;
import com.flst.fges.musehome.ui.activity.MainActivity;
import com.flst.fges.musehome.ui.helper.NotificationHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 09/05/2017.
 */
public class SynchronizeApiToDatabaseImpl extends AsyncTask<Boolean,Boolean,SynchronizeApiToDatabase> implements SynchronizeApiToDatabase {
    private int drawable;
    private int idNotify;
    private String contentTitle;
    private String contentText;
    private Class aClass;
    private Context context;
    private long timestamp;
    private AHBottomNavigation ahBottomNavigation;
    private ArrayList<String> notifications;
    private CollectionManagerSQLite collectionManagerSQLite;
    private CollectionDetailsManagerSQLite collectionDetailsManagerSQLite;
    private DefaultClassCollectionManagerSQLite defaultClassCollectionManagerSQLite;
    private EvenementManagerSQLite evenementManagerSQLite;
    private HerbiersManagerSQLite herbiersManagerSQLite;
    private InstrumentsManagerSQLite instrumentsManagerSQLite;
    private JardinBotaniqueManagerSQLite jardinBotaniqueManagerSQLite;
    private MaterielPedagogiqueManagerSQLite materielPedagogiqueManagerSQLite;
    private MineralogieCristallographieManagerSQLite mineralogieCristallographieManagerSQLite;
    private OuvragesCartesDocumentsManagerSQLite ouvragesCartesDocumentsManagerSQLite;
    private PaleontologieAnimaleManagerSQLite paleontologieAnimaleManagerSQLite;
    private PaleontologieVegetaleManagerSQLite paleontologieVegetaleManagerSQLite;
    private PetrographieManagerSQLite petrographieManagerSQLite;
    private PhysiqueManagerSQLite physiqueManagerSQLite;
    private TypothequeManagerSQLite typothequeManagerSQLite;
    private ZoologieInvertebresAutresManagerSQLite zoologieInvertebresAutresManagerSQLite;
    private ZoologieInvertebresInsectesManagerSQLite zoologieInvertebresInsectesManagerSQLite;
    private ZoologieInvertebresMollusquesManagerSQLite zoologieInvertebresMollusquesManagerSQLite;
    private ZoologieVertebresAutresManagerSQLite zoologieVertebresAutresManagerSQLite;
    private ZoologieVertebresMammiferesManagerSQLite zoologieVertebresMammiferesManagerSQLite;
    private ZoologieVertebresOiseauxManagerSQLite zoologieVertebresOiseauxManagerSQLite;
    private ZoologieVertebresPoissonsManagerSQLite zoologieVertebresPoissonsManagerSQLite;
    private ZoologieVertebresPrimatesManagerSQLite zoologieVertebresPrimatesManagerSQLite;
    private ZoologieVertebresReptileManagerSQLite zoologieVertebresReptileManagerSQLite;

    public SynchronizeApiToDatabaseImpl() {
        this.drawable = 0;
        this.idNotify = 1;
        this.contentTitle = "";
        this.contentText = "";
        this.aClass = MainActivity.class;
        this.context = null;
        this.ahBottomNavigation = null;
        this.timestamp = 0L;
        this.notifications = new ArrayList<>();
        this.collectionManagerSQLite = new CollectionManagerSQLite(context);
        this.collectionDetailsManagerSQLite = new CollectionDetailsManagerSQLite(context);
        this.defaultClassCollectionManagerSQLite = new DefaultClassCollectionManagerSQLite(context);
        this.evenementManagerSQLite = new EvenementManagerSQLite(context);
        this.herbiersManagerSQLite = new HerbiersManagerSQLite(context);
        this.instrumentsManagerSQLite = new InstrumentsManagerSQLite(context);
        this.jardinBotaniqueManagerSQLite = new JardinBotaniqueManagerSQLite(context);
        this.materielPedagogiqueManagerSQLite = new MaterielPedagogiqueManagerSQLite(context);
        this.mineralogieCristallographieManagerSQLite = new MineralogieCristallographieManagerSQLite(context);
        this.ouvragesCartesDocumentsManagerSQLite = new OuvragesCartesDocumentsManagerSQLite(context);
        this.paleontologieAnimaleManagerSQLite = new PaleontologieAnimaleManagerSQLite(context);
        this.paleontologieVegetaleManagerSQLite = new PaleontologieVegetaleManagerSQLite(context);
        this.petrographieManagerSQLite = new PetrographieManagerSQLite(context);
        this.physiqueManagerSQLite = new PhysiqueManagerSQLite(context);
        this.typothequeManagerSQLite = new TypothequeManagerSQLite(context);
        this.zoologieInvertebresAutresManagerSQLite = new ZoologieInvertebresAutresManagerSQLite(context);
        this.zoologieInvertebresInsectesManagerSQLite = new ZoologieInvertebresInsectesManagerSQLite(context);
        this.zoologieInvertebresMollusquesManagerSQLite = new ZoologieInvertebresMollusquesManagerSQLite(context);
        this.zoologieVertebresAutresManagerSQLite = new ZoologieVertebresAutresManagerSQLite(context);
        this.zoologieVertebresMammiferesManagerSQLite = new ZoologieVertebresMammiferesManagerSQLite(context);
        this.zoologieVertebresOiseauxManagerSQLite = new ZoologieVertebresOiseauxManagerSQLite(context);
        this.zoologieVertebresPoissonsManagerSQLite = new ZoologieVertebresPoissonsManagerSQLite(context);
        this.zoologieVertebresPrimatesManagerSQLite = new ZoologieVertebresPrimatesManagerSQLite(context);
        this.zoologieVertebresReptileManagerSQLite = new ZoologieVertebresReptileManagerSQLite(context);
    }

    public SynchronizeApiToDatabaseImpl(int drawable, int idNotify, String contentTitle,
                                        String contentText, Class aClass, Context context,
                                        AHBottomNavigation ahBottomNavigation,long timestamp) {
        this.drawable = drawable;
        this.idNotify = idNotify;
        this.contentTitle = contentTitle;
        this.contentText = contentText;
        this.aClass = aClass;
        this.context = context;
        this.ahBottomNavigation = ahBottomNavigation;
        this.timestamp = timestamp;
        this.notifications = new ArrayList<>();
        this.collectionManagerSQLite = new CollectionManagerSQLite(context);
        this.collectionDetailsManagerSQLite = new CollectionDetailsManagerSQLite(context);
        this.defaultClassCollectionManagerSQLite = new DefaultClassCollectionManagerSQLite(context);
        this.evenementManagerSQLite = new EvenementManagerSQLite(context);
        this.herbiersManagerSQLite = new HerbiersManagerSQLite(context);
        this.instrumentsManagerSQLite = new InstrumentsManagerSQLite(context);
        this.jardinBotaniqueManagerSQLite = new JardinBotaniqueManagerSQLite(context);
        this.materielPedagogiqueManagerSQLite = new MaterielPedagogiqueManagerSQLite(context);
        this.mineralogieCristallographieManagerSQLite = new MineralogieCristallographieManagerSQLite(context);
        this.ouvragesCartesDocumentsManagerSQLite = new OuvragesCartesDocumentsManagerSQLite(context);
        this.paleontologieAnimaleManagerSQLite = new PaleontologieAnimaleManagerSQLite(context);
        this.paleontologieVegetaleManagerSQLite = new PaleontologieVegetaleManagerSQLite(context);
        this.petrographieManagerSQLite = new PetrographieManagerSQLite(context);
        this.physiqueManagerSQLite = new PhysiqueManagerSQLite(context);
        this.typothequeManagerSQLite = new TypothequeManagerSQLite(context);
        this.zoologieInvertebresAutresManagerSQLite = new ZoologieInvertebresAutresManagerSQLite(context);
        this.zoologieInvertebresInsectesManagerSQLite = new ZoologieInvertebresInsectesManagerSQLite(context);
        this.zoologieInvertebresMollusquesManagerSQLite = new ZoologieInvertebresMollusquesManagerSQLite(context);
        this.zoologieVertebresAutresManagerSQLite = new ZoologieVertebresAutresManagerSQLite(context);
        this.zoologieVertebresMammiferesManagerSQLite = new ZoologieVertebresMammiferesManagerSQLite(context);
        this.zoologieVertebresOiseauxManagerSQLite = new ZoologieVertebresOiseauxManagerSQLite(context);
        this.zoologieVertebresPoissonsManagerSQLite = new ZoologieVertebresPoissonsManagerSQLite(context);
        this.zoologieVertebresPrimatesManagerSQLite = new ZoologieVertebresPrimatesManagerSQLite(context);
        this.zoologieVertebresReptileManagerSQLite = new ZoologieVertebresReptileManagerSQLite(context);
    }

    @Override
    protected SynchronizeApiToDatabase doInBackground(Boolean... params) {
        initialize(drawable,idNotify,contentTitle,contentText,aClass,context,ahBottomNavigation,timestamp);
        return this;
    }

    @Override
    public void initialize(int drawable, int idNotify, String contentTitle, String contentText,
                           Class aClass, Context context, AHBottomNavigation ahBottomNavigation, long timestamp) {
        getAllNotificationsToUser();
        NotificationHelper.addLongNotificationWithoutVibration(drawable,idNotify,contentTitle,contentText,
                aClass,context,notifications);
    }

    @Override
    public void getCollectionsApi() {
        CollectionsManager manager = new CollectionsManager();
        ArrayList<Collection> collectionsList = new ArrayList<>();
        manager.getAllCollections(new ICallback<List<Collection>>() {
            @Override
            public void success(List<Collection> collections) {
                collectionsList.clear();
                collectionsList.addAll(collections);
                List<Collection> list = collectionManagerSQLite.getAllCollection();
                for(Collection collection : collections) {
                    Collection collection1 = getCollection(list, collection.getNom());
                    if (collection1.getNom() == null)
                        collectionManagerSQLite.addCollection(collection);
                    else {
                        collection.setId(collection1.getId());
                        collectionManagerSQLite.updateCollection(collection1);
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERREUR",error);
            }
        });
    }

    @Override
    public void getCollectionDetailsApi() {
        CollectionsDetailsManager manager = new CollectionsDetailsManager();
        ArrayList<CollectionDetails> collectionsList = new ArrayList<>();
        manager.getAllCollectionsDetails(new ICallback<List<CollectionDetails>>() {
            @Override
            public void success(List<CollectionDetails> collectionDetailses) {
                collectionsList.clear();
                collectionsList.addAll(collectionDetailses);
                List<CollectionDetails> list = collectionDetailsManagerSQLite.getAllCollectionDetails();
                for(CollectionDetails collection : collectionsList) {
                    CollectionDetails details = getCollectionDetails(list, collection.getNameOfCollection());
                    if (details.getNameOfCollection() == null)
                        collectionDetailsManagerSQLite.addCollectionDetails(collection);
                    else {
                        collection.setId(details.getId());
                        collectionDetailsManagerSQLite.updateCollectionDetails(details);
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERREUR",error);
            }
        });
    }

    @Override
    public void getDefaultClassCollectionApi() {
        CollectionsDetailsManager collectionsDetailsManager = new CollectionsDetailsManager();
        ArrayList<CollectionDetails> collectionDetailses = new ArrayList<>();
        collectionsDetailsManager.getAllCollectionsDetails(new ICallback<List<CollectionDetails>>() {
            @Override
            public void success(List<CollectionDetails> collectionDetails) {
                collectionDetailses.clear();
                collectionDetailses.addAll(collectionDetails);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERREUR",error);
            }
        });
    }

    @Override
    public void getEvenementsApi() {
        EvenementsManager evenementsManager = new EvenementsManager();
        ArrayList<Evenement> evenementList = new ArrayList<>();
        evenementsManager.getAllEvenements(new ICallback<List<Evenement>>() {
            @Override
            public void success(List<Evenement> evenements) {
                evenementList.clear();
                evenementList.addAll(evenements);
                List<Evenement> list = evenementManagerSQLite.getAllEvenement();
                for(Evenement evenement : evenementList){
                    Evenement event = getEvent(list,evenement.getTitre());
                    if(event.getTitre() == null)
                        evenementManagerSQLite.addEvenement(evenement);
                    else {
                        evenement.setId(event.getId());
                        evenementManagerSQLite.updateEvenement(event);
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getHerbiersApi() {
        HerbiersManager herbiersManager = new HerbiersManager();
        ArrayList<Herbiers> herbiers = new ArrayList<>();
        herbiersManager.getAllHerbiers(new ICallback<List<Herbiers>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<Herbiers> herbiersList) {
                herbiers.clear();
                herbiers.addAll(herbiersList);
                List<Herbiers> list = herbiersManagerSQLite.getAllHerbiers();
                for(Herbiers herbiers1 : herbiers){
                    try {
                        Herbiers herbiers2 = getObjectCollection(list,herbiers1.getIdMongoDb(),Herbiers.class);
                        if(herbiers2.getIdMongoDb() == null){
                            herbiersManagerSQLite.addHerbiers(herbiers1);
                        }else{
                            herbiers1.setId(herbiers2.getId());
                            herbiersManagerSQLite.updateHerbiers(herbiers1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getInstrumentsApi() {
        InstrumentsManager instrumentsManager = new InstrumentsManager();
        ArrayList<Instruments> instrumentses = new ArrayList<>();
        instrumentsManager.getAllInstruments(new ICallback<List<Instruments>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<Instruments> instrumentsList) {
                instrumentses.clear();
                instrumentses.addAll(instrumentsList);
                List<Instruments> list = instrumentsManagerSQLite.getAllInstruments();
                for(Instruments instruments : instrumentses){
                    try {
                        Instruments instruments1 = getObjectCollection(list,instruments.getIdMongoDb(),Instruments.class);
                        if(instruments1.getIdMongoDb() == null){
                            instrumentsManagerSQLite.addInstruments(instruments);
                        }else {
                            instruments.setId(instruments1.getId());
                            instrumentsManagerSQLite.updateInstruments(instruments);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getJardinBotaniqueApi() {
        JardinBotaniqueManager jardinBotaniqueManager = new JardinBotaniqueManager();
        ArrayList<JardinBotanique> botaniques = new ArrayList<>();
        jardinBotaniqueManager.getAllJardinBotanique(new ICallback<List<JardinBotanique>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<JardinBotanique> jardinBotaniques) {
                botaniques.clear();
                botaniques.addAll(jardinBotaniques);
                List<JardinBotanique> list = jardinBotaniqueManagerSQLite.getAllJardinBotanique();
                for(JardinBotanique jardinBotanique : botaniques){
                    try {
                        JardinBotanique botanique = getObjectCollection(list,jardinBotanique.getIdMongoDb(),JardinBotanique.class);
                        if(botanique.getIdMongoDb() == null){
                            jardinBotaniqueManagerSQLite.addJardinBotanique(jardinBotanique);
                        }else {
                            jardinBotanique.setId(botanique.getId());
                            jardinBotaniqueManagerSQLite.updateJardinBotanique(jardinBotanique);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getMaterielPedagogiqueApi() {
        MaterielPedagogiqueManager materielPedagogiqueManager = new MaterielPedagogiqueManager();
        ArrayList<MaterielPedagogique> pedagogiques = new ArrayList<>();
        materielPedagogiqueManager.getAllMaterielPedagogique(new ICallback<List<MaterielPedagogique>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<MaterielPedagogique> materielPedagogiques) {
                pedagogiques.clear();
                pedagogiques.addAll(materielPedagogiques);
                List<MaterielPedagogique> list = materielPedagogiqueManagerSQLite.getAllMaterielPedagogique();
                for(MaterielPedagogique materielPedagogique : pedagogiques){
                    try {
                        MaterielPedagogique pedagogique = getObjectCollection(list,materielPedagogique.getIdMongoDb(),MaterielPedagogique.class);
                        if(pedagogique.getIdMongoDb() == null){
                            materielPedagogiqueManagerSQLite.addMaterielPedagogique(materielPedagogique);
                        }else{
                            materielPedagogique.setId(pedagogique.getId());
                            materielPedagogiqueManagerSQLite.updateMaterielPedagogique(materielPedagogique);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
                list.retainAll(pedagogiques);
                materielPedagogiqueManagerSQLite.deleteListMaterielPedagogique(list);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getMineralogieCristallographieApi() {
        MineralogieCristallographieManager mineralogieCristallographieManager = new MineralogieCristallographieManager();
        ArrayList<MineralogieCristallographie> cristallographies = new ArrayList<>();
        mineralogieCristallographieManager.getAllMineralogieCristallographie(new ICallback<List<MineralogieCristallographie>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<MineralogieCristallographie> mineralogieCristallographies) {
                cristallographies.clear();
                cristallographies.addAll(mineralogieCristallographies);
                List<MineralogieCristallographie> list = mineralogieCristallographieManagerSQLite.getAllMineralogieCristallographie();
                for(MineralogieCristallographie mineralogieCristallographie : cristallographies){
                    try {
                        MineralogieCristallographie mineralogieCristallographie1 = getObjectCollection(list,mineralogieCristallographie.getIdMongoDb(),MineralogieCristallographie.class);
                        if(mineralogieCristallographie1.getIdMongoDb() == null){
                            mineralogieCristallographieManagerSQLite.addMineralogieCristallographie(mineralogieCristallographie);
                        }else {
                            mineralogieCristallographie.setId(mineralogieCristallographie1.getId());
                            mineralogieCristallographieManagerSQLite.updateMineralogieCristallographie(mineralogieCristallographie);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getOuvragesCartesDocumentsApi() {
        OuvragesCartesDocumentsManager ouvragesCartesDocumentsManager = new OuvragesCartesDocumentsManager();
        ArrayList<OuvragesCartesDocuments> cartesDocumentses = new ArrayList<>();
        ouvragesCartesDocumentsManager.getAllOuvragesCartesDocuments(new ICallback<List<OuvragesCartesDocuments>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<OuvragesCartesDocuments> ouvragesCartesDocumentses) {
                cartesDocumentses.clear();
                cartesDocumentses.addAll(ouvragesCartesDocumentses);
                List<OuvragesCartesDocuments> list = ouvragesCartesDocumentsManagerSQLite.getAllOuvragesCartesDocuments();
                for(OuvragesCartesDocuments ouvragesCartesDocuments : cartesDocumentses){
                    try {
                        OuvragesCartesDocuments ouvragesCartesDocuments1 = getObjectCollection(list,ouvragesCartesDocuments.getIdMongoDb(),OuvragesCartesDocuments.class);
                        if(ouvragesCartesDocuments1.getIdMongoDb() == null){
                            ouvragesCartesDocumentsManagerSQLite.addOuvragesCartesDocuments(ouvragesCartesDocuments);
                        }else {
                            ouvragesCartesDocuments.setId(ouvragesCartesDocuments1.getId());
                            ouvragesCartesDocumentsManagerSQLite.updateOuvragesCartesDocuments(ouvragesCartesDocuments);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getPaleontologieAnimaleApi() {
        PaleontologieAnimaleManager paleontologieAnimaleManager = new PaleontologieAnimaleManager();
        ArrayList<PaleontologieAnimale> animales = new ArrayList<>();
        paleontologieAnimaleManager.getAllPaleontologieAnimale(new ICallback<List<PaleontologieAnimale>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<PaleontologieAnimale> paleontologieAnimales) {
                animales.clear();
                animales.addAll(paleontologieAnimales);
                List<PaleontologieAnimale> list = paleontologieAnimaleManagerSQLite.getAllPaleontologieAnimale();
                for(PaleontologieAnimale paleontologieAnimale : animales){
                    try {
                        PaleontologieAnimale animale = getObjectCollection(list,paleontologieAnimale.getIdMongoDb(),PaleontologieAnimale.class);
                        if(animale.getIdMongoDb() == null){
                            paleontologieAnimaleManagerSQLite.addPaleontologieAnimale(paleontologieAnimale);
                        }else {
                            paleontologieAnimale.setId(animale.getId());
                            paleontologieAnimaleManagerSQLite.updatePaleontologieAnimale(paleontologieAnimale);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getPaleontologieVegetaleApi() {
        PaleontologieVegetaleManager paleontologieVegetaleManager = new PaleontologieVegetaleManager();
        ArrayList<PaleontologieVegetale> vegetales = new ArrayList<>();
        paleontologieVegetaleManager.getAllPaleontologieVegetale(new ICallback<List<PaleontologieVegetale>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<PaleontologieVegetale> paleontologieVegetales) {
                vegetales.clear();
                vegetales.addAll(paleontologieVegetales);
                List<PaleontologieVegetale> list = paleontologieVegetaleManagerSQLite.getAllPaleontologieVegetale();
                for(PaleontologieVegetale paleontologieVegetale : vegetales){
                    try {
                        PaleontologieVegetale vegetale = getObjectCollection(list,paleontologieVegetale.getIdMongoDb(),PaleontologieVegetale.class);
                        if(vegetale.getIdMongoDb() == null){
                            paleontologieVegetaleManagerSQLite.addPaleontologieVegetale(paleontologieVegetale);
                        }else {
                            paleontologieVegetale.setId(vegetale.getId());
                            paleontologieVegetaleManagerSQLite.updatePaleontologieVegetale(paleontologieVegetale);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getPetrographieApi() {
        PetrographieManager petrographieManager = new PetrographieManager();
        ArrayList<Petrographie> petrographies = new ArrayList<>();
        petrographieManager.getAllPetrographie(new ICallback<List<Petrographie>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<Petrographie> petrographieList) {
                petrographies.clear();
                petrographies.addAll(petrographieList);
                List<Petrographie> list = petrographieManagerSQLite.getAllPetrographie();
                for(Petrographie petrographie : petrographies){
                    try {
                        Petrographie petrographie1 = getObjectCollection(list,petrographie.getIdMongoDb(),Petrographie.class);
                        if(petrographie1.getIdMongoDb() == null){
                            petrographieManagerSQLite.addPetrographie(petrographie);
                        }else {
                            petrographie.setId(petrographie1.getId());
                            petrographieManagerSQLite.updatePetrographie(petrographie);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getPhysiqueApi() {
        PhysiqueManager physiqueManager = new PhysiqueManager();
        ArrayList<Physique> physiques = new ArrayList<>();
        physiqueManager.getAllPhysique(new ICallback<List<Physique>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<Physique> physiqueList) {
                physiques.clear();
                physiques.addAll(physiqueList);
                List<Physique> list = physiqueManagerSQLite.getAllPhysique();
                for(Physique physique : physiques){
                    try {
                        Physique physique1 = getObjectCollection(list,physique.getIdMongoDb(),Physique.class);
                        if(physique1.getIdMongoDb() == null){
                            physiqueManagerSQLite.addPhysique(physique);
                        }else {
                            physique.setId(physique1.getId());
                            physiqueManagerSQLite.updatePhysique(physique);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getTypothequeApi() {
        TypothequeManager typothequeManager = new TypothequeManager();
        ArrayList<Typotheque> typotheques = new ArrayList<>();
        typothequeManager.getAllTypotheque(new ICallback<List<Typotheque>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<Typotheque> typothequeList) {
                typotheques.clear();
                typotheques.addAll(typothequeList);
                List<Typotheque> list = typothequeManagerSQLite.getAllTypotheque();
                for(Typotheque typotheque : typotheques){
                    try {
                        Typotheque typotheque1 = getObjectCollection(list,typotheque.getIdMongoDb(),Typotheque.class);
                        if(typotheque1.getIdMongoDb() == null){
                            typothequeManagerSQLite.addTypotheque(typotheque);
                        }else {
                            typotheque.setId(typotheque1.getId());
                            typothequeManagerSQLite.updateTypotheque(typotheque);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieInvertebresAutresApi() {
        ZoologieInvertebresAutresManager zoologieInvertebresAutresManager =
                new ZoologieInvertebresAutresManager();
        ArrayList<ZoologieInvertebresAutres> invertebresAutres = new ArrayList<>();
        zoologieInvertebresAutresManager.getAllZoologieInvertebresAutres(new ICallback<List<ZoologieInvertebresAutres>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieInvertebresAutres> zoologieInvertebresAutres) {
                invertebresAutres.clear();
                invertebresAutres.addAll(zoologieInvertebresAutres);
                List<ZoologieInvertebresAutres> list = zoologieInvertebresAutresManagerSQLite.getAllZoologieInvertebresAutres();
                for(ZoologieInvertebresAutres zoologieInvertebresAutres1 : invertebresAutres){
                    try {
                        ZoologieInvertebresAutres zoologieInvertebresAutres2 = getObjectCollection(list,zoologieInvertebresAutres1.getIdMongoDb(),ZoologieInvertebresAutres.class);
                        if(zoologieInvertebresAutres2.getIdMongoDb() == null){
                            zoologieInvertebresAutresManagerSQLite.addZoologieInvertebresAutres(zoologieInvertebresAutres1);
                        }else {
                            zoologieInvertebresAutres1.setId(zoologieInvertebresAutres2.getId());
                            zoologieInvertebresAutresManagerSQLite.updateZoologieInvertebresAutres(zoologieInvertebresAutres1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieInvertebresInsectesApi() {
        ZoologieInvertebresInsectesManager insectesManager = new ZoologieInvertebresInsectesManager();
        ArrayList<ZoologieInvertebresInsectes> invertebresInsectes = new ArrayList<>();
        insectesManager.getAllZoologieInvertebresInsectes(new ICallback<List<ZoologieInvertebresInsectes>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieInvertebresInsectes> zoologieInvertebresInsectes) {
                invertebresInsectes.clear();
                invertebresInsectes.addAll(zoologieInvertebresInsectes);
                List<ZoologieInvertebresInsectes> list = zoologieInvertebresInsectesManagerSQLite.getAllZoologieInvertebresInsectes();
                for(ZoologieInvertebresInsectes zoologieInvertebresInsectes1 : invertebresInsectes){
                    try {
                        ZoologieInvertebresInsectes zoologieInvertebresInsectes2 = getObjectCollection(list,zoologieInvertebresInsectes1.getIdMongoDb(),ZoologieInvertebresInsectes.class);
                        if(zoologieInvertebresInsectes2.getIdMongoDb() == null){
                            zoologieInvertebresInsectesManagerSQLite.addZoologieInvertebresInsectes(zoologieInvertebresInsectes1);
                        }else {
                            zoologieInvertebresInsectes1.setId(zoologieInvertebresInsectes2.getId());
                            zoologieInvertebresInsectesManagerSQLite.updateZoologieInvertebresInsectes(zoologieInvertebresInsectes1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieInvertebresMollusquesApi() {
        ZoologieInvertebresMollusquesManager mollusquesManager = new ZoologieInvertebresMollusquesManager();
        ArrayList<ZoologieInvertebresMollusques> invertebresMollusques = new ArrayList<>();
        mollusquesManager.getAllZoologieInvertebresMollusques(new ICallback<List<ZoologieInvertebresMollusques>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieInvertebresMollusques> zoologieInvertebresMollusques) {
                invertebresMollusques.clear();
                invertebresMollusques.addAll(zoologieInvertebresMollusques);
                List<ZoologieInvertebresMollusques> list = zoologieInvertebresMollusquesManagerSQLite.getAllZoologieInvertebresMollusques();
                for(ZoologieInvertebresMollusques zoologieInvertebresMollusques1 : invertebresMollusques){
                    try {
                        ZoologieInvertebresMollusques zoologieInvertebresMollusques2 = getObjectCollection(list,zoologieInvertebresMollusques1.getIdMongoDb(),ZoologieInvertebresMollusques.class);
                        if(zoologieInvertebresMollusques2.getIdMongoDb() == null){
                            zoologieInvertebresMollusquesManagerSQLite.addZoologieInvertebresMollusques(zoologieInvertebresMollusques1);
                        }else {
                            zoologieInvertebresMollusques1.setId(zoologieInvertebresMollusques2.getId());
                            zoologieInvertebresMollusquesManagerSQLite.updateZoologieInvertebresMollusques(zoologieInvertebresMollusques1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieVertebresAutresApi() {
        ZoologieVertebresAutresManager vertebresAutresManager = new ZoologieVertebresAutresManager();
        ArrayList<ZoologieVertebresAutres> vertebresAutres = new ArrayList<>();
        vertebresAutresManager.getAllZoologieVertebresAutres(new ICallback<List<ZoologieVertebresAutres>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieVertebresAutres> zoologieVertebresAutres) {
                vertebresAutres.clear();
                vertebresAutres.addAll(zoologieVertebresAutres);
                List<ZoologieVertebresAutres> list = zoologieVertebresAutresManagerSQLite.getAllZoologieVertebresAutres();
                for(ZoologieVertebresAutres zoologieVertebresAutres1 : vertebresAutres){
                    try {
                        ZoologieVertebresAutres zoologieVertebresAutres2 = getObjectCollection(list,zoologieVertebresAutres1.getIdMongoDb(),ZoologieVertebresAutres.class);
                        if(zoologieVertebresAutres2.getIdMongoDb() == null){
                            zoologieVertebresAutresManagerSQLite.addZoologieVertebresAutres(zoologieVertebresAutres1);
                        }else {
                            zoologieVertebresAutres1.setId(zoologieVertebresAutres2.getId());
                            zoologieVertebresAutresManagerSQLite.updateZoologieVertebresAutres(zoologieVertebresAutres1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieVertebresMammiferesApi() {
        ZoologieVertebresMammiferesManager mammiferesManager = new ZoologieVertebresMammiferesManager();
        ArrayList<ZoologieVertebresMammiferes> vertebresMammiferes = new ArrayList<>();
        mammiferesManager.getAllZoologieVertebresMammiferes(new ICallback<List<ZoologieVertebresMammiferes>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieVertebresMammiferes> zoologieVertebresMammiferes) {
                vertebresMammiferes.clear();
                vertebresMammiferes.addAll(zoologieVertebresMammiferes);
                List<ZoologieVertebresMammiferes> list = zoologieVertebresMammiferesManagerSQLite.getAllZoologieVertebresMammiferes();
                for(ZoologieVertebresMammiferes zoologieVertebresMammiferes1 : vertebresMammiferes){
                    try {
                        ZoologieVertebresMammiferes zoologieVertebresMammiferes2 = getObjectCollection(list,zoologieVertebresMammiferes1.getIdMongoDb(),ZoologieVertebresMammiferes.class);
                        if(zoologieVertebresMammiferes2.getIdMongoDb() == null){
                            zoologieVertebresMammiferesManagerSQLite.addZoologieVertebresMammiferes(zoologieVertebresMammiferes1);
                        }else {
                            zoologieVertebresMammiferes1.setId(zoologieVertebresMammiferes2.getId());
                            zoologieVertebresMammiferesManagerSQLite.updateZoologieVertebresMammiferes(zoologieVertebresMammiferes1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieVertebresOiseauxApi() {
        ZoologieVertebresOiseauxManager zoologieVertebresOiseauxManager = new ZoologieVertebresOiseauxManager();
        ArrayList<ZoologieVertebresOiseaux> vertebresOiseauxes = new ArrayList<>();
        zoologieVertebresOiseauxManager.getAllZoologieVertebresOiseaux(new ICallback<List<ZoologieVertebresOiseaux>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieVertebresOiseaux> zoologieVertebresPoissonses) {
                vertebresOiseauxes.clear();
                vertebresOiseauxes.addAll(zoologieVertebresPoissonses);
                List<ZoologieVertebresOiseaux> list = zoologieVertebresOiseauxManagerSQLite.getAllZoologieVertebresOiseaux();
                for(ZoologieVertebresOiseaux zoologieVertebresOiseaux : vertebresOiseauxes){
                    try {
                        ZoologieVertebresOiseaux zoologieVertebresOiseaux1 = getObjectCollection(list,zoologieVertebresOiseaux.getIdMongoDb(),ZoologieVertebresOiseaux.class);
                        if(zoologieVertebresOiseaux1.getIdMongoDb() == null){
                            zoologieVertebresOiseauxManagerSQLite.addZoologieVertebresOiseaux(zoologieVertebresOiseaux);
                        }else {
                            zoologieVertebresOiseaux.setId(zoologieVertebresOiseaux1.getId());
                            zoologieVertebresOiseauxManagerSQLite.updateZoologieVertebresOiseaux(zoologieVertebresOiseaux);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieVertebresPoissonsApi() {
        ZoologieVertebresPoissonsManager vertebresPoissonsManager = new ZoologieVertebresPoissonsManager();
        ArrayList<ZoologieVertebresPoissons> vertebresPoissonses = new ArrayList<>();
        vertebresPoissonsManager.getAllZoologieVertebresPoissons(new ICallback<List<ZoologieVertebresPoissons>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieVertebresPoissons> zoologieVertebresPoissonses) {
                vertebresPoissonses.clear();
                vertebresPoissonses.addAll(zoologieVertebresPoissonses);
                List<ZoologieVertebresPoissons> list = zoologieVertebresPoissonsManagerSQLite.getAllZoologieVertebresPoissons();
                for(ZoologieVertebresPoissons zoologieVertebresPoissons : vertebresPoissonses){
                    try {
                        ZoologieVertebresPoissons zoologieVertebresPoissons1 = getObjectCollection(list,zoologieVertebresPoissons.getIdMongoDb(),ZoologieVertebresPoissons.class);
                        if(zoologieVertebresPoissons1.getIdMongoDb() == null){
                            zoologieVertebresPoissonsManagerSQLite.addZoologieVertebresPoissons(zoologieVertebresPoissons);
                        }else {
                            zoologieVertebresPoissons.setId(zoologieVertebresPoissons1.getId());
                            zoologieVertebresPoissonsManagerSQLite.updateZoologieVertebresPoissons(zoologieVertebresPoissons);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieVertebresPrimatesApi() {
        ZoologieVertebresPrimatesManager primatesManager = new ZoologieVertebresPrimatesManager();
        ArrayList<ZoologieVertebresPrimates> vertebresPrimates = new ArrayList<>();
        primatesManager.getAllZoologieVertebresPrimates(new ICallback<List<ZoologieVertebresPrimates>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieVertebresPrimates> zoologieVertebresPrimates) {
                vertebresPrimates.clear();
                vertebresPrimates.addAll(zoologieVertebresPrimates);
                List<ZoologieVertebresPrimates> list = zoologieVertebresPrimatesManagerSQLite.getAllZoologieVertebresPrimates();
                for(ZoologieVertebresPrimates zoologieVertebresPrimates1 : vertebresPrimates){
                    try {
                        ZoologieVertebresPrimates zoologieVertebresPrimates2 = getObjectCollection(list,zoologieVertebresPrimates1.getIdMongoDb(),ZoologieVertebresPrimates.class);
                        if(zoologieVertebresPrimates2.getIdMongoDb() == null){
                            zoologieVertebresPrimatesManagerSQLite.addZoologieVertebresPrimates(zoologieVertebresPrimates1);
                        }else {
                            zoologieVertebresPrimates1.setId(zoologieVertebresPrimates2.getId());
                            zoologieVertebresPrimatesManagerSQLite.updateZoologieVertebresPrimates(zoologieVertebresPrimates1);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getZoologieVertebresReptileApi() {
        ZoologieVertebresReptileManager reptileManager = new ZoologieVertebresReptileManager();
        ArrayList<ZoologieVertebresReptile> vertebresReptiles = new ArrayList<>();
        reptileManager.getAllZoologieVertebresReptile(new ICallback<List<ZoologieVertebresReptile>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(List<ZoologieVertebresReptile> zoologieVertebresReptiles) {
                vertebresReptiles.clear();
                vertebresReptiles.addAll(zoologieVertebresReptiles);
                List<ZoologieVertebresReptile> list = zoologieVertebresReptileManagerSQLite.getAllZoologieVertebresReptile();
                for(ZoologieVertebresReptile zoologieVertebresReptile : vertebresReptiles){
                    try {
                        ZoologieVertebresReptile zoologieVertebresReptile1 = getObjectCollection(list,zoologieVertebresReptile.getIdMongoDb(),ZoologieVertebresReptile.class);
                        if(zoologieVertebresReptile1.getIdMongoDb() == null){
                            zoologieVertebresReptileManagerSQLite.addZoologieVertebresReptile(zoologieVertebresReptile);
                        }else {
                            zoologieVertebresReptile.setId(zoologieVertebresReptile1.getId());
                            zoologieVertebresReptileManagerSQLite.updateZoologieVertebresReptile(zoologieVertebresReptile);
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }

    @Override
    public void getAllNotificationsToUser() {
        Integer result = 0;
        getCollectionsApi();
        addNotification("collections",result);
        getCollectionDetailsApi();
        addNotification("collections details",result);
        getEvenementsApi();
        addNotification("evenements",result);
        getHerbiersApi();
        addNotification("herbiers",result);
        getInstrumentsApi();
        addNotification("instruments",result);
        getJardinBotaniqueApi();
        addNotification("jardin botanique",result);
        getMaterielPedagogiqueApi();
        addNotification("materiel pedagogique",result);
        getMineralogieCristallographieApi();
        addNotification("mineralogie cristallographie",result);
        getOuvragesCartesDocumentsApi();
        addNotification("ouvrages cartes documents",result);
        getPaleontologieAnimaleApi();
        addNotification("paleontologie animale",result);
        getPaleontologieVegetaleApi();
        addNotification("paleontologie végétale",result);
        getPetrographieApi();
        addNotification("petrographie",result);
        getPhysiqueApi();
        addNotification("physique",result);
        getTypothequeApi();
        addNotification("typotheque",result);
        getZoologieInvertebresAutresApi();
        addNotification("zoologie invertebres autres",result);
        getZoologieInvertebresInsectesApi();
        addNotification("zoologie invertebres insectes",result);
        getZoologieInvertebresMollusquesApi();
        addNotification("zoologie invertebres mollusques",result);
        getZoologieVertebresAutresApi();
        addNotification("zoologie vertebres autres",result);
        getZoologieVertebresMammiferesApi();
        addNotification("zoologie vertebres mammiferes",result);
        getZoologieVertebresOiseauxApi();
        addNotification("zoologie vertebres oiseaux",result);
        getZoologieVertebresPoissonsApi();
        addNotification("zoologie vertebres poissons",result);
        getZoologieVertebresPrimatesApi();
        addNotification("zoologie vertebres primates",result);
        getZoologieVertebresReptileApi();
        addNotification("zoologie vertebres reptile",result);
        //this.ahBottomNavigation.setNotification("60",2);
    }

    @Override
    public void addNotification(String table,Integer result) {
        if(result > 0)
            notifications.add("L'administrateur a ajouté "+result+" "+table);
        else
            notifications.add("L'administrateur a enlevé "+result+" "+table);
    }

    @Override
    public <T extends DefaultClassCollection> T getObjectCollection(List<T> array,String id,Class<T> tClass)
            throws IllegalAccessException, InstantiationException {
        /*Predicate<T> predicate = c-> c.getIdMongoDb().equals(id);
        T  obj = array.stream().filter(predicate).findFirst().get();
        return obj;*/
        for(T t: array){
            if(t.getIdMongoDb().equals(id))
                return t;
        }
        return tClass.newInstance();
    }

    @Override
    public Collection getCollection(List<Collection> collections, String name) {
        for(Collection collection: collections){
            if(collection.getNom().equals(name))
                return collection;
        }
        return new Collection();
    }

    @Override
    public CollectionDetails getCollectionDetails(List<CollectionDetails> collectionDetailses, String name) {
        for(CollectionDetails collectionDetails: collectionDetailses){
            if(collectionDetails.getNameOfCollection().equals(name))
                return collectionDetails;
        }
        return new CollectionDetails();
    }

    @Override
    public Evenement getEvent(List<Evenement> evenements, String title) {
        for(Evenement evenement: evenements){
            if(evenement.getTitre().equals(title))
                return evenement;
        }
        return new Evenement();
    }
}
