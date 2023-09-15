package org.example.domain.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoordinateVo {
    private long value;

    public void validate(long point) {
        if (point < 0) {
            throw new IllegalArgumentException("좌표는 음수일 수 없습니다");
        }
    }
}
