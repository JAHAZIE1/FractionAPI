// email: jahazi01@student.bbk.ac.uk

package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

    /**
     * helper method to get Greatest Common Divisor (GCD).
     * Takes in two integers and uses Euclid's algorithm to find answer.
     * Returns an integers
     *
     * @param a & b, the two integers to compare
     * @return GCD as an integer
     *
     */
    private static int GCD(int a, int b) {
        int largerNo = 0;
        int smallerNo = 0;

        if (a>b) {
            largerNo = a;
            smallerNo = b;
        } else  { // note if a==b function will return b
            largerNo = b;
            smallerNo = a;
        }

        while (smallerNo != 0) {
            int smallerNoHolder = smallerNo;
            smallerNo = largerNo % smallerNo;
            largerNo = smallerNoHolder ;
        }

        return largerNo;

    }


    public FractionImpl(int numerator, int denominator) {

        if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        int gcd = GCD(numerator, denominator);

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

        if (this.denominator < 0) { // edge case if denominator is negative value
            this.denominator *= -1;
            this.numerator *= -1;
        }

    }

    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    public FractionImpl(String fraction) {

        fraction = fraction.trim();

        if (!fraction.contains("/")) {
            this.denominator = 1;
            this.numerator = Integer.parseInt(fraction);
        } else {

            try {
                String[] currentNumber = fraction.split("/");
                currentNumber[0] = currentNumber[0].trim();
                currentNumber[1] = currentNumber[1].trim();
                this.numerator = Integer.parseInt(currentNumber[0]);
                this.denominator = Integer.parseInt(currentNumber[1]);

            } catch (NumberFormatException e) {
                throw new NumberFormatException("Incorrect input");
            } catch ( ArrayIndexOutOfBoundsException a) { // catches inputs where no denominator included such as "3/"
                throw new NumberFormatException("Incorrect input");
            }


            if (this.denominator == 0) { // edge case if denominator is 0
                throw new ArithmeticException("Divide by zero");
            }

            int gcd = GCD(this.numerator, this.denominator);

            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;

            if (this.denominator < 0) { // edge case if denominator is negative value
                this.denominator *= -1;
                this.numerator *= -1;
            }

            }
        }

    @Override
    public Fraction add(Fraction f) {

        FractionImpl fractionNo = (FractionImpl) f;

        int numeratorAnswer = (this.numerator * fractionNo.denominator) + (this.denominator * fractionNo.numerator);
        int denominatorAnswer = this.denominator * fractionNo.denominator;

        FractionImpl finalAnswer = new FractionImpl(numeratorAnswer, denominatorAnswer);

        return finalAnswer;
    }

    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl fractionNo = (FractionImpl) f;

        int numeratorAnswer = (this.numerator * fractionNo.denominator) - (this.denominator * fractionNo.numerator);
        int denominatorAnswer = this.denominator * fractionNo.denominator;

        FractionImpl finalAnswer = new FractionImpl(numeratorAnswer, denominatorAnswer);

        return finalAnswer;
    }

    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl fractionNo = (FractionImpl) f;

        int numeratorAnswer = this.numerator * fractionNo.numerator;
        int denominatorAnswer = this.denominator * fractionNo.denominator;
        FractionImpl finalAnswer = new FractionImpl(numeratorAnswer, denominatorAnswer);

        return finalAnswer;
    }

    @Override
    public Fraction divide(Fraction f) {

        FractionImpl fractionNo = (FractionImpl) f;

        int fracNum = fractionNo.numerator;
        int fracDen = fractionNo.denominator;

        int numeratorAnswer = this.numerator * fracDen;
        int denominatorAnswer = this.denominator * fracNum;

        FractionImpl finalAnswer = new FractionImpl(numeratorAnswer, denominatorAnswer);

        return finalAnswer;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {

        FractionImpl fractionNo = new FractionImpl(this.numerator, this.denominator);

        if (fractionNo.numerator < 0) {
            fractionNo.numerator *= -1;
        }

        return fractionNo;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {

        FractionImpl fractionNo = new FractionImpl(this.numerator, this.denominator);

        fractionNo.numerator *= -1;

        return fractionNo;

    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {

        if ( obj instanceof Fraction) { // check if object being passed through is a Fraction
            FractionImpl fractionNo = (FractionImpl) obj;
            if (this.numerator == fractionNo.numerator && this.denominator == fractionNo.denominator ) { // next check numerator and denominator are equal
                return true;
            }
        }

        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {

       FractionImpl fraction = new FractionImpl(this.numerator, this.denominator);

       fraction.numerator = this.denominator;
       fraction.denominator = this.numerator;

        if (fraction.denominator < 0) { // edge case for inverting negative fractions
            fraction.numerator *= -1;
            fraction.denominator *= -1;
        } else if (fraction.denominator == 0) { //edge case if denominator becomes 0
            throw new ArithmeticException("Divide by zero");
        }

       return fraction;

    }

    @Override
    public int compareTo(Fraction o) {

        FractionImpl compareFrac = (FractionImpl) o;
        double compareFractionValue = (double) compareFrac.numerator / (double) compareFrac.denominator;
        double thisFractionValue = (double) this.numerator / (double) this.denominator;

        if (this.numerator == compareFrac.numerator && this.denominator == compareFrac.denominator) {
            return 0; // returns 0 if both fraction is equal
        }

        else if (thisFractionValue < compareFractionValue) { // returns negative if this value less then fraction
            return -1;
        }

        return 1; // returns positive number if this value greater then fraction

    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        String answer = "";

        if (this.denominator == 1) {
            answer = "" + this.numerator;
        } else {
            answer = this.numerator + "/" + this.denominator;
        }

        return answer;
    }
}

