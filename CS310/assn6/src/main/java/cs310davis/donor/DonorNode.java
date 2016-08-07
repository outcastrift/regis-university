package cs310davis.donor;

public class DonorNode {

  int donorId;
  private Donor donor;

  private DonorNode leftChild;
  private DonorNode rightChild;

  /**
   * Public constructor for a DonorNode.
   **/
  public DonorNode(int donorId, Donor donor) {
    this.donorId = donorId;
    this.donor = donor;
  }

  /**
   * Convenience method to return the donor .toString method.
   **/
  public String toString() {

    return donor.toString() + " has a donor id number of " + donorId;

  }

  public int getDonorId() {
    return donorId;
  }

  public void setDonorId(int donorId) {
    this.donorId = donorId;
  }

  public Donor getDonor() {
    return donor;
  }

  public void setDonor(Donor donor) {
    this.donor = donor;
  }

  public DonorNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(DonorNode leftChild) {
    this.leftChild = leftChild;
  }

  public DonorNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(DonorNode rightChild) {
    this.rightChild = rightChild;
  }
}