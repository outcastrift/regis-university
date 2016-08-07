package cs310davis.donor;

/**
 * This software was created for Regis University's CS310 course.
 * rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 *
 * Class Description
 * This class is the implementation of a BinarySearchTree for Donors.
 * @author Samuel Davis created on 8/7/16.
 */
public class DonorBinaryTree {

  /**
   * Root of the BinarySearchTree
   * **/
  private DonorNode rootOfTree;
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
   * Private method to traverses the entire tree and calls the .toString method of every Donor found during traversal.
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
    DonorNode deleteNode = rootOfTree;
    DonorNode parentDeleteNode = rootOfTree;
    boolean wasToTheLeft = true;
    while(wasRemoved){
      while (deleteNode.getDonorId() != donorId) {
        parentDeleteNode = deleteNode;
        if (donorId < deleteNode.getDonorId()) {
          wasToTheLeft = true;
          deleteNode = deleteNode.getLeftChild();
        } else {
          wasToTheLeft = false;
          deleteNode = deleteNode.getRightChild();
        }
        if (deleteNode == null) {
          wasRemoved= false;
        }
      }
      if (deleteNode.getLeftChild() == null && deleteNode.getRightChild() == null) {
        if (deleteNode == rootOfTree) {
          rootOfTree = null;
        }
        else if (wasToTheLeft) {
          parentDeleteNode.setLeftChild(null);
        }
        else{
          parentDeleteNode.setRightChild(null);
        }
      }
      else if (deleteNode.getRightChild() == null) {
        if (deleteNode == rootOfTree) {
          rootOfTree = deleteNode.getLeftChild();
        }
        else if (wasToTheLeft) {
          parentDeleteNode.setLeftChild(deleteNode.getLeftChild());
        }
        else {
          parentDeleteNode.setRightChild(deleteNode.getLeftChild());
        }
      }
      else if (deleteNode.getLeftChild() == null) {
        if (deleteNode == rootOfTree) {
          rootOfTree = deleteNode.getRightChild();
        }
        else if (wasToTheLeft) {
          parentDeleteNode.setLeftChild(deleteNode.getRightChild());
        }
        else {
          parentDeleteNode.setRightChild(deleteNode.getRightChild());
        }
      }
      else {
        DonorNode newDonorNode = getReplacementDonorNode(deleteNode);


        if (deleteNode == rootOfTree) {
          rootOfTree = newDonorNode;
        }
        else if (wasToTheLeft) {
          parentDeleteNode.setLeftChild(newDonorNode);
        }
        else {
          parentDeleteNode.setRightChild(newDonorNode);
        }
        newDonorNode.setLeftChild(deleteNode.getLeftChild());
      }
      break;
    }
    return wasRemoved;
  }
  /**
   * Method to determine the appropriate replacement node for when a node is being removed. This method is private and
   * will only ever be called by the remove method.
   * @param incomingNode the donor node to perform replacement logic on
   * @return the donorNode that the logic has been performed on.
   * **/
  private DonorNode getReplacementDonorNode(DonorNode incomingNode) {
    DonorNode replacementParent = incomingNode;
    DonorNode replacement = incomingNode;
    DonorNode nodeToReplace = incomingNode.getRightChild();
    while (nodeToReplace != null) {
      replacementParent = replacement;
      replacement = nodeToReplace;
      nodeToReplace = nodeToReplace.getLeftChild();
    }
    if (replacement != incomingNode.getRightChild()) {
      replacementParent.setLeftChild(replacement.getRightChild());
      replacement.setRightChild(incomingNode.getRightChild());
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


