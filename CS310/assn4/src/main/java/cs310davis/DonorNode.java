package cs310davis;

/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Created by Samuel Davis on 7/17/16.
 * Class Description
 * The purpose of this class is to be the primary data structure for a Singly Linked List of Donor objects.
 * This class will keep reference to the next DonorNode in the List.
 * The last DonorNode within the List will return null on the getNext() signifying the end of the list.
 */
public class DonorNode {
    //NOTE The code pertaining to a Doubly Linked List remains commented out, I initially did this assignment in that
    //NOTE manner but realized once I was close to being finished that it was wrong and you asked for a singly LinkedList
    //NOTE please do not deduct points for these being commented out.
    private Donor donor;
    private DonorNode next;
    //private DonorNode previous;

    /**
     * Public DonorNode constructor.
     *
     * @param donor a donor object to add to the Linked List
     * @param next  a DonorNode object to store reference to, in the case where one does not exist pass in null.
     **/
    public DonorNode(Donor donor, DonorNode next) {
        this.donor = donor;
        this.next = next;
    }
    /*public DonorNode(Donor donor, DonorNode previous, DonorNode next){
        this.donor = donor;
        this.next = next;
        this.previous = previous;
    }*/





    /**
     * Returns the Donor stored within this DonorNode.
     **/
    public Donor getDonor() {
        return donor;
    }

    /**
     * Sets the Donor stored within this DonorNode.
     *
     * @param donor the donor object to be stored within this DonorNode
     **/
    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    /**
     * Returns a reference to the next DonorNode within the List.
     **/
    public DonorNode getNext() {
        return next;
    }

    /**
     * Sets the reference to the next DonorNode within the list.
     * In the case where you have created your first node with null,
     * you must call this method in order for the list to function.
     *
     * @param next the next DonorNode within the List.
     **/
    public void setNext(DonorNode next) {
        this.next = next;
    }


    /**
     * Returns a reference to the previous DonorNode within the List.
     * **/
   /* public DonorNode getPrevious() {
        return previous;
    }*/

    /**
     * Sets the reference to the previous DonorNode within the list.
     * @param previous the previous DonorNode within the List.
     **/
   /* public void setPrevious(DonorNode previous) {
        this.previous = previous;
    }*/


}
