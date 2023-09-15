package org.example.controller;

import org.example.domain.UserLocation;
import org.example.view.UserLocationInputView;
import org.example.view.UserLocationOutputView;

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

    public List getUserLocation(UserLocationInputView userLocationInputView,List userLocationCandidateList) {
        List userLocationList = userLocationInputView.inputUserLocationName(userLocationCandidateList);
        System.out.println("선택하신 위치는 "+userLocationList.get(0) + " 입니다.");
        return userLocationList;
    }

    }



