package com.davis;

import com.sun.istack.internal.Nullable;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.*;

/**
 * Created by Sam on 29-May-16.
 */
public class mt310 {
    /**
     * Notes for How to determine if a set of points is a function, onto, one to one, domain or range
     * Lets just always assume that A  = the domain and that B = the range
     * its a function if every element from a maps to b so if f(x) = some element in B then we are good
     * its onto if everything in b maps to a so basically if a and b are arrays then a and b must be the same size for this to be true.
     * its only one to one if everything inside the domain UNIQUELY matches to something in the range
     * <p>
     * Range  = All of the output of the function that is within the coDomain Y
     * Image of F = All of the output of the function
     * X = the Pre Image
     * Y = the Range in a perfect world or the image
     **/


    public static void main(String[] args) {
      executeWeek5(args);
    }

    private static void executeWeek5(String[] args){
        findSumOfPositiveIntegers(10);
    }

    private static void executeWeek4(String[] args){
        ExpressionBuilder expressionBuilder = new ExpressionBuilder("x * x");
        expressionBuilder.variable("x");
        Expression expression = expressionBuilder.build();
        ArrayList<Integer> domain = populateDomain(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ArrayList<Integer> coDomain = populateCoDomain(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        boolean[] results = isFunction_OrOnto_OrOneToOne(domain, coDomain, expression);
        System.out.println("Is a Function = " + results[0]);
        System.out.println("Is Onto = " + results[1]);
        System.out.println("Is One to One= " + results[2]);
        System.out.println("Execution Finished ::Exiting");

    }

    private static ArrayList<Integer> populateDomain(Integer... elements) {
        ArrayList<Integer> domain = new ArrayList<>();
        for (Integer i : elements) {
            domain.add(i);
        }
        return domain;
    }

    private static ArrayList<Integer> populateCoDomain(Integer... elements) {
        ArrayList<Integer> coDomain = new ArrayList<>();
        for (Integer i : elements) {
            coDomain.add(i);
        }
        return coDomain;
    }

    /**
     * f maps x (which is some element in X) to y (which is some element in Y)
     *
     * @param function CAN BE NULL
     *                 the function to perform. Heavily using the net.objecthunter.exp4j library here.
     *                 If this is passed in as null only value checks against the arrays will be performed which is extremely basic.
     *                 IE. its a function if everything in domain maps to codomain
     *                 IE. its onto if everything in the codomain maps to the domain (if the arrays are the same size)
     *                 IE. its one-to-one if everything in the domain UNIQUELY maps to the codomain, meaning the raw value only appears once.
     * @param domain   A finite set of integers.
     * @param coDomain A finite set of integers.
     * @return will return a boolean array where
     * results[0] = if function
     * results[1] = if onto
     * results[2] = if one to one
     **/
    private static boolean[] isFunction_OrOnto_OrOneToOne(ArrayList<Integer> domain, ArrayList<Integer> coDomain, @Nullable Expression function) {
        //create result array
        boolean[] results = new boolean[3];
        //determine if a function
        results[0] = isFunction(domain, coDomain);
        if (function == null) {
            //determine if onto
            results[1] = isOnto(domain, coDomain);

        }
        results[1] = true;
        // determine if one to one
        results[2] = isOneToOne(domain, coDomain);

        int size = domain.size();

        //creating a complimentary boolean array to store variables
        ArrayList<Boolean> booleanArray = new ArrayList<Boolean>();
        //Initialize the booleanArray
        for (int i = 0; i < size; i++) {
            booleanArray.add(i, false);
        }


        //determine if onto
        for (int i = 0; i < size; i++) {

            if (coDomain.contains(performFunction(function, domain.get(i)))) {
                booleanArray.set(i, true);
            } else {
                booleanArray.set(i, false);
            }
        }
        //Check entire booleanArray to see if any element is false
        // I it is, exit the loop and return false
        for (Boolean checkForResult : booleanArray) {
            if (!checkForResult) {
                //If there is any element within the array that is false then we set result to false.
                results[1] = false;
            }
        }

        return results;

    }

    private static Integer performFunction(Expression function, Integer value) {
        int holder = value;
        double passThrough = (double) holder;
        function.setVariable("x", passThrough);
        Double result = function.evaluate();

        System.out.println("Computation performed = f(x)=x^2" + "\n Result = " + result);
        return result.intValue();
    }

    private static boolean isOnto(ArrayList<Integer> domain, ArrayList<Integer> range) {
        boolean result = true;
        if (domain.size() == range.size()) {
            //do nothing already set to true
        } else {
            result = false;
        }
        return result;
    }

    private static boolean isFunction(ArrayList<Integer> domain, ArrayList<Integer> range) {
        boolean result = true;
        for (Integer a : domain) {
            if (range.contains(a * a)) {
                //do nothing already set to true
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isOneToOne(ArrayList<Integer> domain, ArrayList<Integer> range) {
        boolean result = true;
        ArrayList<Integer> ranged = new ArrayList<Integer>();

        for (int i = 0; i < range.size(); i++) {
            int element = range.get(i);
            if (ranged.contains(element)) {
                result = false;
                break;
            } else {
                ranged.add(element);
            }

        }
        return result;


    }

    private static void findMinAndMax() {
        int finiteSequenceOfIntegers[] = new int[]{79, 101, 87, 29, 2, 310, 42, 3, 18, 999};

        //Assign the first element of the array to both min and max.
        int min = finiteSequenceOfIntegers[0];
        int max = finiteSequenceOfIntegers[0];

 /* Loop through the entirety of the array and if the element we are currently on is greater than max, we set max to the element. If the element we are on is less than min we set min to the value of the element. */

        for (int i = 1; i < finiteSequenceOfIntegers.length; i++) {
            if (finiteSequenceOfIntegers[i] > max)
                max = finiteSequenceOfIntegers[i];
            else if (finiteSequenceOfIntegers[i] < min)
                min = finiteSequenceOfIntegers[i];

        }
        System.out.println("Largest Integer in the Sequence is : " + max);
        System.out.println("Smallest Integer in the Sequence is : " + min);
    }

    private static Integer findSumOfPositiveIntegers(int n){
        Integer sum = 0;
        System.out.println("Begin to calculate the sum of the first "+ String.valueOf(n) + "positive integers.");
        if(n ==1){
            System.out.println("The number 1 was provided to the method, which result in the sum being 1 \n returning sum of 1" );

            sum =1;
        }else{

            int positiveInteger =1;
           while(n > 0){
               System.out.println("The number of remaining integers to add = "+String.valueOf(n));
               sum = sum + positiveInteger;
               System.out.println("Adding the  = "+String.valueOf(positiveInteger) + " to sum  \n "+ "New Value of Sum = "+String.valueOf(sum) );

               positiveInteger = positiveInteger +1;
               n = n-1;
           }
        }

        return sum;
    }


}
