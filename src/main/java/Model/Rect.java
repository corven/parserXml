package Model;

import Model.Interface.FigureImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Rect implements FigureImpl {

    private double sideA, sideB, area;

    public Rect(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void calcArea() {
        area = new BigDecimal(sideA * sideB).setScale(2, RoundingMode.UP).doubleValue();
    }

    public double getArea() {
        return area;
    }
}
