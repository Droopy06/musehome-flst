package com.flst.fges.musehome.data.helper;

import android.content.Context;

import com.flst.fges.musehome.data.database.manager.*;

/**
 * Created by LAMOOT Alexandre on 09/05/2017.
 */

public class SizeOfObjectsCollectionHelper {
    private static DefaultClassCollectionManagerSQLite defaultClassCollectionManagerSQLite;
    private static EvenementManagerSQLite evenementManagerSQLite;
    private static HerbiersManagerSQLite herbiersManagerSQLite;
    private static InstrumentsManagerSQLite instrumentsManagerSQLite;
    private static JardinBotaniqueManagerSQLite jardinBotaniqueManagerSQLite;
    private static MaterielPedagogiqueManagerSQLite materielPedagogiqueManagerSQLite;
    private static MineralogieCristallographieManagerSQLite mineralogieCristallographieManagerSQLite;
    private static OuvragesCartesDocumentsManagerSQLite ouvragesCartesDocumentsManagerSQLite;
    private static PaleontologieAnimaleManagerSQLite paleontologieAnimaleManagerSQLite;
    private static PaleontologieVegetaleManagerSQLite paleontologieVegetaleManagerSQLite;
    private static PetrographieManagerSQLite petrographieManagerSQLite;
    private static PhysiqueManagerSQLite physiqueManagerSQLite;
    private static TypothequeManagerSQLite typothequeManagerSQLite;
    private static ZoologieInvertebresAutresManagerSQLite zoologieInvertebresAutresManagerSQLite;
    private static ZoologieInvertebresInsectesManagerSQLite zoologieInvertebresInsectesManagerSQLite;
    private static ZoologieInvertebresMollusquesManagerSQLite zoologieInvertebresMollusquesManagerSQLite;
    private static ZoologieVertebresAutresManagerSQLite zoologieVertebresAutresManagerSQLite;
    private static ZoologieVertebresMammiferesManagerSQLite zoologieVertebresMammiferesManagerSQLite;
    private static ZoologieVertebresOiseauxManagerSQLite zoologieVertebresOiseauxManagerSQLite;
    private static ZoologieVertebresPoissonsManagerSQLite zoologieVertebresPoissonsManagerSQLite;
    private static ZoologieVertebresPrimatesManagerSQLite zoologieVertebresPrimatesManagerSQLite;
    private static ZoologieVertebresReptileManagerSQLite zoologieVertebresReptileManagerSQLite;

    public SizeOfObjectsCollectionHelper(Context context) {
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
    }

    public Integer getSizeOfObjectsCollection(String nameCollection){
        Integer result;
        switch (nameCollection){
            case "Herbiers":
                result = herbiersManagerSQLite.getAllHerbiers().size();
                break;
            case "Instruments":
                result = instrumentsManagerSQLite.getAllInstruments().size();
                break;
            case "Jardin botanique":
                result = jardinBotaniqueManagerSQLite.getAllJardinBotanique().size();
                break;
            case "Materiel Pedagogique":
                result = materielPedagogiqueManagerSQLite.getAllMaterielPedagogique().size();
                break;
            case "Mineralogie - Cristallographie":
                result = mineralogieCristallographieManagerSQLite.getAllMineralogieCristallographie().size();
                break;
            case "Ouvrages Cartes Documents":
                result = ouvragesCartesDocumentsManagerSQLite.getAllOuvragesCartesDocuments().size();
                break;
            case "Paleontologie Animale":
                result = paleontologieAnimaleManagerSQLite.getAllPaleontologieAnimale().size();
                break;
            case "Paleontologie Vegetale":
                result = paleontologieVegetaleManagerSQLite.getAllPaleontologieVegetale().size();
                break;
            case "Petrographie":
                result = petrographieManagerSQLite.getAllPetrographie().size();
                break;
            case "Physique":
                result = physiqueManagerSQLite.getAllPhysique().size();
                break;
            case "Typotheque":
                result = typothequeManagerSQLite.getAllTypotheque().size();
                break;
            case "Zoologie Invertebres Autres":
                result = zoologieInvertebresAutresManagerSQLite.getAllZoologieInvertebresAutres().size();
                break;
            case "Zoologie Invertebres Insectes":
                result = zoologieInvertebresInsectesManagerSQLite.getAllZoologieInvertebresInsectes().size();
                break;
            case "Zoologie Invertebres Mollusques":
                result = zoologieInvertebresMollusquesManagerSQLite.getAllZoologieInvertebresMollusques().size();
                break;
            case "Zoologie Vertebres Autres":
                result = zoologieVertebresAutresManagerSQLite.getAllZoologieVertebresAutres().size();
                break;
            case "Zoologie Vertebres Mammiferes":
                result = zoologieVertebresMammiferesManagerSQLite.getAllZoologieVertebresMammiferes().size();
                break;
            case "Zoologie Vertebres Oiseaux":
                result = zoologieVertebresOiseauxManagerSQLite.getAllZoologieVertebresOiseaux().size();
                break;
            case "Zoologie Vertebres Poissons":
                result = zoologieVertebresPoissonsManagerSQLite.getAllZoologieVertebresPoissons().size();
                break;
            case "Zoologie Vertebres Primates":
                result = zoologieVertebresPrimatesManagerSQLite.getAllZoologieVertebresPrimates().size();
                break;
            case "Zoologie Vertebres Reptile":
                result = zoologieVertebresReptileManagerSQLite.getAllZoologieVertebresReptile().size();
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
