package com.company;

/***************************************************************************
 ** Kristie Parsons - Assignment # 1
 **
 ** File: ArrayClassMain
 ** Author: Kristie Parsons
 ** Class: CS 260
 ** Create Date: 6/24/14
 **
 ** Description of File: Creates array and then calls methods
 **
 **
 *****************************************************************************/

public class Main
{
    public static void main(String[] args)
    {
        ArrayClass array1 = new ArrayClass(20);

        array1.fillArray();
        System.out.print("Unordered Array:\n" + array1.curElems());
        array1.delElem();
        System.out.println("\nDelete last added element:\n" + array1.curElems());

        //Add method not adding new element
        //array1.addElem(45);
        //System.out.println("\nAdd 45 to array:\n" + array1.curElems());
        array1.selectionSort();
        System.out.println("\nOrdered Array:\n" + array1.curElems());

        System.out.println("\nLargest Number: " + array1.getLargest());
        System.out.println("\nArray With Largest Number Removed:\n" + array1.curElems());

        System.out.println("\nDeleting duplicates... ");
        array1.removeDups();
        array1.selectionSort();
        System.out.println("\nArray with no duplicates:\n" + array1.curElems());

    }


}