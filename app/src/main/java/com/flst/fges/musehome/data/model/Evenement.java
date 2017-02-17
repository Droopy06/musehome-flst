package com.flst.fges.musehome.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@Document(collection = "evenement")
public class Evenement {
    private @Getter @Setter String titre;
    private @Getter @Setter String miniDescr;
    private @Getter @Setter String imageuri;
    private @Getter @Setter String miniimageuri;
    private @Getter @Setter String twitter;
    private @Getter @Setter String facebook;
    private @Getter @Setter String go;
}
