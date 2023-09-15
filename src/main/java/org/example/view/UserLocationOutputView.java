package org.example.view;

import org.example.domain.UserLocation;

import java.util.List;


public class UserLocationOutputView {
    private UserLocation userLocation;
    private UserLocationInputView userLocationInputView;

    public void showUserLocationCandidate(List userLocationCandidateList) {
        System.out.println("해당하는 위치를 고르시오.");
        for (int i = 1; i <= userLocationCandidateList.size(); i++) {
            List userLocationCandidate = (List) userLocationCandidateList.get(i-1);
            System.out.println(i + ". " + userLocationCandidate.get(0));
        }
    }
}
