package cs310sort.algorithms;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply. Class Description The algorithm
 * works by comparing each item in the list with the item next to it, and swapping them if required.
 * In other words, the largest element has bubbled to the top of the array. The algorithm repeats
 * this process until it makes a pass all the way through the list without swapping any items.
 * O(n2) algorithm
 * @author Samuel Kyle Davis
 */
public class BubbleSortAlgorithm extends SortAlgorithm {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void performSorting(Integer[] array) {
    for (int i = 0; i < array.length; ++i) {
      boolean swapFlag = false;
      for (int j = 0; j < array.length - i - 1; ++j) {
        if (less(array[j + 1], array[j])) {
          swap(array, j, j + 1);
          swapFlag = true;
        }
      }
      if (!swapFlag) {
        break; // nothing was changed, so we have sorted array
      }
    }
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public AlgorithmType getType() {
    return AlgorithmType.BUBBLE_SORT;
  }
}
