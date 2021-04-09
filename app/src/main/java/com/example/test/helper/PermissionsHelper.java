package com.example.test.helper;

import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class PermissionsHelper {

    public static void requestPermissions(AppCompatActivity activity, Consumer<Boolean> consumer) {
        if (consumer == null) {
            consumer = new Consumer<Boolean>() {
                @Override
                public void accept(Boolean aBoolean) throws Exception {

                }
            };
        }
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_SETTINGS,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.RECORD_AUDIO
                )
                .subscribe(consumer);
    }

    public static void requestPermission(AppCompatActivity activity, String permiss, Consumer<Boolean> consumer) {
        if (consumer == null) {
            consumer = new Consumer<Boolean>() {
                @Override
                public void accept(Boolean aBoolean) throws Exception {

                }
            };
        }
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(permiss)
                .subscribe(consumer);
    }
}
