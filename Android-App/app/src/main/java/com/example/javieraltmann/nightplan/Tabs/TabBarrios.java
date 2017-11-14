package com.example.javieraltmann.nightplan.Tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javieraltmann.nightplan.R;

/**
 * Created by javier.altmann on 12/11/2017.
 */

public class TabBarrios extends android.support.v4.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab_barrio,container,false);

        return rootView;
    }

}
