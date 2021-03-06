package cs310davis.donation;

/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * The purpose of this class is to be the primary data structure for a Singly Linked List of Donation objects.
 * This class will keep reference to the next DonationNode in the List.
 * The last DonationNode within the List will return null on the getNext() signifying the end of the list.
 *
 * @author Samuel Kyle Davis
 */
public class DonationNode {

  private Donation donation;
  private DonationNode next;

  /**
   * Public DonationNode constructor.
   *
   * @param donation a Donation object to add to the Linked List
   * @param next     a DonationNode object to store reference to, in the case where one does not exist pass in null.
   */
  public DonationNode(Donation donation, DonationNode next) {
    this.donation = donation;
    this.next = next;
  }


  /**
   * Returns the Donation stored within this DonationNode.
   *
   * @return the donation
   */
  public Donation getDonation() {
    return donation;
  }

  /**
   * Sets the Donation stored within this DonationNode.
   *
   * @param donation The Donation object to be stored within this DonationNode.
   */
  public void setDonation(Donation donation) {
    this.donation = donation;
  }

  /**
   * Returns a reference to the next DonationNode within the List.
   *
   * @return the next
   */
  public DonationNode getNext() {
    return next;
  }

  /**
   * Sets the reference to the next DonationNode within the list.
   * In the case where you have created your first node with null,
   * you must call this method in order for the list to function.
   *
   * @param next The next DonationNode within the List.
   */
  public void setNext(DonationNode next) {
    this.next = next;
  }

  /**
   * Check to see if the DonationNode has a next element.
   *
   * @return true or false
   */
  public boolean hasNext() {
    return (this.next != null);
  }

}
