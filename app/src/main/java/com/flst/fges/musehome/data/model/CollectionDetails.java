package com.flst.fges.musehome.data.model;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by LAMOOT Alexandre on 25/11/2016.
 */
@DatabaseTable(tableName = "collection_details")
public class CollectionDetails {

    @DatabaseField(generatedId = true)
    transient protected Integer id;
    @DatabaseField @Expose
    private   String nameOfCollection;
    @DatabaseField @Expose
    private   String idMongoDb;
    @DatabaseField @Expose
    private   String picture;
    @DatabaseField @Expose
    private   String name;
    @DatabaseField @Expose
    private   String groupe;
    @DatabaseField @Expose
    private   String kind;
    @DatabaseField @Expose
    private   String espece;
    @DatabaseField @Expose
    private   String author;
    @DatabaseField @Expose
    private   String year;
    @DatabaseField @Expose
    private   String country;
    @DatabaseField @Expose
    private   String city;
    @DatabaseField @Expose
    private   String place;
    @DatabaseField @Expose
    private   String nameCollection;
    @DatabaseField @Expose
    private   String manifold;
    @DatabaseField @Expose
    private   String localization;
    @DatabaseField @Expose
    private   String annexe1;
    @DatabaseField @Expose
    private   String annexe2;
    @DatabaseField @Expose
    private   String annexe3;
    @DatabaseField @Expose
    private   String annexe4;
    @DatabaseField @Expose
    private   String annexe5;
    @DatabaseField @Expose
    private   String annexe6;
    @DatabaseField @Expose
    private   String annexe7;
    @DatabaseField @Expose
    private   String annexe8;
    @DatabaseField @Expose
    private   String annexe9;
    @DatabaseField @Expose
    private   String annexe10;
    @DatabaseField @Expose
    private   String annexe11;
    @DatabaseField @Expose
    private   String annexe12;
    @DatabaseField @Expose
    private   String annexe13;
    @DatabaseField @Expose
    private   String annexe14;
    @DatabaseField @Expose
    private   String annexe15;
    @DatabaseField @Expose
    private   String annexe16;
    @DatabaseField @Expose
    private   String annexe17;
    @DatabaseField @Expose
    private   String annexe18;
    @DatabaseField @Expose
    private   String annexe19;
    @DatabaseField @Expose
    private   String annexe20;
    @DatabaseField @Expose
    private   String annexe21;
    @DatabaseField @Expose
    private   String annexe22;
    @DatabaseField @Expose
    private   String annexe23;
    @DatabaseField @Expose
    private   String annexe24;
    @DatabaseField @Expose
    private   String annexe25;
    @DatabaseField @Expose
    private   String annexe26;
    @DatabaseField @Expose
    private   String annexe27;
    @DatabaseField @Expose
    private   String annexe28;
    @DatabaseField @Expose
    private   String annexe29;
    @DatabaseField @Expose
    private   String annexe30;
    @DatabaseField @Expose
    private   String annexe31;
    @DatabaseField @Expose
    private   String annexe32;
    @DatabaseField @Expose
    private   String annexe33;
    @DatabaseField @Expose
    private   String annexe34;
    @DatabaseField @Expose
    private   String annexe35;
    @DatabaseField @Expose
    private   String annexe36;
    @DatabaseField @Expose
    private   String annexe37;
    @DatabaseField @Expose
    private   String annexe38;
    @DatabaseField @Expose
    private   String annexe39;
    @DatabaseField @Expose
    private   String annexe40;

    public CollectionDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfCollection() {
        return nameOfCollection;
    }

    public void setNameOfCollection(String nameOfCollection) {
        this.nameOfCollection = nameOfCollection;
    }

    public String getIdMongoDb() {
        return idMongoDb;
    }

    public void setIdMongoDb(String idMongoDb) {
        this.idMongoDb = idMongoDb;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNameCollection() {
        return nameCollection;
    }

    public void setNameCollection(String nameCollection) {
        this.nameCollection = nameCollection;
    }

    public String getManifold() {
        return manifold;
    }

    public void setManifold(String manifold) {
        this.manifold = manifold;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getAnnexe1() {
        return annexe1;
    }

    public void setAnnexe1(String annexe1) {
        this.annexe1 = annexe1;
    }

    public String getAnnexe2() {
        return annexe2;
    }

    public void setAnnexe2(String annexe2) {
        this.annexe2 = annexe2;
    }

    public String getAnnexe3() {
        return annexe3;
    }

    public void setAnnexe3(String annexe3) {
        this.annexe3 = annexe3;
    }

    public String getAnnexe4() {
        return annexe4;
    }

    public void setAnnexe4(String annexe4) {
        this.annexe4 = annexe4;
    }

    public String getAnnexe5() {
        return annexe5;
    }

    public void setAnnexe5(String annexe5) {
        this.annexe5 = annexe5;
    }

    public String getAnnexe6() {
        return annexe6;
    }

    public void setAnnexe6(String annexe6) {
        this.annexe6 = annexe6;
    }

    public String getAnnexe7() {
        return annexe7;
    }

    public void setAnnexe7(String annexe7) {
        this.annexe7 = annexe7;
    }

    public String getAnnexe8() {
        return annexe8;
    }

    public void setAnnexe8(String annexe8) {
        this.annexe8 = annexe8;
    }

    public String getAnnexe9() {
        return annexe9;
    }

    public void setAnnexe9(String annexe9) {
        this.annexe9 = annexe9;
    }

    public String getAnnexe10() {
        return annexe10;
    }

    public void setAnnexe10(String annexe10) {
        this.annexe10 = annexe10;
    }

    public String getAnnexe11() {
        return annexe11;
    }

    public void setAnnexe11(String annexe11) {
        this.annexe11 = annexe11;
    }

    public String getAnnexe12() {
        return annexe12;
    }

    public void setAnnexe12(String annexe12) {
        this.annexe12 = annexe12;
    }

    public String getAnnexe13() {
        return annexe13;
    }

    public void setAnnexe13(String annexe13) {
        this.annexe13 = annexe13;
    }

    public String getAnnexe14() {
        return annexe14;
    }

    public void setAnnexe14(String annexe14) {
        this.annexe14 = annexe14;
    }

    public String getAnnexe15() {
        return annexe15;
    }

    public void setAnnexe15(String annexe15) {
        this.annexe15 = annexe15;
    }

    public String getAnnexe16() {
        return annexe16;
    }

    public void setAnnexe16(String annexe16) {
        this.annexe16 = annexe16;
    }

    public String getAnnexe17() {
        return annexe17;
    }

    public void setAnnexe17(String annexe17) {
        this.annexe17 = annexe17;
    }

    public String getAnnexe18() {
        return annexe18;
    }

    public void setAnnexe18(String annexe18) {
        this.annexe18 = annexe18;
    }

    public String getAnnexe19() {
        return annexe19;
    }

    public void setAnnexe19(String annexe19) {
        this.annexe19 = annexe19;
    }

    public String getAnnexe20() {
        return annexe20;
    }

    public void setAnnexe20(String annexe20) {
        this.annexe20 = annexe20;
    }

    public String getAnnexe21() {
        return annexe21;
    }

    public void setAnnexe21(String annexe21) {
        this.annexe21 = annexe21;
    }

    public String getAnnexe22() {
        return annexe22;
    }

    public void setAnnexe22(String annexe22) {
        this.annexe22 = annexe22;
    }

    public String getAnnexe23() {
        return annexe23;
    }

    public void setAnnexe23(String annexe23) {
        this.annexe23 = annexe23;
    }

    public String getAnnexe24() {
        return annexe24;
    }

    public void setAnnexe24(String annexe24) {
        this.annexe24 = annexe24;
    }

    public String getAnnexe25() {
        return annexe25;
    }

    public void setAnnexe25(String annexe25) {
        this.annexe25 = annexe25;
    }

    public String getAnnexe26() {
        return annexe26;
    }

    public void setAnnexe26(String annexe26) {
        this.annexe26 = annexe26;
    }

    public String getAnnexe27() {
        return annexe27;
    }

    public void setAnnexe27(String annexe27) {
        this.annexe27 = annexe27;
    }

    public String getAnnexe28() {
        return annexe28;
    }

    public void setAnnexe28(String annexe28) {
        this.annexe28 = annexe28;
    }

    public String getAnnexe29() {
        return annexe29;
    }

    public void setAnnexe29(String annexe29) {
        this.annexe29 = annexe29;
    }

    public String getAnnexe30() {
        return annexe30;
    }

    public void setAnnexe30(String annexe30) {
        this.annexe30 = annexe30;
    }

    public String getAnnexe31() {
        return annexe31;
    }

    public void setAnnexe31(String annexe31) {
        this.annexe31 = annexe31;
    }

    public String getAnnexe32() {
        return annexe32;
    }

    public void setAnnexe32(String annexe32) {
        this.annexe32 = annexe32;
    }

    public String getAnnexe33() {
        return annexe33;
    }

    public void setAnnexe33(String annexe33) {
        this.annexe33 = annexe33;
    }

    public String getAnnexe34() {
        return annexe34;
    }

    public void setAnnexe34(String annexe34) {
        this.annexe34 = annexe34;
    }

    public String getAnnexe35() {
        return annexe35;
    }

    public void setAnnexe35(String annexe35) {
        this.annexe35 = annexe35;
    }

    public String getAnnexe36() {
        return annexe36;
    }

    public void setAnnexe36(String annexe36) {
        this.annexe36 = annexe36;
    }

    public String getAnnexe37() {
        return annexe37;
    }

    public void setAnnexe37(String annexe37) {
        this.annexe37 = annexe37;
    }

    public String getAnnexe38() {
        return annexe38;
    }

    public void setAnnexe38(String annexe38) {
        this.annexe38 = annexe38;
    }

    public String getAnnexe39() {
        return annexe39;
    }

    public void setAnnexe39(String annexe39) {
        this.annexe39 = annexe39;
    }

    public String getAnnexe40() {
        return annexe40;
    }

    public void setAnnexe40(String annexe40) {
        this.annexe40 = annexe40;
    }
}
