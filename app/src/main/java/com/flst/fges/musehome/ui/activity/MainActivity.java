package com.flst.fges.musehome.ui.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.flst.fges.musehome.R;
import com.flst.fges.musehome.ui.fragment.CollectionsFragment;
import com.flst.fges.musehome.ui.fragment.ContactFragment;
import com.flst.fges.musehome.ui.fragment.EvenementsFragment;
import com.flst.fges.musehome.ui.fragment.HomeFragment;
import com.flst.fges.musehome.ui.fragment.InformationsFragment;
import com.flst.fges.musehome.ui.helper.GenerateMenuHelper;
import com.flst.fges.musehome.ui.helper.NotificationHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "Home";

    @BindView(R.id.bottom_navigation)
    AHBottomNavigation mBottomNav;
    @BindView(R.id.home_textview)
    TextView mTitleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ArrayList<String> messages = new ArrayList<>();
        messages.add("L'administrateur a ajouté 5 événements durant votre absence");
        messages.add("L'administrateur a ajouté 15 objets dans la collection Materiel pédagogique");
        messages.add("L'administrateur a modifié l'evenement phare de l'application");
        NotificationHelper.addLongNotificationWithoutVibration(R.mipmap.musehome,1,"MuseH@me",
                "Bienvenue sur l'application mobile" +
                " du patrimoine de la fges",MainActivity.class,getApplicationContext(),messages);
        GenerateMenuHelper.createMenu(mBottomNav);
        mBottomNav.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                selectFragment(mBottomNav.getItem(position).getTitle(getApplicationContext()));
                return true;
            }
        });
        mBottomNav.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                selectFragment(mBottomNav.getItem(mBottomNav.getCurrentItem()).getTitle(getApplicationContext()));
            }
        });
        if (savedInstanceState != null) {
            mBottomNav.setCurrentItem(savedInstanceState.getInt(SELECTED_ITEM, 0));
        }
        selectFragment(mBottomNav.getItem(mBottomNav.getCurrentItem()).getTitle(this));
        checkNetwork();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mBottomNav.getCurrentItem());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                String name = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-2).getName();
                Fragment mCurrentFragment = getSupportFragmentManager().findFragmentByTag(name);
                getCurrentItem(mCurrentFragment);
            }
        } else {
            super.onBackPressed();
        }
    }

    private void getCurrentItem(Fragment currentFragment){
        if(currentFragment instanceof HomeFragment)
            mBottomNav.setCurrentItem(0);
        else if (currentFragment instanceof EvenementsFragment)
            mBottomNav.setCurrentItem(1);
        else if (currentFragment instanceof CollectionsFragment)
            mBottomNav.setCurrentItem(2);
        else if (currentFragment instanceof ContactFragment)
            mBottomNav.setCurrentItem(3);
        else if (currentFragment instanceof InformationsFragment)
            mBottomNav.setCurrentItem(4);
        mTitleText.setText(mBottomNav.getItem(mBottomNav.getCurrentItem()).getTitle(getApplicationContext()));
    }

    private void selectFragment(String title) {
        Fragment frag = null;
        // init corresponding fragment
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.musehome_container);
        mTitleText.setText(title);
        switch (title) {
            case "Home":
                if (currentFragment != null && currentFragment instanceof HomeFragment) {
                    // Do nothing.
                    return;
                }
                frag = HomeFragment.newInstance();
                break;
            case "Evenements":
                if (currentFragment != null && currentFragment instanceof EvenementsFragment) {
                    // Do nothing.
                    return;
                }
                frag = EvenementsFragment.newInstance();
                break;
            case "Collections":
                if (currentFragment != null && currentFragment instanceof CollectionsFragment) {
                    // Do nothing.
                    return;
                }
                frag = CollectionsFragment.newInstance();
                break;
            case "Contact":
                if (currentFragment != null && currentFragment instanceof ContactFragment) {
                    // Do nothing.
                    return;
                }
                frag = ContactFragment.newInstance();
                break;
            case "Informations":
                if (currentFragment != null && currentFragment instanceof InformationsFragment) {
                    // Do nothing.
                    return;
                }
                frag = InformationsFragment.newInstance();
                break;
        }
        updateToolbarText(title);
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        //Fragment ft2 = getSupportFragmentManager().findFragmentById(R.id.musehome_container);
        ft.replace(R.id.musehome_container, frag, frag.getClass().getSimpleName()).addToBackStack(frag.getClass().getSimpleName());
        ft.commit();
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
