package sortingbenchmark2;

import java.util.Arrays;
import java.util.Random;

public class Sortingbenchmark2 {

    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 100000;
        Random rand = new Random();

      
        int[] randomData = new int[n];
        for (int i = 0; i < n; i++) {
            randomData[i] = rand.nextInt(1000000);
        }

        
        int[] sortedData = randomData.clone();
        Arrays.sort(sortedData);

        
        String[] scenarios = {"Random", "Fully Sorted"};
        int[][] datasets = {randomData, sortedData};

        System.out.println("Running benchmark for Quick Sort with N = " + n + " ...\n");
        System.out.printf("%-20s | %-18s%n", "Scenario", "Execution Time (ns)");
        System.out.println("----------------------------------------");

        for (int i = 0; i < scenarios.length; i++) {
            int[] dataCopy = datasets[i].clone();
            long startTime = System.nanoTime();
            
            try {
                quickSort(dataCopy, 0, dataCopy.length - 1);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.printf("%-20s | %-18d%n", scenarios[i], duration);
            } catch (StackOverflowError e) {
                System.out.printf("%-20s | %-18s%n", scenarios[i], "Overflow");
            }
        }
    }
}
