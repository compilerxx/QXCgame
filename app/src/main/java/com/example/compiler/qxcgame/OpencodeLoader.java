package com.example.compiler.qxcgame;

//import android.content.AsyncTaskLoader;
import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by compiler on 17-6-24.
 */

public class OpencodeLoader extends AsyncTaskLoader<List<OpenCode>>{

    /*query URL */
    private String mUrl;

    /**
     * constructs a new {@link OpencodeLoader}.
     * @param context of the activity
     * @param url to load data from
     */
    public OpencodeLoader(Context context,String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }

    /**
     * this is on a background thread.
     */
    @Override
    public List<OpenCode> loadInBackground(){
        if (mUrl == null){
            return null;
        }
        //perform the network request, parse the response, and extract a list of opencodes.
        List<OpenCode> opencodes = QueryUtils.fetchOpencodeData(mUrl);
        return opencodes;
    }

}
