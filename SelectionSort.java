package DataStructure;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arrIterative = {64, 25, 12, 22, 11};
        int[] arrRecursive = {64, 25, 12, 22, 11};
        
        SelectionSort sorter = new SelectionSort();
        
        // Iterative selection sort
        sorter.selectionSort1(arrIterative, arrIterative.length);
        System.out.println("Iteratively sorted array:");
        for (int num : arrIterative) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Recursive selection sort
        sorter.selectionSort2(arrRecursive, 0, arrRecursive.length - 1);
        System.out.println("Recursively sorted array:");
        for (int num : arrRecursive) {
            System.out.print(num + " ");
        }
    }

    // Function to select the index of the minimum element
    int SelectMin(int arr[], int i, int n) {
        int min_idx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }
        return min_idx;
    }

    // Iterative selection sort algorithm
    void selectionSort1(int arr[], int n) {
        for (int index = 0; index < n - 1; index++) {
            // Find the index of the smallest value among A[index], A[index+1], ..., A[n-1]
            int indexOfNextSmallest = SelectMin(arr, index, n);

            // Interchange the value of A[index] and A[indexOfNextSmallest]
            int temp = arr[index];
            arr[index] = arr[indexOfNextSmallest];
            arr[indexOfNextSmallest] = temp;
        }
    }

    // Recursive selection sort algorithm
    void selectionSort2(int arr[], int first, int last) {
        if (first < last) {
            // Find the index of the smallest value among A[first], A[first+1], ..., A[last]
            int indexOfNextSmallest = SelectMin(arr, first, last + 1);

            // Interchange the value of A[first] and A[indexOfNextSmallest]
            int temp = arr[first];
            arr[first] = arr[indexOfNextSmallest];
            arr[indexOfNextSmallest] = temp;

            // Recursively sort the remaining elements
            selectionSort2(arr, first + 1, last);
        }
    }
}
