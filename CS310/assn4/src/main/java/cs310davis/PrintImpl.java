package cs310davis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


/**
 * This class is a implementation class to create a results report after ingesting data to the Donation and Donor databases.
 * This class contains only one function, which is used to create a text file at a pre-configured location relative to where the code was ran.
 * <p>
 * This is the primary way of creating a report after ingesting data.
 * Users should instantiate a instance of this class in order to create reports.
 *
 * @author Samuel Kyle Davis
 */
public class PrintImpl {
    /**
     * The Output filename/location.
     */
    final String OUTPUT_DIRECTORY = "output/";


    /**
     * Creates a report and outputs it to the ../output directory with the
     * @param filename the filename to use
     * The output directory is relative
     * to the location in which the class was run. For each donor within the Database a table is
     * created containing his total amount of donations, total amount of donations, and whether or
     * not he is a GOLDSTAR contributor.
     *
     * After printing information on each individual donor a total number of donors will be displayed as well as the
     * total dollar amount of all donations.
     */
    public void printReportToDirectory(String filename,
                                       DonationLogImpl donations,
                                       DonorLogImpl donors) {

        int totalDonationsForAll = 0;
        double totalDonationAmountForAll = 0;

        PrintWriter writer = null;
        try {
            File file = new File(OUTPUT_DIRECTORY + filename);
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }
        StringBuilder donorStringBuilder = null;
        StringBuilder donationStringBuilder = null;


        for (int x = 0; x < donors.getSizeOfList(); x++) {

        }
        DonorNode donorList = donors.getDonorList();
        Donor d = null;
        while (donorList != null) {
            d = donorList.getDonor();


            donorList = donorList.getNext();
            //determine if donor is gold star
            donationStringBuilder = new StringBuilder();
            donationStringBuilder.append("\n          Donations \n");
            double totalDonationAmount = donations.totalDonationAmount(d.getDonorId());
            int totalDonations = donations.numberOfDonations(d.getDonorId());
            for (Donation dn : DonationLogImpl.getDonationList()) {
                if (dn.getDonorId() == d.getDonorId()) {
                    donationStringBuilder.append("                    DonationId = " + dn.getDonationId() + "  ")
                            .append("DonationDate = " + dn.getDonationDate() + "  ")
                            .append("Description = " + dn.getDonationDescription() + "  ")
                            .append("Amount = " + dn.getDonationAmount() + "  ")
                            .append("CheckNumber = " + dn.getDonationCheckNumber() + "  ");
                    if (dn.getIsDonationTaxDeductible()) {
                        donationStringBuilder.append("Tax Deductible = " + dn.getIsDonationTaxDeductible());
                    }
                    donationStringBuilder.append("\n");

                }
            }
            donorStringBuilder = new StringBuilder();
            donorStringBuilder.append("##########################################################################\n");
            donorStringBuilder.append("Donor Identification # = " + d.getDonorId())
                    .append("  Donor Last Name = " + d.getDonorLastName() + ",  ")
                    .append("  Donor First Name = " + d.getDonorFirstName() + ",   ");
            if (totalDonationAmount > 10000.00) {
                d.setGoldStar(true);
                donorStringBuilder.append("GOLDSTAR");
            }
            totalDonationsForAll = totalDonations + totalDonationsForAll;
            totalDonationAmountForAll = totalDonationAmountForAll + totalDonationAmount;
            donorStringBuilder.append(donationStringBuilder.toString());
            donorStringBuilder.append("Number of total donations for donor : " + totalDonations);
            donorStringBuilder.append("\nTotal amount of donations for the donor :: " + totalDonationAmount);
            donorStringBuilder.append("\n ########################################################################## \n");

            writer.println(donorStringBuilder.toString());
        }
        writer.println("Total number of Donations for all Donors = [" + totalDonationsForAll + "]");
        writer.println("Total Dollar Amount of All Donations from All Donors = [" + totalDonationAmountForAll + "]");

        writer.close();

    }
}
