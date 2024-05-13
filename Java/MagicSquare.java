/*
* The program for magic square 305
*
* @author  Michael Zagon
* @version 1.0
* @since   2024-05-10
*
*/
import java.util.ArrayList;

/**
 * This is a Magic Square
 */
final class MagicSquare {

    /**
     * The is 15.
     */
    public static final int MAGICNUM = 15;

    /**
     * This is 9.
     */
    public static final int NINE = 9;

    /**
     * This is 8.
     */
    public static final int EIGHT = 8;

    /**
     * This is 7.
     */
    public static final int SEVEN = 7;

    /**
     * The is 6.
     */
    public static final int SIX = 6;
  
    /**
     * The is 5.
     */
    public static final int FIVE = 5;

    /**
     * The is 4.
     */
    public static final int FOUR = 4;

    /**
     * This is 3.
     */
    public static final int THREE = 3;

    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this is ever called
     *
     * @throws IllegalStateException
     *
     */
    private MagicSquare() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Function that checks for duplicates in an array.
     *
     * @param arrOne - array.
     * @return boolean checks for dups.
     */
    public static boolean dup(final int[] arrOne) {
        final ArrayList<Integer> arr = new ArrayList<Integer>();

        // loops through, checks for length, and sorts array
        for (int counter = 0; counter < arrOne.length; counter++) {
            for (int counterTwo= 1; counterTwo< arrOne.length; counterTwo++) {
                if (arrOne[counter] == arrOne[counterTwo] && counter != counterTwo) {
                    arr.add(arrOne[counter]);
                }
            }
        }
        // returns the length
        return arr.size() != 0;
    }

    /**
     * Checks for magic square.
     *
     * @param num possible numbers
     * @param arrOne - array
     * @param index - current index
     */
    public static void magicSquare(final int[] num, final int[] arrOne,
                                 final int index) {
        // prints valid magic squares
        if (index == NINE && printSquare(arrOne)) {
            generateSquare(arrOne);
        } else {
            // run through each number for each index
            if (index != NINE) {
                for (int counter = 0; counter < NINE; counter++) {
                    arrOne[index] = num[counter];
                    magicSquare(num, arrOne, index + 1);
                }
            }
        }
    }

    /**
     * Where the magic square is printed
     *
     * @param baseArray - array to be checked.
     * @return boolean
     */
    public static boolean printSquare(final int[] baseArray) {
        final boolean returning;
        // checks for duplicates
        if (dup(baseArray)) {
            returning = false;
        } else {
            // declare rows
            final int rowOne = baseArray[0] + baseArray[1] + baseArray[2];
            final int rowTwo = baseArray[THREE] + baseArray[FOUR]
                + baseArray[FIVE];
            final int rowThree = baseArray[SIX] + baseArray[SEVEN]
                + baseArray[EIGHT];
            // declare columns
            final int columnOne = baseArray[0] + baseArray[THREE] + baseArray[SIX];
            final int columnTwo = baseArray[1] + baseArray[FOUR] + baseArray[SEVEN];
            final int columnThree = baseArray[2] + baseArray[FIVE] + baseArray[EIGHT];
            // declare diagonals
            final int diagonalOne = baseArray[0] + baseArray[FOUR]
                + baseArray[EIGHT];
            final int diagonalTwo = baseArray[2] + baseArray[FOUR] + baseArray[SIX];

            returning = rowOne == rowTwo && rowTwo == rowThree && rowThree == columnOne
                && columnOne == columnTwo && columnTwo == columnThree && columnThree == diagonalOne
                && diagonalOne == diagonalTwo && diagonalTwo == MAGICNUM;
        }
        // returns the colomns, rows, and diagonals
        return returning;
    }

    /**
     * Function that prints a magic square.
     *
     * @param outputSquare - array to be printed.
     */
    public static void generateSquare(final int[] outputSquare) {
        // the spaces
        final String spaceBetweenNums = " ";

        // loops through the numbers
        for (int counter = 0; counter < outputSquare.length; counter++) {
            if (counter == THREE || counter == SIX) {
                System.out.println();
                System.out.print(outputSquare[counter] + spaceBetweenNums);
            } else {
                System.out.print(outputSquare[counter] + spaceBetweenNums);
            }
        }
        System.out.println("\n");
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(final String[] args) {
        final int[] magicSquare = {
            1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // starting of the program
        System.out.println("All Possible Magic Squares (3x3):");
        System.out.println("");
        magicSquare(magicSquare, extraArray, 0);

        // end of program
        System.out.println("Done.");
    }
}
