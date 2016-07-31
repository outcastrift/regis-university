package cs310davis;

/**
 * The type Map entry.
 */
public class DonationMapEntry
{
    private int currentSize, maxSize;
    private Integer[] keys;
    private Donation[] vals;

    /**
     * Instantiates a new Map entry.
     *
     * @param capacity the capacity
     */
    public DonationMapEntry(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new Integer[maxSize];
        vals = new Donation[maxSize];
    }

    /**
     * Clear entire map.
     */
    public void clearEntireMap()
    {
        currentSize = 0;
        keys = new Integer[maxSize];
        vals = new Donation[maxSize];
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
     * Tells you if the map is full
     *
     * @return the boolean
     */
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    /**
     * Determines if the map is empty
     *
     * @return the boolean
     */
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /**
     * Determines whether a specified key is within the map.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean contains(Integer key)
    {
        return get(key) !=  null;
    }


    public int hash(int id){
        int hashCode =0;
        String idVar = String.valueOf(id);
        char[] charArray = idVar.toCharArray();


        for(char c : charArray){
            hashCode= hashCode + (int) c;
        }
        hashCode = hashCode % 23;
        return hashCode;
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
            if (keys[i] == null)
            {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                return;
            }
            if (keys[i].equals(key)) 
            { 
                vals[i] = val; 
                return; 
            }            
            i = (i + 1) % maxSize;            
        } while (i != tmp);       
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
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                return vals[i];
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
        boolean result =false;
        if (!contains(key)) {
            result =true;
        }
 
        //find key then remove it
        int i = hash(key);


        while (!key.equals(keys[i])) {
            i = (i + 1) % maxSize;
            keys[i] = null;
            vals[i] = null;
        }
 
        /** rehash all keys **/        
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
        {
            Integer tempId = keys[i];
            Donation tempObject = vals[i];

            keys[i] = null;
            vals[i] = null;

            currentSize--;  
            insert(tempId, tempObject);
        }
        currentSize--;        
    }

    /**
     * Print hash table.
     */
    public void printHashTable()
    {
        System.out.println("\nPrinting Hash Map: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null) {
                System.out.println(keys[i] + " " + vals[i]);
            }
        System.out.println();
    }   
}