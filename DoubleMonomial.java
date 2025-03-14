package Model;
import java.util.regex.Pattern;
import java.lang.*;

import static java.lang.Integer.*;

public class DoubleMonomial {
    private double coef;
    private int power; // Un monom este unic definit de catre coeficientul si puterea variabilei
    public DoubleMonomial(double c, int p) { // Un constructor cu parametri expliciti
        coef = c;
        power = p;
    }
    public DoubleMonomial() { // Un constructor implicit
        this(0, 0);
    }

    @Override
    public String toString() { // Metoda care parseaza un polinom din date interne in reprezentare String
        if (power == 0) {
            return coef + "";
        }
        if (coef == 0) {
            return "0";
        }
        if (coef == 1) {
            if (power == 1) {
                return "x";
            }
            return "x^" + power;
        }

        if (coef == -1) {
            if (power == 1) {
                return "-x";
            }
            return "-x^" + power;
        }
        if (power == 1) {
            return coef + "x";
        }

        return coef + "x^" + power;
    }
    public double getCoef() { // Metoda accesoare pentru coeficient
        return coef;
    }
    public void setCoef(double coef) { // Metoda mutatoare pentru coeficient
        this.coef = coef;
    }
    public int getPower() { // Metoda accesoare pentru putere
        return power;
    }
    public DoubleMonomial multiplyMonomial(Monomial M) { // Inmultirea a doua monoame, indiferent de coeficient si putere
        return new DoubleMonomial(this.coef * M.getCoef(), this.power + M.getPower());
    }

    public DoubleMonomial divideMonomial(Monomial M) {
        if (this.power >= M.getPower())
            return new DoubleMonomial((double)(this.coef / M.getCoef()), this.power - M.getPower());
        return null;
    }


    public DoublePolynomial multiplyPolynomial(Polynomial P) { // Inmultirea a unui monom cu un polinom
        DoublePolynomial result = new DoublePolynomial();
        DoubleMonomial t = new DoubleMonomial();
        for (Integer i : P.getPoly().keySet()) {
            t = this.multiplyMonomial(P.getPoly().get(i));
            result.getPoly().put(i, new DoubleMonomial(t.coef, t.power));
        }
        return result;
    }
}