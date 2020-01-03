package algoexpert.sort;

public class BubbleSort {

    public static void main(String[] args) {

        //int[] a  = new int[]{8,5,2,9,5,6,3};
        int[] a  = new int[]{1,2};

        bubbleSort(a);

    }

    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;

        int counter = 0;

        while (!isSorted){
            isSorted = true;
            for(int i=0 ; i < array.length - 1 - counter ;i++){
                if(array[i] > array[i+1]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }
}
