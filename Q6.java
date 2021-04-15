public class Q6 {
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right)
            return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot);
        quickSort(arr, pivot + 1, right);
        System.out.println("pivot: " + pivot);
        for(int num : arr){
            System.out.print(num +" ");
        }
        System.out.println();
    }
    public static int partition(int[] arr, int left, int right){
        int value = arr[left];
        while(right > left) {
            while (right > left && arr[right] >= value)
                right--;
            arr[left] = arr[right];
            while(right > left && arr[left] <= value)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = value;
        return left;
    }
    public static void main(String[] args){
        int[] arr = new int[]{6, 1, 2, 7, 9 ,3, 4, 5,10, 8};
        //System.out.println()
        quickSort(arr, 0 , arr.length - 1);
    }
}
