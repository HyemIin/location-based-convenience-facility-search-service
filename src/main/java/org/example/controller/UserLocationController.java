package org.example.controller;

import org.example.UserLocation;
import org.example.view.UserLocationInputView;
import org.example.view.UserLocationOutputView;

import java.util.HashMap;
import java.util.List;

public class UserLocationController {

    public String getUserLocationKeyword(UserLocationInputView userLocationInputView) {
        String userLocationInputKeyword = userLocationInputView.inputUserLocationKeyword();
        return userLocationInputKeyword;
    }

    public List getUserLocationCandidateList(UserLocationOutputView userLocationOutputView,UserLocation userLocation,String userLocationKeyword) {
        List userLocationCandidateList = userLocation.searchUserLocationByKeyword(userLocationKeyword);
        userLocationOutputView.printUserLocationCandidate(userLocationCandidateList);
        return userLocationCandidateList;
    }

    public HashMap getUserLocation(UserLocationInputView userLocationInputView,List userLocationCandidateList) {
        HashMap userLocationMap = userLocationInputView.inputUserLocationName(userLocationCandidateList);
        System.out.println("선택하신 위치는 "+userLocationMap.get("place_name") + " 입니다.");
        return userLocationMap;
    }

    }



