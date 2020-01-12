package algoexpert.search;

public class QuickSelect {

    public static void main(String[] args) {

        int[] arr = new int[]{45,61,71,72,73,0,1,21,33,45};

        System.out.println(quickselect(arr,3    ));

    }

    public static int quickselect(int[] array, int k) {

        int position = k-1;
        return quickSelect(array,0,array.length-1,position);
    }

    public static int quickSelect(int[] array, int start, int end, int targetIndex){


        while (true){
            if(start > end){
                return array[targetIndex];
            }

            int pivot = start;
            int left = start + 1;
            int right = end;

            while(left <= right){
                if(array[left] > array[pivot] && array[right] < array[pivot]){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }

                if(array[left] <= array[pivot]){
                    left++;
                }

                if(array[right] >= array[pivot]){
                    right--;
                }
            }

            int temp = array[right];
            array[right] = array[pivot];
            array[pivot] = temp;

            if(right == targetIndex){
                return array[right];
            }else if( targetIndex < right){
                end =  right-1;
            }else{
                start = right+1;
            }
        }
    }
}
