package org.example.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchResultInputView {

    private static Scanner scanner = new Scanner(System.in);

    public int inputSearchRadius() {
        System.out.print("검색 반경을 입력하세요(1000:1km): ");
        int radius = scanner.nextInt();
        return radius;
    }
    public String inputCategoryCode() {
        List categoryCodeList = new ArrayList();
        categoryCodeList.addAll(List.of("MT1", "CS2", "PS3", "SC4", "AC5", "PK6", "OL7", "SW8", "BK9", "CT1", "AG2", "PO3", "AT4", "AD5", "FD6", "CE7", "HP8", "PM9"));
        System.out.println("찾고자하는 서비스를 고르세요.");
        System.out.println("1.대형마트 2.편의점 3.어린이집,유치원 4.학교 5.학원 6.주차장 7.주유소,충전소 8.지하철역 9.은행 10.문화시설 11.중개업소 12.공공기관 13.관광명소 14.숙박 15.음식점 16.카페 17.병원 18.약국");
        int code = scanner.nextInt();
        String categoryCode = (String) categoryCodeList.get(code - 1);
        System.out.println("선택하신 서비스 카테고리 코드는 "+categoryCode+" 입니다.");
        return categoryCode;
    }
}
