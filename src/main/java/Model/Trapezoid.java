package Model;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Trapezoid {

    private double sideA, sideB, height, area;

    public Trapezoid(double sideA, double sideB, double height) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.height = height;
    }

    public void calcArea() {
        area = new BigDecimal((sideA + sideB) * height / 2).setScale(2, RoundingMode.UP).doubleValue();
    }

    public double getArea() {
        return area;
    }
}
