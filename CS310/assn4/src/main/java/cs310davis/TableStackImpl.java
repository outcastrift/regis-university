package cs310davis;

import java.util.Arrays;

/**
 * Created by Samuel Davis on 7/24/16.
 *
 * This class represents the amount of tables at a charity dinner in memory.
 * Remember this data implementation is Last In - First Out
 * This class includes methods to;
 * See the current table at the top of the stack.
 * Pop the top table from the stack.
 * Push a table to the top of the stack.
 */
public class TableStackImpl {
    private Integer[] tables;
    private Integer numberOfTables;
    private Integer nextTable;

    /**
     * Public Constructor
     * **/
    TableStackImpl(int numberOfTables) {

        this.numberOfTables = numberOfTables;

        tables = new Integer[numberOfTables];
        //Hopefully I don't get points removed for using this. I just hate hundreds of for loops.
        Arrays.fill(tables,-1);
    }
    /**
     * Method to add a table to the top of the stack. This should be done when a table becomes available.
     * **/
    public void push(Integer input) {

        if (nextTable + 1 < nextTable) {

            nextTable++;

            tables[nextTable] = input;
            System.out.println("Adding a table with number of  " + input + " to the list of available tables.\n");
        } else {
            System.out.println("ERROR : Table could not be added to the list. The charity has only paid for 5 tables.");

        }
    }

    /**
     * Method to remove the top most element from the stack this should be done when someone is seated at a table.
     *
     * **/
    public Integer pop() {
        if (nextTable >= 0) {
            System.out.println("Removing a table with the number of  " + tables[nextTable] + " from the list of available tables.\n");
            tables[nextTable] = -1; // Assigning -1 to any table that cannot be used.
            return tables[nextTable--];
        } else {
            System.out.println("ERROR : There is no available table at this time. ");
            return -1;
        }

    }
    /**
     * Method to see the top most element within the stack. In other words to see the next available table.
     * **/
    public Integer peek() {
        Integer result = 0;
        if(nextTable > 0){
            System.out.println("The next table to seat donors at will be table number " + tables[nextTable] + "\n");
            result = tables[nextTable];
        }else{
            result = -1;
            System.out.println("ERROR : There is no available table at this time. ");
        }

        return result;

    }

    public void displayAvailableTables() {
        System.out.print("*****************************************************************************************************");
        System.out.println();
        //Print all the table numbers out.
        for (int n = 0; n < nextTable; n++) {
            System.out.format("| Table Number %2s " + "  ", n+1);
        }

        System.out.println("|");
        System.out.print("*****************************************************************************************************");
        System.out.println();
        //Print all the tables in use and the ones that aren't.
        for (int n = 0; n < nextTable; n++) {
            if (tables[n].equals(-1)){
                System.out.print("|    EMPTY TABLE    ");
            }else {
                System.out.print(String.format("| Table # %2s " + "In Use ", tables[n]));
            }
        }
        System.out.println("|");
        System.out.print("*****************************************************************************************************");
        System.out.println();

    }
}
