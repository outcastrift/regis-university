package cs310sort.algorithms;

import cs310sort.results.Speed;
import cs310sort.results.SpeedBuilder;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong
 * to Samuel Davis appropriate licenses and restrictions apply.
 * Class Description
 * Abstract class that encompasses a SortAlgorithm.
 *
 * @author Samuel Kyle Davis
 */
public abstract class SortAlgorithm {

  private long startTime;
  private long endTime;

  protected abstract void doSort(Integer[] array);

  public abstract AlgorithmType getType();

  public Speed sort(Integer[] array) {
    startTime = endTime = 0; //swaps = comparisons = 0;
    startTime = System.nanoTime();
    doSort(array);
    endTime = System.nanoTime();

    return calcSpeed();
  }

  private Speed calcSpeed() {
    return SpeedBuilder.newInstance()
        .setAlgorithmType(getType())
        .setTime(endTime - startTime)
        .build();
  }

  protected void swap(Integer[] array, Integer i, Integer j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  protected boolean less(Integer a1, Integer a2) {
    return a1 < a2;
  }
}
