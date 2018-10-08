package com.mingweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018\9\30 0030.
 */

public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public Carwash carWash;

    public Sport sport;

    public class Comfort {
        @SerializedName("txt")
        public String info;

        public class Carwash {
            @SerializedName("txt")
            public String info;
        }

        public calss Sport{
            @SerializedName("txt")
            public String info;
        }
    }
}

