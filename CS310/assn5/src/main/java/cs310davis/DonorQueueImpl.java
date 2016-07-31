package cs310davis;

/**
 * Created by Samuel Davis on 7/24/16.

 * Class to control the different queues for GoldStar and regular Donors. .
 */
public class DonorQueueImpl {
    //this list will always have reference to the first/next person in line.
    DonorNode goldStarList = null; //Empty Linked List
    //this list will always have reference to the first/next person in line.

    DonorNode regularList = null; //Empty Linked List
    DonorNode rearOfRegularLine = null;
    DonorNode rearOfGoldStarLine = null;


    /**
     * Gets the next donor to be seated from both lines.
     * If the GoldStar line is not empty it will retrieve the first donor in that line
     * otherwise it will get the first person in the regular line.
     * After retrieving the donor from their perspective line they are removed from the line.
     * This is the only public method that removes elements from either line.
     * **/
    public Donor getNextDonorToBeSeated(){
        Donor result = null;
      if(!isGoldStarLineEmpty()){
         result = getNextGoldStarDonor();
          removeDonorFromGoldStarList(result.getDonorId());

      }else{
          result = getNextRegularDonor();
          removeDonorFromRegularList(result.getDonorId());
      }
      return result;
    }

    /**
     * Public method to determine if the Gold Star line is empty or not.
     * **/
    public boolean isGoldStarLineEmpty() {
        boolean isEmpty = false;
        if (goldStarList == null) {
            isEmpty = true;
        } else if (goldStarList.getDonor() == null) {
            isEmpty = true;
        }
        return isEmpty;
    }

    /**
     * Private method invoked to determine the next gold star donor to be seated.
     * **/
    private Donor getNextGoldStarDonor() {

        return goldStarList.getDonor();
    }

    /**
     * Remove a specified donor from the goldstar line.
     *
     * @param donorId the donor id
     * @return true if successful
     * false otherwise
     */
    private boolean removeDonorFromGoldStarList(Integer donorId) {
        boolean wasRemoved = false;

        if (isGoldStarLineEmpty()) {
            System.out.println("ERROR : Unable to remove donor with donor ID of " + donorId +
                    " from the queue because the line contains no donors. ");
        }else{
        DonorNode removalList = goldStarList;
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
        }

        return wasRemoved;


    }

    /**
     * Private method invoked to determine the next regular donor to be seated.
     * **/
    private Donor getNextRegularDonor() {
        return  regularList.getDonor();
    }

    /**
     * Remove a specified donor from the regular line.
     *
     * @param donorId the donor id
     * @return true if successful
     * false otherwise
     */
    private boolean removeDonorFromRegularList(Integer donorId) {
        boolean wasRemoved = false;
        if (isRegularLineEmpty()) {
            System.out.println("ERROR : Unable to remove donor with donor ID of " + donorId +
                    " from the queue because the line contains no donors. ");
        }else {
            DonorNode removalList = regularList;

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
        }
        return wasRemoved;

    }

    /**
     * Public method to determine whether the regular donor line is empty or not.
     * **/
    public boolean isRegularLineEmpty() {
        boolean isEmpty = false;
        if (regularList == null) {
            isEmpty = true;
        } else if (regularList.getDonor() == null) {
            isEmpty = true;
        }
        return isEmpty;
    }

    /**
     * The only public method for adding a donor to the queue, this method will check whether or not the perspective
     * @param donor the donor to add
     *              is a gold star donor or not and add them appropriately.
     * **/
    public void addDonorToAppropriateQueue(Donor donor) {
        if (donor.isGoldStar()) {
            System.out.println("Donor "+donor.getDonorFirstName()+" "+donor.getDonorLastName() +
                    " is a GoldStar donor and will be added to the priority line.");

            addToGoldstarQueue(donor);
        } else {
            System.out.println("Donor "+donor.getDonorFirstName()+" "+donor.getDonorLastName() +
                    " is a regular donor and will be added to the regular line.");
            addToRegularQueue(donor);
        }
    }

    /**
     * Private method invoked to add a donor to the gold star queue.
     * **/
    private void addToGoldstarQueue(Donor donor) {
        if (isGoldStarLineEmpty()) {
            //First donor to enter the line.
            goldStarList = new DonorNode(donor, null);
            rearOfGoldStarLine = goldStarList;
        } else {
            //Someone is ahead of the donor in line.
            if (!isGoldStarListFull()) {
                DonorNode newRearOfLine = new DonorNode(donor, null);
                rearOfGoldStarLine.setNext(newRearOfLine);
                rearOfGoldStarLine = newRearOfLine;
            } else {
                System.out.println("ERROR : The gold star line is full and no donors can be added.");
            }
        }
    }

    /**
     * Private method invoked to add a donor to the regular queue.
     * **/
    private void addToRegularQueue(Donor donor) {
        if (isRegularLineEmpty()) {
            //First donor to enter the line.
            regularList = new DonorNode(donor, null);
            rearOfRegularLine = regularList;
        } else {
            //Someone is ahead of the donor in line.
            if (!isRegularListFull()) {
                DonorNode newRearOfLine = new DonorNode(donor, null);
                rearOfRegularLine.setNext(newRearOfLine);
                rearOfRegularLine = newRearOfLine;

            } else {
                System.out.println("ERROR : The regular line is full and no donors can be added.");
            }


        }
    }

    /**
     * Public method to determine whether the gold star line is full.
     * **/
    public boolean isGoldStarListFull() {
        boolean isFull = false;
        try {
            DonorNode donorNode = new DonorNode(null, null);
        } catch (Exception e) {
            isFull = true;
        }
        return isFull;
    }

    /**
     * Public method to determine whether the regular donor line is full or not.
     * **/
    public boolean isRegularListFull() {
        boolean isFull = false;
        try {
            DonorNode donorNode = new DonorNode(null, null);
        } catch (Exception e) {
            isFull = true;
        }
        return isFull;
    }

    /**
     * Method to return a string represenation of the current gold star line.
     * **/
    public String printGoldStarLine(){
       return printLine(goldStarList);
    }

    /**
     * Method to create a single string representation of the
     * @param lineToPrint the line to create a string for
     * **/
    private String printLine(DonorNode lineToPrint){
        StringBuilder sb = new StringBuilder();
        DonorNode traverseList = lineToPrint;
        if(traverseList ==null){
            sb.append("There is currently no Donors waiting within this Queue.");
        }else {
            Donor d = null;
            while (traverseList != null) {
                d = traverseList.getDonor();
                sb.append(d.getDonorFirstName()).append(" ").append(d.getDonorLastName()).append(" is waiting. \n");
                traverseList = traverseList.getNext();
            }
        }
        return sb.toString();
    }

    /**
     * Method to return a string representation of the current regular line.
     * **/
    public String printRegularLine(){
      return printLine(regularList);
    }

}
