package com.parse.starter;


import android.app.Fragment;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by claudiu.haidu on 7/28/2015.
 */
public class Tab4Fragment extends Fragment implements View.OnClickListener{
    private static final String TAG= "RegisterDonor";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       View view =  inflater.inflate(R.layout.tab4,container,false);
        Button saveButton = (Button) view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    public void onSave() {

        BloodDonor bloodDonor = new BloodDonor();
        bloodDonor.setName(((EditText) getView().findViewById(R.id.name)).getText().toString());
        bloodDonor.setCity(((EditText) getView().findViewById(R.id.city)).getText().toString());
        bloodDonor.setBloodGroup(((EditText) getView().findViewById(R.id.blood_group)).getText().toString());
        bloodDonor.setRH(((EditText) getView().findViewById(R.id.blood_rh)).getText().toString());

        try {
            Geocoder geocoder = new Geocoder(getActivity());
            List<Address> address = geocoder.getFromLocationName(bloodDonor.getName(), 1);
            if (address != null) {
                bloodDonor.setLocation(new ParseGeoPoint(address.get(0).getLatitude(), address.get(0).getLongitude()));
            }
        }catch (Exception ex){
            Log.d(TAG, "Error getting lcoation", ex);
        }

        bloodDonor.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getActivity(), "Saved with success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Saved with error:" + e.getMessage(), Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saveButton:
                onSave();
                Toast.makeText(getActivity(), "Pressed", Toast.LENGTH_LONG).show();
                break;
        }
    }

}