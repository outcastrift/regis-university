package cs310davis;
/**
 * The DonationImpl class.
 *
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
