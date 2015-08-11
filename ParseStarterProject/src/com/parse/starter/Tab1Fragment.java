package com.parse.starter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by claudiu.haidu on 7/28/2015.
 */
public class Tab1Fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return (LinearLayout) inflater.inflate(R.layout.tab1,container,false);
    }
}
