package BloomFilterTest;

import static org.junit.Assert.*; 

import org.junit.Test;

import BloomFilter.TBloomFilter;

public class TBloomFilterTest {
    
    @Test
    public void testIsPresent(){
        // Initialisation of the Bloom Filter
        TBloomFilter t = new TBloomFilter(50, 2000, 1);
        for(int i = 1; i <= 50; i++){
            t.addElement(i);
        }
        // Check if the elements have been added
        assertTrue(t.isPresent(1));
        assertTrue(t.isPresent(50));
        assertTrue(t.isPresent(13));
        assertTrue(t.isPresent(28));
        assertTrue(t.isPresent(33));
        // Check if the elements are not in the Bloom Filter
        assertFalse(t.isPresent(789456));
        assertFalse(t.isPresent(6486));
        assertFalse(t.isPresent(321654));
        assertFalse(t.isPresent(458635));
        assertFalse(t.isPresent(48756)); 
    }
}
