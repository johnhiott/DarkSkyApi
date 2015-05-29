package com.johnhiott.darkskyandroidlib.models;

/*
summary: A human-readable text summary of this data block.
        icon: A machine-readable text summary of this data block (see data point, above, for an enumeration of possible values that this property may take on).
        data: An array of data point objects (see above), ordered by time, which together describe the weather conditions at the requested l
*/

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataBlock {

    private String summary;
    private String icon;
    @SerializedName("data") private List<DataPoint> data;

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public List<DataPoint> getData() {
        return data;
    }
}
