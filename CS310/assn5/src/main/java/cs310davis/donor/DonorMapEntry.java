package cs310davis.donor;

/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 *
 * Class Description
 *
 * This class represents the Donor Hash Map Database
 *
 * @author Samuel Kyle Davis
 */
public class DonorMapEntry {
  private int currentSize, maxSize;
  private Integer[] hashedDonorIds;
  private Donor[] donorValues;

  /**
   * Instantiates a new Map entry.
   *
   * @param capacity the capacity
   */
  public DonorMapEntry(int capacity) {
    currentSize = 0;
    maxSize = capacity;
    hashedDonorIds = new Integer[maxSize];
    donorValues = new Donor[maxSize];
  }

  /**
   * Make empty.
   */
  public void makeEmpty() {
    currentSize = 0;
    hashedDonorIds = new Integer[maxSize];
    donorValues = new Donor[maxSize];
  }

  /**
   * Is full boolean.
   *
   * @return the boolean
   */
  public boolean isFull() {
    return currentSize == maxSize;
  }

  /**
   * Is empty boolean.
   *
   * @return the boolean
   */
  public boolean isEmpty() {
    return getSize() == 0;
  }

  /**
   * Gets size.
   *
   * @return the size
   */
  public int getSize() {
    return currentSize;
  }

  /**
   * Remove.
   *
   * @param key the key
   */
  public boolean remove(Integer key) {
    boolean wasRemoved = false;
    if (contains(key)) {
      /** find position key and delete **/
      int i = hash(key);
      while (!key.equals(hashedDonorIds[i]))
        i = (i + 1) % maxSize;
      hashedDonorIds[i] = null;
      donorValues[i] = null;

      /** rehash all hashedDonorIds **/
      for (i = (i + 1) % maxSize; hashedDonorIds[i] != null; i = (i + 1) % maxSize) {
        Integer tmp1 = hashedDonorIds[i];
        Donor tmp2 = donorValues[i];
        hashedDonorIds[i] = null;
        donorValues[i] = null;
        currentSize--;
        insert(tmp1, tmp2);
      }
      wasRemoved = true;
      currentSize--;
    }
    return wasRemoved;
  }

  /**
   * Contains boolean.
   *
   * @param key the key
   * @return the boolean
   */
  public boolean contains(Integer key) {
    return get(key) != null;
  }

  private int hash(Integer key) {
    return key.hashCode() % maxSize;
  }

  /**
   * Insert.
   *
   * @param key the key
   * @param val the val
   */
  public void insert(Integer key, Donor val) {
    int tmp = hash(key);
    int i = tmp;
    do {
      if (hashedDonorIds[key] == null) {
        hashedDonorIds[key] = key;
        donorValues[key] = val;
        currentSize++;
        return;
      }
      if (hashedDonorIds[key].equals(key)) {
        donorValues[key] = val;
        return;
      }
      i = (i + 1) % maxSize;
    } while (i != tmp);
  }

  /**
   * Get string.
   *
   * @param key the key
   * @return the string
   */
  public Donor get(Integer key) {
    int i = hash(key);
    while (hashedDonorIds[i] != null) {
      if (hashedDonorIds[i].equals(key))
        return donorValues[i];
      i = (i + 1) % maxSize;
    }
    return null;
  }

  /**
   * Print hash table.
   */
  public void printHashTable() {
    System.out.println("\nHash Table: ");
    for (int i = 0; i < maxSize; i++)
      if (hashedDonorIds[i] != null)
        System.out.println(hashedDonorIds[i] + " " + donorValues[i]);
    System.out.println();
  }
}
