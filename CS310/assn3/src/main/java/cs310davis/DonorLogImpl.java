package cs310davis;

import java.util.ArrayList;

/**
 * This class is a implementation class to access the Donor Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 * <p>
 * This is the primary class for interacting with the Donor Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 *
 * @author Samuel Kyle Davis
 */

public class DonorLogImpl {

    /**
     * The Donor Database.
     * A arraylist ordered by donor id.
     */

    private DonorNode donorLinkedList = null; //Empty Linked List

    /**
     * Gets the Donor Database.
     *
     * @return Donor Database
     */
    // return the ArrayList attribute
    public DonorNode getDonorList() {
        return this.donorLinkedList;
    }

    /**
     * Add a entry to the Donor database at the appropriate position.
     *
     * @param obj the obj
     *            obj must be of type Donor otherwise this method will print a error and exit.
     *
     *
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
        if (donorLinkedList == null) {
            donorLinkedList = new DonorNode(donor, null);
        } else {

            if (donor.getDonorId() < donorLinkedList.getDonor().getDonorId()) {
                //Donor ID is less than the first element within the LinkedList
                //Make this donor the new starting point.
                this.donorLinkedList = new DonorNode(donor, donorLinkedList);
            } else {
                DonorNode placementList = donorLinkedList;
                while (placementList != null) {
                    DonorNode current = placementList;
                    DonorNode next = current.getNext();
                    if (donor.getDonorId() > current.getDonor().getDonorId()) {
                        //DonorId is Greater than current element
                        if (next != null) {
                            if (donor.getDonorId() < current.getNext().getDonor().getDonorId()) {
                                //Donor Id is less than the next element which means it
                                //should be stored in front of it.
                                current.setNext(new DonorNode(donor, current.getNext()));
                                break;
                            } else {
                                //Donor ID is greater than both the current element and the next element
                                //Loop again
                            }
                        }

                    }
                    //Code to keep this loop moving without going infinite
                    placementList = next;
                    if (placementList == null) {
                        //if placement list is null it means we are at the last element in the list
                        //we need to add our element to the end
                        current.setNext(new DonorNode(donor, null));
                        break;

                    }
                }
            }

        }
    }


    /**
     * Remove a specified donor from the database..
     *
     * @param donorId the donor id
     * @return true if successful
     * false otherwise
     */
    // remove donor with donorId from list
    // and return true if successful
    public boolean remove(int donorId) {
        DonorNode removalList = donorLinkedList;
        boolean wasRemoved = false;
        Donor d = null;
        DonorNode previous = null;
        DonorNode next = null;
        DonorNode current = null;
        while (removalList != null) {
            current = removalList;
            next = removalList.getNext();
            d = current.getDonor();
            if (d.getDonorId() == donorId) {
                if (previous == null) {
                    // We are deleting the first element in the List
                    //set the current node to null
                    // set the real donorLinkedList to start at the new Element
                    this.donorLinkedList = next;
                    wasRemoved = true;
                } else {
                    //remove the entry from the list
                    //set the previous node to link to the next node
                    //set the current node to null
                    current = null;
                    previous.setNext(next);
                    wasRemoved = true;
                }
            }
            previous = current;
            removalList = removalList.getNext();

        }
        if (!wasRemoved) {
            System.out.println("ERROR: Unable to remove Donor from the List the DonorId specified" +
                    " was not located within the list.");

        }
        return wasRemoved;
    }

    /**
     * Determines if a Donor with the specified ID already exists within the database.
     *
     * @param id the donor id to check
     * @return true if the specified ID does not exist in the database.
     * false otherwise
     */
    public boolean isIdUnique(int id) {
        boolean isUnique = true;
        DonorNode uniqueList = donorLinkedList;
        Donor d = null;
        while (uniqueList != null) {
            d = uniqueList.getDonor();
            if (d.getDonorId() == id) {
                isUnique = false;
                break;
            }
            uniqueList = uniqueList.getNext();
        }
        return isUnique;
    }


    /**
     * Method to traverse the entire list of Donors executing the toString() method of each Donor.
     **/
    public void traverseDisplay() {
        System.out.println("Donor List : \n");
        //Traverse the list of donors using toString() to display each object in the list.
        DonorNode traverseList = donorLinkedList;
        Donor d = null;
        while (traverseList != null) {
            d = traverseList.getDonor();
            System.out.println(d.toString());
            traverseList = traverseList.getNext();
        }
    }

    //TODO
    //FIXME

    /**
     * Validates the List of Donors by using the isEmailValid() method within the Donor Class.
     * If an email address is invalid the donor will be removed from the list along with all
     * Donations associated with that Donor.
     **/
    public void cleanUp() {
        //validate and clean up the donor list
        //All operations performed upon the list will be printed to the console.


    }

    public int getSizeOfList() {
        DonorNode sizeCounter = donorLinkedList;

        int size = 0;
        while (sizeCounter != null) {
            size++;
            sizeCounter = sizeCounter.getNext();
        }
        return size;
    }


}
