package com.flst.fges.musehome.data.factory;

import com.flst.fges.musehome.data.model.Collection;

import java.util.ArrayList;

/**
 * Created by LAMOOT Alexandre on 17/02/2017.
 */

public class CollectionFactory {

    public static ArrayList<Collection> getAllCollections(){
        ArrayList<Collection> collections = new ArrayList<>();
        collections.add(new Collection("Herbiers","","http://vps278022.ovh.net/patrimoine/images/Collections/Collection01/SousCollections/Herbiers.png"));
        collections.add(new Collection("Jardin botanique","","http://vps278022.ovh.net/patrimoine/images/Collections/Collection01/SousCollections/JardinNBoulay.png"));
        collections.add(new Collection("Mineralogie - Cristallographie","Mineralogie","http://vps278022.ovh.net/patrimoine/images/Collections/Collection02/SousCollections/MineralogieCristallographie.png"));
        collections.add(new Collection("Petrographie","","http://vps278022.ovh.net/patrimoine/images/Collections/Collection02/SousCollections/Petrographie.png"));
        collections.add(new Collection("Paleontologie Animale","","http://vps278022.ovh.net/patrimoine/images/Collections/Paleontologie.png"));
        collections.add(new Collection("Paleontologie Vegetale","","http://vps278022.ovh.net/patrimoine/images/Collections/Paleontologie.png"));
        collections.add(new Collection("Physique", "","http://vps278022.ovh.net/patrimoine/images/Collections/Physique.png"));
        collections.add(new Collection("Zoologie Vertebres Mammiferes","oologie Vertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Mammiferes.png"));
        collections.add(new Collection("Zoologie Vertebres Reptiles","Zoologie Vertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Reptiles.png"));
        collections.add(new Collection("Zoologie Vertebres Primates","Zoologie Vertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Primates.png"));
        collections.add(new Collection("Zoologie Vertebres Oiseaux","Zoologie Vertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Oiseaux.png"));
        collections.add(new Collection("Zoologie Vertebres Poissons","Zoologie Vertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Poissons.png"));
        collections.add(new Collection("Zoologie Vertebres Autres","Zoologie Vertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/AutresVertebres.png"));
        collections.add(new Collection("Zoologie Invertebres Insectes","Zoologie Invertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Insectes.png"));
        collections.add(new Collection("Zoologie Invertebres Mollusques","Zoologie Invertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/Coquillages.png"));
        collections.add(new Collection("Zoologie Invertebres Autres","Zoologie Invertebres","http://vps278022.ovh.net/patrimoine/images/Collections/Collection05/SousCollections/AutresInvertebres.png"));
        collections.add(new Collection("Typotheque","","http://vps278022.ovh.net/patrimoine/images/Collections/Typotheque.png"));
        collections.add(new Collection("Instruments","","http://vps278022.ovh.net/patrimoine/images/Collections/Instrument.png"));
        collections.add(new Collection("Materiel Pedagogique","","http://vps278022.ovh.net/patrimoine/images/Collections/MaterielPedagogique.png"));
        collections.add(new Collection("Prehistoire - Archeologique","Prehistoire","http://vps278022.ovh.net/patrimoine/images/Collections/Collection10/HomoSapiens.png"));
        collections.add(new Collection("Ouvrages - Cartes - Documents","","http://vps278022.ovh.net/patrimoine/images/Collections/Collection09/CarteFrance.png"));
        return collections;
    }
}
