package cs310sort.results;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cs310sort.algorithms.AlgorithmType;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * ResultPrinter functions to print the output report required for the CS310Sort program.
 * @author Samuel Kyle Davis
 **/
public class ResultPrinter {
    private static final String hashLine ="#########################################################################################";

    private static final String runLine = "                      Run 1               Run 2               Run 3               Average";


    /**
     * The Output filename/location.
     */
    private static final String OUTPUT_DIRECTORY = "output/";

    /**
     * Print tax exempt report.
     *

     */
    @SuppressWarnings("unchecked")
    public static void printResults(String filename, ArrayList<ArrayList<Speed>> results) {
        PrintWriter writer = null;
        try {
            File file = new File(OUTPUT_DIRECTORY + filename);
            file.getParentFile().mkdirs();
            writer = new PrintWriter(file, "UTF-8");

            writer.println("SORTING RESULTS");
            writer.println(hashLine);
            writer.println(runLine);
            //for each element at index there is a array within the results object.
            ArrayList<Speed> run1 = results.get(0);
            ArrayList<Speed> run2 = results.get(1);
            ArrayList<Speed> run3 = results.get(2);

            long bubble1 = getType(AlgorithmType.BUBBLE_SORT , run1).getTime();
            long bubble2 = getType(AlgorithmType.BUBBLE_SORT , run2).getTime();
            long bubble3 = getType(AlgorithmType.BUBBLE_SORT , run3).getTime();
            long bubbleAverage = (bubble1 + bubble2 + bubble3) / 3;
            writer.println("BubbleSort           "
                    +generatePaddedString(String.valueOf(bubble1))
                    +generatePaddedString(String.valueOf(bubble2))
                    +generatePaddedString(String.valueOf(bubble3))
                    +generatePaddedString(String.valueOf(bubbleAverage)));

            long insert1 = getType(AlgorithmType.INSERTION_SORT , run1).getTime();
            long insert2 = getType(AlgorithmType.INSERTION_SORT , run2).getTime();
            long insert3 = getType(AlgorithmType.INSERTION_SORT , run3).getTime();
            long insertAverage = (insert1 + insert2 + insert3) / 3;
            writer.println("InsertionSort        "
                    +generatePaddedString(String.valueOf(insert1))
                    +generatePaddedString(String.valueOf(insert2))
                    +generatePaddedString(String.valueOf(insert3))
                    +generatePaddedString(String.valueOf(insertAverage)));

            long quick1 = getType(AlgorithmType.QUICK_SORT , run1).getTime();
            long quick2 = getType(AlgorithmType.QUICK_SORT , run2).getTime();
            long quick3 = getType(AlgorithmType.QUICK_SORT , run3).getTime();
            long quickAverage = (quick1 + quick2 + quick3) / 3;
            writer.println("QuickSort            "
                    +generatePaddedString(String.valueOf(quick1))
                    +generatePaddedString(String.valueOf(quick2))
                    +generatePaddedString(String.valueOf(quick3))
                    +generatePaddedString(String.valueOf(quickAverage)));
            writer.println(hashLine);
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(writer != null) {
                writer.close();
            }
        }



    }

    /**
     * Method to pad result times to always be 20 chars in length .
     * **/
    private static String generatePaddedString(String stringToPad){
        int lengthOfString = stringToPad.length();
        int amountOfWhiteSpace = 20 - lengthOfString;
        String pad = "";
        for(int x =0; x < amountOfWhiteSpace; x++){
            pad = pad + " ";
        }

        return stringToPad + pad;





    }


    /**
     * Convenience method to get a speed object with a specified Algorithm type from the speed array.
     * **/
    private static Speed getType(AlgorithmType algorithmType, ArrayList<Speed> speeds){
        Speed result = null;
        for(Speed s : speeds){
            if(s.getAlgorithmType() == algorithmType){
                result = s;
                break;
            }
        }
        return result;
    }


}
