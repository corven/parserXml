package Model;

import Model.Interface.FigureImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements FigureImpl {
    private double sideA, sideB, sideC, area;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void calcArea() {
        double p = (sideA + sideB + sideC)/2;
        area = new BigDecimal(Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC))).setScale(2, RoundingMode.UP).doubleValue();
    }

    public double getArea() {
        return area;
    }
}
