package com.flst.fges.musehome.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.ui.fragment.ObjetsCollectionFragment;

public class CollectionActivity extends AppCompatActivity {

    private String mCollection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setLogo(R.mipmap.musehome);
        actionBar.setDisplayUseLogoEnabled(true);
        mCollection = getIntent().getStringExtra("COLLECTION");
        TextView collectionTitle = (TextView) findViewById(R.id.collections_title_textview);
        collectionTitle.setText(mCollection);
        selectFragment(mCollection);
    }

    private void selectFragment(String collection) {
        Fragment frag = null;
        frag = ObjetsCollectionFragment.newInstance(collection);
        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.musehome_collection_container, frag, frag.getTag());
            ft.commit();
        }
    }
}
