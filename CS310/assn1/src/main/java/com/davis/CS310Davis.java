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
     * The constant INPUT_FILENAME. : Location of the Input File.
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
        System.out.println("###### BEGINNING TEST RUNS #####");

       boolean testRun1 = performTestRun1();
       boolean testRun2 =  performTestRun2();
       boolean testRun3 = performTestRun3();
        System.out.println("###### FINISHED TEST RUNS #####");
        if(testRun1 && testRun2 &&testRun3){
           System.out.println("ALL RUNS WERE SUCCESSFUL");
        }else{
            System.out.println("NOT ALL RUNS WERE SUCCESSFUL EVALUATE CONSOLE OUTPUT FOR DETAILS");

        }


    }
    private static boolean performTestRun1(){
        boolean wasSuccessful = false;
        System.out.println("###### BEGINNING FIRST RUN : No test data input file in input folder.#####");
        // Run 1: No test data input file in input folder.
        performTestSet1(false , false);
        boolean set2Success = performTestSet2("InvalidFile/Path");
        boolean set3Success =false;
        if(set2Success){
            //Test set 2 successful , perform test set 3
            set3Success = performTestSet3(true , true);
        }
        if(!set2Success && !set3Success){
            wasSuccessful =true;
        }
        String resultString = null;
        if(wasSuccessful){
            resultString = "SUCCESS";
        }else{
            resultString = "UNSUCCESSFUL";
        }
        System.out.println("###### FINISHED FIRST RUN : No test data input file in input folder. RESULT = "+resultString+" #####");


        return  wasSuccessful;
    }
    private static boolean performTestRun2(){
        boolean wasSuccessful = false;
        // Run 2: File email is invalid, file check number is invalid, one of the donations is not deductible,
        // and objects are not equal (at least one attribute value differs).
        System.out.println("###### BEGINNING SECOND RUN : File email is invalid, file check number is invalid, one of " +
                "the donations is not deductible, and objects are not equal (at least one attribute value differs) #####");
        performTestSet1(true , true);
        boolean set2Success = performTestSet2(INPUT_FILENAME);
        boolean set3Success =false;
        if(set2Success){
            //Test set 2 successful , perform test set 3
            set3Success = performTestSet3(false , false);
        }
        if(set2Success && set3Success){
            wasSuccessful =true;
        }
        String resultString = null;
        if(wasSuccessful){
            resultString = "SUCCESS";
        }else{
            resultString = "UNSUCCESSFUL";
        }
        System.out.println("###### FINISHED SECOND RUN : File email is invalid, file check number is invalid, one of" +
                " the donations is not deductible, and objects are not equal (at least one attribute value differs) RESULT = "+resultString+" #####");


        return  wasSuccessful;
    }

    private static boolean performTestRun3(){
        boolean wasSuccessful = false;
        // Run 3: All data is valid, one of the donations is deductible, and the objects are equal (all attribute values are the same).
        System.out.println("###### BEGINNING THIRD RUN : All data is valid, one of the donations is deductible, and the" +
                " objects are equal (all attribute values are the same).#####");

        performTestSet1(false , false);

        boolean set2Success = performTestSet2(INPUT_FILENAME);

        boolean set3Success =false;

        if(set2Success){
            //Test set 2 successful , perform test set 3
            set3Success = performTestSet3(true , true);
        }
        if(set2Success && set3Success){
            wasSuccessful =true;
        }
        String resultString = null;
        if(wasSuccessful){
           resultString = "SUCCESS";
        }else{
            resultString = "UNSUCCESSFUL";
        }
        System.out.println("###### FINISHED THIRD RUN : All data is valid, one of the donations is deductible, and the " +
                "objects are equal (all attribute values are the same). RESULT = "+resultString+" #####");


        return  wasSuccessful;
    }
    /**
     * Perform test set 1.
     */
    private static void performTestSet1(boolean isEmailInvalid, boolean isCheckInvalid) {
        String email =null;
        Integer checkNumber = null;
        if(isEmailInvalid){
            email="sam.davistechngs.com";
        }else{
            email="sam.davis@techngs.com";
        }

        if(isCheckInvalid){
            checkNumber=99;

        }else{
           checkNumber=150;
        }
        //Test Set 1
        System.out.println("###### BEGINNING TEST SET 1 #####");

        //Test 1A
        System.out.println("##### START TEST 1A #####");
        Donor donor = new Donor(1000, "Sam", "Davis", "315-281-5502", email);
        System.out.println(donor.toString());
        System.out.println("\n");
        System.out.println("##### END TEST 1A #####");
        //set variable for use in Test Set 3
        donorTestSet3 = donor;
        //Test 1B-
        System.out.println("###### START TEST 1B #####");

        Donation donation = new Donation(1120, 1000, "Just a Simple Description", 50.25, "May 1st 2016", false, checkNumber);
        System.out.println(donation.toString());
        System.out.println("\n");
        System.out.println("##### END TEST 1B ######");
        //set variable for use in Test Set 3
        donationTestSet3 = donation;
        System.out.println("###### FINISHED TEST SET 1 #####");
    }

    /**
     * Perform test set 2.
     *
     * @param fileName the file name
     * @return true if successful false otherwise
     */
    private static boolean performTestSet2(String fileName) {
        boolean wasSuccessful =true;
        System.out.println("###### BEGINNING TEST SET 2 #####");

        //Get file from resources folder
        ClassLoader classLoader = CS310Davis.class.getClassLoader();
        File file = null;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
            //file = new File(fileName);
        } catch (Exception e) {
            System.out.println("ERROR : The file " + fileName + " was unable to be found");
            wasSuccessful =false;
            return wasSuccessful;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            //While the reader has a line to read
            while ((line = br.readLine()) != null) {
                //Create a String[] of the values upon that line--Splitting on Commas
                String[] attributes = line.split(",");
                //If the first value is DONOR its a Donor and perform test2A
                if(attributes[0].equalsIgnoreCase("DONOR")) {
                   test2A(attributes);
                    //Else if the first value is DONATION its a DONATION and perform test2B
                } else if (attributes[0].equalsIgnoreCase("DONATION")) {
                  test2B(attributes);
                }
            }
        } catch (IOException  e) {
            e.printStackTrace();
           wasSuccessful =false;
        }
        System.out.println("###### FINISHED TEST SET 2 #####");
    return wasSuccessful;
    }
    private static void test2A(String[] attributes){
        //TEST 2A
        System.out.println("###### START TEST 2A #####");
        //Instantiate New Object
        Donor d = new Donor();
        //Set values on Object
        setDonorAttributes( attributes);
        //Printing Attributes to Console
        getDonorAttributes(d);
        System.out.println("###### END TEST 2A #####");
    }

    private static void test2B(String[] attributes){
        //TEST 2B
        System.out.println("###### START TEST 2B #####");
        //Instantiate New Object
        Donation dn = new Donation();
        //Set values on Object
        Donation.setDonationAttributes(dn, attributes);
        //Printing Attributes to Console
        Donation.getDonationAttributes(dn);
        System.out.println("###### END TEST 2B #####");
    }




    /**
     * Perform test set 3.
     */
    private static boolean performTestSet3(boolean shouldDonorsBeEqual,boolean shouldDonationsBeEqual) {
        boolean wasSuccessful = true;
        System.out.println("###### BEGINNING TEST SET 3 #####");
        boolean testSet3A = testDonorObjectsEquals(shouldDonorsBeEqual);
        boolean testSet3B = testDonationObjectsEquals(shouldDonationsBeEqual);
        if(!testSet3A || !testSet3B){
            wasSuccessful =false;
        }

        System.out.println("###### FINISHED TEST SET 3 #####");
        return wasSuccessful;
    }

    private static boolean testDonorObjectsEquals(boolean shouldDonorsBeEqual){
        boolean wasSuccessful =true;
        System.out.println("###### START TEST 3A : Equals method Donor #####");

        if(shouldDonorsBeEqual){
            System.out.println("Supplying two identical donor objects.");
            //Creating exact Replica
            Donor donorExactReplica = new Donor();
            donorExactReplica.setDonorId(donorTestSet3.getDonorId());
            donorExactReplica.setDonorEmailAddress(donorTestSet3.getDonorEmailAddress());
            donorExactReplica.setDonorFirstName(donorTestSet3.getDonorFirstName());
            donorExactReplica.setDonorLastName(donorTestSet3.getDonorLastName());
            donorExactReplica.setDonorPhoneNumber(donorTestSet3.getDonorPhoneNumber());


            if (donorTestSet3.equals(donorExactReplica)) {
                System.out.println("Donor objects are equal.");
                wasSuccessful =true;
            }else {
                System.out.println("Donor objects are not equal.");
            }
        }else{
            System.out.println("Supplying two different donor objects.");

            Donor donorDifferent = new Donor(1000, "Not", "TheSame", "315-281-5502", "sam.davis@techngs.com");
            if (donorTestSet3.equals(donorDifferent)) {
                System.out.println("Donor objects are equal.");
            } else {
                System.out.println("Donor objects are not equal.");
                wasSuccessful =true;
            }
        }
        System.out.println("###### END TEST 3A : Equals method Donor #####");
        return wasSuccessful;
    }
    private static boolean testDonationObjectsEquals(boolean shouldDonationsBeEqual){
        boolean wasSuccessful =true;
        System.out.println("###### START TEST 3B : Equals method Donation #####");
        if(shouldDonationsBeEqual){
            System.out.println("Supplying two identical donation objects.");

            //Create exact replica
            Donation donationExactReplica = new Donation();
            donationExactReplica.setDonationAmount(donationTestSet3.getDonationAmount());
            donationExactReplica.setDonationCheckNumber(donationTestSet3.getDonationCheckNumber());
            donationExactReplica.setDonationDate(donationTestSet3.getDonationDate());
            donationExactReplica.setDonationDescription(donationTestSet3.getDonationDescription());
            donationExactReplica.setDonationId(donationTestSet3.getDonationId());
            donationExactReplica.setIsDonationTaxDeductible(donationTestSet3.getIsDonationTaxDeductible());
            donationExactReplica.setDonorId(donationTestSet3.getDonorId());

            if (donationTestSet3.equals(donationExactReplica)) {
                System.out.println("Donation objects are equal.");
                wasSuccessful =true;
            }else {
                System.out.println("Donation objects are not equal.");
                wasSuccessful =false;
            }
        }else{
            System.out.println("Supplying two different donation objects.");
            //create a different one.
            Donation donationDifferent = new Donation(1120, 1001, "Just a Simple different", 50.25, "May 1st 2015", false, 150);

            if (donationTestSet3.equals(donationDifferent)) {
                System.out.println("Donation objects are equal.");
                wasSuccessful =false;
            } else {
                System.out.println("Donation objects are not equal.");
                wasSuccessful =true;
            }
        }
        System.out.println("###### END TEST 3B : Equals method Donation#####");
        return wasSuccessful;
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
     * Takes a String[]
     * @param attributes and populates a
     * @return donor <p> Attributes must be in this specified order: Integer donorId, String donorFirstName, String donorLastName, String donorEmailAddress String donorPhoneNumber
     */
    public static Donor setDonorAttributes(  String[] attributes) {
        Donor donor = new Donor();
        Integer integer = Integer.valueOf(attributes[1]);
        donor.setDonorId(integer);
        donor.setDonorFirstName(attributes[2]);
        donor.setDonorLastName(attributes[3]);
        donor.setDonorPhoneNumber(attributes[5]);
        donor.setDonorEmailAddress(attributes[4]);
        if (!donor.isEmailValid(donor.getDonorEmailAddress())) {
            System.out.println("ERROR : The email supplied during creation of a Donor was invalid. Email did not contain a \"@\" symbol"
                    + donor.getDonorEmailAddress());
        }

        return donor;
    }

}
