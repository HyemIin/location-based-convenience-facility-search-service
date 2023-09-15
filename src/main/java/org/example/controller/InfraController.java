package org.example.controller;

import org.example.domain.Infra;
import org.example.view.SearchResultInputView;
import org.json.JSONArray;

import java.util.List;

public class InfraController {
    public int getRadius(SearchResultInputView searchResultInputView) {
        int radius = searchResultInputView.inputSearchRadius();
        return radius;
    }
    public String getCategoryCode(SearchResultInputView searchResultInputView) {
        String categoryCode = searchResultInputView.inputCategoryCode();
        return categoryCode;
    }

    public JSONArray getInfraList(Infra infra,List userLocationList, String code, int radius) {
        JSONArray infraInfo = infra.searchInfraInformationNearByUser(userLocationList, code, radius);
        return infraInfo;
    }


}
