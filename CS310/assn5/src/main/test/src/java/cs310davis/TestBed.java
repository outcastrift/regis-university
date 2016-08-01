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
  Integer[] donors = new Integer[]{1,3,4,6,7,8,9,10};
  @Test
  public void testDonationLog(){
    int mine =0;
    for(int x : donors){
      mine =hashCode(x);
      System.out.println("Hashing Value of X= ["+x+"] Hashed Value = "+mine);
    }


  }

  public int hashCode(int donorId){
    int hashCode =0;
    String idVar = String.valueOf(donorId);
    char[] charArray = idVar.toCharArray();


    for(char c : charArray){
      hashCode= hashCode + (int) c;
    }
    hashCode = hashCode % 23;
    return hashCode;
  }

}
