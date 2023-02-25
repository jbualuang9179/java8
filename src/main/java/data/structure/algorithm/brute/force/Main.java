package data.structure.algorithm.brute.force;

public class Main {

    public static int search(int[] arr, int target) {
        // Iterate over each element in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                // If a match is found, return the index of the element
                return i;
            }
        }
        // If no match is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,2,1,9};

        System.out.println(search(arr, 9));
    }
}
