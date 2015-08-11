package com.parse.starter;

/**
 * Created by claudiu.haidu on 8/6/2015.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by claudiu.haidu on 7/28/2015.
 */
public class Tab2Fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return (LinearLayout) inflater.inflate(R.layout.tab2,container,false);
    }
}
