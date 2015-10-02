package com.example.student.droidlab;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.student.droidlab.R.id.MapFragment;
import static com.example.student.droidlab.R.id.mapFragment;

public class MainActivity extends Activity {

    private GoogleMap googleMap;
    //create longitide and latitude
    private MarkerOptions markerOptions;//to put a marker on the map

    double latitude;
    double longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();

        markerOptions = new MarkerOptions().
                position(new LatLng(latitude, longitude))
                .title("Nairobi");

        //setting the icon of the marker
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cast_dark));

        CameraPosition cameraPosition =new CameraPosition.Builder().
                target(new LatLng(17.385044, 78.486671)).zoom(12).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


//setting of current location

        googleMap.setMyLocationEnabled(true);

   //zooming button and functionality

        googleMap.getUiSettings().setZoomControlsEnabled(false); // true to enable

        googleMap.getUiSettings().setZoomGesturesEnabled(false);

        //setting up a compass on the map

        googleMap.getUiSettings().setCompassEnabled(true);

        //setting up current location button


        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

//settings to enable map rotation
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
    }



        public void onclick(View v) {
              switch (v.getId()){
                case R.id.normal:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case R.id.satellite:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;
                case R.id.terrain:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    break;
                case R.id.hybrid:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;
            }
        }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
