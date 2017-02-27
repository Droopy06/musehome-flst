package com.flst.fges.musehome.data.converter;

import com.flst.fges.musehome.data.model.OuvragesCartesDocuments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 20/02/2017.
 */

public class OuvragesCartesDocumentsConverter {

    public ArrayList<OuvragesCartesDocuments> convertDtoToOuvragesCartesDocuments(List<OuvragesCartesDocuments> ouvragesCartesDocumentses){
        ArrayList<OuvragesCartesDocuments> list = new ArrayList<>();
        for(OuvragesCartesDocuments ouvragesCartesDocuments : ouvragesCartesDocumentses)
            list.add(ouvragesCartesDocuments);
        return list;
    }
}
