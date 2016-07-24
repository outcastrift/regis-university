package cs310davis;

/**
 * Created by Samuel Davis on 7/24/16.
 * You will create your own DonorQueueImpl using a singly linked list, with references to both the front
 * and back nodes in the queue (you should be able to use your DonorNode class from last week to build this
 * linked list). This implementation will be store Donor nodes, and will be used to create two separate
 * queues (representing lines waiting for tables) – one for standard donors, and one for GoldStar donors.
 * .
 * <p>
 * If a donor arrives to the dinner, but there are not any tables available, the donor will be assigned to a
 * queue to wait for the next available table. If the donor is a GoldStar donor, that donor is assigned to the
 * GoldStar queue. If the donor is not, then the donor is assigned to standard donor queue.
 * Newly arriving donors will be added to the rear of the linked list.
 * When a donor is seated from the queue, that donor will be taken from the front of the linked list.
 * <p>
 * The code should be able to add and remove donors from each of the queues.
 * You will also need to build methods to check if a queue is empty or full, and use the methods.
 * If you try to remove a donor from an empty queue, you will need to provide an error message.
 * A queue will only be considered full if memory  allocation fails when you try to instantiate a new node object.
 * <p>
 * You will also need to watch for gate crashers. If a donor attempts to get a table, but his/her donor ID is
 * not in your Donor linked list (built using the code from Assn 3), then that donor will be ignored, and your
 * application will move on to the next donor.
 * <p>
 * As each action occurs, you will provide an audit trail.
 * At the end of the program, your application will provide a report providing the existing seating chart (which donor is at which table),
 * which tables are available in the stack (the top of the stack is to be listed first), and which donors are still sitting in each of
 * the queues in order.
 * All output is to be placed into a dinnerReport.txt file to be located in the output folder.
 */
public class DonorQueueImpl {
    //this list will always have reference to the first/next person in line.
   DonorNode goldStarList = null; //Empty Linked List
    //this list will always have reference to the first/next person in line.

    DonorNode regularList = null; //Empty Linked List


    public boolean isGoldStarLineEmpty(){
        boolean isEmpty =false;
        if(goldStarList ==null){
            isEmpty =true;
        }else if(goldStarList.getDonor() ==null){
            isEmpty =true;
        }
        return isEmpty;
    }
    public boolean isRegularLineEmpty(){
        boolean isEmpty =false;
        if(regularList ==null){
            isEmpty =true;
        }else if(regularList.getDonor() ==null){
            isEmpty =true;
        }
        return isEmpty;
    }
    public boolean isGoldStarListFull(){
        boolean isFull =false;
       try{
           DonorNode donorNode = new DonorNode(null, null);
       }catch(Exception e){
          isFull =true;
       }
       return isFull;
    }

    public boolean isRegularListFull(){
        boolean isFull =false;
        try{
            DonorNode donorNode = new DonorNode(null, null);
        }catch(Exception e){
            isFull =true;
        }
        return isFull;
    }

    public void addToGoldstarQueue(Donor donor){
        if(goldStarList == null){
            //First donor to enter the line.
            goldStarList = new DonorNode(donor,null);

        }else{
            //Someone is ahead of the donor in line.
            DonorNode newRearOfLine = new DonorNode(donor, null);
            goldStarList.setNext(newRearOfLine);

        }
    }
    public void addToRegularQueue(Donor donor){
        if(regularList == null){
            //First donor to enter the line.
            regularList = new DonorNode(donor,null);

        }else{
            //Someone is ahead of the donor in line.
            DonorNode newRearOfLine = new DonorNode(donor, null);

            regularList.setNext(newRearOfLine);

        }
    }
    public Donor getNextGoldStarDonor(Integer donorId){
       return getDonor(goldStarList, donorId);
    }
    public Donor getNextRegularDonor(Integer donorId){
        return getDonor(regularList, donorId);
    }
    /**
     * Remove a specified donor from the goldstar line.
     *
     * @param donorId the donor id
     * @return true if successful
     * false otherwise
     */
    public boolean removeDonorFromGoldStarList(Integer donorId){
        DonorNode removalList = goldStarList;
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
                    this.goldStarList = next;
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
     * Remove a specified donor from the regular line.
     *
     * @param donorId the donor id
     * @return true if successful
     * false otherwise
     */
    public boolean removeDonorFromRegularList(Integer donorId){
        DonorNode removalList = regularList;
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
                    this.regularList = next;
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
     * Method to get specified donor from the list.
     **/
    public Donor getDonor(DonorNode listToGetFrom,
                          Integer donorID) {
        Donor result = null;
        DonorNode searchList = listToGetFrom;
        Donor d = null;
        while (searchList != null) {
            d = searchList.getDonor();
            if(d.getDonorId().equals(donorID)){
                result = d;
                break;
            }
            searchList = searchList.getNext();
        }
        return result;
    }

}
