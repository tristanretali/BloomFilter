package Benchmark;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

import BloomFilter.*;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 0)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 3)
@State(Scope.Benchmark)
public class isPresentBenchmark {
    Random r = new Random();
    private ABloomFilter arrayBloomFilter = ABloomFilter.bloomFilterWithElement(10000, 200,1);
    private LBloomFilter linkedBloomFilter = LBloomFilter.bloomFilterWithElement(10000, 200,1);
    private TBloomFilter listBloomFilter =  TBloomFilter.bloomFilterWithElement(10000, 200, 1);

    /**
     * Benchmark of isPresent for ArrayList
     */
    @Benchmark
    public void benchmarkOfIsPresentForArrayList(){
        int checkElement = r.nextInt();
        arrayBloomFilter.isPresent(checkElement);
    }

    /**
     * Benchmark of isPresent for LinkedList
     */
    @Benchmark
    public void benchmarkOfIsPresentForLinkedList(){
        int checkElement = r.nextInt();
        linkedBloomFilter.isPresent(checkElement);
    }

    /**
     * Benchmark of isPresent for List
     */
    @Benchmark
    public void benchmarkOfIsPresentForList(){
        int checkElement = r.nextInt();
        listBloomFilter.isPresent(checkElement);
    }
}

