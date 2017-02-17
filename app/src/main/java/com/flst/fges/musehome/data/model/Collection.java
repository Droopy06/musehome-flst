package com.flst.fges.musehome.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by LAMOOT Alexandre on 11/04/2016.
 */
@Document(collection = "collection")
public class Collection {
    private @Getter @Setter String nom;
    private @Getter @Setter String famille;
    private @Getter @Setter String uri;
    private @Getter @Setter String uriadmin;
    private @Getter @Setter String img;
}
