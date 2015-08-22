package com.parse.starter;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by claudiu.haidu on 7/28/2015.
 */
public class Tab1Fragment extends Fragment implements View.OnClickListener  {
 String AllAddresses;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        //return (LinearLayout) inflater.inflate(R.layout.tab1,container,false);

        View view =  inflater.inflate(R.layout.tab1,container,false);
        Button mapsButton = (Button) view.findViewById(R.id.mapButton);
        mapsButton.setOnClickListener(this);
        loadCenters();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mapButton:
               final Intent intent;
                //context.getClass();
                 intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);

                Toast.makeText(getActivity(), "Showing Map", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void getCenters(String Addresses){
        AllAddresses = Addresses;
        TextView centers = (TextView)getActivity().findViewById(R.id.textview1);
        centers.setText(AllAddresses);
    }

    private void loadCenters() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("BloodCenter");
        query.whereExists("Location");

        query.findInBackground(new FindCallback<ParseObject>() {
            //String Addresses = "";
            String Point="";
            ParseGeoPoint userLocation;
            @Override
            public void done(List<ParseObject> list, com.parse.ParseException e) {


                if (e == null) {
                    Log.d("score", "Retrieved ");

                    for (int i = 0; i < list.size(); i++) {
                        ParseObject p = list.get(i);

                        userLocation = list.get(i).getParseGeoPoint("Location");

                       double geo1Int =userLocation.getLatitude();
                        double geo2Int = userLocation.getLongitude();

                        Point =Point+ String.valueOf(geo1Int)+" "+String.valueOf(geo2Int)+";";
                       // Addresses = Addresses + p.getString("Location")+";";

                    }
                    getCenters(Point);
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
         });

        }
    }


