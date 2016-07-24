package cs310davis;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Samuel Davis on 7/24/16.
 *
 * As donors are assigned to a table, you will need to be able to specify which donor is sitting at what table.
 Choose an appropriate data structure that we have studied to provide this information
 */
public class SeatingImpl {

    //A array list containing donors stored by table number.
    private ArrayList<Donor> seatingChart;
    private DonorQueueImpl theDonorLines;
    private TableStackImpl tables;

    public SeatingImpl(DonorQueueImpl theDonorLines,
                       TableStackImpl tables){
        this.theDonorLines = theDonorLines;
        this.tables = tables;
        setupSeatingChart();

    }
    private void setupSeatingChart(){
        seatingChart = new ArrayList<Donor>();
        seatingChart.add(0,null);
        seatingChart.add(1,null);
        seatingChart.add(2,null);
        seatingChart.add(3,null);
        seatingChart.add(4,null);
        seatingChart.add(5,null);
        seatingChart.add(6,null);


    }

    public void processDonorArrival(Donor donor){
        Integer nextTable = tables.nextAvailableTable();

        if(nextTable >= 0){
            seatDonor(donor,nextTable);
        }else{
           addDonorToLine(donor);
        }
    }
    public void processDonorDeparture(Donor donor){
        // free up table
        for(int x =0; x < seatingChart.size(); x++){
           //looping from the beginning of the seating chart
            if(seatingChart.get(x) != null){
                if(seatingChart.get(x).equals(donor)){
                    System.out.println("Donor "+donor.getDonorFirstName()+" "+donor.getDonorLastName() +
                            " has left table number "+ x);
                    //return the table to the list
                    addTableToAvailableTables(x);
                    //seat the next person from the line
                    seatDonor(theDonorLines.getNextDonorToBeSeated(),tables.nextAvailableTable());
                }
            }

        }

        //if lines aren't empty seat the next person
    }
    public void seatDonor(Donor donor,Integer tableNumber){
        //removing table from available tables and storing the location of the donor in array based on table id
        //table number
        seatingChart.add(tableNumber,donor);
        tables.pop();

        System.out.println("Donor "+donor.getDonorFirstName()+" "+donor.getDonorLastName() +
                " was seated at table number "+ tableNumber);

    }
    public void addDonorToLine(Donor donor){
        System.out.println("All tables are currently full adding Donor "+donor.getDonorFirstName()+" " +
                ""+donor.getDonorLastName() + " to the appropriate line.");
        theDonorLines.addDonorToAppropriateQueue(donor);
    }
    public void addTableToAvailableTables(Integer tableNumber){
        tables.push(tableNumber);
    }






}
