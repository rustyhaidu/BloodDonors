package com.parse.starter;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

/**
 * Created by sebi on 8/4/15.
 */
@ParseClassName("Donor")
public class BloodDonor extends ParseObject{
    public String getName() {
        return getString("Name");
    }

    public void setName(String name) {
        put("Name", name);
    }


    public String getCity() {
        return getString("City");
    }

    public void setCity(String name) {
        put("City", name);
    }


    public void setRH(String name) {
        put("RH", name);
    }

    public String getRH() {
        return getString("RH");
    }


    public void setBloodGroup(String name) {
        put("BloodGroup", name);
    }

    public String getBloodGroup() {
        return getString("BloodGroup");
    }


    public void setLocation(ParseGeoPoint location) {
        put("Location", location);
    }
}
