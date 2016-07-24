package cs310davis;

import java.util.Arrays;

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
    private String[] queueArray;
    private int queueSize;

    // Sets stack as empty

    private int front, numberOfItems, rear = 0;

    DonorQueueImpl(int size) {

        queueSize = size;

        queueArray = new String[size];

        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen

        Arrays.fill(queueArray, "-1");

    }

    public static void main(String[] args) {

        DonorQueueImpl theQueue = new DonorQueueImpl(10);

        theQueue.priorityInsert("16");

        theQueue.priorityInsert("25");

        theQueue.priorityInsert("10");

		/*
        theQueue.insert("10");

		theQueue.displayTheQueue();

		theQueue.insert("15");

		theQueue.displayTheQueue();

		theQueue.insert("25");

		theQueue.displayTheQueue();

		theQueue.insert("25");

		theQueue.displayTheQueue();

		theQueue.insert("25");
		*/

        theQueue.displayTheQueue();

        theQueue.remove();

        theQueue.displayTheQueue();

        theQueue.remove();

        theQueue.displayTheQueue();

        theQueue.peek();

    }

    // This priority insert will add items in order from high to low

    public void insert(String input) {

        if (numberOfItems + 1 <= queueSize) {

            queueArray[rear] = input;

            rear++;

            numberOfItems++;

            System.out.println("INSERT " + input + " Was Added to the Stack\n");

        } else {

            System.out.println("Sorry But the Queue is Full");

        }

    }

    public void priorityInsert(String input) {

        int i;

        if (numberOfItems == 0) {

            insert(input);

        } else {

            for (i = numberOfItems - 1; i >= 0; i--) {

                if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {

                    queueArray[i + 1] = queueArray[i];

                } else break; // Done shifting items in queue

            }

            queueArray[i + 1] = input;

            rear++;

            numberOfItems++;

        }

    }

    public void remove() {

        if (numberOfItems > 0) {

            System.out.println("REMOVE " + queueArray[front] + " Was Removed From the Queue\n");

            // Just like in memory an item isn't deleted, but instead is just not available

            queueArray[front] = "-1";

            front++;

            numberOfItems--;

        } else {

            System.out.println("Sorry But the Queue is Empty");


        }

    }

    public void peek() {

        System.out.println("The First Element is " + queueArray[front]);

    }

    public void displayTheQueue() {

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {


            if (queueArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s " + " ", queueArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        // Number of spaces to put before the F

        int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

        for (int k = 1; k < spacesBeforeFront; k++) System.out.print(" ");

        System.out.print("F");

        // Number of spaces to put before the R

        int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

        for (int l = 0; l < spacesBeforeRear; l++) System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }


}
