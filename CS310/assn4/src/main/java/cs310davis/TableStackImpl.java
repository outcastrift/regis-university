package cs310davis;

import java.util.Arrays;

/**
 * Created by Samuel Davis on 7/24/16.
 *
 * using a 5-element array implementation. The data can be a
 simple integer 1 through 5 to represent the table number. The TableStackImpl should be able to push
 and pop tables from the stack. You also need to include method to determine if the stack is empty or full
 – and use these methods.
 */
public class TableStackImpl {
    private Integer[] stackArray;
    private int stackSize;

    // Sets stack as empty

    private int topOfStack = -1;

    TableStackImpl(int size){

        stackSize = size;

        stackArray = new Integer[size];
        //Lets fill up the TableStack with zeros to make this easier to do.
        // I would have used java util methods here but i figured it was frowned upon.
        for(int x =0; x<size; x++){
            stackArray[x] = 0;
        }
    }

    public static void main(String[] args){

        TableStackImpl theStack = new TableStackImpl(5);

        theStack.push(10);
        theStack.push(17);
        theStack.push(13);

        // Look at the top value on the stack

        theStack.peek();

        // Remove values from the stack (LIFO)

        theStack.pop();
        theStack.pop();
        theStack.pop();

        // Add many to the stack

        theStack.pushMany("1 2 4 5 6 7 8 9");

        // Remove all from the stack

        // theStack.popAll();

        // Remove all from the stack and print them

        theStack.popDisplayAll();

        theStack.displayTheStack();


    }

    public void push(Integer input){

        if(topOfStack+1 < stackSize){

            topOfStack++;

            stackArray[topOfStack] = input;
            System.out.println("PUSH " + input + " Was Added to the Stack\n");
        } else{
            System.out.println("Sorry But the Stack is Full");

        }
        displayTheStack();

    }

    public Integer pop(){

        if(topOfStack >= 0){

            displayTheStack();

            System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the Stack\n");

            // Just like in memory an item isn't deleted, but instead is just not available

            stackArray[topOfStack] = 0; // Assigns -1 so the value won't appear

            return stackArray[topOfStack--];


        } else {

            displayTheStack();

            System.out.println("Sorry But the Stack is Empty");

            return 0;
        }


    }

    public Integer peek(){

        displayTheStack();

        System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the Stack\n");

        return stackArray[topOfStack];

    }

    public void pushMany(String multipleValues){

        String[] stringArray = multipleValues.split(" ");
        for(int x = 0; x < stringArray.length; x++){

            push(Integer.valueOf(stringArray[x]));

        }

    }

    public void popAll(){

        for(int i = topOfStack; i >= 0; i--){

            pop();

        }

    }

    public void popDisplayAll(){

        String theReverse = "";

        for(int i = topOfStack; i >= 0; i--){

            theReverse += stackArray[i];

        }

        System.out.println("The Reverse: " + theReverse);

        popAll();

    }

    public void displayTheStack(){

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){



            if(stackArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }
}
