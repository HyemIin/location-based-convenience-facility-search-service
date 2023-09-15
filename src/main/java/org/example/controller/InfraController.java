package org.example.controller;

import org.example.domain.Infra;
import org.example.view.SearchResultInputView;

import java.util.List;

public class InfraController {
    public int getRadius(SearchResultInputView searchResultInputView) {
        int radius = searchResultInputView.inputSearchRadius();
        return radius;
    }
    public String getCategoryCode(SearchResultInputView searchResultInputView) {
        String categoryCode = searchResultInputView.getCategoryCode();
        return categoryCode;
    }


}
