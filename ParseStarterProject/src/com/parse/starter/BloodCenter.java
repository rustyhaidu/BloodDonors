package com.parse.starter;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by sebi on 8/4/15.
 */
@ParseClassName("BloodCenter")
public class BloodCenter extends ParseObject {

    public String getName() {
        return getString("Name");
    }

    public String getAddress() {
        return getString("Address");
    }


    public int getOpenAt() {
        return getNumber("OpenAt") != null ? getNumber("OpenAt").intValue() : 0;
    }


    public int getCloseAt() {
        return getNumber("CloseAt") != null ? getNumber("CloseAt").intValue() : 0;
    }

}
