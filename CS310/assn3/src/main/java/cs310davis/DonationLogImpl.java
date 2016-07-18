package cs310davis;

import java.util.LinkedList;

/**
 * This class is a implementation class to access the Donation Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 * <p>
 * This is the primary class for interacting with the Donation Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 *
 * @author Samuel Kyle Davis
 */
public class DonationLogImpl {

    /**
     * The Donation Database.
     */
    private LinkedList<Donation> donationLinkedList = new LinkedList<Donation>();


    /**
     * Get donation database as array list.
     *
     * @return the donation database
     */
    public LinkedList<Donation> getDonationList() {
        // return the ArrayList attribute
        return this.donationLinkedList;

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
            donationLinkedList.add(donation);

        } else {
            added = false;
        }
        return added;
    }

    /**
     * Remove donations with donorId from list and return true
     *
     * @param donorId the donor id
     * @return false if nothing was deleted
     */
    public boolean remove(int donorId) {
        boolean result = false;
        try {
            for (Donation dn : donationLinkedList) {
                if (dn.getDonorId() == donorId) {
                    donationLinkedList.remove(dn);
                    result = true;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR : Unable to remove donation with donor id of " + donorId + " .");

        }
        return result;

    }

    /**
     * Remove donation with both donorId and donationId from list
     *
     * @param donorId    the donor id
     * @param donationId the donation id
     * @return false if unsuccessful
     */

    public boolean remove(int donorId, int donationId) {
        boolean result = false;
        try {
            for (Donation dn : donationLinkedList) {
                if (dn.getDonorId() == donorId && dn.getDonationId() == donationId) {
                    donationLinkedList.remove(dn);
                    result = true;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR : Unable to remove donation with donor id of " + donorId + " and donation with id of " + donationId + " .");

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
        boolean isUnique = true;
        for (Donation dn : donationLinkedList) {
            if (dn.getDonationId() == donationId) {
                isUnique = false;
                break;
            }
        }
        return isUnique;

    }

    /**
     * Number of donations int.
     *
     * @return count of all donations
     */

    public int numberOfDonations() {
        return donationLinkedList.size();
    }

    /**
     * Number of donations int.
     *
     * @param donorId the donor id
     * @return return count of donations with specified donorId
     */


    public int numberOfDonations(int donorId) {
        int result = 0;
        for (Donation dn : donationLinkedList) {
            if (dn.getDonorId() == donorId) {
                result = result + 1;
            }
        }
        return result;
    }

    /**
     * Total donation amount float.
     *
     * @return sum of all donations
     */
    public float totalDonationAmount() {
        float result = 0;
        for (Donation dn : donationLinkedList) {
            result = (float) (result + dn.getDonationAmount());
        }
        return result;
    }

    /**
     * Total donation amount float.
     *
     * @param donorId the donor id
     * @return sum of all donations with specified donorId
     */

    public float totalDonationAmount(int donorId) {
        float result = 0;
        for (Donation dn : donationLinkedList) {
            if (dn.getDonorId() == donorId) {
                result = (float) (result + dn.getDonationAmount());
            }
        }
        return result;
    }


    //TODO
    //FIXME

    /**
     * Method to traverse the entire list of Donations executing the toString() method of each Donation.
     **/
    public void traverseDisplay() {
        System.out.println("Donation List : \n");
        //Traverse the list of donations using toString() to display each object in the list.
    }


    //TODO
    //FIXME

    /**
     * Validates the List of Donations by using the isCheckValid() method within the Donation Class.
     * If a check number  is invalid the donation will be removed from the list.
     **/
    public void cleanUp() {
        //validate and clean up the donation list
        //All operations performed will be printed to the console.
    }


}
