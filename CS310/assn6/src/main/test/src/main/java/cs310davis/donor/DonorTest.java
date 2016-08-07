package cs310davis.donor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

    /**
    * Donor Tester.
    *
    * @author <Authors name>
    * @since <pre>Aug 7, 2016</pre>
    * @version 1.0
    */
    public class DonorTest {
    static Donor donor;
    @Before
    public void before() throws Exception {
    donor = new Donor(1, "Sam", "Davis", "315-281-5502", "sam.davis@techngs.com",true);

    }



    /**
    *
    * Method: isEmailValid(String donorEmailAddress)
    *
    */
    @Test
    public void testIsEmailValidSuccess() throws Exception {
    String validEmail = "sam.davis@techngs.com";
      Assert.assertTrue(donor.isEmailValid(validEmail));
    }
      /**
       *
       * Method: isEmailValid(String donorEmailAddress)
       *
       */
      @Test
      public void testIsEmailValidFailure() throws Exception {
        String validEmail = "sam.davistechngs.com";
        Assert.assertFalse(donor.isEmailValid(validEmail));
      }
    /**
    *
    * Method: equals(Object obj)
    *
    */
    @Test
    public void testEqualsSuccess() throws Exception {
      Donor donor2 = new Donor();
      donor2.setDonorId(1);
      donor2.setDonorEmailAddress("sam.davis@techngs.com");
      donor2.setDonorFirstName("Sam");
      donor2.setDonorLastName("Davis");
      donor2.setDonorPhoneNumber("315-281-5502");
      donor2.setGoldStar(true);
      Assert.assertTrue(donor.equals(donor2));

    }
      /**
       *
       * Method: equals(Object obj)
       *
       */
      @Test
      public void testEqualsFailure() throws Exception {
        Donor donor2 = new Donor();
        donor2.setDonorId(10);
        donor2.setDonorEmailAddress("samdavis@techngs.com");
        donor2.setDonorFirstName("Sa");
        donor2.setDonorLastName("Davi");
        donor2.setDonorPhoneNumber("31-281-5502");
        donor2.setGoldStar(false);

        Assert.assertFalse(donor.equals(donor2));
      }
    /**
    *
    * Method: getDonorEmailAddress()
    *
    */
    @Test
    public void testGetDonorEmailAddress() throws Exception {
    Assert.assertTrue(donor.getDonorEmailAddress().equalsIgnoreCase("sam.davis@techngs.com"));
    }

    /**
    *
    * Method: setDonorEmailAddress(String donorEmailAddress)
    *
    */
    @Test
    public void testSetDonorEmailAddress() throws Exception {
      donor.setDonorEmailAddress("sam.davistechngs.com");
      Assert.assertTrue(donor.getDonorEmailAddress().equalsIgnoreCase("sam.davistechngs.com"));
      donor.setDonorEmailAddress("sam.davis@techngs.com");


    }

    /**
    *
    * Method: getDonorFirstName()
    *
    */
    @Test
    public void testGetDonorFirstName() throws Exception {
      Assert.assertTrue(donor.getDonorFirstName().equalsIgnoreCase("sam"));
    }

    /**
    *
    * Method: setDonorFirstName(String donorFirstName)
    *
    */
    @Test
    public void testSetDonorFirstName() throws Exception {
      donor.setDonorFirstName("bob");
      Assert.assertTrue(donor.getDonorFirstName().equalsIgnoreCase("bob"));
      donor.setDonorFirstName("Sam");
    }

    /**
    *
    * Method: getDonorId()
    *
    */
    @Test
    public void testGetDonorId() throws Exception {
    Assert.assertTrue(donor.getDonorId().equals(1));
    }

    /**
    *
    * Method: setDonorId(Integer donorId)
    *
    */
    @Test
    public void testSetDonorId() throws Exception {
      donor.setDonorId(10);
      Assert.assertTrue(donor.getDonorId().equals(10));
      donor.setDonorId(1);
    }

    /**
    *
    * Method: getDonorLastName()
    *
    */
    @Test
    public void testGetDonorLastName() throws Exception {
    Assert.assertTrue(donor.getDonorLastName().equalsIgnoreCase("Davis"));
    }

    /**
    *
    * Method: setDonorLastName(String donorLastName)
    *
    */
    @Test
    public void testSetDonorLastName() throws Exception {
      donor.setDonorLastName("Dav");
      Assert.assertTrue(donor.getDonorLastName().equalsIgnoreCase("Dav"));
      donor.setDonorLastName("Davis");
    }

    /**
    *
    * Method: getDonorPhoneNumber()
    *
    */
    @Test
    public void testGetDonorPhoneNumber() throws Exception {
      Assert.assertTrue(donor.getDonorPhoneNumber().equalsIgnoreCase("315-281-5502"));

    }

    /**
    *
    * Method: setDonorPhoneNumber(String donorPhoneNumber)
    *
    */
    @Test
    public void testSetDonorPhoneNumber() throws Exception {
      donor.setDonorPhoneNumber("315-550-4152");
      Assert.assertTrue(donor.getDonorPhoneNumber().equalsIgnoreCase("315-550-4152"));
      donor.setDonorPhoneNumber("315-281-5502");
    }



    /**
    *
    * Method: isGoldStar()
    *
    */
    @Test
    public void testIsGoldStar() throws Exception {
    Assert.assertTrue(donor.isGoldStar());
    }

    /**
    *
    * Method: setGoldStar(boolean goldStar)
    *
    */
    @Test
    public void testSetGoldStar() throws Exception {
    donor.setGoldStar(false);
      Assert.assertFalse(donor.isGoldStar());
      donor.setGoldStar(true);
    }


    }
