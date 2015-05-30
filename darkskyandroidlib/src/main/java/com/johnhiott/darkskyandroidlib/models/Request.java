package com.johnhiott.darkskyandroidlib.models;

import android.util.Log;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {

    private static final String UNITS_KEY = "units";
    public static final String UNITS_SI = "si";
    public static final String UNITS_US = "us";
    public static final String UNITS_CA = "ca";
    public static final String UNITS_UK = "uk";
    public static final String UNITS_AUTO = "auto";

    private static final String LANGUAGE_KEY = "lang";
    public static final String LANGUAGE_BOSNIAN = "bs";
    public static final String LANGUAGE_GERMAN = "de";
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANG_SPANISH = "es";
    public static final String LANG_FRENCH = "fr";
    public static final String LANG_ITALIAN = "it";
    public static final String LANG_DUTCH = "nl";
    public static final String LANG_POLISH = "pl";
    public static final String LANG_PORTUGUESE = "pt";
    public static final String LANG_RUSSIAN = "ru";
    public static final String LANG_TETUM = "tet";
    public static final String LANG_PIG_LATIN = "x-pig-latin";

    private static final String EXCLUDE_KEY = "exclude";
    /** Exclude the currently block */
    public static final String EXCLUDE_CURRENTLY = "currently";
    /** Exclude the minutely block */
    public static final String EXCLUDE_MINUTELY = "minutely";
    public static final String EXCLUDE_HOURLY = "hourly";
    public static final String EXCLUDE_DAILY = "daily";
    public static final String EXCLUDE_ALERTS = "alerts";
    public static final String EXCLUDE_FLAGS = "flags";

    private String mLat;
    private String mLng;
    private String mTime;
    private String mUnits;
    private String mLanguage;
    private List<String> mExcludeBlock = new ArrayList<String>();

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLng() {
        return mLng;
    }

    public void setLng(String lng) {
        mLng = lng;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    private Boolean useTime() {
        return mTime != null && !mTime.equals("");
    }

    public String getUnits() {
        return mUnits;
    }

    public void setUnits(String units) {
        mUnits = units;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public void addToExcludeBlock(String exclude) {
        mExcludeBlock.add(exclude);
    }

    public void removeFromExcludeBlock(String exclude) {
        int index = mExcludeBlock.indexOf(exclude);
        if (index != -1) mExcludeBlock.remove(index);
    }

    public Map<String, String> getQueryParams() {
        Map<String, String> query = new HashMap<String, String>();
        query.put(UNITS_KEY, mUnits);
        query.put(LANGUAGE_KEY, mLanguage);
        query.put(EXCLUDE_KEY, getExcludeBlock());
        return query;
    }

    private String getExcludeBlock() {
        return mExcludeBlock.size() > 0 ? Joiner.on(",").join(mExcludeBlock) : null;
    }

    @Override
    public String toString() {
        String params = mLat + "," + mLng;
        return  useTime() ?  params + "," + mTime : params;
    }

}
