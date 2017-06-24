package com.example.compiler.qxcgame.FragmentV4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.compiler.qxcgame.OpenCode;
import com.example.compiler.qxcgame.OpencodeAdapter;
import com.example.compiler.qxcgame.OpencodeLoader;
import com.example.compiler.qxcgame.R;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class AnalyticFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<List<OpenCode>>{

    //http://f.apiplus.net/qxc-20.json
    public static final String OPENCODE_REQUEST_URL =
            "http://f.apiplus.net/qxc-10.json";
    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    public static final int OPENCODE_LOADER_ID = 1;

    //adapter for the list of opencodes
    private OpencodeAdapter mAdapter;

    //TextView that is displayed when the list is empty
    private TextView mEmptyStateTextView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_analytic,container,false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //find a reference to the {@link ListView} in the layout
        ListView opencodeListView = (ListView) getActivity().findViewById(R.id.list);

        mEmptyStateTextView = (TextView) getActivity().findViewById(R.id.empty_view);
        opencodeListView.setEmptyView(mEmptyStateTextView);

        //create a new adapter that takes an empty list of opencodes a input
        //mAdapter = new OpencodeAdapter(this,new ArrayList<OpenCode>());
        mAdapter = new OpencodeAdapter(getActivity(),new ArrayList<OpenCode>());

        opencodeListView.setAdapter(mAdapter);

        //get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        //get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        //if there is a network connection, fetch data
        if (networkInfo!=null && networkInfo.isConnected()){
            //get a reference to LoaderManage, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            //loaderManager.initLoader(OPENCODE_LOADER_ID,null,getActivity());
            loaderManager.initLoader(OPENCODE_LOADER_ID,null,this);
        }else {
            //otherwise, display error
            //first hide loading indicator so error message will be visible
            View loadingIndicator = getActivity().findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            //update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);

        }

    }

    @Override
    public Loader<List<OpenCode>> onCreateLoader(int i,Bundle bundle){

        Uri baseUri = Uri.parse(OPENCODE_REQUEST_URL);
        Uri.Builder uriBuiler = baseUri.buildUpon();

        //return new OpencodeLoader(this,uriBuiler.toString());
        return new OpencodeLoader(getActivity(), baseUri.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<OpenCode>> loader, List<OpenCode> opencodes){
        //hide loading indicator because the data has been loaded
        View loadingIndicator = getActivity().findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        //set empty state text to display "No opencodes found"
        mEmptyStateTextView.setText(R.string.no_opencodes);

        //clear the adapter of previous opencode data
        mAdapter.clear();

        //if there is a valid list of {@link OpenCode}s, then add them to the adapter's
        //data set. This will trigger the ListView to update.
        if (opencodes !=null && !opencodes.isEmpty()){
            mAdapter.addAll(opencodes);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<OpenCode>> loader){
        //Loader reset, so we can clear out the existing data.
        mAdapter.clear();
    }








}
