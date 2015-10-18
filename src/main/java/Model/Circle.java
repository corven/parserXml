package Model;

import Model.Interface.FigureImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements FigureImpl {

    private double rad,area;

    public Circle(double rad) {
        this.rad = rad;
    }

    public double getArea() {
        return area;
    }

    public void calcArea() {
        area = new BigDecimal(Math.PI * rad * rad).setScale(2, RoundingMode.UP).doubleValue();

    }
}
