package org.example;

import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;


public class UserLocation {

    private static final String KEYWORD_URL = "https://dapi.kakao.com/v2/local/search/keyword";
    private static HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
    public ArrayList<HashMap> searchUserLocationByKeyword(String keyword) {
        ArrayList<HashMap> userLocationCandidateList = new ArrayList<>();
        try {
            String url = KEYWORD_URL + "?query=" + URLEncoder.encode(keyword);
            String userLocationString = httpUrlConnection.requestApiConnection(url);
            JSONObject userLocationJson = new JSONObject(userLocationString);
            JSONArray userLocationList = (JSONArray) userLocationJson.get("documents");

            for (Object o : userLocationList) {
                JSONObject placeCandidate = (JSONObject) o;
                HashMap<String,String> placeCandidateInfoMap = new HashMap();
                placeCandidateInfoMap.put("place_name", (String) placeCandidate.get("place_name"));
                placeCandidateInfoMap.put("x", (String) placeCandidate.get("x"));
                placeCandidateInfoMap.put("y", (String) placeCandidate.get("y"));
                userLocationCandidateList.add(placeCandidateInfoMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userLocationCandidateList;

    }


}
