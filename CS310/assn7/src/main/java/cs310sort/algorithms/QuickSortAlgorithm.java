package cs310sort.algorithms;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply. Class Description
 *
 * <p>Quicksort or partition-exchange sort, is a fast sorting algorithm, which is using divide and
 * conquer algorithm. Quicksort first divides a large list into two smaller sub-lists: the low
 * elements and the high elements. Quicksort can then recursively sort the sub-lists.
 *
 * @author Samuel Kyle Davis
 */
public class QuickSortAlgorithm extends SortAlgorithm {
  /**
   * {@inheritDoc}
   */
  @Override
  protected void performSorting(Integer[] array) {
    quicksort(array, 0, array.length - 1);
  }



  private void quicksort(Integer[] array, Integer left, Integer right) {
    if (left < right) {
      int pivot = partition(array, left, right);
      if (left < pivot - 1) {
        quicksort(array, left, pivot - 1);
      }
      if (pivot + 1 < right) {
        quicksort(array, pivot + 1, right);
      }
    }
  }


  private int partition(Integer[] array, Integer left, Integer right) {
    int pivotIndex = (right + left) / 2;
    int pivotValue = array[pivotIndex];

    swap(array, right, pivotIndex);
    int storeIndex = left;

    for (int i = left; i < right; ++i) {
      if (less(array[i], pivotValue)) {
        swap(array, i, storeIndex);
        ++storeIndex;
      }
    }

    swap(array, right, storeIndex);

    return storeIndex;
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public AlgorithmType getType() {
    return AlgorithmType.QUICK_SORT;
  }
}
