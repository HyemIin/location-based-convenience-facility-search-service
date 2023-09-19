package org.example.domain.vo;


public class CoordinateVo {
    private double x;
    private double y;

    public CoordinateVo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValidatedPositiveNumber(double x, double y) {

        if (x < 0 || y < 0) {
            return false;
        } else {
            return true;
        }
    }
}
