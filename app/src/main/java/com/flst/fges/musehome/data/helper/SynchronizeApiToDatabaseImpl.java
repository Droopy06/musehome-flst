package com.flst.fges.musehome.data.helper;

import android.content.Context;
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
import com.flst.fges.musehome.ui.helper.NotificationHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by LAMOOT Alexandre on 09/05/2017.
 */
public class SynchronizeApiToDatabaseImpl implements SynchronizeApiToDatabase{
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
    }

    @Override
    public void initialize(int drawable, int idNotify, String contentTitle, String contentText,
                           Class aClass, Context context, AHBottomNavigation ahBottomNavigation, long timestamp) {
        this.ahBottomNavigation = ahBottomNavigation;
        notifications = new ArrayList<>();
        collectionManagerSQLite = new CollectionManagerSQLite(context);
        collectionDetailsManagerSQLite = new CollectionDetailsManagerSQLite(context);
        defaultClassCollectionManagerSQLite = new DefaultClassCollectionManagerSQLite(context);
        evenementManagerSQLite = new EvenementManagerSQLite(context);
        herbiersManagerSQLite = new HerbiersManagerSQLite(context);
        instrumentsManagerSQLite = new InstrumentsManagerSQLite(context);
        jardinBotaniqueManagerSQLite = new JardinBotaniqueManagerSQLite(context);
        materielPedagogiqueManagerSQLite = new MaterielPedagogiqueManagerSQLite(context);
        mineralogieCristallographieManagerSQLite = new MineralogieCristallographieManagerSQLite(context);
        ouvragesCartesDocumentsManagerSQLite = new OuvragesCartesDocumentsManagerSQLite(context);
        paleontologieAnimaleManagerSQLite = new PaleontologieAnimaleManagerSQLite(context);
        paleontologieVegetaleManagerSQLite = new PaleontologieVegetaleManagerSQLite(context);
        petrographieManagerSQLite = new PetrographieManagerSQLite(context);
        physiqueManagerSQLite = new PhysiqueManagerSQLite(context);
        typothequeManagerSQLite = new TypothequeManagerSQLite(context);
        zoologieInvertebresAutresManagerSQLite = new ZoologieInvertebresAutresManagerSQLite(context);
        zoologieInvertebresInsectesManagerSQLite = new ZoologieInvertebresInsectesManagerSQLite(context);
        zoologieInvertebresMollusquesManagerSQLite = new ZoologieInvertebresMollusquesManagerSQLite(context);
        zoologieVertebresAutresManagerSQLite = new ZoologieVertebresAutresManagerSQLite(context);
        zoologieVertebresMammiferesManagerSQLite = new ZoologieVertebresMammiferesManagerSQLite(context);
        zoologieVertebresOiseauxManagerSQLite = new ZoologieVertebresOiseauxManagerSQLite(context);
        zoologieVertebresPoissonsManagerSQLite = new ZoologieVertebresPoissonsManagerSQLite(context);
        zoologieVertebresPrimatesManagerSQLite = new ZoologieVertebresPrimatesManagerSQLite(context);
        zoologieVertebresReptileManagerSQLite = new ZoologieVertebresReptileManagerSQLite(context);
        getAllNotificationsToUser();
        NotificationHelper.addLongNotificationWithoutVibration(drawable,idNotify,contentTitle,contentText,
                aClass,context,notifications);
    }

    @Override
    public Integer getCollectionsApi() {
        CollectionsManager manager = new CollectionsManager();
        ArrayList<Collection> collectionsList = new ArrayList<>();
        manager.getAllCollections(new ICallback<List<Collection>>() {
            @Override
            public void success(List<Collection> collections) {
                collectionsList.clear();
                collectionsList.addAll(collections);
                for(Collection collection : collections)
                    collectionManagerSQLite.addCollection(collection);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERREUR",error);
            }
        });
        Integer rowsInDatabase = 0;
        return collectionsList.size() - rowsInDatabase;
    }

    @Override
    public Integer getCollectionDetailsApi() {
        defaultClassCollectionManagerSQLite.getAllDefaultClassCollection();
        return 0;
    }

    @Override
    public Integer getDefaultClassCollectionApi() {
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
        ArrayList<CollectionDetails> arrayDatabase = collectionDetailsManagerSQLite.getAllCollectionDetails();
        Integer rowsInDatabase = arrayDatabase.size();
        return collectionDetailses.size() - rowsInDatabase;
    }

    @Override
    public Integer getEvenementsApi() {
        EvenementsManager evenementsManager = new EvenementsManager();
        ArrayList<Evenement> evenementList = new ArrayList<>();
        evenementsManager.getAllEvenements(new ICallback<List<Evenement>>() {
            @Override
            public void success(List<Evenement> evenements) {
                evenementList.clear();
                evenementList.addAll(evenements);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<Evenement> arrayDatabase = evenementManagerSQLite.getAllEvenement();
        Integer rowsInDatabase = arrayDatabase.size();
        return evenementList.size() - rowsInDatabase;
    }

    @Override
    public Integer getHerbiersApi() {
        HerbiersManager herbiersManager = new HerbiersManager();
        ArrayList<Herbiers> herbiers = new ArrayList<>();
        herbiersManager.getAllHerbiers(new ICallback<List<Herbiers>>() {
            @Override
            public void success(List<Herbiers> herbiersList) {
                herbiers.clear();
                herbiers.addAll(herbiersList);
                for(Herbiers herbiers1 : herbiers)
                    herbiersManagerSQLite.addHerbiers(herbiers1);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<Herbiers> arrayDatabase = herbiersManagerSQLite.getAllHerbiers();
        Integer rowsInDatabase = arrayDatabase.size();
        return herbiers.size() - rowsInDatabase;
    }

    @Override
    public Integer getInstrumentsApi() {
        InstrumentsManager instrumentsManager = new InstrumentsManager();
        ArrayList<Instruments> instrumentses = new ArrayList<>();
        instrumentsManager.getAllInstruments(new ICallback<List<Instruments>>() {
            @Override
            public void success(List<Instruments> instrumentsList) {
                instrumentses.clear();
                instrumentses.addAll(instrumentsList);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<Instruments> arrayDatabase = instrumentsManagerSQLite.getAllInstruments();
        Integer rowsInDatabase = arrayDatabase.size();
        return instrumentses.size() - rowsInDatabase;
    }

    @Override
    public Integer getJardinBotaniqueApi() {
        JardinBotaniqueManager jardinBotaniqueManager = new JardinBotaniqueManager();
        ArrayList<JardinBotanique> botaniques = new ArrayList<>();
        jardinBotaniqueManager.getAllJardinBotanique(new ICallback<List<JardinBotanique>>() {
            @Override
            public void success(List<JardinBotanique> jardinBotaniques) {
                botaniques.clear();
                botaniques.addAll(jardinBotaniques);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<JardinBotanique> arrayDatabase = jardinBotaniqueManagerSQLite.getAllJardinBotanique();
        Integer rowsInDatabase = arrayDatabase.size();
        return botaniques.size() - rowsInDatabase;
    }

    @Override
    public Integer getMaterielPedagogiqueApi() {
        MaterielPedagogiqueManager materielPedagogiqueManager = new MaterielPedagogiqueManager();
        ArrayList<MaterielPedagogique> pedagogiques = new ArrayList<>();
        materielPedagogiqueManager.getAllMaterielPedagogique(new ICallback<List<MaterielPedagogique>>() {
            @Override
            public void success(List<MaterielPedagogique> materielPedagogiques) {
                pedagogiques.clear();
                pedagogiques.addAll(materielPedagogiques);
                for(MaterielPedagogique materielPedagogique : pedagogiques)
                    materielPedagogiqueManagerSQLite.addMaterielPedagogique(materielPedagogique);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        Integer rowsInDatabase = 8;
        return pedagogiques.size() - rowsInDatabase;
    }

    @Override
    public Integer getMineralogieCristallographieApi() {
        MineralogieCristallographieManager mineralogieCristallographieManager = new MineralogieCristallographieManager();
        ArrayList<MineralogieCristallographie> cristallographies = new ArrayList<>();
        mineralogieCristallographieManager.getAllMineralogieCristallographie(new ICallback<List<MineralogieCristallographie>>() {
            @Override
            public void success(List<MineralogieCristallographie> mineralogieCristallographies) {
                cristallographies.clear();
                cristallographies.addAll(mineralogieCristallographies);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<MineralogieCristallographie> arrayDatabase = mineralogieCristallographieManagerSQLite.getAllMineralogieCristallographie();
        Integer rowsInDatabase = arrayDatabase.size();
        return cristallographies.size() - rowsInDatabase;
    }

    @Override
    public Integer getOuvragesCartesDocumentsApi() {
        OuvragesCartesDocumentsManager ouvragesCartesDocumentsManager = new OuvragesCartesDocumentsManager();
        ArrayList<OuvragesCartesDocuments> cartesDocumentses = new ArrayList<>();
        ouvragesCartesDocumentsManager.getAllOuvragesCartesDocuments(new ICallback<List<OuvragesCartesDocuments>>() {
            @Override
            public void success(List<OuvragesCartesDocuments> ouvragesCartesDocumentses) {
                cartesDocumentses.clear();
                cartesDocumentses.addAll(ouvragesCartesDocumentses);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<OuvragesCartesDocuments> arrayDatabase = ouvragesCartesDocumentsManagerSQLite.getAllOuvragesCartesDocuments();
        Integer rowsInDatabase = arrayDatabase.size();
        return cartesDocumentses.size() - rowsInDatabase;
    }

    @Override
    public Integer getPaleontologieAnimaleApi() {
        PaleontologieAnimaleManager paleontologieAnimaleManager = new PaleontologieAnimaleManager();
        ArrayList<PaleontologieAnimale> animales = new ArrayList<>();
        paleontologieAnimaleManager.getAllPaleontologieAnimale(new ICallback<List<PaleontologieAnimale>>() {
            @Override
            public void success(List<PaleontologieAnimale> paleontologieAnimales) {
                animales.clear();
                animales.addAll(paleontologieAnimales);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<PaleontologieAnimale> arrayDatabase = paleontologieAnimaleManagerSQLite.getAllPaleontologieAnimale();
        Integer rowsInDatabase = arrayDatabase.size();
        return animales.size() - rowsInDatabase;
    }

    @Override
    public Integer getPaleontologieVegetaleApi() {
        PaleontologieVegetaleManager paleontologieVegetaleManager = new PaleontologieVegetaleManager();
        ArrayList<PaleontologieVegetale> vegetales = new ArrayList<>();
        paleontologieVegetaleManager.getAllPaleontologieVegetale(new ICallback<List<PaleontologieVegetale>>() {
            @Override
            public void success(List<PaleontologieVegetale> paleontologieVegetales) {
                vegetales.clear();
                vegetales.addAll(paleontologieVegetales);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<PaleontologieVegetale> arrayDatabase = paleontologieVegetaleManagerSQLite.getAllPaleontologieVegetale();
        Integer rowsInDatabase = arrayDatabase.size();
        return vegetales.size() - rowsInDatabase;
    }

    @Override
    public Integer getPetrographieApi() {
        PetrographieManager petrographieManager = new PetrographieManager();
        ArrayList<Petrographie> petrographies = new ArrayList<>();
        petrographieManager.getAllPetrographie(new ICallback<List<Petrographie>>() {
            @Override
            public void success(List<Petrographie> petrographieList) {
                petrographies.clear();
                petrographies.addAll(petrographieList);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<Petrographie> arrayDatabase = petrographieManagerSQLite.getAllPetrographie();
        Integer rowsInDatabase = arrayDatabase.size();
        return petrographies.size() - rowsInDatabase;
    }

    @Override
    public Integer getPhysiqueApi() {
        PhysiqueManager physiqueManager = new PhysiqueManager();
        ArrayList<Physique> physiques = new ArrayList<>();
        physiqueManager.getAllPhysique(new ICallback<List<Physique>>() {
            @Override
            public void success(List<Physique> physiqueList) {
                physiques.clear();
                physiques.addAll(physiqueList);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<Physique> arrayDatabase = physiqueManagerSQLite.getAllPhysique();
        Integer rowsInDatabase = arrayDatabase.size();
        return physiques.size() - rowsInDatabase;
    }

    @Override
    public Integer getTypothequeApi() {
        TypothequeManager typothequeManager = new TypothequeManager();
        ArrayList<Typotheque> typotheques = new ArrayList<>();
        typothequeManager.getAllTypotheque(new ICallback<List<Typotheque>>() {
            @Override
            public void success(List<Typotheque> typothequeList) {
                typotheques.clear();
                typotheques.addAll(typothequeList);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<Typotheque> arrayDatabase = typothequeManagerSQLite.getAllTypotheque();
        Integer rowsInDatabase = arrayDatabase.size();
        return typotheques.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieInvertebresAutresApi() {
        ZoologieInvertebresAutresManager zoologieInvertebresAutresManager =
                new ZoologieInvertebresAutresManager();
        ArrayList<ZoologieInvertebresAutres> invertebresAutres = new ArrayList<>();
        zoologieInvertebresAutresManager.getAllZoologieInvertebresAutres(new ICallback<List<ZoologieInvertebresAutres>>() {
            @Override
            public void success(List<ZoologieInvertebresAutres> zoologieInvertebresAutres) {
                invertebresAutres.clear();
                invertebresAutres.addAll(zoologieInvertebresAutres);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieInvertebresAutres> arrayDatabase = zoologieInvertebresAutresManagerSQLite.getAllZoologieInvertebresAutres();
        Integer rowsInDatabase = arrayDatabase.size();
        return invertebresAutres.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieInvertebresInsectesApi() {
        ZoologieInvertebresInsectesManager insectesManager = new ZoologieInvertebresInsectesManager();
        ArrayList<ZoologieInvertebresInsectes> invertebresInsectes = new ArrayList<>();
        insectesManager.getAllZoologieInvertebresInsectes(new ICallback<List<ZoologieInvertebresInsectes>>() {
            @Override
            public void success(List<ZoologieInvertebresInsectes> zoologieInvertebresInsectes) {
                invertebresInsectes.clear();
                invertebresInsectes.addAll(zoologieInvertebresInsectes);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieInvertebresInsectes> arrayDatabase = zoologieInvertebresInsectesManagerSQLite.getAllZoologieInvertebresInsectes();
        Integer rowsInDatabase = arrayDatabase.size();
        return invertebresInsectes.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieInvertebresMollusquesApi() {
        ZoologieInvertebresMollusquesManager mollusquesManager = new ZoologieInvertebresMollusquesManager();
        ArrayList<ZoologieInvertebresMollusques> invertebresMollusques = new ArrayList<>();
        mollusquesManager.getAllZoologieInvertebresMollusques(new ICallback<List<ZoologieInvertebresMollusques>>() {
            @Override
            public void success(List<ZoologieInvertebresMollusques> zoologieInvertebresMollusques) {
                invertebresMollusques.clear();
                invertebresMollusques.addAll(zoologieInvertebresMollusques);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieInvertebresMollusques> arrayDatabase = zoologieInvertebresMollusquesManagerSQLite.getAllZoologieInvertebresMollusques();
        Integer rowsInDatabase = arrayDatabase.size();
        return invertebresMollusques.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieVertebresAutresApi() {
        ZoologieVertebresAutresManager vertebresAutresManager = new ZoologieVertebresAutresManager();
        ArrayList<ZoologieVertebresAutres> vertebresAutres = new ArrayList<>();
        vertebresAutresManager.getAllZoologieVertebresAutres(new ICallback<List<ZoologieVertebresAutres>>() {
            @Override
            public void success(List<ZoologieVertebresAutres> zoologieVertebresAutres) {
                vertebresAutres.clear();
                vertebresAutres.addAll(zoologieVertebresAutres);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieVertebresAutres> arrayDatabase = zoologieVertebresAutresManagerSQLite.getAllZoologieVertebresAutres();
        Integer rowsInDatabase = arrayDatabase.size();
        return vertebresAutres.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieVertebresMammiferesApi() {
        ZoologieVertebresMammiferesManager mammiferesManager = new ZoologieVertebresMammiferesManager();
        ArrayList<ZoologieVertebresMammiferes> vertebresMammiferes = new ArrayList<>();
        mammiferesManager.getAllZoologieVertebresMammiferes(new ICallback<List<ZoologieVertebresMammiferes>>() {
            @Override
            public void success(List<ZoologieVertebresMammiferes> zoologieVertebresMammiferes) {
                vertebresMammiferes.clear();
                vertebresMammiferes.addAll(zoologieVertebresMammiferes);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieVertebresMammiferes> arrayDatabase = zoologieVertebresMammiferesManagerSQLite.getAllZoologieVertebresMammiferes();
        Integer rowsInDatabase = arrayDatabase.size();
        return vertebresMammiferes.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieVertebresOiseauxApi() {
        ZoologieVertebresOiseauxManager zoologieVertebresOiseauxManager = new ZoologieVertebresOiseauxManager();
        ArrayList<ZoologieVertebresOiseaux> vertebresOiseauxes = new ArrayList<>();
        zoologieVertebresOiseauxManager.getAllZoologieVertebresOiseaux(new ICallback<List<ZoologieVertebresOiseaux>>() {
            @Override
            public void success(List<ZoologieVertebresOiseaux> zoologieVertebresPoissonses) {
                vertebresOiseauxes.clear();
                vertebresOiseauxes.addAll(zoologieVertebresPoissonses);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieVertebresOiseaux> arrayDatabase = zoologieVertebresOiseauxManagerSQLite.getAllZoologieVertebresOiseaux();
        Integer rowsInDatabase = arrayDatabase.size();
        return vertebresOiseauxes.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieVertebresPoissonsApi() {
        ZoologieVertebresPoissonsManager vertebresPoissonsManager = new ZoologieVertebresPoissonsManager();
        ArrayList<ZoologieVertebresPoissons> vertebresPoissonses = new ArrayList<>();
        vertebresPoissonsManager.getAllZoologieVertebresPoissons(new ICallback<List<ZoologieVertebresPoissons>>() {
            @Override
            public void success(List<ZoologieVertebresPoissons> zoologieVertebresPoissonses) {
                vertebresPoissonses.clear();
                vertebresPoissonses.addAll(zoologieVertebresPoissonses);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieVertebresPoissons> arrayDatabase = zoologieVertebresPoissonsManagerSQLite.getAllZoologieVertebresPoissons();
        Integer rowsInDatabase = arrayDatabase.size();
        return vertebresPoissonses.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieVertebresPrimatesApi() {
        ZoologieVertebresPrimatesManager primatesManager = new ZoologieVertebresPrimatesManager();
        ArrayList<ZoologieVertebresPrimates> vertebresPrimates = new ArrayList<>();
        primatesManager.getAllZoologieVertebresPrimates(new ICallback<List<ZoologieVertebresPrimates>>() {
            @Override
            public void success(List<ZoologieVertebresPrimates> zoologieVertebresPrimates) {
                vertebresPrimates.clear();
                vertebresPrimates.addAll(zoologieVertebresPrimates);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        ArrayList<ZoologieVertebresPrimates> arrayDatabase = zoologieVertebresPrimatesManagerSQLite.getAllZoologieVertebresPrimates();
        Integer rowsInDatabase = arrayDatabase.size();
        return vertebresPrimates.size() - rowsInDatabase;
    }

    @Override
    public Integer getZoologieVertebresReptileApi() {
        ZoologieVertebresReptileManager reptileManager = new ZoologieVertebresReptileManager();
        ArrayList<ZoologieVertebresReptile> vertebresReptiles = new ArrayList<>();
        reptileManager.getAllZoologieVertebresReptile(new ICallback<List<ZoologieVertebresReptile>>() {
            @Override
            public void success(List<ZoologieVertebresReptile> zoologieVertebresReptiles) {
                vertebresReptiles.clear();
                vertebresReptiles.addAll(zoologieVertebresReptiles);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });

        ArrayList<ZoologieVertebresReptile> arrayDatabase = zoologieVertebresReptileManagerSQLite.getAllZoologieVertebresReptile();
        Integer rowsInDatabase = arrayDatabase.size();
        return vertebresReptiles.size() - rowsInDatabase;
    }

    @Override
    public void getAllNotificationsToUser() {
        Integer result;
        result = getCollectionsApi();
        if(result != 0)
            addNotification("collections",result);
        result = getCollectionDetailsApi();
        if(result != 0)
            addNotification("collections details",result);
        result = getEvenementsApi();
        if(result != 0)
            addNotification("evenements",result);
        result = getHerbiersApi();
        if(result != 0)
            addNotification("herbiers",result);
        result = getInstrumentsApi();
        if(result != 0)
            addNotification("instruments",result);
        result = getJardinBotaniqueApi();
        if(result != 0)
            addNotification("jardin botanique",result);
        result = getMaterielPedagogiqueApi();
        if(result != 0)
            addNotification("materiel pedagogique",result);
        result = getMineralogieCristallographieApi();
        if(result != 0)
            addNotification("mineralogie cristallographie",result);
        result = getOuvragesCartesDocumentsApi();
        if(result != 0)
            addNotification("ouvrages cartes documents",result);
        result = getPaleontologieAnimaleApi();
        if(result != 0)
            addNotification("paleontologie animale",result);
        result = getPaleontologieVegetaleApi();
        if(result != 0)
            addNotification("paleontologie végétale",result);
        result = getPetrographieApi();
        if(result != 0)
            addNotification("petrographie",result);
        result = getPhysiqueApi();
        if(result != 0)
            addNotification("physique",result);
        result = getTypothequeApi();
        if(result != 0)
            addNotification("typotheque",result);
        result = getZoologieInvertebresAutresApi();
        if(result != 0)
            addNotification("zoologie invertebres autres",result);
        result = getZoologieInvertebresInsectesApi();
        if(result != 0)
            addNotification("zoologie invertebres insectes",result);
        result = getZoologieInvertebresMollusquesApi();
        if(result != 0)
            addNotification("zoologie invertebres mollusques",result);
        result = getZoologieVertebresAutresApi();
        if(result != 0)
            addNotification("zoologie vertebres autres",result);
        result = getZoologieVertebresMammiferesApi();
        if(result != 0)
            addNotification("zoologie vertebres mammiferes",result);
        result = getZoologieVertebresOiseauxApi();
        if(result != 0)
            addNotification("zoologie vertebres oiseaux",result);
        result = getZoologieVertebresPoissonsApi();
        if(result != 0)
            addNotification("zoologie vertebres poissons",result);
        result = getZoologieVertebresPrimatesApi();
        if(result != 0)
            addNotification("zoologie vertebres primates",result);
        result = getZoologieVertebresReptileApi();
        if(result != 0)
            addNotification("zoologie vertebres reptile",result);
        this.ahBottomNavigation.setNotification("60",2);
    }

    @Override
    public void addNotification(String table,Integer result) {
        if(result > 0)
            notifications.add("L'administrateur a ajouté "+result+" "+table);
        else
            notifications.add("L'administrateur a enlevé "+result+" "+table);
    }

    @Override
    public <T extends DefaultClassCollection> T getObjectCollection(List<T> array,String id) {
        Predicate<T> predicate = c-> c.getIdMongoDb().equals(id);
        T  obj = array.stream().filter(predicate).findFirst().get();
        return obj;
    }
}
