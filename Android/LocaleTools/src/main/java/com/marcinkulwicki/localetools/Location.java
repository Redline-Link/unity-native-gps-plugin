package com.marcinkulwicki.localetools;

import android.content.Context;
import android.location.LocationManager;
import android.location.LocationListener;

public class Location implements LocationListener
{
    public static android.location.Location LastLocation;

    private LocationManager locationManager;

    public void init(Context context)
    {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, this);
        locationManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000, 0, this);
    }

    @Override
    public void onLocationChanged(android.location.Location location)
    {
        LastLocation = location;
    }

    // FIXME hasn't test the new one with different params
//    @Override
//    public void onLocationChanged(List<android.location.Location> locations) {
//        //LocationListener.super.onLocationChanged(locations);
//        if (locations.size() > 1) {
//            Log.d("NativeGPS", "location count: " + locations.size());
//            LastLocation = locations.get(locations.size()-1);
//        }
//    }

    // need to implement those callback or it'll just crash on API level 29 phone
    @Override
    public void onFlushComplete(int requestCode) {
        //LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onProviderEnabled(String provider) {
        //LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        //LocationListener.super.onProviderDisabled(provider);
    }
}
