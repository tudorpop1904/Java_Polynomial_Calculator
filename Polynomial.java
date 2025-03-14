package Model;
import java.util.*;
import java.util.regex.*;
public class Polynomial {
    private HashMap<Integer, Monomial> poly; // O lista de asocieri de tip f(Integer) = Monomial.
    public Polynomial() { // Constructor care declara lista de asocieri mentionata anterior ca fiind una de tip Hash
        poly = new HashMap<Integer, Monomial>();
    }
    public Polynomial(Polynomial other) { // Constructor care instantiaza un polinom nou ca fiind o copie a polinomului "other"
        poly = new HashMap<>(other.poly);
    }
    public Polynomial(String input) {
        this();
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String aux = matcher.group();
            Monomial monomial = new Monomial(aux);
            setCoef(monomial.getCoef(), monomial.getPower());
        }
    }
    public HashMap<Integer, Monomial> getPoly() { // Un accesor pentru lista "poly"
        return this.poly;
    }
    public boolean isZeroPolynomial() { // Verifica daca polinomul actual este polinomul "0"
        for (Integer i : this.poly.keySet()) {
            if (this.poly.get(i).getCoef() != 0)
                return false;
        }
        return true;
    }
    public void setCoef(int coef, int power){ // Seteaza coeficientul "coef" pentru termenul cu puterea "power"
        if(poly.containsKey(power))
            poly.get(power).setCoef(coef);
        else
            poly.put(power, new Monomial(coef, power));
    }
    public int getCoef(int power){ // acceseaza coeficientul termenului cu puterea "power"
        if(poly.containsKey(power))
            return poly.get(power).getCoef();
        else
            return 0;
    }
    public Polynomial addPolynomial(Polynomial P) { // Operatia de adunare a doua polinoame
        Polynomial result = new Polynomial(this);
        for (int i = 0; i <= Math.max(this.degree(), P.degree()); i ++)
            result.setCoef(result.getCoef(i) + P.getCoef(i), i);
        return result;
    }
    public Polynomial subtractPolynomial(Polynomial P) { // Operatia de scadere a doua polinoame
        Polynomial result = new Polynomial(this);
        for (int i = 0; i <= Math.max(this.degree(), P.degree()); i ++)
            result.setCoef(result.getCoef(i) - P.getCoef(i), i);
        return result;
    }
    public Polynomial multiplyPolynomial(Polynomial P) { // Operatia de inmultire a doua polinoame
        Polynomial result = new Polynomial();
        for (Integer i : this.poly.keySet()) {
            for (Integer j : P.poly.keySet()) {
                int powerr = i + j;
                int coeff = this.poly.get(i).getCoef() * P.poly.get(j).getCoef();
                result.setCoef(result.getCoef(powerr) + coeff, powerr);
            }
        }
        return result;
    }
    public int degree(){ // Functie care returneaza gradul polinomului actual
        int deg = 0;
        for(Integer key : poly.keySet()){
            if(poly.get(key).getCoef() != 0)
                deg = Math.max(deg, key);
        }
        return deg;
    }
    public Polynomial diffPolynomial() { // Functia de derivare a polinomului actual
        Polynomial result = new Polynomial();
        int deg = this.degree();
        for (Integer i : this.poly.keySet()) {
                result.poly.put(i, this.poly.get(i).diffMonomial());
        }
        return result;
    }
    public DoublePolynomial toDoublePolynomial() {
        DoublePolynomial result = new DoublePolynomial();
        for (Integer i : this.poly.keySet()) {
            result.getPoly().put(i, new DoubleMonomial((double)(this.poly.get(i).getCoef()), this.poly.get(i).getPower()));
        }
        return result;
    }

    public DoublePolynomial integratePolynomial() { // Functia de integrare a polinomului actual
        DoublePolynomial result = new DoublePolynomial();
        int deg = degree();
        for (Integer i : this.poly.keySet()) {
            result.getPoly().put(i + 1, this.poly.get(i).integrateMonomial());
        }
        result.setCoef(0, 0);
        return result;
    }
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        for (int i = this.degree(); i >= 0; i --) {
            if (this.getCoef(i) != 0) {
                if (print.length() > 0) {
                    if (this.getCoef(i) > 0)
                        print.append(" + ");
                    else {
                        print.append(" - ");
                        this.poly.get(i).setCoef(-this.poly.get(i).getCoef());
                    }
                }
                print.append(this.poly.get(i));
            }
        }
        return print.toString();
    }

}