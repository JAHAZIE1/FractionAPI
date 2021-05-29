import fraction.*;
import java.io.*;
import java.util.*;

/* This program will take an input of two fractions
provide a choice to add, subtract or multiply the two fractions.
Then prints out lowest term for each input and the answer.
 */


public class Main {

    public static void main(String[] args) {
        System.out.print("Enter 1st fraction or whole number: ");
        Scanner firstInput = new Scanner(System.in);
        String firstFraction = firstInput.next();

        System.out.print("Enter 2nd fraction or whole number: ");
        Scanner secondInput = new Scanner(System.in);
        String secondFraction = secondInput.next();

        System.out.print("Enter either ADD, SUBTRACT or MULTIPLY: ");
        Scanner finalInput = new Scanner(System.in);
        String method = finalInput.next();
        System.out.println("");

        FractionImpl fractionOne = new FractionImpl(firstFraction);
        FractionImpl fractionTwo = new FractionImpl(secondFraction);
        FractionImpl fractionAnswer = null;

        if (method.equals("ADD") | method.equals("add") | method.equals("Add") ) {
            fractionAnswer = (FractionImpl) fractionOne.add(fractionTwo);
        } else if (method.equals("SUBTRACT") | method.equals("subtract") | method.equals("Subtract") ) {
            fractionAnswer = (FractionImpl) fractionOne.subtract(fractionTwo);
        } else if (method.equals("MULTIPLY") | method.equals("multiply") | method.equals("Multiply")) {
            fractionAnswer = (FractionImpl) fractionOne.multiply(fractionTwo);
        } else {
            System.out.println("Error with input. Restart again.");
            System.exit(0);
        }

        System.out.print("Lowest term for 1st fraction: ");
        System.out.println(fractionOne.toString());
        System.out.print("Lowest term for 2nd fraction: ");
        System.out.println(fractionTwo.toString());

        System.out.print("Answer: ");

        System.out.println(fractionAnswer.toString());


    }

}
