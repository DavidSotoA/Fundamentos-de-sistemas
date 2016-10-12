package com.example.skorpionx.aerolineaudea_movil.com.udea.aerolineaUdeA.Servicios;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.skorpionx.aerolineaudea_movil.AerolineaUdeA;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

public class ServiociosAerolinea {
    private static final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(AerolineaUdeA.getAppContext());
    private static final String AUTENCICACION_END_POINT="http://192.168.0.19:41392/AerolineaUdeA/servicios";
    private static SesionSocio socioInstance;

    public static SesionSocio getAutenticacionService() {
        String url=sharedPreferences.getString("url","");
        System.out.println(url);
        if (socioInstance == null) {
            RequestInterceptor requestInterceptor = new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    //Log.e("intercept request", AccountUtils.getToken(UdeApps.getContext()));
                    //request.addHeader("token", AccountUtils.getToken(UdeApps.getContext()));
                }
            };
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(AUTENCICACION_END_POINT)
                    .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("REQUEST"))
                    .setRequestInterceptor(requestInterceptor)
                    .build();
            System.out.println(restAdapter.toString());
            socioInstance = restAdapter.create(SesionSocio.class);
        }
        return socioInstance;
    }
}