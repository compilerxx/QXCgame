package com.example.compiler.qxcgame;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by compiler on 17-6-22.
 */

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils(){

    }

    public static List<OpenCode> fetchOpencodeData(String requestUrl){
        //create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);

        }catch (IOException e){
            Log.e(LOG_TAG,"Problem making the HTTP request.",e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link OpenCode}s
        List<OpenCode> opencodes = extractOpenCodeFromJson(jsonResponse);
        return opencodes;
    }

    /*
     *return new URL object from the given string URL
     */
    private static URL createUrl(String stringUrl){
        URL url = null;
        try{
            url = new URL(stringUrl);
        }catch (MalformedURLException e){
            Log.e(LOG_TAG,"Problem building the URL",e);
        }
        return url;
    }

    /*
     * make and http request to the given URL and return a String as response.
     */
    private static String makeHttpRequest(URL url)throws IOException{
        String jsonResponse = "";

        if(url == null){
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000); /*milliseconds*/
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if(urlConnection.getResponseCode()==200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }else {
                Log.e(LOG_TAG,"Error response code: " + urlConnection.getResponseCode());
            }
        }catch (IOException e){
            Log.e(LOG_TAG,"Problem retrieving the opencode JSON results",e);
        }finally {
            if (urlConnection!= null){
                urlConnection.disconnect();
            }
            if (inputStream != null){
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */

    private static String readFromStream(InputStream inputStream) throws IOException{
        StringBuilder output = new StringBuilder();
        if (inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return a list of {@link OpenCode} objects that has been built up from
     * parsing the given JSON response.
     */

    private static List<OpenCode> extractOpenCodeFromJson(String opencodeJSON){
        if (TextUtils.isEmpty(opencodeJSON)){
            return null;
        }

        //create an empty ArrayList that we can start adding opencode to
        List<OpenCode> opencodes = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            //create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(opencodeJSON);
            JSONArray opencodeArray = baseJsonResponse.getJSONArray("data");

            for (int i = 0;i<opencodeArray.length();i++){
                JSONObject currentOpencodeJson = opencodeArray.getJSONObject(i);
                String currentOpencode = currentOpencodeJson.getString("opencode");
                String currentOpendate = currentOpencodeJson.getString("opentime");
                String currentOpenWeekday = getWeek(currentOpendate);

                OpenCode opencode = new OpenCode(currentOpencode,currentOpendate,currentOpenWeekday);

                // Add the new {@link OpenCode} to the list of opencodes.
                opencodes.add(opencode);

            }


        }catch (JSONException e){
            Log.e("QueryUtils", "Problem parsing the opencode JSON results", e);
        }

        return opencodes;
    }



    public  static String getWeek(String sdate) {
        //(Sun, Mon, Tue, Wed, Thu, Fri, Sat).

        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(sdate);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return date.toString().substring(0,3);


    }







}
