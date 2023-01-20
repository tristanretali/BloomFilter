package App;

import java.util.ArrayList;
import java.util.Random;

import BloomFilter.ABloomFilter;

public class App {
    private static ArrayList<Integer> valueToAdd = new ArrayList<>();
    private static Random r = new Random();

    public static void main(String[] args) throws Exception {
        // Benchmark of isPresent function 
        org.openjdk.jmh.Main.main(args);
        // Percentage of error for m 50% of n
        showPercentageOfError(1000, 50, 1, 500);
        showPercentageOfError(1000, 50, 3, 500);
        showPercentageOfError(1000, 50, 5, 500);
        // Percentage of error for m 100% of n
        showPercentageOfError(1000, 100, 1, 500);
        showPercentageOfError(1000, 100, 3, 500);
        showPercentageOfError(1000, 100, 5, 500);
        // Percentage of error for m 200% of n
        showPercentageOfError(1000, 200, 1, 500);
        showPercentageOfError(1000, 200, 3, 500);
        showPercentageOfError(1000, 200, 5, 500);     
    }

    /**
     * Show the percentage of error
     * @param nbElement the number of elements we want to insert
     * @param size the size of the bloom filter 
     * @param k the number of Hash function
     * @param nbTest the number of elements we use to calculate the percentage of error 
     */
    private static void showPercentageOfError(int nbElement, int size, int k, int nbTest){
        int avgError = 0;
        System.out.println("<======================================= Taux d'erreur pour k à " + k + " et m à " + size + "% de n =======================================>");
        for(int i = 0; i < 15; i++){
            avgError += ErrorArrayList(nbElement, size, k,nbTest);
            valueToAdd.removeAll(valueToAdd);
        }
        System.out.println("Taux d'erreur moyen : " + avgError/15 + "%");
    }

    /**
     * Calculate the percentage of error
     * @param nbElement the number of elements we want to insert
     * @param size the size of the bloom filter 
     * @param k the number of Hash function
     * @param nbTest the number of elements we use to calculate the percentage of error 
     * @return the percentage of error
     */
    private static int ErrorArrayList(int nbElement, int size, int k, int nbTest) {
        ABloomFilter a = new ABloomFilter(nbElement, size, k);
        int nbError = 0;
        int current = 0;
        fillValueToAdd(nbElement);
        for(int i = 0; i < valueToAdd.size(); i++){
            a.addElement(valueToAdd.get(i));
        }
        for(int i = 0; i < nbTest; i++){
            current = r.nextInt();
            if(a.isPresent(current) && !valueToAdd.contains(current)){
                nbError++;
            }
        }
        nbError = (nbError*100)/nbTest;
        System.out.println("Taux d'erreur : " + nbError + "%");
        return nbError;
    }

    /**
     * Field a list which contains random elements we want to test the insertion in the bloom filter
     * @param nbElement the number of elements we want to insert
     */
    private static void fillValueToAdd(int nbElement) {
        for (int i = 1; i <= nbElement; i++) {
            valueToAdd.add(r.nextInt());
        }

    }
}
