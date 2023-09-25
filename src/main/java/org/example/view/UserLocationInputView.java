package org.example.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserLocationInputView {
    private Scanner scanner;

    public UserLocationInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static int num;

    public String inputUserLocationKeyword() {
        System.out.print("현재 위치 키워드를 입력하세요 : ");
        String userLocationKeyword = scanner.nextLine();
        return userLocationKeyword;
    }
    public HashMap inputUserLocationName(List userLocationCandidateList) {
        num = scanner.nextInt();
        HashMap userChoiceLocationInfo = (HashMap)userLocationCandidateList.get(num-1);
        return userChoiceLocationInfo;
    }



}
