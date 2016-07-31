package cs310davis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
    private static LinkedList<Donation> donationLinkedList = new LinkedList<Donation>();
    private static HashSet<Donation> donationHashSet = new HashSet<Donation>(23);
    /**
     * Remove donations with donorId from list and return true if successful.
     *
     * @param donorId the donor id
     * @return false if nothing was deleted
     */
    public static boolean remove(int donorId) {
        boolean result = false;
        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
            if (dn.getDonorId() == donorId) {
                donationLinkedList.remove(dn);
                result = true;
                break;
            }
        }
        if (!result) {
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

    public static boolean remove(int donorId, int donationId) {
        boolean result = false;

        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
            if (dn.getDonorId() == donorId && dn.getDonationId() == donationId) {
                donationIterator.remove();
                result = true;
                break;
            }
        }
        if (!result) {
            System.out.println("ERROR : Unable to remove donation with donor id of "
                    + donorId + " and donation with id of " + donationId + " .");

        }

        return result;
    }

    /**
     * Get donation database as array list.
     *
     * @return the donation database
     */
    public static LinkedList<Donation> getDonationList() {
        // return the ArrayList attribute
        return donationLinkedList;

    }

    public int hashDonationId(int donationId){
        int hashCode =0;
        String id = String.valueOf(donationId);
        char[] charArray = id.toCharArray();


        for(char c : charArray){
            hashCode= hashCode + (int) c;
        }
        //todo change this to whatever data structure i end up using
        hashCode = hashCode % 23;
        return hashCode;
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
     * Is id unique boolean.
     * Tests if  a donation with id exists in the database.
     *
     * @param donationId the donation id
     * @return the boolean
     */

    public boolean isIdUnique(int donationId) {
        boolean isUnique = true;

        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
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
        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
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
        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
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
        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
            if (dn.getDonorId() == donorId) {
                result = (float) (result + dn.getDonationAmount());
            }
        }

        return result;
    }


    /**
     * Method to traverse the entire list of Donations executing the toString() method of each Donation.
     **/
    public void traverseDisplay() {
        System.out.println("Donation List : \n");
        Iterator<Donation> donationIterator = donationLinkedList.iterator();

        Donation dn = null;
        while (donationIterator.hasNext()) {
            dn = donationIterator.next();
            System.out.println(dn.toString());
        }
    }



    /**
     * Validates the List of Donations by using the isCheckValid() method within the Donation Class.
     * If a check number  is invalid the donation will be removed from the list.
     **/
    public void cleanUp() {
        System.out.println("Beginning to Validate the Donation List : \n");
        Iterator<Donation> donationIterator = donationLinkedList.iterator();
        //created to avoid a concurrent modification exception
        //this isn't as clean as it could be
        ArrayList<Integer> removalList = new ArrayList<Integer>();

        Donation donation = null;
        int x = -1;
        while (donationIterator.hasNext()) {
            x = x + 1;
            donation = donationIterator.next();
            if (!Donation.isCheckValid(donation.getDonationCheckNumber())) {
                System.out.println("The donation with donation ID of [" + donation.getDonationId() + "]" +
                        " and the donor ID of [" + donation.getDonorId() + "] supplied a invalid check number of [" +
                        donation.getDonationCheckNumber() + "] and will be removed from the list of donations. ");
                donationIterator.remove();
            }

        }


        System.out.println("Finished Validating the Donation List : \n");

    }


}
