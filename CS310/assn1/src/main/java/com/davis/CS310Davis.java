package com.davis;
/**
 * This class is used to test the functions of the Donor and Donation classes within this package.
 *
 * @author Samuel Kyle Davis
 *
 **/

import java.io.*;

/**
 * The type Cs 310 davis.
 */
public class CS310Davis {

    /**
     * The constant INPUT_FILENAME.
     */
    private static final String INPUT_FILENAME = "input/assn1input.txt";
    /**
     * The constant donor1ForTestSet3.
     */
    private static Donor donor1ForTestSet3;
    /**
     * The constant donation1ForTestSet3.
     */
    private static Donation donation1ForTestSet3;
    /**
     * The constant donor2ForTestSet3.
     */
    private static Donor donor2ForTestSet3;
    /**
     * The constant donation2ForTestSet3.
     */
    private static Donation donation2ForTestSet3;
    private static Donor donor1ForTestSet3Clone;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        performTestSet1();
        performTestSet2(INPUT_FILENAME);
        performTestSet3();
    }

    /**
     * Perform test set 1.
     */
    private static void performTestSet1() {
        //Test Set 1
        System.out.println("###### BEGINNING TEST SET 1 #####");

        //Test 1A
        System.out.println("##### START TEST 1A #####");
        Donor donor = new Donor(1000, "Sam", "Davis", "315-281-5502", "sam.davis@techngs.com");
        System.out.println(donor.toString());
        System.out.println("\n");
        System.out.println("##### END TEST 1A #####");
        //set variable for use in Test Set 3
        donor1ForTestSet3 = donor;
        donor1ForTestSet3Clone = new Donor(1,"George","Washington","202-123-4567","gwashington@mtvernon.com");

        //Test 1B-
        System.out.println("###### START TEST 1B #####");

        Donation donation = new Donation(1120, 1000, "Just a Simple Description", 50.25, "May 1st 2016", false, 150);
        System.out.println(donation.toString());
        System.out.println("\n");
        System.out.println("##### END TEST 1B ######");
        //set variable for use in Test Set 3
        donation1ForTestSet3 = donation;
        System.out.println("###### FINISHED TEST SET 1 #####");
    }

    /**
     * Perform test set 2.
     *
     * @param fileName the file name
     */
    private static void performTestSet2(String fileName) {
        System.out.println("###### BEGINNING TEST SET 2 #####");

        //Get file from resources folder
        ClassLoader classLoader = CS310Davis.class.getClassLoader();
        File file = null;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
        } catch (Exception e) {
            System.out.println("ERROR : The file " + fileName + " was unable to be found");
            e.printStackTrace();
            System.exit(1);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if(attributes[0].equalsIgnoreCase("DONOR")) {
                    //TEST 2A
                    System.out.println("###### START TEST 2A #####");

                    Donor d = new Donor();
                    Donor.setDonorAttributes(d, attributes);
                    Donor.getDonorAttributes(d);
                    //set variable for use in Test Set 3
                    donor2ForTestSet3 = d;
                    System.out.println("###### END TEST 2B #####");

                } else if (attributes[0].equalsIgnoreCase("DONATION")) {
                    //TEST 2B
                    System.out.println("###### START TEST 2B #####");

                    Donation dn = new Donation();
                    Donation.setDonationAttributes(dn, attributes);
                    Donation.getDonationAttributes(dn);
                    //set variable for use in Test Set 3
                    donation2ForTestSet3 = dn;
                    System.out.println("###### END TEST 2B #####");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("###### FINISHED TEST SET 2 #####");

    }

    /**
     * Perform test set 3.
     */
    private static void performTestSet3() {
        System.out.println("###### BEGINNING TEST SET 3 #####");
        System.out.println("###### START TEST 3A #####");
        System.out.println("Supplying two different donor objects.");
        if (donor1ForTestSet3.equals(donor2ForTestSet3)) {
            System.out.println("Donor objects are equal.");
        } else {
            System.out.println("Donor objects are not equal.");
        }
        System.out.println("Supplying two identical donor objects.");
        if (donor1ForTestSet3.equals(donor1ForTestSet3Clone)) {
            System.out.println("Donor objects are equal.");
        } else {
            System.out.println("Donor objects are not equal.");
        }
        System.out.println("###### END TEST 3A #####");

        System.out.println("###### START TEST 3B #####");
        System.out.println("Supplying two different donation objects.");

        if (donation1ForTestSet3.equals(donation2ForTestSet3)) {
            System.out.println("Donation objects are equal.");
        } else {
            System.out.println("Donation objects are not equal.");
        }
        System.out.println("Supplying two identical donation objects.");
        if (donation1ForTestSet3.equals(donation1ForTestSet3)) {
            System.out.println("Donation objects are equal.");
        } else {
            System.out.println("Donation objects are not equal.");
        }
        System.out.println("###### END TEST 3B #####");

        System.out.println("###### FINISHED TEST SET 3 #####");

    }
}
