package org.example.domain;

import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;


public class UserLocation {

    private static final String KEYWORD_URL = "https://dapi.kakao.com/v2/local/search/keyword";

    private static String API_KEY = KakaoApi.getApiKey();
    private static HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
    public ArrayList<ArrayList> searchUserLocationByKeyword(String keyword) {
        Gson gson = new GsonBuilder().create();
        ArrayList<ArrayList> userLocationCandidateList = new ArrayList<ArrayList>();
        try {
            String url = KEYWORD_URL + "?query=" + URLEncoder.encode(keyword);
            String userLocationString = httpUrlConnection.requestApiConnection(url);
            JSONObject userLocationJson = new JSONObject(userLocationString);
            JSONArray userLocationList = (JSONArray) userLocationJson.get("documents");

            for (Object o : userLocationList) {
                JSONObject placeCandidate = (JSONObject) o;
                ArrayList placeCandidateInfoList = new ArrayList();
                placeCandidateInfoList.add(placeCandidate.get("place_name"));
                placeCandidateInfoList.add(placeCandidate.get("x"));
                placeCandidateInfoList.add(placeCandidate.get("y"));
                userLocationCandidateList.add(placeCandidateInfoList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLocationCandidateList;

    }


}
