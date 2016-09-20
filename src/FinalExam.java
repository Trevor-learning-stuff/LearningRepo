import java.util.Arrays;

/**
 * Programmer: Trevor Campbell             CSC110AB FinalExam
 * Date: May 5, 2016
 * Description: This program will reverse the order of an array without
 * creating another array. This works for arrays of any length.
 *
 * Input: an array of any length
 * Output: An array in the reverse order of the parameter array
 *
 * Pseudocode for this solution:
 * Begin
 * start loop
 * initialize temp int variable to hold the beginning array value
 * set the beginning array value to the last array value
 * set the last array value to the temp int variable
 * repeat loop until array has passed through the length / 2
 * end
 */

public class FinalExam {

    static void reverse(int arr[]) {
        int temp = 0;

        //loop through to reverse the array
        for(int i = 0; i < arr.length / 2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

    }

    public static void main(String[] args) {
        //test with 10 elements
        int[] myArray10Elements = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] myArrayRev10Elements = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        reverse(myArray10Elements);

        if (Arrays.equals(myArray10Elements, myArrayRev10Elements)) {
            System.out.println("reverse worked for 10 elements");
        }

        //test with 9 elements
        int[] myArray9Elements = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] myArrayRev9Elements = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        reverse(myArray9Elements);

        if (Arrays.equals(myArray9Elements, myArrayRev9Elements)) {
            System.out.println("reverse worked for 9 elements");
        }

        //test with zero elements
        int[] myArray1Element = {0};
        int[] myArrayRev1Element = {0};
        reverse(myArray1Element);

        if (Arrays.equals(myArray1Element, myArrayRev1Element)) {
            System.out.println("reverse worked for 1 elements");
        }

        //test with an empty array
        int[] myArrayWithNoElements = {};
        int[] myArrayRevNoElements = {};
        reverse(myArrayWithNoElements);

        if (Arrays.equals(myArrayWithNoElements, myArrayRevNoElements)) {
            System.out.println("reverse worked for no elements");
        }

        int[] myArrayRandomElements = {3, 2, 8, 5};
        int[] myArrayRandomRevElements = {5, 8, 2, 3};

        if (Arrays.equals(myArrayRandomElements, myArrayRandomRevElements)) {
            System.out.println("reverse worked for a random string of elements");
        }
    }
}
