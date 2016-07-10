package com.davis;

import java.util.ArrayList;

/**
 * This class is a implementation class to access the Donor Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 *
 * This is the primary class for interacting with the Donor Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 * @author Samuel Kyle Davis
 */

public class DonorLogImpl {

    /**
     * The Donor Database.
     * A arraylist ordered by donor id.
     */

    private ArrayList<Donor> donorArray = new ArrayList<Donor>();


    /**
     * Gets the Donor Database.
     *
     * @return Donor Database
     */
// return the ArrayList attribute
    public ArrayList<Donor> getDonorList() {
        return this.donorArray;
    }

    /**
     * Add a entry to the Donor database
     * @param obj the obj
     *            obj must be of type Donor otherwise this method will print a error and exit.
     */
// add donor to ordered list
    public void add(Object obj) {
        Donor donor = null;
        try{
            donor   = (Donor) obj;
        }catch(ClassCastException e){
            System.out.println("ERROR : Unable to add Donor to the Donor List.  Object was not of type donor. ");
            return;
        }
        Donor dd= null;
        if(!donorArray.isEmpty()){
            for (int i = 0; i < donorArray.size(); i++) {
                dd = donorArray.get(i);
                if (donor.getDonorId() > dd.getDonorId()) {
                    donorArray.add(i + 1, donor);
                    break;
                }
            }
        }else{
            donorArray.add(donor);
        }


    }


    /**
     * Remove a specified donor from the database..
     *
     * @param donorId the donor id
     * @return true if successful
     *          false otherwise
     */
    // remove donor with donorId from list
    // and return true if successful
    public boolean remove(int donorId) {
        try {
            donorArray.remove(donorId);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: Unable to remove Donor from the List \n " + e.getMessage());
            return false;
        }
    }

    /**
     * Determines if a Donor with the specified ID already exists within the database.
     *
     * @param id the donor id to check
     *@return true if the specified ID does not exist in the database.
     *          false otherwise
     */
    public boolean isIdUnique(int id) {

            for(Donor d : donorArray){
                if (d.getDonorId()==id) {
                    return false;

                }
            }
        return true;
    }

}
