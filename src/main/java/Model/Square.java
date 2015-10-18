package Model;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Square {

    private double sideA, area;

    public Square(double sideA) {
        this.sideA = sideA;
    }

    public void calcArea() {
        area = new BigDecimal(sideA * sideA).setScale(2, RoundingMode.UP).doubleValue();
    }

    public double getArea() {
        return area;
    }
}
