
class HeapSort {

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if( l < n && arr[largest] < arr[l]) {
            largest = l;
        }
        if(r < n && arr[largest] < arr[r]) {
            largest = r;
        }
        if(largest != i) {
            HeapSort.swap(arr, largest, i);
            HeapSort.heapify(arr, n, largest);
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for(int i = n/2 - 1; i > -1; i--) {
            HeapSort.heapify(arr, n, i);
        }
        for(int i = n-1; i > 0; i--) {
            HeapSort.swap(arr, 0, i);
            HeapSort.heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] test_arr = new int[]{3,4,7,3,5,1,4,2,9,6,0};
        HeapSort.sort(test_arr);
        for(int i: test_arr) {
            System.out.println(i);
        }
    }
}