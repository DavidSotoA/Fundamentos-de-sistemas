package com.example.skorpionx.aerolineaudea_movil;

import android.app.Application;
import android.content.Context;

public class AerolineaUdeA extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        AerolineaUdeA.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return AerolineaUdeA.context;
    }
}
