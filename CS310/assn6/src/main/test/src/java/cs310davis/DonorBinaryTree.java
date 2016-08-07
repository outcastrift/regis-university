package cs310davis;

import java.util.concurrent.ThreadLocalRandom;

import cs310davis.donor.Donor;

public class DonorBinaryTree {

  private DonorNode rootOfTree;

  public static void main(String[] args) {

    DonorBinaryTree theTree = new DonorBinaryTree();

    for (int x = 0; x < 15; x++) {
      int donorID = ThreadLocalRandom.current().nextInt(0, 50);
      Donor d = new Donor();
      d.setDonorId(donorID);
      theTree.addNode(donorID, d);
    }


    // Different ways to traverse binary trees

    theTree.inOrderTraverseTree(theTree.rootOfTree);

    // theTree.preorderTraverseTree(theTree.rootOfTree);

    // theTree.postOrderTraverseTree(theTree.rootOfTree);

    // Find the node with donorId 75

    System.out.println("\nNode with the donorId 75");

    System.out.println(theTree.findNode(75));

  }

  // All nodes are visited in ascending order
  // Recursion is used to go to one node and
  // then go to its child nodes and so forth

  public void addNode(int donorId, Donor donor) {

    // Create a new Node and initialize it

    DonorNode newDonorNode = new DonorNode(donorId, donor);

    // If there is no rootOfTree this becomes rootOfTree

    if (rootOfTree == null) {

      rootOfTree = newDonorNode;

    } else {

      // Set rootOfTree as the Node we will start
      // with as we traverse the tree

      DonorNode focusNode = rootOfTree;

      // Future parent for our new Node

      DonorNode parent;

      while (true) {

        // rootOfTree is the top parent so we start
        // there

        parent = focusNode;

        // Check if the new node should go on
        // the left side of the parent node

        if (donorId < focusNode.getDonorId()) {

          // Switch focus to the left child

          focusNode = focusNode.getLeftChild();

          // If the left child has no children

          if (focusNode == null) {

            // then place the new node on the left of it

            parent.setLeftChild(newDonorNode);
            return; // All Done

          }

        } else { // If we get here put the node on the right

          focusNode = focusNode.getRightChild();

          // If the right child has no children

          if (focusNode == null) {

            // then place the new node on the right of it

            parent.setRightChild(newDonorNode);
            return; // All Done

          }

        }

      }
    }

  }

  public void inOrderTraverseTree(DonorNode focusNode) {

    if (focusNode != null) {

      // Traverse the left node

      inOrderTraverseTree(focusNode.getLeftChild());

      // Visit the currently focused on node

      System.out.println(focusNode);

      // Traverse the right node

      inOrderTraverseTree(focusNode.getRightChild());

    }

  }

  public DonorNode findNode(int donorId) {

    // Start at the top of the tree

    DonorNode focusNode = rootOfTree;

    // While we haven't found the Node
    // keep looking

    while (focusNode.getDonorId() != donorId) {

      // If we should search to the left

      if (donorId < focusNode.getDonorId()) {

        // Shift the focus Node to the left child

        focusNode = focusNode.getLeftChild();

      } else {

        // Shift the focus Node to the right child

        focusNode = focusNode.getRightChild();

      }

      // The node wasn't found

      if (focusNode == null)
        return null;

    }

    return focusNode;

  }

}


