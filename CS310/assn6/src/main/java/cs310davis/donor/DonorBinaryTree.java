package cs310davis.donor;

import java.util.concurrent.ThreadLocalRandom;

public class DonorBinaryTree {

  private DonorNode rootOfTree;

  public static void main(String[] args) {
    DonorBinaryTree theTree = new DonorBinaryTree();
    for (int x = 0; x < 15; x++) {
      int donorID = ThreadLocalRandom.current().nextInt(0, 50);
      Donor d = new Donor();
      d.setDonorId(donorID);
      theTree.addNode(d);
    }
    theTree.traverseTreeInOrder(theTree.rootOfTree);
    // Find the node with donorId 75
    System.out.println("\nNode with the donorId 75");

    System.out.println(theTree.findDonorInTree(75));

  }
  /**
   * Method to add a Donor to the BinaryTree
   * @param donor the donor to be added
   * **/
  public void addNode(Donor donor) {
    int donorId = donor.getDonorId();
    DonorNode newDonorNode = new DonorNode(donorId, donor);
    if (rootOfTree == null) {
      rootOfTree = newDonorNode;
    } else {
      DonorNode addDonorNode = rootOfTree;
      DonorNode parentNode;
      while (true) {
        parentNode = addDonorNode;
        if (donorId < addDonorNode.getDonorId()) {
          addDonorNode = addDonorNode.getLeftChild();
          if (addDonorNode == null) {
            parentNode.setLeftChild(newDonorNode);
            break;
          }
        } else {
          addDonorNode = addDonorNode.getRightChild();
          if (addDonorNode == null) {
            parentNode.setRightChild(newDonorNode);
            break;
          }
        }
      }
    }
  }
  /**
   * This method traverses the entire tree and calls the .toString method of every Donor found during traversal.
   * **/
  public void traverseTreeInOrder(DonorNode donorNode) {
    if (donorNode != null) {
      traverseTreeInOrder(donorNode.getLeftChild());
      System.out.println(donorNode.toString());
      traverseTreeInOrder(donorNode.getRightChild());
    }
  }
  /**
   * This method searches the entire BinaryTree to find a
   * @param donorId the donorId of the Donor attempting to be located.
   * once found the method will
   * @return the donorNode containing the Donor to the caller, if the Donor is not found, returns null.
   * **/
  public DonorNode findDonorInTree(int donorId) {
    DonorNode find = rootOfTree;
    while (find.getDonorId() != donorId) {
      if (donorId < find.getDonorId()) {
        find = find.getLeftChild();
      } else {
        find = find.getRightChild();
      }
      if (find == null) {
        return null;
      }
    }
    return find;

  }
/**
 * Method to remove a Donor from the BinaryTree this method will find a donor if it exists within the tree, once found
 * it will recursively move all elements of the tree into the correct positions according to which donor was removed.
 * This method requires a
 * @param donorId the donorId of the donor to be removed.
 * @return true if the donor was removed from the tree otherwise return false.
 * **/
  public boolean remove(int donorId) {
    boolean wasRemoved =true;
    DonorNode focusNode = rootOfTree;
    DonorNode parent = rootOfTree;
    boolean wasToTheLeft = true;
    while(wasRemoved){
      while (focusNode.getDonorId() != donorId) {
        parent = focusNode;
        if (donorId < focusNode.getDonorId()) {
          wasToTheLeft = true;
          focusNode = focusNode.getLeftChild();
        } else {
          wasToTheLeft = false;
          focusNode = focusNode.getRightChild();
        }
        if (focusNode == null) {
          wasRemoved= false;
        }
      }
      if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
        if (focusNode == rootOfTree) {
          rootOfTree = null;
        }
        else if (wasToTheLeft) {
          parent.setLeftChild(null);
        }
        else{
          parent.setRightChild(null);
        }
      }
      else if (focusNode.getRightChild() == null) {
        if (focusNode == rootOfTree) {
          rootOfTree = focusNode.getLeftChild();
        }
        else if (wasToTheLeft) {
          parent.setLeftChild(focusNode.getLeftChild());
        }
        else {
          parent.setRightChild(focusNode.getLeftChild());
        }
      }
      else if (focusNode.getLeftChild() == null) {
        if (focusNode == rootOfTree) {
          rootOfTree = focusNode.getRightChild();
        }
        else if (wasToTheLeft) {
          parent.setLeftChild(focusNode.getRightChild());
        }
        else {
          parent.setRightChild(focusNode.getRightChild());
        }
      }
      else {
        DonorNode replacement = getReplacementNode(focusNode);
        if (focusNode == rootOfTree) {
          rootOfTree = replacement;
        }
        else if (wasToTheLeft) {
          parent.setLeftChild(replacement);
        }
        else {
          parent.setRightChild(replacement);
        }
        replacement.setLeftChild(focusNode.getLeftChild());
      }
      break;
    }
    return wasRemoved;
  }
  /**
   * Method to determine the appropriate replacement node for when a node is being removed. This method is private and
   * will only ever be called by the remove method.
   * **/
  private DonorNode getReplacementNode(DonorNode replacedNode) {
    DonorNode replacementParent = replacedNode;
    DonorNode replacement = replacedNode;
    DonorNode focusNode = replacedNode.getRightChild();
    while (focusNode != null) {
      replacementParent = replacement;
      replacement = focusNode;
      focusNode = focusNode.getLeftChild();
    }
    if (replacement != replacedNode.getRightChild()) {
      replacementParent.setLeftChild(replacement.getRightChild());
      replacement.setRightChild(replacedNode.getRightChild());
    }
    return replacement;

  }
  /**
   * Method to get the root of the binary tree, primarily used to determine if the root of the tree is null.
   * **/
  public DonorNode getRootOfTree() {
    return rootOfTree;
  }
}


