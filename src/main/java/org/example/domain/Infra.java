package org.example.domain;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.view.UserLocationInputView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Infra {
    private static final String CATEGORY_URL = "https://dapi.kakao.com/v2/local/search/category";
    public JSONArray searchInfra(List userLocationList, String code, int radius) {
        String x = (String) userLocationList.get(1);
        String y = (String) userLocationList.get(2);
        String url = CATEGORY_URL + "?x=" + x + "&y=" + y + "&category_group_code=" + code + "&radius=" + radius;
        JSONArray infraList = null;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Authorization", "KakaoAK " + KakaoApi.API_KEY);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String infraString = bufferedReader.readLine();
            JSONObject infraJson = new JSONObject(infraString);

            infraList = (JSONArray) infraJson.get("documents");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return infraList;
    }
}
