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
    private static UserLocationInputView userLocationInputView = new UserLocationInputView();
    private static UserLocationOutputView userLocationOutputView = new UserLocationOutputView();
    private static SearchResultInputView searchResultInputView = new SearchResultInputView();
    private static SearchResultOutputView searchResultOutputView = new SearchResultOutputView();
    private static UserLocation userLocation = new UserLocation();
    private static Infra infra = new Infra();


    public static void main(String[] args) {

        UserLocationController userLocationController = new UserLocationController();
        InfraController infraController = new InfraController();

        String userLocationInputKeyword = userLocationController.getUserLocationKeyword(userLocationInputView);
        List userLocationCandidateList = userLocationController.getUserLocationCandidateList(userLocationOutputView, userLocation, userLocationInputKeyword);
        List userLocationList = userLocationController.getUserLocation(userLocationInputView, userLocationCandidateList);

        String categoryCode = infraController.getCategoryCode(searchResultInputView);
        int radius = infraController.getRadius(searchResultInputView);

        JSONArray infraInfo = infraController.getInfraList(infra,userLocationList, categoryCode, radius);
        searchResultOutputView.printSearchResult(infraInfo);

    }
}