package cs310davis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Created by Samuel Davis on 7/24/16.
 *
 * CLass that controls adding donors to tables and seating them correctly.
 */
public class SeatingImpl {

    private ArrayList<HashMap<Integer, Integer>> seating;
    private DonorQueueImpl theDonorLines;
    private TableStackImpl tables;

    /**
     * Public Constructor
     * **/
    public SeatingImpl(DonorQueueImpl theDonorLines,
                       TableStackImpl tables){
        this.theDonorLines = theDonorLines;
        this.tables = tables;
        seating = new ArrayList<>();
        setupTables();
    }
    /**
     * Creates the initial tables.
     * **/
    private void setupTables(){
        tables.push(1);
        tables.push(2);
        tables.push(3);
        tables.push(4);
        tables.push(5);

    }
    /**
     * Method to process the arrival of a
     * @param donor the donor that arrived
     *              to the dinner.
     * **/
    public void processDonorArrival(Donor donor){
        if(!tables.isEmpty() ){
            seatDonor(donor);
        }else{
           addDonorToLine(donor);
        }
    }

    /**
     * Seats a
     * @param donor the donor to be seated at a table
     *
     * **/
    public void seatDonor(Donor donor){
        Integer tableNumber = tables.pop();
        HashMap<Integer,Integer> donorSeat = new HashMap<>();
        donorSeat.put(donor.getDonorId(), tableNumber);
        seating.add(donorSeat);

        System.out.println("Donor "+donor.getDonorFirstName()+" "+donor.getDonorLastName() +
                " was seated at table number "+ tableNumber);

    }

    /**
     * If no tables are available adds the
     * @param donor the donor that must wait in line
     *              to the rear of the correct line.
     *
     * **/
    public void addDonorToLine(Donor donor){
        System.out.println("All tables are currently full adding Donor "+donor.getDonorFirstName()+" " +
                ""+donor.getDonorLastName() + " to the appropriate line.");
        theDonorLines.addDonorToAppropriateQueue(donor);
    }

    /**
     * Method to process the departure of a
     * @param donor the donor that is leaving the dinner
     *              This method will
     *              remove the donor from the seating chart
     *              Free up the table he left
     *              process the next appropriate donor from the line and seat them at a table
     *
     * **/
    public void processDonorDeparture(Donor donor){
        int position = -1;
        for(HashMap<Integer, Integer> map : seating){
            position = position+1;
            if(map.get(donor.getDonorId()) !=null ){
                System.out.println("Donor "+donor.getDonorFirstName()+" "+donor.getDonorLastName() +
                        " has left table number "+ map.get(donor.getDonorId()));
                addTableToAvailableTables(map.get(donor.getDonorId()));
                if(!theDonorLines.isGoldStarLineEmpty() || !theDonorLines.isRegularLineEmpty()){
                    seatDonor(theDonorLines.getNextDonorToBeSeated());
                }

                break;
            }
        }
        seating.remove(position);
    }

    /**
     * Adds the specified
     * @param tableNumber the table to be added back into the stack of available tables
     *                    to the available table stack.
     * **/
    public void addTableToAvailableTables(Integer tableNumber){
        tables.push(tableNumber);
    }


    /**
     * Method to return the current seating chart.
     * **/
    public ArrayList<HashMap<Integer, Integer>> getSeating() {
        return seating;
    }




}
