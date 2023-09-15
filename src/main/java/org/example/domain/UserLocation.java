package org.example.domain;

import com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.domain.vo.CoordinateVo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserLocation {

    private static final String KEYWORD_URL = "https://dapi.kakao.com/v2/local/search/keyword";

    // KakaoApi.getApiKey()이 static이니깐 여기서 static을 붙여줄 필요가 있는지??
    private static String API_KEY = KakaoApi.getApiKey();
    public ArrayList<ArrayList> searchUserLocationByKeyword(String keyword) {
        Gson gson = new GsonBuilder().create();
        ArrayList<ArrayList> userLocationCandidateList = new ArrayList<ArrayList>();
        try {
            String url = KEYWORD_URL + "?query=" + URLEncoder.encode(keyword);
            //httpclient
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Authorization", "KakaoAK " + KakaoApi.API_KEY);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String userLocationString = bufferedReader.readLine();
            JSONObject userLocationJson = new JSONObject(userLocationString);

            JSONArray userLocationList = (JSONArray) userLocationJson.get("documents");

            // Object타입밖에 안돼??
            for (Object o : userLocationList) {
                JSONObject placeCandidate = (JSONObject) o;
                ArrayList placeCandidateInfo = new ArrayList();
                placeCandidateInfo.add(placeCandidate.get("place_name"));
                placeCandidateInfo.add(placeCandidate.get("x"));
                placeCandidateInfo.add(placeCandidate.get("y"));
                userLocationCandidateList.add(placeCandidateInfo);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLocationCandidateList;

    }


}
