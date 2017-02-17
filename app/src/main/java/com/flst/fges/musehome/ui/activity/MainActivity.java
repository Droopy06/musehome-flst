package com.flst.fges.musehome.ui.activity;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.ui.fragment.CollectionsFragment;
import com.flst.fges.musehome.ui.fragment.ContactFragment;
import com.flst.fges.musehome.ui.fragment.EvenementsFragment;
import com.flst.fges.musehome.ui.fragment.HomeFragment;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "Home";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    private TextView mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleText = (TextView) findViewById(R.id.home_textview);
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        // init corresponding fragment
        switch (item.getItemId()) {
            case R.id.home_button:
                mTitleText.setText("Page d'accueil");
                frag = HomeFragment.newInstance();
                break;
            case R.id.evenement_button:
                mTitleText.setText("Liste des événements");
                frag = EvenementsFragment.newInstance();
                break;
            case R.id.collections_button:
                mTitleText.setText("Liste des collections");
                frag = CollectionsFragment.newInstance();
                break;
            case R.id.contact_button:
                mTitleText.setText("Formulaire de contact");
                frag = ContactFragment.newInstance();
                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();

        // uncheck the other items.
        for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }

        updateToolbarText(item.getTitle());

        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.musehome_container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }
}
