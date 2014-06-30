package com.company;
/***************************************************************************
 ** Kristie Parsons - Assignment # 1
 **
 ** File: ArrayClass
 ** Author: Kristie Parsons
 ** Class: CS 260
 ** Create Date: 6/24/14
 ** Imports: java.util.Random
 **
 ** Description of File: Holds the methods used for filling an array with
 random numbers, adding numbers to an array, deleting numbers from array,
 deleting duplicate numbers, sorting numbers from smallest to largest and
 for figuring out the current array size.
 **
 **
 *****************************************************************************/

import java.util.Random;


//PART ONE
public class ArrayClass {
    private static int DEFAULT_SIZE = 100;    //Defines the size of array
    private int arraySize;                    //Size of array
    private int count;                        //Holds # of elements in array
    private int[] array;                      //Creates array

    /**
     * Constructs array of 100 elements
     */
    public ArrayClass() {
        arraySize = DEFAULT_SIZE;
        array = new int[arraySize];
    }

    /**
     * Constructs an array of n elements.
     *
     * @param int n
     */
    public ArrayClass(int n) {
        arraySize = n;
        array = new int[arraySize];
    }

    //PART 4

    /**
     * Fills array with random integers
     */
    public void fillArray() {

        Random random = new Random();
        int maxInt = 25;                //The max integer that random can create

        //random.nextInt(maxInt);

        //Fills array
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(maxInt);
            addElem(array[i]);
            curElems();

            int index = count; //

            while (index != 0 && array[index - 1] > arraySize) //Finds empty place for value
            {
                array[index] = array[index - 1];
                index++;                         //Increment size
                array[index] = arraySize;

            }//End while
        }
    }//End fillArray


    /**
     * Adds the integer value to the array in the next available
     * location, returns false if this is not possible.
     *
     * @param int value
     * @return true
     * false otherwise
     */
    public boolean addElem(int value) {
        int max = arraySize;

        if (count <= max) {
            int[] newArray = new int[max * 2];                //Creates new array with double size

            for (int i = 0; i < arraySize; i++)                 //Copies elements onto new array
            {
                newArray[i] = array[i];
            }

            int index = count;                                 //Sets index = to count

            while (index != 0 && array[index - 1] < arraySize)   //Finds empty place for value
            {
                array[index] = array[index - 1];
                index++;
                array[index] = value;

            }

            return true;

        } else return false;

    }//End addElement

    /**
     * Deletes the last added element, return false if array is empty.
     *
     * @return true if # of elements is greaters than zero
     * false otherwise
     */
    public boolean delElem() {
        if (howMany(count) > 0)                        //If # of elements in array greater than 0
        {
            arraySize--;                               //Delete last element in array
            return true;
        } else return false;

    }//End delElement

    /**
     * Returns the number	of	elements	in	the array.
     *
     * @return number of elements in array
     */
    private int howMany(int value) {
        count = arraySize;

        if (count == 0)                                //Checks to see if array is empty
        {
            return -1;
        } else return count;

    }//End howMany

    /**
     * Returns a string listing the current elements, ten	per line.
     *
     * @ return the curElements
     */
    public String curElems() {
        String curElements = "";                       //Sets string
        int wordCount = 0;                             //Sets # of words

        //Goes through array
        for (int i = 0; i < arraySize; i++) {
            wordCount++;                                //Increases wordCount
            curElements += array[i] + ", ";             //Adds array to curElements String

            if (wordCount == 10)                         //If wordCount = 10
            {
                curElements += "\n";                     //Go to next line
                wordCount = 0;                           //Reset wordCount to zero

            }

        }//End for

        return curElements;

    }//End curElems

    //PART TWO

    /**
     * Selection Sorts the array from smallest to largest
     */
    public void selectionSort() {
        int min;
        for (int i = 0; i < arraySize; i++)             //Steps through array
        {
            min = i;                                    //Assume first element is min

            for (int j = i + 1; j < arraySize; j++)     //Steps through array again
            {
                if (array[j] < array[min])                //If element is smaller than the min
                {
                    min = j;                              //The new min is at element j
                }
            }

            if (min != i)                               //If min does not equal element i
            {
                final int temp = array[i];                //Hold element i in temp until match is found
                array[i] = array[min];                    //When element i equals min
                array[min] = temp;                        //Assign min to temp
            }
        }
    }

    /**
     * Returns the largest element and removes it from the array.
     *
     * @returns the largest value and deletes it
     */
    public int getLargest() {
        int element = 0;                          //Sets element to zero

        for (int i = 0; i < arraySize; i++)      //Go through array
        {
            if (array[i] > array[element])         //Find largest element array
            {
                element = i;                        //Set element equal to i if i is larger
            }
        }
        int largestVal = array[element];          //Holds largest int value
        array[element] = array[arraySize - 1];    //Moves last int down
        delElem();                                //Deletes largest value

        return largestVal;

    }//End getLargest

    //PART 3

    /**
     * Removes any duplicate entries.
     */
    public void removeDups() {
        for (int i = 0; i < arraySize; i++)        //Steps through array
        {
            for (int j = i + 1; j < arraySize; j++)  //Steps through array again
            {
                if (array[i] == array[j])            //If duplicate is found
                {
                    unsortDelete(j);                  //Call unsortDelete and delete it
                    j--;

                }//End if

            }//End for

        }//End for

    }//End removeDups

    /**
     * Moves the array size down after duplicate is found
     */
    private void unsortDelete(int location) {
        array[location] = array[arraySize - 1];   //Deletes the duplicate
        arraySize--;                              //Moves arraySize down to fill hole

    }//End
}