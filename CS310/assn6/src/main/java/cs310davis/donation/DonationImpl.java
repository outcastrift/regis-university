package cs310davis.donation;


import java.util.Map;
import java.util.TreeMap;


/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * This class is a implementation class to access the Donation Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 * <p>
 * This is the primary class for interacting with the Donation Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 *
 * @author Samuel Kyle Davis
 */
public class DonationImpl {
  private  static TreeMap<Integer, Donation> donations = new TreeMap<Integer, Donation>();

  /**
   * Default Constructor
   */
  public DonationImpl() {

  }


  public void addDonation(Donation donation){
    donations.put(donation.getDonationId(),donation);
  }


  /**
   * Method to check if a Donation ID is unique IE has not already been used.
   *
   * @param donationId the donation id to check
   * @return true if donation id has not been used previously false otherwise.
   */
  public boolean isIdUnique(int donationId) {
    boolean isUnique = true;
    for(Map.Entry<Integer,Donation> entry : donations.entrySet()) {
      Integer key = entry.getKey();
      if(key == donationId){
        isUnique =false;
      }
    }
    return isUnique;
  }

  /**
   * Add donation to the database..
   *
   * @param obj the obj must be of type Donation
   * @return false if unsuccessful
   */
  public boolean add(Object obj) {
    boolean added = true;
    if (obj instanceof Donation) {
      Donation donation = (Donation) obj;
      addDonation(donation);
    }else {
      System.out.println("ERROR :: Object supplied was not of type Donation. ");
      added = false;
    }
    return added;
  }

  /**
   * Remove donations with donorId from list and return true if successful.
   *
   * @param donorId donor id
   * @return false if nothing was deleted, true if anything was removed for the supplied donor id.
   */
  public static boolean removeDonationByDonorId(int donorId){
    boolean isRemoved = false;
    for(Map.Entry<Integer,Donation> entry : donations.entrySet()) {
      Integer key = entry.getKey();
      Donation value = entry.getValue();
      if(value.getDonorId().equals(donorId)){
        donations.remove(key, value);
        isRemoved =true;
      }
    }
    return isRemoved;
  }

  /**
   * Remove donations with donationId from list and return true if successful.
   *
   * @param donationId donor id
   * @return false if nothing was deleted
   */
  public boolean removeDonationByDonationId(int donationId){
    boolean isRemoved = false;
    for(Map.Entry<Integer,Donation> entry : donations.entrySet()) {
      Integer key = entry.getKey();
      Donation value = entry.getValue();
      if(value.getDonationId().equals(donationId)){
        donations.remove(key, value);
        isRemoved =true;
      }
    }
    return isRemoved;
  }
  /**
   * Method to get a single donation specified by
   * @param donationId the ID of the donation to return.
   * @return the Donation specified by the DonationId.
   * **/
  public Donation getDonationById(Integer donationId) {
    return donations.get(donationId);
  }
  /**
   * Method to traverse the entire database of Donations and print them in ascending order.
   * The order defaults to lowest number of donationId to highest number of DonationId, so least to greatest.
   * **/
  public void traverseTreeInOrder(){
    System.out.println("Beginning to Traverse the Donation Tree \nDonation List:\n");
    for(Map.Entry<Integer,Donation> entry : donations.entrySet()) {
      Integer key = entry.getKey();
      Donation value = entry.getValue();
     System.out.println(value.toString());
    }
  }
}

