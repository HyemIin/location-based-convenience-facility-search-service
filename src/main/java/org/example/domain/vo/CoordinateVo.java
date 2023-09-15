package org.example.domain.vo;

import lombok.AllArgsConstructor;


public class CoordinateVo {

    public boolean isValidated(String point) {
        double coordinatePoint = Double.parseDouble(point);
        if (coordinatePoint < 0) {
            throw new IllegalArgumentException("좌표는 음수일 수 없습니다");
        } else {
            return true;
        }
    }
}
