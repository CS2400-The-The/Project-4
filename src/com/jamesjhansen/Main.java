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
     * TODO: setup file I/O (read from data_random.txt into int[], write to output.txt)
     *       instantiate a couple heaps, calling heap methods on them with data
     *       implement heap add and remove
     * @param args command line arguments (none expected for this program)
     */
    public static void main(String[] args) {

        MaxHeap heap1 = new MaxHeap();
        MaxHeap heap2 = new MaxHeap();
        int[] data = readData();
        heap1.sequentialHeap(data);
        heap2.optimalHeap(data);

        try {
            FileWriter myWriter = new FileWriter("output.txt");

            myWriter.write("Heap built using sequential insertions: " + heap1);
            myWriter.write("Number of swaps in the heap creation: " ); // TODO
            // TODO: preform 10 removals
            myWriter.write("Heap after 10 removals: " + heap1);

            myWriter.write("Heap built using optimal method: " + heap2);
            myWriter.write("Number of swaps in the heap creation: " ); // TODO
            // TODO: preform 10 removals
            myWriter.write("Heap after 10 removals: " + heap2);

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readData() {
        int[] data = new int[100];
        int count = 0;
        try {
            File f = new File("data_random.txt");
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
}
