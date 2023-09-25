package org.example.view;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class SearchResultOutputView {

    public void printSearchResult(List infraInfo) {
        for (Object o : infraInfo) {
            Map result = (Map) o;
            System.out.println(result.get("place_name")+ " : " + result.get("place_url"));
        }

    }
}
