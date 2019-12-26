package algoexpert.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{0,1,21,33,45,46,61,62,63,73};

        int result = binarySearch(arr,33);

        System.out.println(result);

    }

    public static int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length-1;
        int middle;

        while(left > right){   //left could be equal to right

            middle = (left + right) / 2;

            if(target ==array[middle]){
                return middle;
            }else if(target > array[middle]){
                left = middle + 1;
            }else{
                right = middle-1;
            }

        }

        return -1;
    }
}
