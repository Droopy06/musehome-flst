package com.flst.fges.musehome.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.ICallback;
import com.flst.fges.musehome.data.manager.EvenementsManager;
import com.flst.fges.musehome.data.model.Evenement;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EvenementDetailActivity extends AppCompatActivity {

    @BindView(R.id.object_evenement_imageview)
    ImageView evenementImageView;
    @BindView(R.id.text_nom_commum_textview)
    TextView titreTextView;
    @BindView(R.id.text_mini_description_textview)
    TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement_detail);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.banniere);
        actionBar.setDisplayUseLogoEnabled(true);
        ButterKnife.bind(this);
        EvenementsManager evenementsManager = new EvenementsManager();
        evenementsManager.getEvenementByTitle(getIntent().getStringExtra("EVENEMENT"), new ICallback<Evenement>() {
            @Override
            public void success(Evenement evenement) {
                titreTextView.setText(evenement.getTitre());
                descriptionTextView.setText(evenement.getMiniDescr());
                Picasso.with(getApplicationContext()).load(evenement.getImageuri()).into(evenementImageView);
            }

            @Override
            public void failure(Throwable error) {
                Log.w("ERROR",error);
            }
        });
    }
}
