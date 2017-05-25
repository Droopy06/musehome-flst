package com.flst.fges.musehome.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.flst.fges.musehome.R;
import com.flst.fges.musehome.data.helper.SynchronizeApiToDatabase;
import com.flst.fges.musehome.data.helper.SynchronizeApiToDatabaseImpl;
import com.flst.fges.musehome.ui.fragment.CollectionsFragment;
import com.flst.fges.musehome.ui.fragment.ContactFragment;
import com.flst.fges.musehome.ui.fragment.EvenementsFragment;
import com.flst.fges.musehome.ui.fragment.HomeFragment;
import com.flst.fges.musehome.ui.fragment.InformationsFragment;
import com.flst.fges.musehome.ui.helper.GenerateMenuHelper;
import com.flst.fges.musehome.ui.helper.NetworkHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final String SELECTED_ITEM = "Home";

    @BindView(R.id.bottom_navigation)
    AHBottomNavigation mBottomNav;
    @BindView(R.id.home_textview)
    TextView mTitleText;
    private static final int MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        GenerateMenuHelper.createMenu(mBottomNav);
        mBottomNav.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                selectFragment(mBottomNav.getItem(position).getTitle(getApplicationContext()));
                mBottomNav.setNotification("", position);
                return true;
            }
        });
        mBottomNav.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                selectFragment(mBottomNav.getItem(mBottomNav.getCurrentItem()).getTitle(getApplicationContext()));
                mBottomNav.setNotification("", mBottomNav.getCurrentItem());
            }
        });
        if (savedInstanceState != null) {
            mBottomNav.setCurrentItem(savedInstanceState.getInt(SELECTED_ITEM, 0));
        }
        selectFragment(mBottomNav.getItem(mBottomNav.getCurrentItem()).getTitle(this));
        NetworkHelper.checkNetwork(this);
        if(EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            Log.w("test","ok");
        }else{
            EasyPermissions.requestPermissions(this, getString(R.string.permissions), MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
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
        mBottomNav.restoreBottomNavigation();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            if(EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Log.w("test","ok");
            }else{
                EasyPermissions.requestPermissions(this, getString(R.string.rationale_ask_again), MY_PERMISSIONS_WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        SynchronizeApiToDatabase synchronizeApiToDatabase = (SynchronizeApiToDatabase) new SynchronizeApiToDatabaseImpl(R.mipmap.musehome,1,"MuseH@me",
                "Bienvenue sur l'application mobile du patrimoine de la fges",MainActivity.class,
                getApplicationContext(),mBottomNav,10245252).execute(true,true,true);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
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
}
