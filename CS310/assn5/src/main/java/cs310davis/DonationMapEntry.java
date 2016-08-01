package cs310davis;

/**
 * The type Map entry.
 */
public class DonationMapEntry
{
    private int currentSize, maxSize;
    private Integer[] hashedDonationIds;
    private Donation[] donationValues;

    /**
     * Instantiates a new Map entry.
     *
     * @param capacity the capacity
     */
    public DonationMapEntry(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        hashedDonationIds = new Integer[maxSize];
        donationValues = new Donation[maxSize];
    }

    /**
     * Make empty.
     */
    public void makeEmpty()
    {
        currentSize = 0;
        hashedDonationIds = new Integer[maxSize];
        donationValues = new Donation[maxSize];
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize()
    {
        return currentSize;
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /**
     * Contains boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean contains(Integer key)
    {
        return get(key) !=  null;
    }
 
    private int hash(Integer key)
    {
        return key.hashCode() % maxSize;
    }

    /**
     * Insert.
     *
     * @param key the key
     * @param val the val
     */
    public void insert(Integer key, Donation val)
    {                
        int tmp = hash(key);
        int i = tmp;
        do
        {
            if (hashedDonationIds[i] == null)
            {
                hashedDonationIds[i] = key;
                donationValues[i] = val;
                currentSize++;
                return;
            }
            if (hashedDonationIds[i].equals(key))
            { 
                donationValues[i] = val;
                return; 
            }            
            i = (i + 1) % maxSize;            
        }
        while (i != tmp);
    }

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    public Donation get(Integer key)
    {
        int i = hash(key);
        while (hashedDonationIds[i] != null)
        {
            if (hashedDonationIds[i].equals(key))
                return donationValues[i];
            i = (i + 1) % maxSize;
        }            
        return null;
    }

    /**
     * Remove.
     *
     * @param key the key
     */
    public void remove(Integer key)
    {
        if (!contains(key)) 
            return;
 
        /** find position key and delete **/
        int i = hash(key);
        while (!key.equals(hashedDonationIds[i]))
            i = (i + 1) % maxSize;        
            hashedDonationIds[i] = null;
            donationValues[i] = null;
 
        /** rehash all hashedDonationIds **/
        for (i = (i + 1) % maxSize; hashedDonationIds[i] != null; i = (i + 1) % maxSize)
        {
            Integer tmp1 = hashedDonationIds[i];
            Donation tmp2 = donationValues[i];
            hashedDonationIds[i] = null;
            donationValues[i] = null;
            currentSize--;  
            insert(tmp1, tmp2);            
        }
        currentSize--;        
    }

    /**
     * Print hash table.
     */
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (hashedDonationIds[i] != null)
                System.out.println(hashedDonationIds[i] +" "+ donationValues[i]);
        System.out.println();
    }   
}
