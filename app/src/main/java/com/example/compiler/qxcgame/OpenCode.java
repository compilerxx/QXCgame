package com.example.compiler.qxcgame;

/**
 * Created by compiler on 17-6-20.
 */
/**
 * An {@link OpenCode} object contains information related to a single date opencode.
 */

public class OpenCode {
    /* opencode of the date */
    private String mOpenCode;

    /* open date */
    private String mOpenDate;

    private String mWeekDay;

    /**
     * Constructs a new {@link OpenCode} object.
     *
     * @param opencode is the code open for that date
     * @param opendate is the code open date
     * @param weekday is the code open weekday
     */
    public OpenCode(String opencode,String opendate,String weekday){
        mOpenCode = opencode;
        mOpenDate = opendate;
        mWeekDay = weekday;
    }

    public String getOpenCode(){
        return mOpenCode;
    }

    public String getOpenDate(){
        return mOpenDate;
    }

    public String getWeekDay(){
        return mWeekDay;
    }
}
