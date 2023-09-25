package org.example;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Infra {
    private static final String CATEGORY_URL = "https://dapi.kakao.com/v2/local/search/category";
    private static HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
    
    public JSONArray searchInfraInformationNearByUser(HashMap userLocationMap, String code, int radius) {
        double x = Double.parseDouble((String) userLocationMap.get("x"));
        double y = Double.parseDouble((String) userLocationMap.get("y"));
        CoordinateVo coordinateVo = new CoordinateVo(x,y);
        JSONArray infraList = null;

        if (coordinateVo.isValidatedPositiveNumber(x,y)) {
            String url = CATEGORY_URL + "?x=" + x + "&y=" + y + "&category_group_code=" + code + "&radius=" + radius;
            try {
                String infraString = httpUrlConnection.requestApiConnection(url);
                JSONObject infraJson = new JSONObject(infraString);
                infraList = (JSONArray) infraJson.get("documents");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } return infraList;
    }
}
