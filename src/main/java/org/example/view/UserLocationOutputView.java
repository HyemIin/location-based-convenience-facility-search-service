package org.example.view;

import org.example.UserLocation;

import java.util.HashMap;
import java.util.List;


public class UserLocationOutputView {

    public void printUserLocationCandidate(List userLocationCandidateList) {
        System.out.println("해당하는 위치를 고르시오.");
        for (int i = 1; i <= userLocationCandidateList.size(); i++) {
            HashMap userLocationCandidate = (HashMap) userLocationCandidateList.get(i-1);
            System.out.println(i + ". " + userLocationCandidate.get("place_name"));
        }
    }
}
