package org.example.controller;

import org.example.domain.UserLocation;
import org.example.view.UserLocationInputView;
import org.example.view.UserLocationOutputView;

import java.util.List;

public class UserLocationController {


    // 사용자 위치 정보 입력 후 사용자 위치 후보 가져오기

    public String getUserLocationKeyword(UserLocationInputView userLocationInputView) {
        String userLocationKeyword = userLocationInputView.inputUserLocationKeyword();
        return userLocationKeyword;
    }

    public List getUserLocationCandidateList(UserLocationOutputView userLocationOutputView,UserLocation userLocation,String userLocationKeyword) {
        List userLocationCandidateList = userLocation.searchUserLocationByKeyword(userLocationKeyword);
        userLocationOutputView.showUserLocationCandidate(userLocationCandidateList);
        return userLocationCandidateList;
    }

    public List getUserLocation(UserLocationInputView userLocationInputView,List userLocationCandidateList) {
        List userLocationList = userLocationInputView.getUserLocationName(userLocationCandidateList);
        System.out.println("선택하신 위치는 "+userLocationList.get(0) + " 입니다.");
        return userLocationList;
    }

    }



