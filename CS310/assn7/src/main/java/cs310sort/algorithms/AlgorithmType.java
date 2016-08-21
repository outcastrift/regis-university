package cs310sort.algorithms;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply. Enum Description This Enum is used
 * to differentiate between all the different sort types.
 *
 * @author Samuel Kyle Davis
 */
public enum AlgorithmType {
  BUBBLE_SORT("Bubble sort"),
  INSERTION_SORT("Insertion sort"),
  MERGE_SORT("Merge sort"),
  QUICK_SORT("Quick sort"),
  SELECTION_SORT("Select sort");

  private String name;

  private AlgorithmType(String name) {
    this.name = name;
  }

  public String getValue() {
    return name;
  }
}
