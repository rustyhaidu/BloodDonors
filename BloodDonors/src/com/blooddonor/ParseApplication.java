package com.blooddonor;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

// TODO - CODE REVIEW - andrei | 9/10/15 - The name should probably be BloodDonorApplication -> since this the app object for YOUR app, not the parse example.
public class ParseApplication extends Application {


  @Override
  public void onCreate() {
    super.onCreate();


    ParseObject.registerSubclass(BloodDonor.class);
    ParseObject.registerSubclass(BloodCenter.class);

    // Add your initialization code here
    Parse.initialize(this);

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
