package com.flst.fges.musehome.ui.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.flst.fges.musehome.R;

/**
 * Created by LAMOOT Alexandre on 09/05/2017.
 */

public class NetworkHelper {

    public static boolean checkNetwork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            boolean wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
            boolean mobileConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if(wifiConnected)
                Toast.makeText(context, R.string.wifi_connection,Toast.LENGTH_SHORT).show();
            else if (mobileConnected)
                Toast.makeText(context,R.string.mobile_connection,Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(context, R.string.no_wifi_or_mobile, Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
