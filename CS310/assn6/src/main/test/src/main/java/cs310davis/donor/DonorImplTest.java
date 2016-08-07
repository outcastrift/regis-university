package cs310davis.donor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** 
* DonorImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Aug 7, 2016</pre> 
* @version 1.0 
*/ 
public class DonorImplTest {
  Donor donor = new Donor(1000, "Sam", "Davis", "315-281-5502", "sam.davis@techngs.com",true);
  static DonorImpl donorImpl;
  @Before
  public void before() throws Exception {
    donorImpl  = new DonorImpl();
  }


  /**
  *
  * Method: getDonorBinaryTree()
  *
  */
  @Test
  public void testGetDonorBinaryTree() throws Exception {
    Assert.assertNotNull(donorImpl.getDonorBinaryTree());
  }

  /**
  *
  * Method: add(Object obj)
  *
  */
  @Test
  public void testAdd() throws Exception {
    donorImpl.add(donor);
    Donor added = donorImpl.getDonor(donor.getDonorId());
    Assert.assertTrue(donor.getDonorId().equals(added.getDonorId()));
  }

  /**
  *
  * Method: isIdUnique(int id)
  *
  */
  @Test
  public void testIsIdUniqueSuccess() throws Exception {
    //empty database should be unique
    Assert.assertTrue( donorImpl.isIdUnique(1));
  }
  /**
   *
   * Method: isIdUnique(int id)
   *
   */
  @Test
  public void testIsIdUniqueFailure() throws Exception {
    donorImpl.add(donor);
    Assert.assertFalse( donorImpl.isIdUnique(1000));
  }

  /**
  *
  * Method: traverseTreeInOrder()
  *
  */
  @Test
  public void testTraverseTreeInOrder() throws Exception {
  donorImpl.traverseTreeInOrder();
  }

  /**
  *
  * Method: getDonor(Integer donorID)
  *
  */
  @Test
  public void testGetDonor() throws Exception {
    donorImpl.add(donor);
    Donor added = donorImpl.getDonor(donor.getDonorId());
    Assert.assertTrue(donor.equals(added));
  }



  }
