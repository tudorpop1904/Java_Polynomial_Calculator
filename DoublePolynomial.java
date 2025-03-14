package Model;

import java.util.HashMap;

public class DoublePolynomial {
    private HashMap<Integer, DoubleMonomial> poly;
    public DoublePolynomial() {
        poly = new HashMap<Integer, DoubleMonomial>();
    }
    public DoublePolynomial(DoublePolynomial other) {
        poly = new HashMap<Integer, DoubleMonomial>(other.poly);
    }

    public boolean isZeroPolynomial() {
        for (Integer i : this.poly.keySet()) {
            if (this.poly.get(i).getCoef() != 0)
                return false;
        }
        return true;
    }

    public HashMap<Integer, DoubleMonomial> getPoly() { // Un accesor pentru lista "poly"
        return this.poly;
    }

    public void setCoef(double coef, int power){ // Seteaza coeficientul "coef" pentru termenul cu puterea "power"
        if(poly.containsKey(power))
            poly.get(power).setCoef(coef);
        else
            poly.put(power, new DoubleMonomial(coef, power));
    }
    public double getCoef(int power){ // acceseaza coeficientul termenului cu puterea "power"
        if(poly.containsKey(power))
            return poly.get(power).getCoef();
        else
            return 0;
    }

    public DoublePolynomial addPolynomial(DoublePolynomial P) { // Operatia de adunare a doua polinoame
        DoublePolynomial result = new DoublePolynomial(this);
        for (int i = 0; i <= Math.max(this.degree(), P.degree()); i ++)
            result.setCoef(result.getCoef(i) + P.getCoef(i), i);
        return result;
    }
    public DoublePolynomial subtractPolynomial(DoublePolynomial P) { // Operatia de scadere a doua polinoame
        DoublePolynomial result = new DoublePolynomial(this);
        for (int i = 0; i <= Math.max(this.degree(), P.degree()); i ++)
            result.setCoef(result.getCoef(i) - P.getCoef(i), i);
        return result;
    }
    public DoublePolynomial addMonomial(DoubleMonomial M) { // Operatia de adunare a unui polinom cu un monom
        DoublePolynomial result = new DoublePolynomial(this);
        result.setCoef( result.getCoef(M.getPower()) + M.getCoef(), M.getPower());
        return result;
    }
    public int degree(){ // Functie care returneaza gradul polinomului actual
        int deg = 0;
        for(Integer key : poly.keySet()) {
            if(poly.get(key).getCoef() != 0)
                deg = Math.max(deg, key);
        }
        return deg;
    }
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        for (int i = this.degree(); i >= 0; i --) {
            if (this.getCoef(i) != 0) {
                if (print.length() > 0)
                    print.append(" + ");
                print.append(this.poly.get(i));
            }
        }
        return print.toString();
    }
}
