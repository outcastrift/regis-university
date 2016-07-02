package com.davis;


/**
 * This class is used to represent a Donation in memory.
 * It contains methods that check the validity of checks as well as methods to create a donation object from a file.
 *
 * @author Samuel Kyle Davis
 *
 */
public class Donation {


    /**
     * The Donation Id (integer identification number - should be a unique value)
     */
    private Integer donationId;
    /**
     * Donor Id of the donor (integer identification number – should match a donor id in the donor list)
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
    public Donation(Integer donationId, Integer donorId, String donationDescription,
                    Double donationAmount, String donationDate, Boolean isDonationTaxDeductible,
                    Integer donationCheckNumber) {
        this.donationId = donationId;
        this.donorId = donorId;
        this.donationDescription = shortenDescription(donationDescription);
        this.donationAmount = donationAmount;
        this.donationDate = donationDate;
        this.isDonationTaxDeductible = isDonationTaxDeductible;
        this.donationCheckNumber = donationCheckNumber;

    }

    /**
     * Instantiates a new Donation.
     */
    public Donation() {

    }

    /**
     * Shorten description string.
     *
     * @param donationDescription the donation description
     * @return the string
     */
    private static String shortenDescription(String donationDescription) {
        if (donationDescription.length() > 25) {
            donationDescription = donationDescription.substring(0, 25);
        }
        return donationDescription;
    }

    /**
     * Sets donation attributes.
     * @param donation   and then
     * @param attributes and populates a
     * @return donation <p> Attributes must be in this specified order: Integer donationId Integer donorId String donationDescription Double donationAmount String donationDate Boolean isDonationTaxDeductible Integer donationCheckNumber
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static Donation setDonationAttributes(Donation donation, String[] attributes) throws IllegalArgumentException {
        Integer donationId = Integer.valueOf(attributes[1]);
        donation.setDonationId(donationId);
        Integer donorID = Integer.valueOf(attributes[2]);
        donation.setDonorId(donorID);
        donation.setDonationDescription(shortenDescription(attributes[3]));
        donation.setDonationAmount(Double.parseDouble(attributes[4]));
        donation.setDonationDate(attributes[5]);
        donation.setIsDonationTaxDeductible(Boolean.valueOf(attributes[6]));
        donation.setDonationCheckNumber(Integer.valueOf(attributes[7]));
        if (!isCheckValid(donation.getDonationCheckNumber())) {
            throw new IllegalArgumentException("ERROR : The check number supplied during creation of the donation was invalid. Check number must be within the range of 100 to 5000 Check Number = "
                    + donation.getDonationCheckNumber());
        }

        return donation;
    }

    /**
     * Gets donation attributes.
     *
     * @param donation the donation
     */
    public static void getDonationAttributes(Donation donation) {
        System.out.println(donation.getDonationId() + "\n");
        System.out.println(donation.getDonorId() + "\n");
        System.out.println(donation.getDonationDescription() + "\n");
        System.out.println(donation.getDonationAmount() + "\n");
        System.out.println(donation.getDonationDate() + "\n");
        System.out.println(donation.getIsDonationTaxDeductible() + "\n");
        System.out.println(donation.getDonationCheckNumber() + "\n");


    }

    /**
     * Is check valid boolean.
     *
     * @param donationCheckNumber the donation check number
     * @return the boolean
     */
    private static boolean isCheckValid(Integer donationCheckNumber) {
        if (donationCheckNumber > 5000 || donationCheckNumber < 100) {
            //check number is either below 100 or higher than 5000
            return false;
        } else {
            //check number is between 100 and 5000 exclusive
            return true;
        }
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
     * Gets donation description.
     *
     * @return the donation description
     */
    public String getDonationDescription() {
        return donationDescription;
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
     * Sets donor id.
     *
     * @param donorId the donor id
     */
    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
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
     * Sets is donation tax deductible.
     *
     * @param isDonationTaxDeductible the is donation tax deductible
     */
    public void setIsDonationTaxDeductible(Boolean isDonationTaxDeductible) {
        this.isDonationTaxDeductible = isDonationTaxDeductible;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Donation :: ID = ").append(String.valueOf(donationId)).append("\n");
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
