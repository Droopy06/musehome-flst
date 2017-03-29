package com.flst.fges.musehome.ui.activity;

import android.app.FragmentManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import com.flst.fges.musehome.R;
import com.flst.fges.musehome.ui.fragment.CollectionsFragment;
import com.flst.fges.musehome.ui.fragment.ContactFragment;
import com.flst.fges.musehome.ui.fragment.EvenementsFragment;
import com.flst.fges.musehome.ui.fragment.HomeFragment;
import com.flst.fges.musehome.ui.fragment.InformationsFragment;
import com.flst.fges.musehome.ui.helper.NotificationHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "Home";

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNav;
    private int mSelectedItem;
    @BindView(R.id.home_textview)
    TextView mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        //mTitleText = (TextView) findViewById(R.id.home_textview);
        //mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
        ArrayList<String> messages = new ArrayList<>();
        messages.add("L'administrateur a ajouté 5 événements durant votre absence");
        messages.add("L'administrateur a ajouté 15 objets dans la collection Materiel pédagogique");
        messages.add("L'administrateur a modifié l'evenement phare de l'application");
        NotificationHelper.addLongNotificationWithoutVibration(R.mipmap.musehome,1,"MuseH@me",
                "Bienvenue sur l'application mobile" +
                " du patrimoine de la fges",MainActivity.class,getApplicationContext(),messages);
        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
        checkNetwork();
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
                mTitleText.setText("Accueil");
                frag = HomeFragment.newInstance();
                break;
            case R.id.evenement_button:
                mTitleText.setText("Evénements");
                frag = EvenementsFragment.newInstance();
                break;
            case R.id.collections_button:
                mTitleText.setText("Collections");
                frag = CollectionsFragment.newInstance();
                break;
            case R.id.contact_button:
                mTitleText.setText("Formulaire de contact");
                frag = ContactFragment.newInstance();
                break;
            case R.id.information_button:
                mTitleText.setText("Informations");
                frag = InformationsFragment.newInstance();
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
        FragmentManager fragmentManager = getFragmentManager();
        boolean fragmentPopped = fragmentManager
                .popBackStackImmediate(frag.getClass().getSimpleName() , 0);
        if (!fragmentPopped && fragmentManager.findFragmentByTag(frag.getClass().getSimpleName()) == null) {
            FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
            ft.addToBackStack(frag.getClass().getSimpleName());
            //Fragment ft2 = getSupportFragmentManager().findFragmentById(R.id.musehome_container);
            ft.replace(R.id.musehome_container, frag, frag.getTag());
            ft.commit();
        }
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.drawable.banniere);
            //actionBar.setLogo(R.mipmap.musehome);
            actionBar.setDisplayUseLogoEnabled(true);
        }
    }

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }

    private void checkNetwork(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            boolean wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            boolean mobileConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if(wifiConnected)
                Toast.makeText(this, R.string.wifi_connection,Toast.LENGTH_SHORT).show();
            else if (mobileConnected)
                Toast.makeText(this,R.string.mobile_connection,Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this,R.string.no_wifi_or_mobile,Toast.LENGTH_SHORT).show();
    }
}
