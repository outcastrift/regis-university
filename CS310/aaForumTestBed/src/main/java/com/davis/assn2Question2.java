package com.davis;

import java.util.Arrays;

/**
 * This software was created for
 * All rights to this software belong to  appropriate licenses and restrictions apply.
 * Created by Samuel Davis on 5/10/16.
 * INSTRUCTIONS GIVEN:
 * Present an example of using the binary search algorithm.
 * Start by showing an example sorted list of at least 11 and no more than 20 items. The items in the list can be of type integer, double, or String (your choice).
 * Be sure to show both the indexes and the values stored at each index. 
 * For example:
 * [0] 3.5
 * [1] 4.6
 * :
 * State the value of the target item you will be searching for.
 * List the values of the low, high and middle indexes for each pass, until the algorithm completes (note: The target should not be found on the first pass)
 * State how many passes were required to find the target (or how many passes were required to discover that the target was not in the list).
 * NOTE: Your example must be unique from any other example presented.
 */

public class assn2Question2 {

    public static void main( String[] args )
    {
       ;
    }




    /**
     * Takes a  integer array as a argument and populates it within the values 1-11.
     * @param array Integer array to populate
     * @return the populated array
     * **/
    private static Integer[] initializeArrayForTest(Integer[] array){
        array[0]=1;
        array[1]=2;
        array[2]=3;
        array[3]=4;
        array[4]=5;
        array[5]=6;
        array[6]=7;
        array[7]=8;
        array[8]=9;
        array[9]=10;
        array[10]=11;
        return array;
    }


    /**
     Will loop through a array using a binary search  algorithm.
     If the searchValue supplied is not within the array the method returns false.
     @param searchValue the search value to find within the array
     @param array a array to search within.
     @return true if integer is within the array
     @return false if integer is not within the array
     **/
    private static  boolean isValueInArray(Integer[] array, Integer searchValue){
        Integer[] temp = new Integer[0];
        boolean found =false;
        int counter =0;
        while(!found){
            if(array.length ==0){
                System.out.println("Value ["+String.valueOf(searchValue)+"] was not within the array, returning false.");
                break;
            }
            counter = counter+1;
            System.out.println(" Loop number  = "+String.valueOf(counter));
            int x = (array.length / 2);
            System.out.println("Values for the Indexes of this Loop Iteration High=["+array[array.length-1]+"] Medium=["+array[x]+"] Low=["+array[0]+"]");
            System.out.println("Current Values for all Index Positions for This Loop Iteration");
            printIntegerArray(array);

            if(array[x]==searchValue){
                //value was found
                System.out.println("Loop iteration "+String.valueOf(counter)+" finished.::: Array Size = ["+ String.valueOf(array.length) + "] The index of X =["+String.valueOf(x)+"] The value of X =["+String.valueOf(array[x])+"] " );
                System.out.println("Search Value=["+String.valueOf(searchValue)+"] was found in array. Exiting Loop and returning true.");
                found =true;

            }else if (searchValue > array[x]){
                System.out.println("Search value was greater than X::: Array Size =["+ String.valueOf(array.length) + "] The index of X=["+String.valueOf(x)+"] The value of X =["+String.valueOf(array[x])+"]" );
                temp = Arrays.copyOfRange(array, (x+1) , (array.length ));
                array = temp;
                System.out.println(" Loop iteration ["+String.valueOf(counter)+"] finished. Value ["+String.valueOf(searchValue)+"] was not found");

            }else if (searchValue < array[x] ){
                System.out.println("Search value was less than X::: Array Length = ["+ String.valueOf(array.length) + "] The index of X =["+String.valueOf(x)+"] The value of X =["+String.valueOf(array[x])+"]" );

                temp = Arrays.copyOfRange(array, 0 , (x));
                array=temp;
                System.out.println(" Loop iteration ["+String.valueOf(counter)+"] finished. Value ["+String.valueOf(searchValue)+"] was not found");
            }

        }
        return found;

    }
    private static void printIntegerArray(Integer[] array){
         for(int i =0; i < array.length ;i++){
                System.out.println("Index =["+i+"]  Value =["+array[i]+"]");
            }
    }


}
