package cs310davis.donation;


/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * This class is used to represent a Donation in memory. It contains methods that check the validity
 * of checks as well as methods to create a donation object from a file.
 *
 * @author Samuel Kyle Davis
 */
public class Donation {


  /**
   * The Donation Id (integer identification number - should be a unique value)
   */
  private Integer donationId;
  /**
   * Donor Id of the donor (integer identification number – should match a donor id in the donor
   * list)
   */
  private Integer donorId;
  /**
   * Description of the donation (String – up to length 25)
   */
  private String donationDescription;
  /**
   * The Donation amount.
   */
  private Double donationAmount;
  /**
   * The Donation date.
   */
  private String donationDate;
  /**
   * An indication if the donation is tax deductible (boolean)
   */
  private Boolean isDonationTaxDeductible;
  /**
   * The Donation check number.
   */
  private Integer donationCheckNumber;

  /**
   * Instantiates a new Donation.
   *
   * @param donationId              the donation id
   * @param donorId                 the donor id
   * @param donationDescription     the donation description
   * @param donationAmount          the donation amount
   * @param donationDate            the donation date
   * @param isDonationTaxDeductible the is donation tax deductible
   * @param donationCheckNumber     the donation check number
   */
  public Donation(Integer donationId, Integer donorId, String donationDescription, Double donationAmount, String
          donationDate, Boolean isDonationTaxDeductible, Integer donationCheckNumber) {
    this.donationId = donationId;
    this.donorId = donorId;
    this.donationDescription = shortenDescription(donationDescription);
    this.donationAmount = donationAmount;
    this.donationDate = donationDate;
    this.isDonationTaxDeductible = isDonationTaxDeductible;
    this.donationCheckNumber = donationCheckNumber;

  }

  /**
   * Shorten description string.
   *
   * @param donationDescription the donation description
   * @return the string
   */
  public static String shortenDescription(String donationDescription) {
    if (donationDescription.length() > 25) {
      donationDescription = donationDescription.substring(0, 25);
    }
    return donationDescription;
  }

  /**
   * Instantiates a new Donation.
   */
  public Donation() {

  }


  /**
   * Gets donation id.
   *
   * @return the donation id
   */
  public Integer getDonationId() {
    return donationId;
  }

  /**
   * Sets donation id.
   *
   * @param donationId the donation id
   */
  public void setDonationId(Integer donationId) {
    this.donationId = donationId;
  }

  /**
   * Gets donor id.
   *
   * @return the donor id
   */
  public Integer getDonorId() {
    return donorId;
  }

  /**
   * Gets donation description.
   *
   * @return the donation description
   */
  public String getDonationDescription() {
    return donationDescription;
  }

  /**
   * Gets donation amount.
   *
   * @return the donation amount
   */
  public Double getDonationAmount() {
    return donationAmount;
  }

  /**
   * Sets donation amount.
   *
   * @param donationAmount the donation amount
   */
  public void setDonationAmount(Double donationAmount) {
    this.donationAmount = donationAmount;
  }

  /**
   * Gets donation date.
   *
   * @return the donation date
   */
  public String getDonationDate() {
    return donationDate;
  }

  /**
   * Sets donation date.
   *
   * @param donationDate the donation date
   */
  public void setDonationDate(String donationDate) {
    this.donationDate = donationDate;
  }

  /**
   * Gets is donation tax deductible.
   *
   * @return the is donation tax deductible
   */
  public Boolean getIsDonationTaxDeductible() {
    return isDonationTaxDeductible;
  }

  /**
   * Gets donation check number.
   *
   * @return the donation check number
   */
  public Integer getDonationCheckNumber() {
    return donationCheckNumber;
  }

  /**
   * Sets donation check number.
   *
   * @param donationCheckNumber the donation check number
   */
  public void setDonationCheckNumber(Integer donationCheckNumber) {
    this.donationCheckNumber = donationCheckNumber;
  }

  /**
   * Sets is donation tax deductible.
   *
   * @param isDonationTaxDeductible the is donation tax deductible
   */
  public void setIsDonationTaxDeductible(Boolean isDonationTaxDeductible) {
    this.isDonationTaxDeductible = isDonationTaxDeductible;
  }

  /**
   * Sets donation description.
   *
   * @param donationDescription the donation description
   */
  public void setDonationDescription(String donationDescription) {
    this.donationDescription = donationDescription;
  }

  /**
   * Sets donor id.
   *
   * @param donorId the donor id
   */
  public void setDonorId(Integer donorId) {
    this.donorId = donorId;
  }

  /**
   * Is check valid boolean.
   *
   * @param donationCheckNumber the donation check number
   * @return the boolean
   */
  public static boolean isCheckValid(Integer donationCheckNumber) {
    return !(donationCheckNumber > 5000 || donationCheckNumber < 100);
  }

  /**
   * Equals boolean.
   *
   * @param obj the obj
   * @return the boolean
   */
  @Override
  public boolean equals(Object obj) {
    Donation donation = (Donation) obj;
    boolean isEqual = true;

    if (!donation.getDonorId().equals(donorId)) {
      isEqual = false;
    }

    if (!donation.getIsDonationTaxDeductible() == isDonationTaxDeductible) {
      isEqual = false;
    }
    if (!donation.getDonationAmount().equals(donationAmount)) {
      isEqual = false;
    }
    if (!donation.getDonationCheckNumber().equals(donationCheckNumber)) {
      isEqual = false;
    }
    if (!donation.getDonationDate().trim().equalsIgnoreCase(donationDate)) {
      isEqual = false;
    }
    if (!donation.getDonationDescription().trim().equalsIgnoreCase(donationDescription)) {
      isEqual = false;
    }
    if (!donation.getDonationId().equals(donationId)) {
      isEqual = false;
    }


    return isEqual;
  }

  /**
   * To string string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nDonation :: ID = ").append(String.valueOf(donationId)).append("\n");
    sb.append("Donation :: Donor ID = ").append(String.valueOf(donorId)).append("\n");
    sb.append("Donation :: Amount = ").append(String.valueOf(donationAmount)).append("\n");
    sb.append("Donation :: Date = ").append(donationDate).append("\n");
    sb.append("Donation :: Check Number = ").append(String.valueOf(donationCheckNumber)).append("\n");
    sb.append("Donation :: Description = ").append(donationDescription).append("\n");

    if (isDonationTaxDeductible) {
      sb.append("Donation :: Was Donation Tax Deductible  = Yes ").append("\n");
    } else {
      sb.append("Donation :: Was Donation Tax Deductible  = No ").append("\n");

    }
    return sb.toString();
  }
}
