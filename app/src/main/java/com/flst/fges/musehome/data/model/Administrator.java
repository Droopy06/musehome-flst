package com.flst.fges.musehome.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by LAMOOT Alexandre on 02/01/2017.
 */
@Document(collection = "administrateur")
public class Administrator {
    private @Id @Getter @Setter String email;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String password;
    private @Getter @Setter boolean activated;
}
