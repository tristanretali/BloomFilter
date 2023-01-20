package BloomFilterTest;
import static org.junit.Assert.*;

import org.junit.Test;

import BloomFilter.LBloomFilter;

public class LBloomFilterTest {
    
    @Test
    public void testIsPresent(){
        // Initialisation of the Bloom Filter
        LBloomFilter l = new LBloomFilter(50, 2000, 1);
        for(int i = 1; i <= 50; i++){
            l.addElement(i);
        }
        // Check if the elements have been added
        assertTrue(l.isPresent(1));
        assertTrue(l.isPresent(50));
        assertTrue(l.isPresent(13));
        assertTrue(l.isPresent(28));
        assertTrue(l.isPresent(33));
        // Check if the elements are not in the Bloom Filter
        assertFalse(l.isPresent(789456));
        assertFalse(l.isPresent(6486));
        assertFalse(l.isPresent(321654));
        assertFalse(l.isPresent(458635));
        assertFalse(l.isPresent(48756));
    }

}
