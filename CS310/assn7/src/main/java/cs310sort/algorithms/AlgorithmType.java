package cs310sort.algorithms;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply. Enum Description This Enum is used
 * to differentiate between all the different sort types.
 *
 * @author Samuel Kyle Davis
 */
public enum AlgorithmType {
  BUBBLE_SORT("BubbleSort"),
  INSERTION_SORT("InsertionSort"),
  QUICK_SORT("QuickSort");

  private String name;

  /**
   * Public constructor.
   * @param name the name of the type.
   * **/
  private AlgorithmType(String name) {
    this.name = name;
  }

  /**
   * Returns the type of this Algorithm.
   * **/
  public String getValue() {
    return name;
  }
}
