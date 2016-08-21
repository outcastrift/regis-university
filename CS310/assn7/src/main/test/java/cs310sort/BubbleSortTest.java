package cs310sort;

import cs310sort.algorithms.BubbleSortAlgorithm;
import cs310sort.results.Speed;
import org.junit.Test;
import org.junit.*;


/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 *
 * @author Samuel Kyle Davis
 **/
public class BubbleSortTest extends BaseSortTest {


    @Test
    public void testBubbleSort(){
        Integer[] dataSet = populateArray(50);
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();


        Speed run1 = bubbleSortAlgorithm.sort(dataSet);

        System.out.println("Run 1 " + String.valueOf(run1.getTime()));
        printArray(dataSet);
        Assert.assertTrue(isSorted(dataSet));

    }



}
