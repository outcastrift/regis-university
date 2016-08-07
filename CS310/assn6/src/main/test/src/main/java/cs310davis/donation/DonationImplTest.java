package cs310davis.donation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * DonationImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Aug 7, 2016</pre>
 */
public class DonationImplTest {
  static Donation donation = new Donation(1120, 1000, "Just a Simple Description", 50.25, "May 1st 2016", false, 1000);

  static DonationImpl  donationImpl = new DonationImpl();
  @Before
  public void before() throws Exception {

  }

  /**
   * Method: addDonation(Donation donation)
   */
  @Test
  public void testAddDonation() throws Exception {
   donationImpl.addDonation(donation);
   Donation d = donationImpl.getDonationById(donation.getDonationId());
   Assert.assertTrue(d.getDonationId().equals(donation.getDonationId()));
  }

  /**
   * Method: isIdUnique(int donationId)
   */
  @Test
  public void testIsIdUniqueSuccess() throws Exception {
    //Empty list should return true
    boolean unique =donationImpl.isIdUnique(donation.getDonationId());
    Assert.assertTrue(unique);
  }
  /**
   * Method: isIdUnique(int donationId)
   */
  @Test
  public void testIsIdUniqueFailure() throws Exception {
    donationImpl.addDonation(donation);
    //just added a donation with that ID should be false
    boolean unique =donationImpl.isIdUnique(donation.getDonationId());
    Assert.assertFalse(unique);

  }
  /**
   * Method: removeDonationByDonorId(int donorId)
   */
  @Test
  public void testRemoveDonationByDonorId() throws Exception {
    donationImpl.addDonation(donation);
    donationImpl.removeDonationByDonorId(donation.getDonorId());
    Donation d = donationImpl.getDonationById(donation.getDonationId());
    Assert.assertTrue(d ==null);
  }

  /**
   * Method: removeDonationByDonationId(int donationId)
   */
  @Test
  public void testRemoveDonationByDonationId() throws Exception {
    donationImpl.addDonation(donation);
    donationImpl.removeDonationByDonationId(donation.getDonationId());
    Donation d = donationImpl.getDonationById(donation.getDonationId());
    Assert.assertTrue(d ==null);
  }

  /**
   * Method: getDonationById(Integer donationId)
   */
  @Test
  public void testGetDonationById() throws Exception {
    donationImpl.addDonation(donation);
    Donation d = donationImpl.getDonationById(donation.getDonationId());
    Assert.assertTrue(d.getDonationId().equals(donation.getDonationId()));
  }

  /**
   * Method: traverseTreeInOrder()
   */
  @Test
  public void testTraverseTreeInOrder() throws Exception {
    donationImpl.addDonation(donation);
    donationImpl.traverseTreeInOrder();
  }


} 
