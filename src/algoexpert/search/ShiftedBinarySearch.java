package algoexpert.search;

public class ShiftedBinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{45,61,71,72,73,0,1,21,33,45};

        System.out.println(shiftedBinarySearch(arr,33));

    }

    public static int shiftedBinarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right){
            int middle = (left + right) / 2;

            if(array[middle] == target){
                return middle;
            }else if(array[left] <= array[middle]){

                if( target >= array [left] && target < array[middle]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }else{
                if( target <= array [right] && target > array[middle]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }

            }
        }
        return -1;
    }
}
