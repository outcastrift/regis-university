package cs310davis;

import java.io.*;

/**
 * Main Entry class for this program, it will process a input file and create a report in a pre-defined directory based on the content of the file.
 *
 * @author Samuel Kyle Davis
 **/

public class CS310Davis {


    /**
     * The input file to parse.
     */
    private static final String INPUT_FILENAME = "input/assn2input1.txt";
    /**
     * The Donor log.
     */
    static DonorLogImpl donorLogImpl = new DonorLogImpl();
    /**
     * The Donation log.
     */
    static DonationLogImpl donationLogImpl = new DonationLogImpl();
    /**
     * The Print.
     */
    static PrintImpl printImpl = new PrintImpl();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Call the method to read and process the data file.
        processFile();
        // Call the method to create the report.
        createReport();
    }

    /**
     * Method to process a Donor addition to the list
     *
     * @param inputLineValues the String[] containing the line read from a file.
     */
    public static void processDonorAddition(String[] inputLineValues) {
        Donor d = setDonorAttributes(inputLineValues);
        if (donorLogImpl.isIdUnique(d.getDonorId())) {
            donorLogImpl.add(d);
        } else {
            //donor was not unique
            System.out.println("\n The donor specified will not be added to the list." +
                    " The donor did not have a unique ID \n " + d.toString());
        }
    }

    /**
     * Method to process a Donation addition to the list.
     *
     * @param inputLineValues the String[] containing the line read from a file.
     *                        Creates a Donation from input :                        If the Donor
     *                        id IS NOT Unique, and the Donation id IS UNIQUE it stores it into the
     *                        database.
     */
    public static void processDonationAddition(String[] inputLineValues) {
        Donation dn = setDonationAttributes(inputLineValues);

        if (!donorLogImpl.isIdUnique(dn.getDonorId())) {
            if (donationLogImpl.isIdUnique(dn.getDonationId())) {
                donationLogImpl.add(dn);
            } else {
                //donation ID wasn't unique
                System.out.println("\n The donation id specified within the donation will not be added to the list." +
                        " The donation did not have a unique ID \n " + dn.toString());
            }
        } else {
            //donor id was unique
            System.out.println("\n The donor specified within the donation will not be added to the list." +
                    " The donation was not added the donor id was not already in the database \n " + dn.toString());
        }

    }

    /**
     * Populates a donation objects with values.
     *
     * @param attributes and populates a
     * @return donation <p> Attributes must be in this specified order: Integer donationId Integer
     * donorId String donationDescription Double donationAmount String donationDate Boolean
     * isDonationTaxDeductible Integer donationCheckNumber
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static Donation setDonationAttributes(String[] attributes) {
        Donation donation = new Donation();
        Integer donationId = Integer.valueOf(attributes[2]);
        donation.setDonationId(donationId);
        Integer donorID = Integer.valueOf(attributes[3]);
        donation.setDonorId(donorID);
        donation.setDonationDescription(Donation.shortenDescription(attributes[4]));
        donation.setDonationAmount(Double.parseDouble(attributes[5]));
        donation.setDonationDate(attributes[6]);
        donation.setIsDonationTaxDeductible(Boolean.valueOf(attributes[7]));
        donation.setDonationCheckNumber(Integer.valueOf(attributes[8]));
        if (!Donation.isCheckValid(donation.getDonationCheckNumber())) {
            System.out.println("ERROR : The check number supplied during creation of the donation was invalid. Check number must be within the range of 100 to 5000 Check Number = "
                    + donation.getDonationCheckNumber());
        }

        return donation;
    }

    /**
     * Method to process a Donor deletion
     *
     * @param inputLineValues the String[] containing the line read from a file.
     *                        Based on input it will search the donor database and remove the
     *                        donor.                         Prints a error if no donor exists with
     *                        the given id.
     */
    public static void processDonorDeletion(String[] inputLineValues) {
        int donorId = Integer.valueOf(inputLineValues[3]);
        if (!donorLogImpl.isIdUnique(donorId)) {
            donorLogImpl.remove(donorId);
            donationLogImpl.remove(donorId);
            System.out.println("\n A donor with the id of " + donorId + " and his donations was successfully deleted from the donor and donation list.");

        } else {
            System.out.println("\n ERROR : A donor with the id of " + donorId + "was not within the donor list and was not deleted.");

        }
    }

    /**
     * Method to process a Donation deletion.
     *
     * @param inputLineValues the String[] containing the line read from a file.
     *                        Based on input it will search the donation database and remove the
     *                        donation.                         Prints a error if no donation exists
     *                        with the given id.
     */
    public static void processDonationDeletion(String[] inputLineValues) {
        int donationId = Integer.valueOf(inputLineValues[3]);
        if (!donationLogImpl.isIdUnique(donationId)) {
            donationLogImpl.remove(donationId);
            System.out.println("\n A donation with the id of " + donationId + " was successfully deleted.");
        } else {
            System.out.println("\n ERROR : A donation with the id of " + donationId + " was not within the list and was not deleted.");

        }
    }

    /**
     * Method to read a data file and process each data line A exception will occur if the file can
     * not be opened. If the file opens, for each line in the data file: This method will: Call a
     * method to do the addition/deletion for either a Donor or a Donation, passing in the parsed
     * String array as a parameter.
     */
    private static void processFile() {

        ClassLoader classLoader = CS310Davis.class.getClassLoader();
        File file = null;
        try {
            file = new File(classLoader.getResource(INPUT_FILENAME).getFile());
        } catch (Exception e) {
            System.out.println("\n ERROR : The file " + file.getName() + " was unable to be found");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Reading data from file " + file.getName());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes[0].equalsIgnoreCase("DONOR")) {
                    if (attributes[1].equalsIgnoreCase("ADD")) {
                        processDonorAddition(attributes);
                    } else if (attributes[1].equalsIgnoreCase("DEL")) {
                        processDonorDeletion(attributes);
                    }


                } else if (attributes[0].equalsIgnoreCase("DONATION")) {
                    if (attributes[1].equalsIgnoreCase("ADD")) {
                        processDonationAddition(attributes);
                    } else if (attributes[1].equalsIgnoreCase("DEL")) {
                        processDonationDeletion(attributes);
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Populates a Donor object with supplied values from a String[].
     *
     * @param attributes and populates a
     * @return donor <p> Attributes must be in this specified order: Integer donorId, String
     * donorFirstName, String donorLastName, String donorEmailAddress String donorPhoneNumber
     */
    public static Donor setDonorAttributes(String[] attributes) {
        Donor donor = new Donor();
        Integer integer = Integer.valueOf(attributes[2]);
        donor.setDonorId(integer);
        donor.setDonorFirstName(attributes[3]);
        donor.setDonorLastName(attributes[4]);
        donor.setDonorEmailAddress(attributes[5]);
        if (!donor.isEmailValid(donor.getDonorEmailAddress())) {
            System.out.println("ERROR : The email supplied during creation of a Donor was invalid. Email did not contain a \"@\" symbol"
                    + donor.getDonorEmailAddress());
        }
        donor.setDonorPhoneNumber(attributes[6]);

        return donor;
    }

    /**
     * Gets donor attributes and then prints them out to the console.
     *
     * @param donor the donor
     */
    public static void getDonorAttributes(Donor donor) {
        System.out.println(donor.getDonorId() + "\n");
        System.out.println(donor.getDonorFirstName() + "\n");
        System.out.println(donor.getDonorLastName() + "\n");
        System.out.println(donor.getDonorPhoneNumber() + "\n");
        System.out.println(donor.getDonorEmailAddress() + "\n");

    }

    /**
     * Method to create a report via the PrintImpl.class.
     */
    public static void createReport() {
        printImpl.printReportToDirectory();
    }

}
