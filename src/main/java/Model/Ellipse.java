package Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ellipse {
    private double radA, radB, area;

    public Ellipse(double radA, double radB) {
        this.radA = radA;
        this.radB = radB;
    }

    public void calcArea() {
        area = new BigDecimal(Math.PI * radA * radB).setScale(2, RoundingMode.UP).doubleValue();
    }

    public double getArea() {
        return area;
    }
}
