package Model;

import Model.Interface.FigureImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rhomb implements FigureImpl {
    private double diagA, diagB, area;

    public Rhomb(double diagA, double diagB) {
        this.diagA = diagA;
        this.diagB = diagB;
    }

    public void calcArea() {
        area = new BigDecimal(diagA * diagB / 2).setScale(2, RoundingMode.UP).doubleValue();
    }

    public double getArea() {
        return area;
    }
}
