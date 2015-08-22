package com.parse.starter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Claudiu on 8/22/2015.
 */
 class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_center, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView tvBody = (TextView) view.findViewById(R.id.tvCity);
        TextView tvPriority = (TextView) view.findViewById(R.id.tvAddress);
        // Extract properties from cursor
        String city = cursor.getString(cursor.getColumnIndexOrThrow("City"));
        int address = cursor.getInt(cursor.getColumnIndexOrThrow("Address"));
        // Populate fields with extracted properties
        tvBody.setText(city);
        tvPriority.setText(String.valueOf(address));
    }
}