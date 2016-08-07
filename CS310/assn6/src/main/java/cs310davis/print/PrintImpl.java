package cs310davis.print;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cs310davis.donation.Donation;
import cs310davis.donation.DonationImpl;
import cs310davis.donor.Donor;
import cs310davis.donor.DonorImpl;

/**
 * This class is a implementation class to create a results report after ingesting data to the Donation and Donor
 * databases. This class contains only one function, which is used to create a text file at a pre-configured location
 * relative to where the code was ran. <p> This is the primary way of creating a report after ingesting data. Users
 * should instantiate a instance of this class in order to create reports.
 *
 * @author Samuel Kyle Davis
 */
public class PrintImpl {
  /**
   * The Output filename/location.
   */
  private static final String OUTPUT_DIRECTORY = "output/";

  /**
   * Print tax exempt report.
   *
   * @param filename             the filename
   * @param donorImpl            the donor
   * @param donationImpl         the donation
   * @param taxExemptionRequests the tax exemption requests
   */
  @SuppressWarnings("unchecked")
  public static void printTaxExemptReport(String filename, DonorImpl donorImpl, DonationImpl donationImpl,
                                          HashMap<Integer, ArrayList<Integer>> taxExemptionRequests) {
    PrintWriter writer = null;
    try {
      File file = new File(OUTPUT_DIRECTORY + filename);
      file.getParentFile().mkdirs();
      writer = new PrintWriter(file, "UTF-8");

      Iterator it = taxExemptionRequests.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry) it.next();
        Integer donorId = (Integer) pair.getKey();
        Donor donor = donorImpl.getDonor(donorId);

        ArrayList<Integer> donations = (ArrayList<Integer>) pair.getValue();
        writer.println("Donor " + donorId + ", " + donor.getDonorFirstName() + " " + donor.getDonorLastName());

        for (Integer x : donations) {
          Donation dn = donationImpl.getDonationById(x);
          if (dn.getDonorId().equals(donorId)) {
            if (dn.getIsDonationTaxDeductible()) {
              writer.println("Donation " + dn.getDonationId() + " for $" + dn.getDonationAmount() + " is tax deductible" + ".");

            } else {
              writer.println("Donation " + dn.getDonationId() + " for $" + dn.getDonationAmount() + " is NOT tax " + "deductible.");
            }
          }

        }
        it.remove();
      }
    }catch (IOException e) {
      e.printStackTrace();
    }finally{
      if(writer != null) {
        writer.close();
      }
    }



  }

}
