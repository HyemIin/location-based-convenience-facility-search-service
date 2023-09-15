package org.example.domain;

import com.google.gson.Gson;
import org.example.domain.vo.CoordinateVo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Infra {
    private static final String CATEGORY_URL = "https://dapi.kakao.com/v2/local/search/category";
    private static HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
    private static Gson gson = new Gson();
    
    public JSONArray searchInfraInformationNearByUser(List userLocationList, String code, int radius) {
        String x = (String) userLocationList.get(1);
        String y = (String) userLocationList.get(2);
        CoordinateVo coordinateVo = new CoordinateVo();
        JSONArray infraList = null;

        if (coordinateVo.isValidated(x,y)) {
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
