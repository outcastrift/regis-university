package cs310davis;

/**
 * Created by Samuel Davis on 7/24/16.
 *
 * This class represents the amount of tables at a charity dinner in memory.
 * Remember this data implementation is Last In - First Out
 * This class includes methods to;
 * See the current table at the topOfStack of the stack.
 * Pop the topOfStack table from the stack.
 * Push a table to the topOfStack of the stack.
 */
public class TableStackImpl {


    static int MAXSIZE=5;          // maximum size of the stack
    Integer[] tableStack;          // the array to hold the tableStack
    int topOfStack;                // indicates the topOfStack of the stack

    public TableStackImpl() {
        tableStack = new Integer[MAXSIZE];    // instantiate the TableStack array
        topOfStack = -1;                                // initialize the topOfStack
    }

    public void push (int input ) {
        if (topOfStack < tableStack.length) {             // make sure the stack is not full
            topOfStack++;                                // increment the topOfStack pointer
            tableStack[topOfStack] = input;           // add the new paper to the stack
            System.out.println("Adding a table with number of  " + input + " to the list of available tables.\n");

        }
        else {
            System.out.println("ERROR : Table could not be added to the list. The charity has only paid for 5 tables.");
        }
    }
    /**
     * Public method to remove the top most integer from the stack and return it to the caller.
     * **/
    public int pop () {
        int tableNumber = -1;

        if (!isEmpty()) {                      // make sure there is something in the stack
            tableNumber = tableStack[topOfStack];      // take the paper out of the stack
            topOfStack--;                              // decrement the stack pointer
            System.out.println("Removing a table with the number of  " + tableNumber + " from the list of available tables.\n");

        }
        else {
            System.out.println("ERROR : There is no available tables to remove.");
        }
        return tableNumber;
    }
    /**
     * Public method to determine whether or not the table stack is empty.
     * **/
    public boolean isEmpty() {      // check if the stack is empty
        boolean retValue = false;
        if (topOfStack < 0) {
            retValue = true;
        }
        return (retValue);
    }

    /**
     * Print method called to get the list of available tables
     * **/
    public  String printStack() {    // utility to print contents of the stack
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            for (int idx = topOfStack; idx >= 0; idx--) {
                sb.append("\nTable [" + tableStack[idx] + "] is available ");
            }
            sb.append("\n");
        }
        else {
            sb.append("\nThere is currently no available tables.\n");
        }
        return  sb.toString();
    }


}
