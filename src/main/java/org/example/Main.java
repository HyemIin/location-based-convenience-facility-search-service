package org.example;

import org.example.controller.InfraController;
import org.example.controller.UserLocationController;
import org.example.view.SearchResultInputView;
import org.example.view.SearchResultOutputView;
import org.example.view.UserLocationInputView;
import org.example.view.UserLocationOutputView;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static UserLocationInputView userLocationInputView = new UserLocationInputView(new Scanner(System.in));
    private static UserLocationOutputView userLocationOutputView = new UserLocationOutputView();
    private static SearchResultInputView searchResultInputView = new SearchResultInputView(new Scanner(System.in));
    private static SearchResultOutputView searchResultOutputView = new SearchResultOutputView();
    private static UserLocation userLocation = new UserLocation();
    private static Infra infra = new Infra();


    public static void main(String[] args) {

        UserLocationController userLocationController = new UserLocationController();
        InfraController infraController = new InfraController();

        String userLocationInputKeyword = userLocationController.getUserLocationKeyword(userLocationInputView);
        List userLocationCandidateList = userLocationController.getUserLocationCandidateList(userLocationOutputView, userLocation, userLocationInputKeyword);
        HashMap userLocationMap = userLocationController.getUserLocation(userLocationInputView, userLocationCandidateList);

        String categoryCode = infraController.getCategoryCode(searchResultInputView);
        int radius = infraController.getRadius(searchResultInputView);

        JSONArray infraInfo = infraController.getInfraList(infra,userLocationMap, categoryCode, radius);
        searchResultOutputView.printSearchResult(infraInfo.toList());

    }
}