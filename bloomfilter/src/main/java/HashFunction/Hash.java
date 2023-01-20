package HashFunction;

public class Hash{

    /**
     * The hash function for my Bloom Filter
     * @param element the element we want to hash
     * @param k the number of the hash function
     * @param size the size of the bloom filter
     * @return element ground
     */
    public static int hash(int element, int k, int size) {
        int elementHash = element*k*size;
        elementHash /= k*size >> 2;
        elementHash ^= 10;
        return elementHash;
    }
    
}
