package BloomFilterTest;
import static org.junit.Assert.*;

import org.junit.Test;

import BloomFilter.ABloomFilter;

public class ABloomFilterTest {
    
    @Test
    public void testIsPresent(){
    // Initialisation of the Bloom Filter
     ABloomFilter a = new ABloomFilter(50, 2000, 1);
    for(int i = 1; i <= 50; i++){
        a.addElement(i);
    }
    // Check if the elements have been added
    assertTrue(a.isPresent(1));
    assertTrue(a.isPresent(50));
    assertTrue(a.isPresent(13));
    assertTrue(a.isPresent(28));
    assertTrue(a.isPresent(33));
    // Check if the elements are not in the Bloom Filter
    assertFalse(a.isPresent(789456));
    assertFalse(a.isPresent(6486));
    assertFalse(a.isPresent(321654));
    assertFalse(a.isPresent(458635));
    assertFalse(a.isPresent(48756));
    }
}
