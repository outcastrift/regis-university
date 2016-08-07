package cs310davis.donation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Donation Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Aug 7, 2016</pre>
 */
public class DonationTest {
  static Donation donation;
  @Before
  public void before() throws Exception {
  donation = new Donation();

  }

  /**
   * Method: shortenDescription(String donationDescription)
   */
  @Test
  public void testShortenDescription() throws Exception {
    String thirtyCharString = "123456789123456789123456789012";
   String shortened = donation.shortenDescription(thirtyCharString);
    Assert.assertTrue(shortened.length() == 25);
  }


  /**
   * Method: getDonationId()
   */
  @Test
  public void testGetDonationId() throws Exception {
   donation.setDonationId(1);
   Assert.assertTrue(donation.getDonationId().equals(1));
   donation.setDonationId(null);
  }

  /**
   * Method: setDonationId(Integer donationId)
   */
  @Test
  public void testSetDonationId() throws Exception {
    donation.setDonationId(1);
    Assert.assertTrue(donation.getDonationId().equals(1));
    donation.setDonationId(null);
  }

  /**
   * Method: getDonorId()
   */
  @Test
  public void testGetDonorId() throws Exception {
    donation.setDonorId(1);
    Assert.assertTrue(donation.getDonorId().equals(1));
    donation.setDonorId(null);
  }

  /**
   * Method: getDonationDescription()
   */
  @Test
  public void testGetDonationDescription() throws Exception {
    donation.setDonationDescription("DESCRIPTION");
    Assert.assertTrue(donation.getDonationDescription().equalsIgnoreCase("DESCRIPTION"));
    donation.setDonationDescription(null);
  }

  /**
   * Method: getDonationAmount()
   */
  @Test
  public void testGetDonationAmount() throws Exception {
    donation.setDonationAmount(10.00);
    Assert.assertTrue(donation.getDonationAmount().equals(10.00));
    donation.setDonationAmount(null);
  }

  /**
   * Method: setDonationAmount(Double donationAmount)
   */
  @Test
  public void testSetDonationAmount() throws Exception {
    donation.setDonationAmount(10.00);
    Assert.assertTrue(donation.getDonationAmount().equals(10.00));
    donation.setDonationAmount(null);
  }

  /**
   * Method: getDonationDate()
   */
  @Test
  public void testGetDonationDate() throws Exception {
    donation.setDonationDate("04/02/2016");
    Assert.assertTrue(donation.getDonationDate().equalsIgnoreCase("04/02/2016"));
    donation.setDonationDate(null);
  }

  /**
   * Method: setDonationDate(String donationDate)
   */
  @Test
  public void testSetDonationDate() throws Exception {
    donation.setDonationDate("04/02/2016");
    Assert.assertTrue(donation.getDonationDate().equalsIgnoreCase("04/02/2016"));
    donation.setDonationDate(null);
  }

  /**
   * Method: getIsDonationTaxDeductible()
   */
  @Test
  public void testGetIsDonationTaxDeductible() throws Exception {
    donation.setIsDonationTaxDeductible(true);
    Assert.assertTrue(donation.getIsDonationTaxDeductible());
    donation.setIsDonationTaxDeductible(null);
  }

  /**
   * Method: getDonationCheckNumber()
   */
  @Test
  public void testGetDonationCheckNumber() throws Exception {
    donation.setDonationCheckNumber(100);
    Assert.assertTrue(donation.getDonationCheckNumber().equals(100));
    donation.setDonationCheckNumber(null);
  }

  /**
   * Method: setDonationCheckNumber(Integer donationCheckNumber)
   */
  @Test
  public void testSetDonationCheckNumber() throws Exception {
    donation.setDonationCheckNumber(100);
    Assert.assertTrue(donation.getDonationCheckNumber().equals(100));
    donation.setDonationCheckNumber(null);
  }

  /**
   * Method: setIsDonationTaxDeductible(Boolean isDonationTaxDeductible)
   */
  @Test
  public void testSetIsDonationTaxDeductible() throws Exception {
    donation.setIsDonationTaxDeductible(true);
    Assert.assertTrue(donation.getIsDonationTaxDeductible());
    donation.setIsDonationTaxDeductible(null);
  }

  /**
   * Method: setDonationDescription(String donationDescription)
   */
  @Test
  public void testSetDonationDescription() throws Exception {
    donation.setDonationDescription("DESCRIPTION");
    Assert.assertTrue(donation.getDonationDescription().equalsIgnoreCase("DESCRIPTION"));
    donation.setDonationDescription(null);
  }

  /**
   * Method: setDonorId(Integer donorId)
   */
  @Test
  public void testSetDonorId() throws Exception {
    donation.setDonorId(1);
    Assert.assertTrue(donation.getDonorId().equals(1));
    donation.setDonorId(null);
  }

  /**
   * Method: isCheckValid(Integer donationCheckNumber)
   */
  @Test
  public void testIsCheckValidFailure() throws Exception {
    boolean valid = donation.isCheckValid(1);
    Assert.assertFalse(valid);
  }
  /**
   * Method: isCheckValid(Integer donationCheckNumber)
   */
  @Test
  public void testIsCheckValidSuccess() throws Exception {
    boolean valid = donation.isCheckValid(1000);
    Assert.assertTrue(valid);
  }
  /**
   * Method: equals(Object obj)
   */
  @Test
  public void testEqualsSuccess() throws Exception {
    donation.setDonorId(1);
    donation.setDonationCheckNumber(100);
    donation.setIsDonationTaxDeductible(false);
    donation.setDonationId(1);
    donation.setDonationDescription("");
    donation.setDonationAmount(100.00);
    donation.setDonationDate("");
    Donation donation2 = new Donation();
    donation2.setDonorId(1);
    donation2.setDonationCheckNumber(100);
    donation2.setIsDonationTaxDeductible(false);
    donation2.setDonationId(1);
    donation2.setDonationDescription("");
    donation2.setDonationAmount(100.00);
    donation2.setDonationDate("");
    boolean isTheSame = donation.equals(donation2);
    Assert.assertTrue(isTheSame);


  }
  /**
   * Method: equals(Object obj)
   */
  @Test
  public void testEqualsFailure() throws Exception {
    donation.setDonorId(1);
    donation.setDonationCheckNumber(100);
    donation.setIsDonationTaxDeductible(false);
    donation.setDonationId(1);
    donation.setDonationDescription("");
    donation.setDonationAmount(100.00);
    donation.setDonationDate("");
    Donation donation2 = new Donation();
    donation2.setDonorId(2);
    donation2.setDonationCheckNumber(100);
    donation2.setIsDonationTaxDeductible(false);
    donation2.setDonationId(1);
    donation2.setDonationDescription("");
    donation2.setDonationAmount(100.00);
    donation2.setDonationDate("");
    boolean isTheSame = donation.equals(donation2);
    Assert.assertFalse(isTheSame);
    donation.setDonorId(null);
    donation.setDonationCheckNumber(null);
    donation.setIsDonationTaxDeductible(null);
    donation.setDonationId(null);
    donation.setDonationDescription(null);
    donation.setDonationAmount(null);
    donation.setDonationDate(null);

  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    donation.setDonorId(1);
    donation.setDonationCheckNumber(100);
    donation.setIsDonationTaxDeductible(false);
    donation.setDonationId(1);
    donation.setDonationDescription("");
    donation.setDonationAmount(100.00);
    donation.setDonationDate("");

    Assert.assertNotNull( donation.toString());
  }


} 
