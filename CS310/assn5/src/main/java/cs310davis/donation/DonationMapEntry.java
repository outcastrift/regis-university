package cs310davis.donation;


import cs310davis.CharityConstants;

/**
 * The type Donation map entry.
 */
public class DonationMapEntry {
  private DonationNode value;
  private int hash;

  /**
   * Instantiates a new Map entry.
   *
   * @param value the capacity
   */
  public DonationMapEntry(DonationNode value) {
    this.value = value;
    computeHash();
  }

  private void computeHash() {
    Integer id = null;
    String idStr = null;
    int theHash = 0;

    if (this.value != null && this.value.getDonation() != null) {
      id = this.value.getDonation().getDonationId();

      if (id != null) {
        idStr = String.valueOf(id);

        for (int i = 0; i < idStr.length(); i++) {
          theHash += idStr.charAt(i);
        }

        theHash = theHash % CharityConstants.DONATION_MAX_CAPACITY;
      }
    }

    this.hash = theHash;
  }

  /**
   * Gets value.
   *
   * @return the DonationNode
   */
  public DonationNode getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the DonationNode to set
   */
  public void setValue(DonationNode value) {
    this.value = value;
    this.computeHash();
  }

  /**
   * Gets hash.
   *
   * @return the hash
   */
  public int getHash() {
    return hash;
  }


}
