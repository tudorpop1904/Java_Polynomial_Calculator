package Model;

public class PolynomialDivision {
    private DoublePolynomial quotient, remainder;
    public PolynomialDivision(Polynomial P, Polynomial Q) {
        if (!Q.isZeroPolynomial()) {
            DoubleMonomial t = new DoubleMonomial();
            quotient = new DoublePolynomial();
            remainder = P.toDoublePolynomial();
            int degR = remainder.degree();
            int degQ = Q.degree();
            while(!remainder.isZeroPolynomial() && degR >= degQ) {
                t = remainder.getPoly().get(degR).divideMonomial(Q.getPoly().get(degQ));
                quotient = quotient.addMonomial(t);
                remainder = remainder.subtractPolynomial(t.multiplyPolynomial(P));
                degR = remainder.degree();
                degQ = Q.degree();
            }
        }
    }

    public DoublePolynomial getQuotient() {
        return quotient;
    }

    public void setQuotient(DoublePolynomial quotient) {
        this.quotient = quotient;
    }

    public DoublePolynomial getRemainder() {
        return remainder;
    }

    public void setRemainder(DoublePolynomial remainder) {
        this.remainder = remainder;
    }

}
