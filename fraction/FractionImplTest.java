package fraction;

import org.junit.*;
import static org.junit.Assert.*;

public class FractionImplTest {

// GCD method made private, however test used below commented out.

//    @Test
//    public void testGCD1() {
//        int a = -1785;
//        int b = 546;
//        int value = FractionImpl.GCD(a, b);
//        assertEquals(21, value);
//    }
//
//    @Test
//    public void testGCD2() {
//        int c = 4;
//        int d = 8;
//        int value2 = FractionImpl.GCD(c, d);
//        assertEquals(4, value2);
//    }
//
//    @Test
//    public void testGCD3() {
//        int c = 7;
//        int d = 8;
//        int value = FractionImpl.GCD(c, d);
//        assertEquals(1, value);
//    }
//
//    @Test
//    public void testGCD4() {
//        int c = -7;
//        int d = 8;
//        int value = FractionImpl.GCD(c, d);
//        assertEquals(1, value);
//    }
//
//    @Test
//    public void testGCD5() {
//        int c = 4;
//        int d = 4;
//        int value = FractionImpl.GCD(c, d);
//        assertEquals(4, value);
//    }

    @Test(expected = ArithmeticException.class)
    public void exceptionCheck1() {
        FractionImpl frac1 = new FractionImpl(3, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void exceptionCheck2() {
        FractionImpl frac1 = new FractionImpl("3/0");
    }

    @Test(expected = NumberFormatException.class)
    public void exceptionCheck3() {
        FractionImpl frac1 = new FractionImpl("/2");
    }

    @Test(expected = NumberFormatException.class)
    public void exceptionCheck4() {
        FractionImpl frac1 = new FractionImpl("1 0 /7");
    }

    @Test(expected = NumberFormatException.class)
    public void exceptionCheck5() {
        FractionImpl frac1 = new FractionImpl("1 0/7");
    }

    @Test(expected = NumberFormatException.class)
    public void exceptionCheck6() {
        FractionImpl frac1 = new FractionImpl("2/");
    }

    @Test
    public void add1() {
        FractionImpl frac1 = new FractionImpl(3, 5);
        FractionImpl frac2 = new FractionImpl(2, 6);
        Fraction value = frac1.add((Fraction) frac2);
        String answer = value.toString();

        assertEquals("14/15", answer);

    }

    @Test
    public void add2() {
        FractionImpl frac1 = new FractionImpl(3, 5);
        FractionImpl frac2 = new FractionImpl(2, 5);
        Fraction value = frac1.add((Fraction) frac2);
        String answer = value.toString();

        assertEquals("1", answer);

    }

    @Test
    public void add3() {
        FractionImpl frac1 = new FractionImpl(-3, 5);
        FractionImpl frac2 = new FractionImpl(2, 5);
        Fraction value = frac1.add((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-1/5", answer);

    }

    @Test
    public void add4() {
        FractionImpl frac1 = new FractionImpl(6, 10);
        FractionImpl frac2 = new FractionImpl(2, 5);
        Fraction value = frac1.add((Fraction) frac2);
        String answer = value.toString();

        assertEquals("1", answer);
    }

    @Test
    public void subtract1() {
        FractionImpl frac1 = new FractionImpl(6, 10);
        FractionImpl frac2 = new FractionImpl(2, 5);
        Fraction value = frac1.subtract((Fraction) frac2);
        String answer = value.toString();

        assertEquals("1/5", answer);
    }

    @Test
    public void subtract2() {
        FractionImpl frac1 = new FractionImpl(1, 10);
        FractionImpl frac2 = new FractionImpl(2, 5);
        Fraction value = frac1.subtract((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-3/10", answer);
    }

    @Test
    public void subtract3() {
        FractionImpl frac1 = new FractionImpl(1);
        FractionImpl frac2 = new FractionImpl(2);
        Fraction value = frac1.subtract((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-1", answer);
    }

    @Test
    public void subtract4() {
        FractionImpl frac1 = new FractionImpl("5 /7");
        FractionImpl frac2 = new FractionImpl("2/7 ");
        Fraction value = frac1.subtract((Fraction) frac2);
        String answer = value.toString();

        assertEquals("3/7", answer);
    }

    @Test
    public void subtract5() {
        FractionImpl frac1 = new FractionImpl("2/7");
        FractionImpl frac2 = new FractionImpl("6/9");
        Fraction value = frac1.subtract((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-8/21", answer);
    }

    @Test
    public void multiply1() {
        FractionImpl frac1 = new FractionImpl("2/7");
        FractionImpl frac2 = new FractionImpl("6/9");
        Fraction value = frac1.multiply((Fraction) frac2);
        String answer = value.toString();

        assertEquals("4/21", answer);
    }

    @Test
    public void multiply2() {
        FractionImpl frac1 = new FractionImpl("2 /7");
        FractionImpl frac2 = new FractionImpl(" -6/ 9");
        Fraction value = frac1.multiply((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-4/21", answer);
    }

    @Test
    public void multiply3() {
        FractionImpl frac1 = new FractionImpl("-2 / 7");
        FractionImpl frac2 = new FractionImpl("-6/9");
        Fraction value = frac1.multiply((Fraction) frac2);
        String answer = value.toString();

        assertEquals("4/21", answer);
    }

    @Test
    public void multiply4() {
        FractionImpl frac1 = new FractionImpl(-3);
        FractionImpl frac2 = new FractionImpl(-5);
        Fraction value = frac1.multiply((Fraction) frac2);
        String answer = value.toString();

        assertEquals("15", answer);
    }

    @Test
    public void multiply5() {
        FractionImpl frac1 = new FractionImpl(3, -2);
        FractionImpl frac2 = new FractionImpl(-5, 7);
        Fraction value = frac1.multiply((Fraction) frac2);
        String answer = value.toString();

        assertEquals("15/14", answer);
    }


    @Test
    public void divide1() {
        FractionImpl frac1 = new FractionImpl(-3, 2);
        FractionImpl frac2 = new FractionImpl(-5, 7);
        Fraction value = frac1.divide((Fraction) frac2);
        String answer = value.toString();

        assertEquals("21/10", answer);
    }

    @Test
    public void divide2() {
        FractionImpl frac1 = new FractionImpl(-1, 2);
        FractionImpl frac2 = new FractionImpl(5, 7);
        Fraction value = frac1.divide((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-7/10", answer);
    }

    @Test
    public void divide3() {
        FractionImpl frac1 = new FractionImpl("-1 /2");
        FractionImpl frac2 = new FractionImpl("-5/7");
        Fraction value = frac1.divide((Fraction) frac2);
        String answer = value.toString();

        assertEquals("7/10", answer);
    }

    @Test
    public void divide4() {
        FractionImpl frac1 = new FractionImpl(-2);
        FractionImpl frac2 = new FractionImpl(4);
        Fraction value = frac1.divide((Fraction) frac2);
        String answer = value.toString();

        assertEquals("-1/2", answer);
    }

    @Test
    public void divide5() {
        FractionImpl frac1 = new FractionImpl(" -2");
        FractionImpl frac2 = new FractionImpl("-10 ");
        Fraction value = frac1.divide((Fraction) frac2);
        String answer = value.toString();

        assertEquals("1/5", answer);
    }

    @Test
    public void abs1() {
        FractionImpl frac1 = new FractionImpl("-2");
        Fraction testcase = frac1.abs();
        String answer = testcase.toString();
        assertEquals("2", answer);

    }

    @Test
    public void abs2() {
        FractionImpl frac1 = new FractionImpl(-10);
        Fraction testcase = frac1.abs();
        String answer = testcase.toString();
        assertEquals("10", answer);
    }

    @Test
    public void abs3() {
        FractionImpl frac1 = new FractionImpl("-2 /3");
        Fraction testcase = frac1.abs();
        String answer = testcase.toString();
        assertEquals("2/3", answer);

    }

    @Test
    public void abs4() {
        FractionImpl frac1 = new FractionImpl(3, -4);
        Fraction testcase = frac1.abs();
        String answer = testcase.toString();
        assertEquals("3/4", answer);

    }

    @Test
    public void abs5() {
        FractionImpl frac1 = new FractionImpl(3, 4);
        Fraction testcase = frac1.abs();
        String answer = testcase.toString();
        assertEquals("3/4", answer);

    }

    @Test
    public void negate1() {
        FractionImpl frac1 = new FractionImpl(3, -4);
        Fraction testcase = frac1.negate();
        String answer = testcase.toString();
        assertEquals("3/4", answer);
    }

    @Test
    public void negate2() {
        FractionImpl frac1 = new FractionImpl(3, 4);
        Fraction testcase = frac1.negate();
        String answer = testcase.toString();
        assertEquals("-3/4", answer);
    }

    @Test
    public void negate3() {
        FractionImpl frac1 = new FractionImpl("-2/ 3");
        Fraction testcase = frac1.negate();
        String answer = testcase.toString();
        assertEquals("2/3", answer);
    }

    @Test
    public void negate4() {
        FractionImpl frac1 = new FractionImpl(-2);
        Fraction testcase = frac1.negate();
        String answer = testcase.toString();
        assertEquals("2", answer);
    }

    @Test
    public void negate5() {
        FractionImpl frac1 = new FractionImpl("2");
        Fraction testcase = frac1.negate();
        String answer = testcase.toString();
        assertEquals("-2", answer);
    }

    @Test
    public void negate6() {
        FractionImpl frac1 = new FractionImpl(2);
        Fraction testcase = frac1.negate();
        String answer = testcase.toString();
        assertEquals("-2", answer);
    }

    @Test
    public void testEquals1() {
        FractionImpl frac1 = new FractionImpl(-3);
        FractionImpl frac2 = new FractionImpl(-5);
        boolean answer = frac1.equals(frac2);
        assertEquals(false, answer);
    }

    @Test
    public void testEquals2() {
        FractionImpl frac1 = new FractionImpl(-3);
        FractionImpl frac2 = new FractionImpl(-3);
        boolean answer = frac1.equals(frac2);
        assertEquals(true, answer);
    }

    @Test
    public void testEquals3() {
        FractionImpl frac1 = new FractionImpl(3, 2);
        FractionImpl frac2 = new FractionImpl(6, 4);
        Fraction F1 = (Fraction) frac1;
        Fraction F2 = (Fraction) frac2;
        boolean answer = F1.equals(F2);
        assertEquals(true, answer);
    }

    @Test
    public void testEquals4() {
        FractionImpl frac1 = new FractionImpl(-9);
        boolean answer = frac1.equals(-9);
        assertEquals(false, answer);
    }

    @Test
    public void testEquals5() {
        FractionImpl frac1 = new FractionImpl("3/7");
        FractionImpl frac2 = new FractionImpl("3/7");
        String test = frac2.toString();
        boolean answer = frac1.equals(test);
        assertEquals(false, answer);
    }

    @Test
    public void inverse1() {
        FractionImpl frac1 = new FractionImpl("3/7");
        Fraction frac2 = frac1.inverse();
        String answer = frac2.toString();
        assertEquals("7/3", answer);
    }

    @Test
    public void inverse2() {
        FractionImpl frac1 = new FractionImpl(3, -7);
        Fraction frac2 = frac1.inverse();
        String answer = frac2.toString();
        assertEquals("-7/3", answer);
    }

    @Test
    public void inverse3() {
        FractionImpl frac1 = new FractionImpl(3);
        Fraction frac2 = frac1.inverse();
        String answer = frac2.toString();
        assertEquals("1/3", answer);
    }

    @Test
    public void inverse4() {
        FractionImpl frac1 = new FractionImpl(-9);
        Fraction frac2 = frac1.inverse();
        String answer = frac2.toString();
        assertEquals("-1/9", answer);
    }

    @Test
    public void inverse5() {
        FractionImpl frac1 = new FractionImpl(1, -5);
        Fraction frac2 = frac1.inverse();
        String answer = frac2.toString();
        assertEquals("-5", answer);
    }

    @Test(expected = ArithmeticException.class)
    public void inverse6() {
        FractionImpl frac1 = new FractionImpl(0, -5);
        Fraction frac2 = frac1.inverse();
    }

    @Test
    public void compareTo1() {
        FractionImpl frac1 = new FractionImpl(1, 5);
        FractionImpl frac2 = new FractionImpl(2, 10);
        int answer = frac1.compareTo(frac2);
        assertEquals(0, answer);
    }

    @Test
    public void compareTo2() {
        FractionImpl frac1 = new FractionImpl(1, 5);
        FractionImpl frac2 = new FractionImpl(3, 10);
        int answer = frac1.compareTo(frac2);
        assertEquals(-1, answer);
    }

    @Test
    public void compareTo3() {
        FractionImpl frac1 = new FractionImpl(3, 5);
        FractionImpl frac2 = new FractionImpl(3, 10);
        int answer = frac1.compareTo(frac2);
        assertEquals(1, answer);
    }

    @Test
    public void compareTo4() {
        FractionImpl frac1 = new FractionImpl(1, -5);
        FractionImpl frac2 = new FractionImpl(2, 10);
        int answer = frac1.compareTo(frac2);
        assertEquals(-1, answer);
    }

    @Test
    public void compareTo5() {
        FractionImpl frac1 = new FractionImpl(1, -5);
        FractionImpl frac2 = new FractionImpl(-2, 10);
        int answer = frac1.compareTo(frac2);
        assertEquals(0, answer);
    }

    @Test
    public void testToString1() {
        FractionImpl T = new FractionImpl("4/-3");
        String result = T.toString();
        assertEquals("-4/3", result);
    }

    @Test
    public void testToString2() {
        FractionImpl T = new FractionImpl(6, -9);
        String result = T.toString();
        assertEquals("-2/3", result);
    }

    @Test
    public void testToString3() {
        FractionImpl T = new FractionImpl(6);
        String result = T.toString();
        assertEquals("6", result);
    }

    @Test
    public void testToString4() {
        FractionImpl T = new FractionImpl(-6);
        String result = T.toString();
        assertEquals("-6", result);
    }

    @Test
    public void testToString5() {
        FractionImpl T = new FractionImpl(" 18 / -3");
        String result = T.toString();
        assertEquals("-6", result);
    }

}

