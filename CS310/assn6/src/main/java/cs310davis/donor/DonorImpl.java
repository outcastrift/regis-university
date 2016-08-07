package cs310davis.donor;


/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * This class is a implementation class to access the Donor Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 * <p>
 * This is the primary class for interacting with the Donor Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 *
 * @author Samuel Kyle Davis
 */
public class DonorImpl {

  /**
   * The Donor Database.
   *
   */

  private DonorBinaryTree donorBinaryTree = new DonorBinaryTree();

  /**
   * Gets the Donor Database.
   *
   * @return Donor Database
   */
  // return the ArrayList attribute
  public DonorBinaryTree getDonorBinaryTree() {
    return this.donorBinaryTree;
  }

  /**
   * Add a entry to the Donor database at the appropriate position.
   *
   * @param obj the obj obj must be of type Donor otherwise this method will print a error and exit.
   */
  // add donor to ordered linked list
  public void add(Object obj) {
    Donor donor = null;
    try {
      donor = (Donor) obj;
    } catch (ClassCastException e) {
      System.out.println("ERROR : Unable to add Donor to the Donor List.  Object was not of type donor. ");
      return;
    }
    donorBinaryTree.addNode(donor);
  }



  /**
   * Determines if a Donor with the specified ID already exists within the database.
   *
   * @param id the donor id to check
   * @return true if the specified ID does not exist in the database. false otherwise
   */
  public boolean isIdUnique(int id) {
    boolean isUnique = true;

    if(donorBinaryTree.getRootOfTree() != null){
      if(donorBinaryTree.findDonorInTree(id) != null){
        //Donor with specified ID was already added to the database.
        isUnique =false;
      }
    }


    return isUnique;
  }

  /**
   * Method to get specified donor from the list.
   *
   * @param donorID the donor id
   * @return the donor
   */
  public Donor getDonor(Integer donorID) {

    return donorBinaryTree.findDonorInTree(donorID).getDonor();
  }

  /**
   * Remove a specified donor from the database..
   *
   * @param donorId the donor id
   * @return true if successful false otherwise
   */
  // remove donor with donorId from list
  // and return true if successful
  public boolean remove(int donorId) {

    return donorBinaryTree.remove(donorId);
  }


}
