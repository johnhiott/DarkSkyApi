package com.johnhiott.darkskyandroidlib.models;

import android.util.Log;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Request {

    private static final String UNITS_KEY = "units";
    public enum Units {
        SI("si"), US("us"), CA("ca"), UK("uk"), AUTO("auto");
        private String mValue;
        private Units(String value) {
            mValue = value;
        }
        @Override
        public String toString() {
            return mValue;
        }
    }

    private static final String LANGUAGE_KEY = "lang";
    public enum Language {
        BOSNIAN("bs"),
        GERMAN("de"),
        ENGLISH("en"),
        SPANISH("es"),
        FRENCH("fr"),
        ITALIAN("it"),
        DUTCH("nl"),
        POLISH("pl"),
        PORTUGUESE("pt"),
        RUSSIAN("ru"),
        TETUM("tet"),
        PIG_LATIN("x-pig-latin");
        private String mValue;
        private Language(String value) {
            mValue = value;
        }
        @Override
        public String toString() {
            return mValue;
        }
    }

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
    private Units mUnits;
    private Language mLanguage;
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

    public Units getUnits() {
        return mUnits;
    }

    public void setUnits(Units units) {
        mUnits = units;
    }

    public Language getLanguage() {
        return mLanguage;
    }

    public void setLanguage(Language language) {
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
        query.put(UNITS_KEY, mUnits.toString());
        query.put(LANGUAGE_KEY, mLanguage.toString());
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
