package cs310davis;

/**
 * The type Map entry.
 */
public class DonorMapEntry
{
    private int currentSize, maxSize;       
    private Integer[] keys;
    private Donor[] vals;

    /**
     * Instantiates a new Map entry.
     *
     * @param capacity the capacity
     */
    public DonorMapEntry(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new Integer[maxSize];
        vals = new Donor[maxSize];
    }

    /**
     * Make empty.
     */
    public void makeEmpty()
    {
        currentSize = 0;
        keys = new Integer[maxSize];
        vals = new Donor[maxSize];
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
    public void insert(Integer key, Donor val)
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
        }
        while (i != tmp);
    }

    /**
     * Get string.
     *
     * @param key the key
     * @return the string
     */
    public Donor get(Integer key)
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
        if (!contains(key)) 
            return;
 
        /** find position key and delete **/
        int i = hash(key);
        while (!key.equals(keys[i])) 
            i = (i + 1) % maxSize;        
            keys[i] = null;
            vals[i] = null;
 
        /** rehash all keys **/        
        for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize)
        {
            Integer tmp1 = keys[i];
            Donor tmp2 = vals[i];
            keys[i] = null;
            vals[i] = null;
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
            if (keys[i] != null)
                System.out.println(keys[i] +" "+ vals[i]);
        System.out.println();
    }   
}
