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
     * Variables to for use in Test Set 3
     */
    private static Donor donorTestSet3;
    private static Donation donationTestSet3;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       boolean testRun1 = performTestRun1();
       boolean testRun2=  performTestRun2();
       boolean testRun3= performTestRun3();
        
    }
    private static boolean performTestRun1(){
        boolean wasSuccessful = true;
        System.out.println("###### BEGINNING FIRST RUN : No test data input file in input folder.#####");
        // Run 1: No test data input file in input folder.
        boolean set1Success= performTestSet1();
        boolean set2Success= performTestSet2("InvalidFile/Path");
        boolean set3Success=performTestSet3();
        System.out.println("###### FINISHED FIRST RUN : No test data input file in input folder.#####");

        if(!set1Success && !set2Success && !set3Success){
            wasSuccessful =false;
        }
        return  wasSuccessful;
    }
    private static boolean performTestRun2(){
        boolean wasSuccessful = true;
        // Run 2: File email is invalid, file check number is invalid, one of the donations is not deductible,
        // and objects are not equal (at least one attribute value differs).
        System.out.println("###### BEGINNING SECOND RUN : File email is invalid, file check number is invalid, one of " +
                "the donations is not deductible, and objects are not equal (at least one attribute value differs)#####");
        boolean set1Success= performTestSet1();
        boolean set2Success= performTestSet2(INPUT_FILENAME);
        boolean set3Success=performTestSet3();
        System.out.println("###### FINISHED SECOND RUN : File email is invalid, file check number is invalid, one of" +
                " the donations is not deductible, and objects are not equal (at least one attribute value differs)#####");

        if(!set1Success && !set2Success && !set3Success){
            wasSuccessful =false;
        }
        return  wasSuccessful;
    }
    private static boolean performTestRun3(){
        boolean wasSuccessful = true;
        // Run 3: All data is valid, one of the donations is deductible, and the objects are equal (all attribute values are the same).
        System.out.println("###### BEGINNING THIRD RUN : All data is valid, one of the donations is deductible, and the" +
                " objects are equal (all attribute values are the same).#####");
        boolean set1Success= performTestSet1();
        boolean set2Success= performTestSet2(INPUT_FILENAME);
        boolean set3Success=performTestSet3();
        System.out.println("###### FINISHED THIRD RUN : All data is valid, one of the donations is deductible, and the " +
                "objects are equal (all attribute values are the same).#####");

        if(!set1Success && !set2Success && !set3Success){
            wasSuccessful =false;
        }

        return  wasSuccessful;
    }
    /**
     * Perform test set 1.
     */
    private static boolean performTestSet1() {
        boolean wasSuccessful =true;

        //Test Set 1
        System.out.println("###### BEGINNING TEST SET 1 #####");

        //Test 1A
        System.out.println("##### START TEST 1A #####");
        Donor donor = new Donor(1000, "Sam", "Davis", "315-281-5502", "sam.davis@techngs.com");
        System.out.println(donor.toString());
        System.out.println("\n");
        System.out.println("##### END TEST 1A #####");
        //set variable for use in Test Set 3
        donorTestSet3 = donor;
        //donor1ForTestSet3Clone = new Donor(1,"George","Washington","202-123-4567","gwashington@mtvernon.com");
        //Test 1B-
        System.out.println("###### START TEST 1B #####");

        Donation donation = new Donation(1120, 1000, "Just a Simple Description", 50.25, "May 1st 2016", false, 150);
        System.out.println(donation.toString());
        System.out.println("\n");
        System.out.println("##### END TEST 1B ######");
        //set variable for use in Test Set 3
        donationTestSet3 = donation;
        System.out.println("###### FINISHED TEST SET 1 #####");
        return  wasSuccessful;
    }

    /**
     * Perform test set 2.
     *
     * @param fileName the file name
     *@return true if successful false otherwise
     */
    private static boolean performTestSet2(String fileName) {
        boolean wasSuccessful =true;
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
                   test2A(attributes);
                } else if (attributes[0].equalsIgnoreCase("DONATION")) {
                  test2B(attributes);
                }
            }
        } catch (IOException  e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("###### FINISHED TEST SET 2 #####");
    return wasSuccessful;
    }
    private static void test2A(String[] attributes){
        //TEST 2A
        System.out.println("###### START TEST 2A #####");

        Donor d = new Donor();
        Donor.setDonorAttributes(d, attributes);
        Donor.getDonorAttributes(d);
        System.out.println("###### END TEST 2A #####");
    }

    private static void test2B(String[] attributes){
        //TEST 2B
        System.out.println("###### START TEST 2B #####");
        Donation dn = new Donation();
        Donation.setDonationAttributes(dn, attributes);
        Donation.getDonationAttributes(dn);
        System.out.println("###### END TEST 2B #####");
    }
    /**
     * Perform test set 3.
     */
    private static boolean performTestSet3() {
        boolean wasSuccessful = true;
        System.out.println("###### BEGINNING TEST SET 3 #####");
        boolean testSet3A = testDonorObjectsEquals();
        boolean testSet3B = testDonationObjectsEquals();
        if(!testSet3A && !testSet3B){
            wasSuccessful =false;
        }

        System.out.println("###### FINISHED TEST SET 3 #####");
        return wasSuccessful;
    }

    private static boolean testDonorObjectsEquals(){
        boolean wasSuccessful =true;
        System.out.println("###### START TEST 3A : Equals method Donor #####");
        System.out.println("Supplying two different donor objects.");
        boolean differentSuccessful =false;
        Donor donorDifferent = new Donor(1000, "Not", "TheSame", "315-281-5502", "sam.davis@techngs.com");
        if (donorTestSet3.equals(donorDifferent)) {
            System.out.println("Donor objects are equal.");
        } else {
            System.out.println("Donor objects are not equal.");
            differentSuccessful =true;
        }
        System.out.println("Supplying two identical donor objects.");
        Donor donorExactReplica = new Donor(1000, "Sam", "Davis", "315-281-5502", "sam.davis@techngs.com");
        boolean identicalSuccessful =false;
        if (donorTestSet3.equals(donorExactReplica)) {
            System.out.println("Donor objects are equal.");
            identicalSuccessful =true;
        }else {
            System.out.println("Donor objects are not equal.");
        }
        if(!differentSuccessful && !identicalSuccessful){
           wasSuccessful =false;
        }

        System.out.println("###### END TEST 3A : Equals method Donor #####");
        return wasSuccessful;
    }
    private static boolean testDonationObjectsEquals(){
        boolean wasSuccessful =true;
        System.out.println("###### START TEST 3B : Equals method Donation #####");
        System.out.println("Supplying two different donation objects.");
        boolean differentSuccessful =false;
        Donation donationDifferent = new Donation(1120, 1001, "Just a Simple different", 50.25, "May 1st 2015", false, 150);

        if (donationTestSet3.equals(donationDifferent)) {
            System.out.println("Donation objects are equal.");
        } else {
            System.out.println("Donation objects are not equal.");
            differentSuccessful =true;
        }
        System.out.println("Supplying two identical donation objects.");
        boolean identicalSuccessful =false;
        Donation donationExactReplica = new Donation(1120, 1000, "Just a Simple Description", 50.25, "May 1st 2016", false, 150);
        if (donationTestSet3.equals(donationExactReplica)) {
            System.out.println("Donation objects are equal.");
            identicalSuccessful =true;
        }else {
            System.out.println("Donation objects are not equal.");
        }
        if(!differentSuccessful && !identicalSuccessful){
            wasSuccessful =false;
        }
        System.out.println("###### END TEST 3B : Equals method Donation#####");
        return wasSuccessful;
    }


}
