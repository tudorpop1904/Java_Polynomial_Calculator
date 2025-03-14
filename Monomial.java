package Model;
import java.util.regex.Pattern;
import java.lang.*;

import static java.lang.Integer.*;

public class Monomial {
    private int coef, power; // Un monom este unic definit de catre coeficientul si puterea variabilei
    public Monomial(int c, int p) { // Un constructor cu parametri expliciti
        coef = c;
        power = p;
    }
    public Monomial() { // Un constructor implicit
        this(0, 0);
    }
    public Monomial(String s) {
        if (s.contains("x^")) {
            String[] mon = s.split("x\\^");
            if (mon.length < 2) {
                coef = 1;
                power = parseInt(mon[0]);
            }
            else {
                power = parseInt(mon[1]);
                if (mon[0].equals("-") || mon[0].equals("- ")) {
                    coef = -1;
                }
                else if (mon[0].equals("") || mon[0].equals("+"))
                    coef = 1;
                else coef = parseInt(mon[0]);
            }
        }
        else if (s.contains("x")) {
            if (s.equals("x") || s.equals("+x")) {
                coef = 1;
                power = 1;
            }
            else if (s.equals("-x") || s.equals("- x")) {
                coef = -1;
                power = 1;
            }
            else {
                coef = parseInt(s.replace("x", ""));
                power = 1;
            }
        }
        else {
            coef = parseInt(s);
            power = 0;
        }
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
    public int getCoef() { // Metoda accesoare pentru coeficient
        return coef;
    }
    public void setCoef(int coef) { // Metoda mutatoare pentru coeficient
        this.coef = coef;
    }
    public int getPower() { // Metoda accesoare pentru putere
        return power;
    }
    public void setPower(int power) { // Metoda mutatoare pentru putere
        this.power = power;
    }
    public Monomial multiplyMonomial(Monomial M) { // Inmultirea a doua monoame, indiferent de coeficient si putere
        return new Monomial(this.coef * M.coef, this.power + M.power);
    }
    public Monomial diffMonomial() { // Derivata unui monom
        // -10
        if (this.power == 0 || this.coef == 0) {
            return new Monomial();
        }
        return new Monomial(this.power * this.coef, this.power - 1);
    }
    public DoubleMonomial integrateMonomial() {
        if (this.coef == 0)
            return new DoubleMonomial();
        return new DoubleMonomial(this.coef / (double)(this.power + 1), this.power + 1);
    }
}