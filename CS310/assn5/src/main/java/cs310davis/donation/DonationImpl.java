package cs310davis.donation;


import java.util.Iterator;

import cs310davis.CharityConstants;

/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 *
 * This class is a implementation class to access the Donation Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 * <p>
 * This is the primary class for interacting with the Donation Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 *
 * @author Samuel Kyle Davis
 */
public class DonationImpl {
  private final DonationMapEntry[] donations = new DonationMapEntry[CharityConstants.DONOR_MAX_CAPACITY];

  /**
   * Default Constructor
   */
  public DonationImpl() {

  }

  /**
   * Put an entry in the map.
   *
   * @param entry A DonationMapEntry
   */
  public void put(DonationMapEntry entry) {
    boolean isPut = false;
    DonationMapEntry donationEntry = null;
    DonationNode donationNode = null;

    if (entry != null) {

      for (int i = 0; i < this.donations.length && !isPut; i++) {
        donationEntry = this.donations[i];

        if (donationEntry == null) {
          this.donations[i] = entry;
          isPut = true;
        } else {
          if (donationEntry.getHash() == entry.getHash()) {
            donationNode = donationEntry.getValue();
            while (donationNode.hasNext()) {
              donationNode = donationNode.getNext();
            }
            donationNode.setNext(entry.getValue());
            isPut = true;
          }
        }
      }
    }
  }


  private int computeHash(Integer id) {
    String idStr = null;
    int theHash = 0;

      if (id != null) {
        idStr = String.valueOf(id);

        for (int i = 0; i < idStr.length(); i++) {
          theHash += idStr.charAt(i);
        }

        theHash = theHash % CharityConstants.DONATION_MAX_CAPACITY;
      }
    return theHash;
  }

  /**
   * Get the DonationMapEntry for a specified key.
   *
   * @param key the hash value
   * @return A DonationMapEntry
   */
  public DonationMapEntry get(int key) {
    DonationMapEntry entry = null;
    DonationMapEntry found = null;

    for (int i = 0; i < this.donations.length && (found == null); i++) {
      entry = this.donations[i];
      if (entry != null && entry.getHash() == key) {
        found = entry;
      }
    }

    return found;
  }

  public Donation getDonationById(int donationId){
    Donation result = null;
    DonationMapEntry donationMapEntry = get(computeHash(donationId));
    if(donationMapEntry != null){
      DonationNode donationNode = donationMapEntry.getValue();
      Donation dn = null;
      while(donationNode !=null && result == null){
        dn = donationNode.getDonation();
        if(dn.getDonationId() == donationId){
          result = dn;
        }
        donationNode = donationNode.getNext();

      }
    }
    return result;
  }


  /**
   * Is id unique boolean.
   * Tests if  a donation with id exists in the database.
   *
   * @param donationId the donation id
   * @return the boolean
   */

  public boolean isIdUnique(int donationId) {
    /*boolean isUnique =false;
    if(donations){

    }

    if(getDonationById(donationId) != null){
      isUnique =true;
    }*/


    return (getDonationById(donationId) == null);
  }

  /**
   * Add donation to the database..
   *
   * @param obj the obj
   * @param obj must be of type Donation otherwise method returns false.
   * @return false if unsuccessful
   */

  public boolean add(Object obj) {
    boolean added = true;
    if (obj instanceof Donation) {
      Donation donation = (Donation) obj;
      put(new DonationMapEntry(new DonationNode(donation,null)));

    }else {
      added = false;
    }
    return added;
  }

  /**
   * Remove donations with donorId from list and return true if successful.
   *
   * @param donorId donor id
   * @return false if nothing was deleted
   */
  public Donation removeDonationById(int donorId){
    boolean isRemoved = false;
    Donation result = null;
    for(DonationMapEntry donationMapEntry : donations){
      DonationNode  donationNode= donationMapEntry.getValue();
      Donation dn = null;
      DonationNode previous = null;

      while(donationNode != null && !isRemoved){
        dn = donationNode.getDonation();
        if(dn.getDonorId() == donorId){
          if(previous != null){
            previous.setNext(donationNode.getNext());
          }
        }
        previous = donationNode;
        donationNode = donationNode.getNext();
      }
    }

    DonationMapEntry donationMapEntry = get(computeHash(donationId));
    if(donationMapEntry != null){
      DonationNode donationNode = donationMapEntry.getValue();
      Donation dn = null;
      while(donationNode !=null && result == null){
        dn = donationNode.getDonation();
        if(dn.getDonationId() == donationId){
          result = dn;
        }
        donationNode = donationNode.getNext();

      }
    }
    return result;
  }

}
