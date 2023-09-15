package org.example.view;

import com.google.gson.JsonPrimitive;

import java.util.List;
import java.util.Scanner;

public class UserLocationInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int num;

    public String inputUserLocationKeyword() {
        System.out.print("현재 위치 키워드를 입력하세요 : ");
        String userLocationKeyword = scanner.nextLine();
        return userLocationKeyword;
    }
    public List getUserLocationName (List userLocationCandidateList) {
        num = scanner.nextInt();
        List userChoiceLocationInfo = (List) userLocationCandidateList.get(num-1);
        return userChoiceLocationInfo;
    }



}
