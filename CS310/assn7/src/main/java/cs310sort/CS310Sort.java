package cs310sort;

import java.util.ArrayList;
import java.util.Random;

import cs310sort.algorithms.BubbleSortAlgorithm;
import cs310sort.algorithms.InsertionSortAlgorithm;
import cs310sort.algorithms.QuickSortAlgorithm;
import cs310sort.results.ResultPrinter;
import cs310sort.results.Speed;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply. Class Description
 *
 * @author Samuel Kyle Davis
 */
public class CS310Sort {

  private static ResultPrinter resultPrinter = new ResultPrinter();
  private static BubbleSortAlgorithm bubble = new BubbleSortAlgorithm();
  private static InsertionSortAlgorithm insertion = new InsertionSortAlgorithm();
  private static QuickSortAlgorithm quick = new QuickSortAlgorithm();

  /** Datasets for use in testing the algorithms.* */
  private static int numElements = 50000;

  private static Random random = new Random();



  private static ArrayList<ArrayList<Speed>> results = new ArrayList<ArrayList<Speed>>();

  public static void main(String[] args) {
    runAlgorithmTests();
  }

  private static void runAlgorithmTests() {
    testRun(1);
    testRun(2);
    testRun(3);
    printResults();
  }
  /**
   * Method to print results to the specified output file.
   * **/
  private static void printResults(){
    resultPrinter.printResults("sortResults.txt",results);

  }

  /**
   * Method to perform a test run with a specified run number.
   * @param runNumber the number of the run.
   *
   * **/
  private static void testRun(int runNumber){
    ArrayList<Speed> speedsForAlgos = new ArrayList<Speed>();
    //populate arrays for test run
    Integer[] dataSetOne = populateArray(numElements);
    Integer[] dataSetTwo = populateArray(numElements);
    Integer[] dataSetThree = populateArray(numElements);

    System.out.println("Starting Sort Run #"+String.valueOf(runNumber));
    //add the speed results to the test run result array
    Speed bubbleSpeed = bubble.sort(dataSetOne);
    System.out.println("BubbleSort Speed =[ "+bubbleSpeed.getTime()+" ]");
    speedsForAlgos.add(bubbleSpeed);
    validOrInvalidMessage("BubbleSort",dataSetOne);

    System.out.println();

    Speed insertSpeed = insertion.sort(dataSetTwo);
    System.out.println("Insertion Sort Speed =[ "+insertSpeed.getTime()+" ]");
    speedsForAlgos.add(insertSpeed);
    validOrInvalidMessage("InsertionSort",dataSetTwo);

    System.out.println();

    Speed quickSpeed = quick.sort(dataSetThree);
    System.out.println("QuickSort Sort Speed =[ "+quickSpeed.getTime()+" ]");
    speedsForAlgos.add(quickSpeed);
    validOrInvalidMessage("QuickSort",dataSetThree);
    System.out.println();


    //add the test run result array to the main results array
    results.add(runNumber - 1, speedsForAlgos);

    System.out.println("Sort Run #"+String.valueOf(runNumber)+ " successfully completed.");
    System.out.println();



  }

  /**
   * Simple method to determine if the sorting was accurate or inaccurate and print
   * a message determining whether it was or wasn't.
   * @param sortType type of Sortign Algorithm used.
   * @param dataSet the set of data to be validated.
   * **/
  private static void validOrInvalidMessage(String sortType, Integer[] dataSet){
    if(isSorted(dataSet)){
      System.out.println(sortType +" was validated and determined to be correct. ");
    }else{
      System.out.println("ERROR :: "+ sortType+" results failed validation, program will now exit.");
      System.exit(1);
    }
  }


  /**
   * Method to determine if the array was sorted correctly.
   * **/
  private static boolean isSorted(Integer[] array) {
    boolean sorted = true;
    for (Integer i = 0; i < array.length - 1; ++i) {
      if (array[i] > array[i + 1]) {
        sorted =false;
        break;
      }
    }

    return sorted;
  }


  /**
   * Convenience method to create a array with a specified number of elements and then populate with
   * random integers. *
   */
  private static Integer[] populateArray(int numElements) {
    Integer[] intArray = new Integer[numElements];

    for (Integer i = 0; i < numElements; i++) {
      intArray[i] = random.nextInt(100000);
    }
    return intArray;
  }
}
