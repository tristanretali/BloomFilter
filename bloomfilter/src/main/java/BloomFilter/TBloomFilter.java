package BloomFilter;

import java.util.Random;

import HashFunction.*;

public class TBloomFilter implements IBloomFilter{

    private int size;
    private int k;
    private int nbElement;
    private int[] myBits;

    public TBloomFilter(int nbElement, int size, int k){
        this.nbElement = nbElement;
        this.size = (int)(size*nbElement)/100;
        this.k = k;
        this.myBits = new int[this.size];
        for(int i = 0; i < this.myBits.length; i ++){
            this.myBits[i] = 0;
        }
    }

    
    /** 
     * Add an element in the bloom filter 
     * @param element the element we want to add in the bloom filter 
     */
    @Override
    public <T> void addElement(T element) {
        for (int i = 1; i <= this.k; i++){
            this.myBits[(Math.abs(Hash.hash(element.hashCode(), i, this.size)))%(myBits.length-1)] = 1;
        }
    }    

    
    /** 
     * Check if an elemnt is present in the bloom filter
     * @param element the element we want to know if he is present 
     * @return true iff the element is present
     */
    @Override
    public <T> boolean isPresent(T element) {
        boolean present = true;
        int i = 1;
        while(present && i <= this.k){
            if(myBits[(Math.abs(Hash.hash(element.hashCode(), i, this.size)))%(myBits.length-1)] != 1){
                present = false;
            }
            i++;
        }
        return present;
    }

    /**
     * Create and fill a bloom filter
     * @param nbElement the number of elements we want to insert
     * @param size the size of the bloom filter
     * @param k the number of Hash function
     * @return a bloom filter which contains elements
     */
    public static TBloomFilter bloomFilterWithElement(int nbElement,int size, int k){
        TBloomFilter bloomFilter = new TBloomFilter(nbElement, size, k);
        Random r = new Random();
        for (int i = 0; i < bloomFilter.nbElement; i++){
            int element = r.nextInt();
            bloomFilter.addElement(element);
        }
        return bloomFilter;
    }
    
}
