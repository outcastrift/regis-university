package cs310davis;

import java.util.ArrayList;

/**
 * This class is a implementation class to access the Donation Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 *
 * This is the primary class for interacting with the Donation Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 * @author Samuel Kyle Davis
 */
public class DonationLogImpl {

    /**
     * The Donation Database.
     */
    private ArrayList<Donation> donationArray = new ArrayList<Donation>();


    /**
     * Get donation database as array list.
     *
     * @return the donation database
     */
    public ArrayList<Donation> getDonationList(){
        // return the ArrayList attribute
        return this.donationArray;
    }

    /**
     * Add donation to the database..
     *
     * @param obj the obj
     * @return true if successful
     * @return false if unsuccessful
     * @param obj must be of type Donation otherwise method returns false.
     */

    public boolean add(Object obj){
        if (obj instanceof Donation) {
            Donation donation = (Donation) obj;
            donationArray.add(donation);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Remove donations with donorId from list and return true
     *
     * @param donorId the donor id
     * @return true if any donations deleted
     * @return false if nothing was deleted
     */
    public boolean remove(int donorId){
        boolean result =false;
        try{
            for(Donation dn : donationArray){
                if(dn.getDonorId()==donorId){
                    donationArray.remove(dn);
                    result = true;
                }
            }
        }catch(Exception e){
            System.out.println("ERROR : Unable to remove donation with donor id of "+donorId+" .");

        }
        return result;

    }

    /**
     * Remove donation with both donorId and donationId from list
     *
     * @param donorId    the donor id
     * @param donationId the donation id
     * @return true if successful
     * @return false if unsuccessful
     */

    public boolean remove(int donorId, int donationId){
        boolean result =false;
        try{
            for(Donation dn : donationArray){
                if(dn.getDonorId()==donorId &&dn.getDonationId()==donationId){
                    donationArray.remove(dn);
                    result = true;
                }
            }
        }catch(Exception e){
            System.out.println("ERROR : Unable to remove donation with donor id of "+donorId+" and donation with id of "+donationId+" .");

        }
        return result;
    }

    /**
     * Is id unique boolean.
     * Tests if  a donation with id exists in the database.
     * @param donationId the donation id
     * @return the boolean
     */

    public boolean isIdUnique(int donationId){

            for(Donation dn : donationArray){
                if(dn.getDonationId()==donationId){
                    return false;
                }
            }


        return true;

    }

    /**
     * Number of donations int.
     *
     * @return count of all donations
     */

    public int numberOfDonations(){
      return donationArray.size();
    }

    /**
     * Number of donations int.
     *
     * @param donorId the donor id
     * @return return count of donations with specified donorId
     */


    public int numberOfDonations(int donorId){
       int result = 0;
        for(Donation dn : donationArray){
            if(dn.getDonorId() == donorId){
                result = result +1;
            }
        }
        return result;
    }

    /**
     * Total donation amount float.
     *
     * @return sum of all donations
     */
    public float totalDonationAmount(){
        float result = 0;
        for(Donation dn : donationArray){
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
        for(Donation dn : donationArray){
            if(dn.getDonorId() == donorId){
                result = (float) (result + dn.getDonationAmount());
            }
        }
        return result;
    }

}
