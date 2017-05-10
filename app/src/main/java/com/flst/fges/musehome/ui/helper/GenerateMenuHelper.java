package com.flst.fges.musehome.ui.helper;

import android.graphics.Color;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.flst.fges.musehome.R;

/**
 * Created by LAMOOT Alexandre on 01/04/2017.
 */

public class GenerateMenuHelper {

    public static void createMenu(AHBottomNavigation menu){
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.home, R.drawable.ic_home_black_24dp, R.color.background);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.evenements, R.drawable.ic_insert_invitation_black_24dp, R.color.background);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.collections, R.drawable.ic_collections_bookmark_black_24dp, R.color.background);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.contact, R.drawable.ic_mode_edit_black_24dp, R.color.background);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(R.string.informations, R.drawable.ic_info_black_24dp, R.color.background);
        menu.addItem(item1);
        menu.addItem(item2);
        menu.addItem(item3);
        menu.addItem(item4);
        menu.addItem(item5);
        menu.setDefaultBackgroundColor(Color.parseColor("#000000"));
        menu.setBehaviorTranslationEnabled(true);
        //menu.setForceTint(true);
        menu.setTranslucentNavigationEnabled(true);
        menu.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        // Use colored navigation with circle reveal effect
        menu.setColored(true);
        // Set current item programmatically
        menu.setCurrentItem(0);
    }
}
