package cs310sort.algorithms;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply. Class Description To sort unordered
 * list of elements, we remove its entries one at a time and then insert each of them into a sorted
 * part which is initially empty.
 *
 * @author Samuel Kyle Davis
 */
public class InsertionSortAlgorithm extends SortAlgorithm {

  @Override
  public void doSort(Integer[] array) {
    for (int i = 1; i < array.length; ++i) {
      int j = i;
      while (j > 0 && less(array[j], array[j - 1])) {
        swap(array, j, j - 1);
        --j;
      }
    }
  }

  @Override
  public AlgorithmType getType() {
    return AlgorithmType.INSERTION_SORT;
  }
}
