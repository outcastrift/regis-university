package cs310sort;

import cs310sort.algorithms.InsertionSortAlgorithm;
import cs310sort.results.Speed;
import org.junit.Assert;
import org.junit.Test;


/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 *
 * @author Samuel Kyle Davis
 **/
public class InsertionSortTest extends BaseSortTest {


    @Test
    public void testSelectionSort(){
        Integer[] dataSet = populateArray(50);
        InsertionSortAlgorithm algorithm = new InsertionSortAlgorithm();

        Speed run1 = algorithm.sort(dataSet);

        System.out.println("Run 1 " + String.valueOf(run1.getTime()));
        printArray(dataSet);
        Assert.assertTrue(isSorted(dataSet));

    }



}
