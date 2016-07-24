package cs310davis;

/**
 * Created by Samuel Davis on 7/24/16.
 * You will create your own DonorQueueImpl using a singly linked list, with references to both the front
 and back nodes in the queue (you should be able to use your DonorNode class from last week to build this
 linked list). This implementation will be store Donor nodes, and will be used to create two separate
 queues (representing lines waiting for tables) – one for standard donors, and one for GoldStar donors.
 .

 If a donor arrives to the dinner, but there are not any tables available, the donor will be assigned to a
 queue to wait for the next available table. If the donor is a GoldStar donor, that donor is assigned to the
 GoldStar queue. If the donor is not, then the donor is assigned to standard donor queue.
 Newly arriving donors will be added to the rear of the linked list. When a donor is seated from the queue,
 that donor will be taken from the front of the linked list.
 The code should be able to add and remove donors from each of the queues. You will also need to build
 methods to check if a queue is empty or full, and use the methods. If you try to remove a donor from an
 empty queue, you will need to provide an error message. A queue will only be considered full if memory
 allocation fails when you try to instantiate a new node object.
 You will also need to watch for gate crashers. If a donor attempts to get a table, but his/her donor ID is
 not in your Donor linked list (built using the code from Assn 3), then that donor will be ignored, and your
 application will move on to the next donor.

 As each action occurs, you will provide an audit trail. At the end of the program, your application will
 provide a report providing the existing seating chart (which donor is at which table), which tables are
 available in the stack (the top of the stack is to be listed first), and which donors are still sitting in each of
 the queues in order.
 All output is to be placed into a dinnerReport.txt file to be located in the output folder.
 */
public class DonorQueueImpl {
}
