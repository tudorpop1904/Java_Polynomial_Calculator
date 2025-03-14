import Model.Polynomial;
import Model.Monomial;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class OperationsTest {
    Polynomial P1 = new Polynomial(), P2 = new Polynomial();
    @Test
    public void additionTest() {
        P1.getPoly().put(4, new Monomial(3, 4));
        P1.getPoly().put(3, new Monomial(4, 3));
        P1.getPoly().put(1, new Monomial(-1, 1));
        P1.getPoly().put(0, new Monomial(2, 0));

        P2.getPoly().put(1, new Monomial(3, 1));
        P2.getPoly().put(0, new Monomial(-1, 0));
        assertEquals(P1.addPolynomial(P2).toString(), "3x^4 + 4x^3 + 2x + 1");
    }
    @Test
    public void subtractionTest() {
        P1.getPoly().put(4, new Monomial(3, 4));
        P1.getPoly().put(3, new Monomial(4, 3));
        P1.getPoly().put(1, new Monomial(-1, 1));
        P1.getPoly().put(0, new Monomial(2, 0));

        P2.getPoly().put(1, new Monomial(3, 1));
        P2.getPoly().put(0, new Monomial(-1, 0));
        assertEquals(P1.subtractPolynomial(P2).toString(), "3x^4 + 4x^3 + -4x + 3");
    }
    @Test
    public void multiplicationTest() {
        P1.getPoly().put(1, new Monomial(3, 1));
        P1.getPoly().put(0, new Monomial(-1, 0));

        P2.getPoly().put(0, new Monomial(-4, 0));
        assertEquals(P1.multiplyPolynomial(P2).toString(), "-12x + 4");
    }
    @Test
    public void diffTest() {
        P1.getPoly().put(3, new Monomial(1, 3));
        P1.getPoly().put(2, new Monomial(1, 2));
        P1.getPoly().put(1, new Monomial(1, 1));
        P1.getPoly().put(0, new Monomial(1, 0));
        assertEquals(P1.diffPolynomial().toString(), "3x^2 + 2x + 1");
    }
    @Test
    public void integralTest() {
        P1.getPoly().put(3, new Monomial(1, 3));
        P1.getPoly().put(2, new Monomial(3, 2));
        P1.getPoly().put(1, new Monomial(1, 1));
        P1.getPoly().put(0, new Monomial(1, 0));
        assertEquals(P1.integratePolynomial().toString(), "0.25x^4 + x^3 + 0.5x^2 + x");
    }
}
