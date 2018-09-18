package com.mingweather.android.util;

import org.json.JSONException;

/**
 * Created by Administrator on 2018/9/18.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JASONArray allProvinces=new JASONArray(response);
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JASONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceID){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length;i++);
                JSONObject cityObject=allCities.getJSONObject(i);
                City city=new City;
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceID);
                city.save();
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    return false;
}
/**
 * 解析和处理服务器返回的县级数据
 */
public static boolean handleCountryResponse(String response,int cityId){
    if(!TextUtils.isEmpty(response)){
        try{
            JSONArray allCountries=new JSONArray(response);
            for (int i=0;i<allCountries.length();i++){
                JSONObject countryObject=allCountries.getJSONObject(i);
                Country country=new Country();
                country.setCountryName(countryObject.getString("name"));
                country.setWeatherId(countryObject.getString("weather_id"));
                country.setCityID(cityId);
                country.save();
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    return false;
}
}
