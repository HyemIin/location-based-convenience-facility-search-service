package org.example.view;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchResultOutputView {

    public void printSearchResult(JSONArray infraInfo) {
        for (Object o : infraInfo) {
            JSONObject result = (JSONObject) o;
            System.out.println(result.get("place_name") + " : " + result.get("place_url"));
        }

    }
}
