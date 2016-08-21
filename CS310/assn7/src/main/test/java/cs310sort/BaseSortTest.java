package cs310sort;

import org.junit.Before;

import java.util.Random;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * Base Sort Testing Class providing methods for use to everything else in the test suite.
 * @author Samuel Kyle Davis
 **/
public class BaseSortTest {

    private static Random random = new Random();


    public static Integer[] populateArray(int numElements){
        Integer[] intArray = new Integer[numElements];

        for (Integer i = 0; i < numElements; i++){
            intArray[i] = random.nextInt(100000);
        }
        return intArray;

    }

    protected boolean isSorted(Integer[] array) {
        boolean sorted = true;
        for (Integer i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
                sorted =false;
                break;
            }
        }

        return sorted;
    }
    protected void  printArray(Integer[] dataSet){
        System.out.println("Printing Array ");

        for(int i =0; i < dataSet.length; i++){
            System.out.println("Item Number ["+String.valueOf(i)+"] = ["+String.valueOf(dataSet[i]) + "]" );
        }
    }
}
