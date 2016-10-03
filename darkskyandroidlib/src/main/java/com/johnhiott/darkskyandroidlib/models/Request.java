package com.johnhiott.darkskyandroidlib.models;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {

    private static final String UNITS_KEY = "units";
    public enum Units {
        SI("si"),
        US("us"),
        CA("ca"),
        UK("uk"),
        AUTO("auto");
        private String mValue;
        Units(String value) {
            mValue = value;
        }
        @Override
        public String toString() {
            return mValue;
        }
    }

    private static final String LANGUAGE_KEY = "lang";
    public enum Language {
        ARABIC("ar"),
        BOSNIAN("bs"),
        CORNISH("kw"),
        CZECH("cs"),
        GERMAN("de"),
        GREEK("el"),
        HUNGARIAN("hu"),
        ICELANDIC("is"),
        NORWEGIAN("nb"),
        ENGLISH("en"),
        SPANISH("es"),
        FRENCH("fr"),
        CROATIAN("hr"),
        ITALIAN("it"),
        DUTCH("nl"),
        POLISH("pl"),
        PORTUGUESE("pt"),
        RUSSIAN("ru"),
        SERBIAN("sr"),
        SLOVAK("sk"),
        SWEDISH("sv"),
        TETUM("tet"),
        TURKISH("tr"),
        UKRAINIAN("uk"),
        PIG_LATIN("x-pig-latin"),
        CHINESE("zh"),
        CHINESE_TRADITIONAL("zh-tw");
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
    private static final String EXTEND_KEY = "extend";

    public enum Block {
        CURRENTLY("currently"),
        MINUTELY("minutely"),
        HOURLY("hourly"),
        DAILY("daily"),
        ALERTS("alerts"),
        FLAGS("flags");
        String mValue;
        private Block (String value) {
            mValue = value;
        }
        @Override
        public String toString() {
            return mValue;
        }
    }

    private String mLat;
    private String mLng;
    private String mTime;
    private Units mUnits;
    private Language mLanguage;
    private List<Block> mExcludeBlocks = new ArrayList<>();
    private List<Block> mExtendBlocks = new ArrayList<>();

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

    public void addExcludeBlock(Block exclude) {
        mExcludeBlocks.add(exclude);
    }

    public void addExtendBlock(Block extend) {
        mExtendBlocks.add(extend);
    }

    public void removeExcludeBlock(Block exclude) {
        int index = mExcludeBlocks.indexOf(exclude);
        if (index != -1) mExcludeBlocks.remove(index);
    }

    public Map<String, String> getQueryParams() {
        Map<String, String> query = new HashMap<>();
        query.put(UNITS_KEY, mUnits.toString());
        query.put(LANGUAGE_KEY, mLanguage.toString());
        query.put(EXCLUDE_KEY, getExcludeBlock());
        query.put(EXTEND_KEY, getExtendBlocks());
        return query;
    }

    private String getExcludeBlock() {
        return mExcludeBlocks.size() > 0 ? TextUtils.join(",", mExcludeBlocks) : null;
    }

    private String getExtendBlocks() {
        return mExtendBlocks.size() > 0 ? TextUtils.join(",", mExtendBlocks) : null;
    }

    @Override
    public String toString() {
        String params = mLat + "," + mLng;
        return  useTime() ?  params + "," + mTime : params;
    }
}
