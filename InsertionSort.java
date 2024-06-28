package DataStructure;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        InsertionSort sorter = new InsertionSort();
        sorter.insertionSort(arr, arr.length);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Insertion Sort - JAVA
    void insertionSort(int arr[], int n) {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}


