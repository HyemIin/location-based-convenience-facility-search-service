package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;

public class KakaoApi {
    public static String API_KEY = new KakaoApi().getApiKey();

    public String getApiKey() {
        Gson gson = new Gson();
        String filePath = "/Users/jeonghyemin/Desktop/야놀자_부트캠프/과제/location-based-convenience-facility-search-service/src/main/resources/KakaoApiConnectInfo.json";
        try {
            JsonObject jsonObject = gson.fromJson(new FileReader(filePath), JsonObject.class);
            String kakaoApiKey = jsonObject.get("API_KEY").getAsString();
            return kakaoApiKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
