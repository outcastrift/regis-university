package cs310davis;

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
    private Integer[] tableArray;
    private int tableNumber;

    // Sets stack as empty
    private int topOfStack = -1;


    /**
     * Public Constructor
     * **/
    TableStackImpl(int numberOfTables) {

        tableNumber = numberOfTables;

        tableArray = new Integer[numberOfTables];

        for (int x = 0; x < numberOfTables; x++) {
            tableArray[x] = -1;
        }
        displayAvailableTables();
    }

    public static void main(String[] args) {

        TableStackImpl theStack = new TableStackImpl(5);
        //Add to the stack.
        theStack.push(1);
        theStack.peek();

        theStack.push(2);
        theStack.peek();

        theStack.push(3);
        theStack.peek();

        theStack.push(4);
        theStack.peek();

        theStack.push(5);
        theStack.peek();

        theStack.pop();
        theStack.pop();
        theStack.pop();
        theStack.pop();
        theStack.pop();


        // Look at the top value on the stack



        theStack.displayAvailableTables();


    }
    /**
     * Method to add a table to the top of the stack. This should be done when a table becomes available.
     * **/
    public void push(Integer input) {

        if (topOfStack + 1 < tableNumber) {

            topOfStack++;

            tableArray[topOfStack] = input;
            System.out.println("Adding a table with number of  " + input + " to the TableStack\n");
        } else {
            System.out.println("ERROR : There is no more room within the stack, the charity only has 5 tables.");

        }
        displayAvailableTables();

    }
    /**
     * Method to remove the top most element from the stack this should be done when someone is seated at a table.
     *
     * **/
    public Integer pop() {

        if (topOfStack >= 0) {

            displayAvailableTables();

            System.out.println("Removing a table with a number of  " + tableArray[topOfStack] + " from the TableStack\n");

            tableArray[topOfStack] = -1; // Assigning -1 to any table that cannot be used.

            return tableArray[topOfStack--];


        } else {

            displayAvailableTables();

            System.out.println("ERROR : There is no available table at this time. ");

            return 0;
        }


    }
/**
 * Method to see the top most element within the stack.
 * **/
    public Integer peek() {
        Integer result = 0;
        if(topOfStack > 0){
            System.out.println("The next table to seat donors at will be table number " + tableArray[topOfStack] + "\n");
            result = tableArray[topOfStack];
        }else{
            result =0;
            System.out.println("ERROR : There is no table at the top of the stack, the stack is empty.");
        }

        return result;

    }


    public void displayAvailableTables() {
        System.out.print("*****************************************************************************************************");
        System.out.println();

        for (int n = 0; n < tableNumber; n++) {
            System.out.format("| Table Number %2s " + "  ", n+1);
        }

        System.out.println("|");

        System.out.print("*****************************************************************************************************");
        System.out.println();

        for (int n = 0; n < tableNumber; n++) {


            if (tableArray[n].equals(-1)){
                System.out.print("|    EMPTY TABLE    ");
            }else {
                System.out.print(String.format("| Table # %2s " + "In Use ", tableArray[n]));
            }

        }
        System.out.println("|");
        System.out.print("*****************************************************************************************************");
        System.out.println();

    }
}
