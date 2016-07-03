package com.davis;

/**
 * This class is used to represent a Donor in memory.
 * It contains methods that check the validity of emails as well as methods to create a donor object from a file.
 *
 * @author Samuel Kyle Davis
 *
 */
public class Donor {
    /**
     * Donor Id (integer identification number - should be a unique value)
     */
    private Integer donorId;
    /**
     * The Donor first name.
     */
    private String donorFirstName;
    /**
     * The Donor last name.
     */
    private String donorLastName;
    /**
     * The Donor phone number.
     */
    private String donorPhoneNumber;
    /**
     * The Donor email address.
     */
    private String donorEmailAddress;


    /**
     * Instantiates a new Donor.
     *
     * @param donorId           the donor id
     * @param donorFirstName    the donor first name
     * @param donorLastName     the donor last name
     * @param donorPhoneNumber  the donor phone number
     * @param donorEmailAddress the donor email address
     */
    public Donor(Integer donorId, String donorFirstName, String donorLastName,
                 String donorPhoneNumber, String donorEmailAddress) {
        this.donorId = donorId;
        this.donorFirstName = donorFirstName;
        this.donorLastName = donorLastName;
        this.donorPhoneNumber = donorPhoneNumber;
        this.donorEmailAddress = donorEmailAddress;
    }

    /**
     * Instantiates a new Donor.
     */
    public Donor() {

    }

    /**
     * Takes a String[]
     *
     * @param donor      and then
     * @param attributes and populates a
     * @return donor <p> Attributes must be in this specified order: Integer donorId, String donorFirstName, String donorLastName, String donorEmailAddress String donorPhoneNumber
     */
    public static Donor setDonorAttributes(Donor donor, String[] attributes) {
        Integer integer = Integer.valueOf(attributes[1]);
        donor.setDonorId(integer);
        donor.setDonorFirstName(attributes[2]);
        donor.setDonorLastName(attributes[3]);
        donor.setDonorPhoneNumber(attributes[5]);
        donor.setDonorEmailAddress(attributes[4]);
        if (!isEmailValid(donor.getDonorEmailAddress())) {
            System.out.println("ERROR : The email supplied during creation of a Donor was invalid. Email did not contain a \"@\" symbol"
                    + donor.getDonorEmailAddress());
        }

        return donor;
    }

    /**
     * Gets donor attributes.
     *
     * @param donor the donor
     */
    public static void getDonorAttributes(Donor donor) {
        System.out.println(donor.getDonorId() );
        System.out.println(donor.getDonorFirstName() );
        System.out.println(donor.getDonorLastName() );
        System.out.println(donor.getDonorPhoneNumber() );
        System.out.println(donor.getDonorEmailAddress() );

    }

    /**
     * Checks if a email is valid by looking for a @ symbol.
     *
     * @param donorEmailAddress the email
     * @return the boolean
     */
    private static boolean isEmailValid(String donorEmailAddress) {
        if (!donorEmailAddress.contains("@")) {
            //email doesn't contain the @ symbol
            return false;
        } else {
            //email does contain the @ symbol
            return true;
        }
    }

    /**
     * Gets donor email address.
     *
     * @return the donor email address
     */
    public   String getDonorEmailAddress() {
        return donorEmailAddress;
    }

    /**
     * Sets donor email address.
     *
     * @param donorEmailAddress the donor email address
     */
    public void setDonorEmailAddress(String donorEmailAddress) {
        this.donorEmailAddress = donorEmailAddress;
    }

    /**
     * Gets donor first name.
     *
     * @return the donor first name
     */
    public String getDonorFirstName() {
        return donorFirstName;
    }

    /**
     * Sets donor first name.
     *
     * @param donorFirstName the donor first name
     */
    public void setDonorFirstName(String donorFirstName) {
        this.donorFirstName = donorFirstName;
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
     * Gets donor last name.
     *
     * @return the donor last name
     */
    public String getDonorLastName() {
        return donorLastName;
    }

    /**
     * Sets donor last name.
     *
     * @param donorLastName the donor last name
     */
    public void setDonorLastName(String donorLastName) {
        this.donorLastName = donorLastName;
    }

    /**
     * Gets donor phone number.
     *
     * @return the donor phone number
     */
    public String getDonorPhoneNumber() {
        return donorPhoneNumber;
    }

    /**
     * Sets donor phone number.
     *
     * @param donorPhoneNumber the donor phone number
     */
    public void setDonorPhoneNumber(String donorPhoneNumber) {
        this.donorPhoneNumber = donorPhoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Donor donor = (Donor) obj;
        boolean isEqual = true;

        if(!donor.getDonorEmailAddress().trim().equalsIgnoreCase(donorEmailAddress)){
            isEqual =false;
        }
        if(!donor.getDonorFirstName().trim().equalsIgnoreCase(donorFirstName)){
            isEqual =false;
        }
        if(!donor.getDonorId().equals(donorId)){
            isEqual =false;
        }
        if(!donor.getDonorLastName().trim().equalsIgnoreCase(donorLastName)){
            isEqual =false;
        }
        if(!donor.getDonorPhoneNumber().trim().equalsIgnoreCase(donorPhoneNumber)){
            isEqual =false;
        }
        return isEqual;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Donor :: ID = ").append(donorId).append("\n");
        sb.append("Donor :: First Name = ").append(donorFirstName).append("\n");
        sb.append("Donor :: Last Name = ").append(donorLastName).append("\n");
        sb.append("Donor :: Phone Number = ").append(donorPhoneNumber).append("\n");
        sb.append("Donor :: Email Address = ").append(donorEmailAddress).append("\n");
        return sb.toString();
    }
}
