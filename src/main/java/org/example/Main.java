package org.example;

import org.example.controller.InfraController;
import org.example.controller.UserLocationController;
import org.example.domain.Infra;
import org.example.domain.UserLocation;
import org.example.view.SearchResultInputView;
import org.example.view.SearchResultOutputView;
import org.example.view.UserLocationInputView;
import org.example.view.UserLocationOutputView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Main {
    static UserLocationInputView userLocationInputView = new UserLocationInputView();
    static UserLocationOutputView userLocationOutputView = new UserLocationOutputView();
    static SearchResultInputView searchResultInputView = new SearchResultInputView();
    static SearchResultOutputView searchResultOutputView = new SearchResultOutputView();
    static UserLocation userLocation = new UserLocation();


    public static void main(String[] args) {

        UserLocationController userLocationController = new UserLocationController();
        InfraController infraController = new InfraController();
        Infra infra = new Infra();

        String userLocationKeyword = userLocationController.getUserLocationKeyword(userLocationInputView);
        List userLocationCandidateList = userLocationController.getUserLocationCandidateList(userLocationOutputView, userLocation, userLocationKeyword);
        List userLocationList = userLocationController.getUserLocation(userLocationInputView, userLocationCandidateList);

        String categoryCode = infraController.getCategoryCode(searchResultInputView);
        int radius = infraController.getRadius(searchResultInputView);

        JSONArray infraInfo = infra.searchInfra(userLocationList, categoryCode, radius);
        searchResultOutputView.printSearchResult(infraInfo);


    }
}