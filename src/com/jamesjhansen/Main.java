package com.jamesjhansen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * driver class: contains main method
 */
public class Main {


    /**
     * demonstrates use of heap methods
     * @param args command line arguments (none expected for this program)
     */
    public static void main(String[] args) {

        MaxHeap<Integer> heap1 = new MaxHeap<Integer>();
        MaxHeap<Integer> heap2 = new MaxHeap<Integer>();
        MaxHeap<Integer> heap3 = new MaxHeap<Integer>();
        MaxHeap<Integer> heap4 = new MaxHeap<Integer>();
        String data_random = "data_random.txt";
        String data_sorted = "data_sorted.txt";
        Integer[] dataRandom = readData("data_random.txt");
        Integer[] dataSorted = readData("data_sorted.txt");
        heap1.sequentialHeap(dataRandom);
        heap2.optimalHeap(dataRandom);
        heap3.sequentialHeap(dataSorted);
        heap4.optimalHeap(dataSorted);


        try {
            FileWriter myWriter = new FileWriter("output.txt");

            myWriter.write("Testing 'data_random.txt'");
            myWriter.write("\nHeap built using sequential insertions: " + heap1 + "\n");
            myWriter.write("Number of swaps in the heap creation: " + heap1.getSwaps() + "\n"); 
            remove10(heap1);
            myWriter.write("Heap after 10 removals: " + heap1 + "\n");

            myWriter.write("\nHeap built using optimal method: " + heap2 + "\n");
            myWriter.write("Number of swaps in the heap creation: " + heap2.getSwaps() + "\n");
            remove10(heap2);
            myWriter.write("Heap after 10 removals: " + heap2);

            myWriter.write("\n\n\n\n\nTesting 'data_sorted.txt'");
            myWriter.write("\nHeap built using sequential insertions: " + heap3 + "\n");
            myWriter.write("Number of swaps in the heap creation: " + heap3.getSwaps() + "\n"); 
            remove10(heap3);
            myWriter.write("Heap after 10 removals: " + heap3 + "\n");

            myWriter.write("\nHeap built using optimal method: " + heap4 + "\n");
            myWriter.write("Number of swaps in the heap creation: " + heap4.getSwaps() + "\n");
            remove10(heap4);
            myWriter.write("Heap after 10 removals: " + heap4);

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * returns integer array from data in imported files
     * @param fileName name of file to read data from
     * @return integer array of data from files
     */
    public static Integer[] readData(String fileName) {
        Integer[] data = new Integer[100];
        int count = 0;
        try {
            File f = new File(fileName);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                int d = Integer.parseInt(myReader.nextLine());
                data[count] = d;
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

     /**
     * performs 10 removals on the heap
     */
    public static void remove10(MaxHeap<Integer> heap) {
        
        for (int i = 0; i < 10; i++) {
            heap.removeMax();
        }
    }
}
