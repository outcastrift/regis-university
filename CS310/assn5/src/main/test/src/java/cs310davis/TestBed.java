package cs310davis;

import org.junit.Test;

/**
 * This software was created for
 * rights to this software belong to
 * appropriate licenses and restrictions apply.
 * Created by Samuel Davis on 7/31/16.
 */
public class TestBed {
  //Test hashing algo

  DonationLogImpl donationLog = new DonationLogImpl();
  DonorLogImpl donorLog = new DonorLogImpl();

  @Test
  public void testDonationLog(){
    int mine =0;
    for(int x =0; x<23 ; x++){
      mine =donorLog.hashDonorId(x);
      System.out.println(mine);
    }


  }

}
