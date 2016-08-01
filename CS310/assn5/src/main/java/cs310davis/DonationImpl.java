package cs310davis;
/**
 * This software was created for Regis University's CS 310 Course
 * All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 *
 * This class is a implementation class to access the Donation Database, it contains functions to ensure that
 * ids are unique, to retrieve the database, and to add and remove entries from the database.
 * <p>
 * This is the primary class for interacting with the Donation Database.
 * Users should instantiate a instance of this class in order to perform operations on it.
 *
 * @author Samuel Kyle Davis
 */
public class DonationImpl {
  private final DonationMapEntry[] donations = new DonationMapEntry[DonationConstants.MAX_CAPACITY];
  /**
   * Default Constructor
   */
  public DonationImpl(){
    
  }
  /**
   * Put an entry in the map.
   * @param entry A DonationMapEntry
   */
  public void put( DonationMapEntry entry ){
    boolean isPut = false;
    DonationMapEntry donationEntry = null;
    DonationNode donationNode = null;
    
    if( entry != null ){
      
      for( int i = 0; i < this.donations.length && !isPut; i++ ){
        donationEntry = this.donations[i];
        
        if( donationEntry == null ){
          this.donations[i] = entry;
          isPut = true;
        }
        else{
          if( donationEntry.getHash() == entry.getHash() ){
            donationNode = donationEntry.getValue();
            while( donationNode.hasNext() ){
              donationNode = donationNode.getNext();
            }
            donationNode.setNext( entry.getValue() );
            isPut = true;
          }
        }
      }
    }
  }
  /**
   * Get the DonationMapEntry for a specified key.
   * @param key The Key (Hash)
   * @return A DonationMapEntry
   */
  public DonationMapEntry get( int key ){
    DonationMapEntry entry = null;
    DonationMapEntry found = null;
    
    for( int i = 0; i < this.donations.length && (found == null); i++ ){
      entry = this.donations[i];
      
      if( entry != null && entry.getHash() == key ){
        found = entry;
      }
    }
    
    return found;
  }
}
