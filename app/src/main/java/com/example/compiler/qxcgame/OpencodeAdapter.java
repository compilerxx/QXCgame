package com.example.compiler.qxcgame;

/**
 * Created by compiler on 17-6-20.
 */

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link OpencodeAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link OpenCode} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */

public class OpencodeAdapter extends ArrayAdapter<OpenCode>{

    /**
     * Constructs a new {@link OpencodeAdapter}.
     *
     * @param context of the app
     * @param opencode is the list of opencode, which is the data source of the adapter
     */
    public OpencodeAdapter(Context context, List<OpenCode> opencode){
        super(context,0,opencode);
    }


    /**
     * Returns a list item view that displays information about the opencode at the given position
     * in the list of opencodes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.opencode_list_item,parent,false);
        }


        //find the opencode at the given position in the list of opencodes
        OpenCode currentOpencode = getItem(position);

        TextView opencodeView =(TextView) listItemView.findViewById(R.id.textv_opencode);
        String opencodeText = currentOpencode.getOpenCode();
        opencodeView.setText(opencodeText);

        TextView opendateView = (TextView) listItemView.findViewById(R.id.textv_opendate);
        String opendateText = currentOpencode.getOpenDate();
        opendateView.setText(opendateText);

        TextView openweekdayView = (TextView) listItemView.findViewById(R.id.textv_openweekday);
        String openweekdayText = currentOpencode.getWeekDay();

        openweekdayView.setText(openweekdayText);

        return listItemView;
    }










}
