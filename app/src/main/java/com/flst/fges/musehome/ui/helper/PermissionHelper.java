package com.flst.fges.musehome.ui.helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by LAMOOT Alexandre on 24/03/2017.
 */

public class PermissionHelper {

    private static final int STORAGE_REQUEST_CODE = 100;
    private static final String TAG = "ERROR";

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults,Class aClass) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, aClass);
    }
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d(TAG, "Permission has been granted");
    }
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d(TAG, "Permission has been denied");
    }
    public void onActivityResult(int requestCode, int resultCode,Context context) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            if(EasyPermissions.hasPermissions(context, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Log.d(TAG, "granted");
            }/*else{
                EasyPermissions.requestPermissions(context, string.storage, STORAGE_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
            }*/
        }
    }
}
