package home.pdm.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestCalService {
    private CalcService calc = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("Before");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("After");
    }

    @Test
    public void testSum() {
        calc = new CalcService();
        double res = calc.sum(2.0, 5.0);
        assertTrue(res == 7);
    }

    @Test
    public void testMinus() {
        calc = new CalcService();
        double res = calc.minus(5.0, 2.0);
        assertTrue(res == 3);
    }

    @Test
    public void testMult() {
        calc = new CalcService();
        double res = calc.mult(5.0, 2.0);
        assertTrue(res == 10);
    }

    @Test
    public void testDiv() throws Exception {
        calc = new CalcService();
        double res = calc.div(5.0, 2.0);
        assertTrue(res == 2.5);
    }
}
