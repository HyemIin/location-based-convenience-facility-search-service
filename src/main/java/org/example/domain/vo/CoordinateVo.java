package org.example.domain.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoordinateVo {
    private String x;
    private String y;

    public boolean isValidated(String x,String y) {
        double xPoint = Double.parseDouble(x);
        double yPoint = Double.parseDouble(y);
        if (xPoint < 0 || yPoint < 0) {
            throw new IllegalArgumentException("좌표는 음수일 수 없습니다");
        } else {
            return true;
        }
    }
}
