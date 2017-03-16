package com.flst.fges.musehome.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.helper.UrlHelper;
import com.flst.fges.musehome.data.manager.CollectionsDetailsManager;
import com.flst.fges.musehome.data.manager.DefaultClassCollectionManager;
import com.flst.fges.musehome.data.model.CollectionDetails;
import com.flst.fges.musehome.data.model.DefaultClassCollection;
import com.squareup.picasso.Picasso;

public class ObjetsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objets_detail);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.banniere);
        actionBar.setDisplayUseLogoEnabled(true);
        final ImageView imageView = (ImageView) findViewById(R.id.object_collection_imageview);
        final TextView mHeaderNomCommum = (TextView) findViewById(R.id.header_nom_commum_textview);
        final TextView mTextNomCommum = (TextView) findViewById(R.id.text_nom_commum_textview);
        final TextView mHeaderGroupe = (TextView) findViewById(R.id.header_groupe_textview);
        final TextView mTextGroupe = (TextView) findViewById(R.id.text_groupe_textview);
        final TextView mHeaderGenre = (TextView) findViewById(R.id.header_genre_textview);
        final TextView mTextGenre = (TextView) findViewById(R.id.text_genre_textview);
        final TextView mHeaderEspece = (TextView) findViewById(R.id.header_espece_textview);
        final TextView mTextEspece = (TextView) findViewById(R.id.text_espece_textview);
        final TextView mHeaderAuteur = (TextView) findViewById(R.id.header_auteur_textview);
        final TextView mTextAuteur = (TextView) findViewById(R.id.text_auteur_textview);
        final TextView mHeaderAnnee = (TextView) findViewById(R.id.header_annee_textview);
        final TextView mTextAnnee = (TextView) findViewById(R.id.text_annee_textview);
        final TextView mHeaderPays = (TextView) findViewById(R.id.header_pays_textview);
        final TextView mTextPays = (TextView) findViewById(R.id.text_pays_textview);
        final TextView mHeaderVille = (TextView) findViewById(R.id.header_ville_textview);
        final TextView mTextVille = (TextView) findViewById(R.id.text_ville_textview);
        final TextView mHeaderLieu = (TextView) findViewById(R.id.header_lieu_textview);
        final TextView mTextLieu = (TextView) findViewById(R.id.text_lieu_textview);
        final TextView mHeaderNomCollection = (TextView) findViewById(R.id.header_nom_collection_textview);
        final TextView mTextNomCollection = (TextView) findViewById(R.id.text_nom_collection_textview);
        final TextView mHeaderCollectionneur = (TextView) findViewById(R.id.header_collectionneur_textview);
        final TextView mTextCollectionneur = (TextView) findViewById(R.id.text_collectionneur_textview);
        final TextView mHeaderLocalisation = (TextView) findViewById(R.id.header_localisation_textview);
        final TextView mTextLocalisation = (TextView) findViewById(R.id.text_localisation_textview);
        CollectionsDetailsManager collectionsDetailsManager = new CollectionsDetailsManager();
        collectionsDetailsManager.getCollectionsDetailsByName(getIntent().getStringExtra("COLLECTION").replace(" ", "").toLowerCase(), new ICallback<CollectionDetails>() {
            @Override
            public void success(CollectionDetails collectionDetails) {
                mHeaderNomCommum.setText(collectionDetails.getName());
                mHeaderGroupe.setText(collectionDetails.getGroupe());
                mHeaderGenre.setText(collectionDetails.getKind());
                mHeaderEspece.setText(collectionDetails.getEspece());
                mHeaderAuteur.setText(collectionDetails.getAuthor());
                mHeaderAnnee.setText(collectionDetails.getYear());
                mHeaderPays.setText(collectionDetails.getCountry());
                mHeaderVille.setText(collectionDetails.getCity());
                mHeaderLieu.setText(collectionDetails.getPlace());
                mHeaderNomCollection.setText(collectionDetails.getNameCollection());
                mHeaderCollectionneur.setText(collectionDetails.getManifold());
                mHeaderLocalisation.setText(collectionDetails.getLocalization());
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
        DefaultClassCollectionManager defaultClassCollectionManager = new DefaultClassCollectionManager();
        String id = getIntent().getStringExtra("OBJET").split(" ")[0];
        defaultClassCollectionManager.getDefaultClassCollectionByName(getIntent().getStringExtra("COLLECTION").replace(" ", "").toLowerCase(), id, new ICallback<DefaultClassCollection>() {
            @Override
            public void success(DefaultClassCollection defaultClassCollection) {
                Picasso.with(getApplicationContext()).
                        load("http://"+ UrlHelper.BASE_URL_API +"/patrimoine/images/Collections/"+
                                getIntent().getStringExtra("COLLECTION").replace(" ", "").toLowerCase()+
                                "/"+defaultClassCollection.getPicture()).
                        into(imageView);
                mTextNomCommum.setText(defaultClassCollection.getName());
                mTextGroupe.setText(defaultClassCollection.getGroupe());
                mTextGenre.setText(defaultClassCollection.getKind());
                mTextEspece.setText(defaultClassCollection.getEspece());
                mTextAuteur.setText(defaultClassCollection.getAuthor());
                mTextAnnee.setText(defaultClassCollection.getYear());
                mTextPays.setText(defaultClassCollection.getCountry());
                mTextVille.setText(defaultClassCollection.getCity());
                mTextLieu.setText(defaultClassCollection.getPlace());
                mTextNomCollection.setText(defaultClassCollection.getNameCollection());
                mTextCollectionneur.setText(defaultClassCollection.getManifold());
                mTextLocalisation.setText(defaultClassCollection.getLocalization());
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }
}
