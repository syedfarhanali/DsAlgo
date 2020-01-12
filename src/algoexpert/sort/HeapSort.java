package algoexpert.sort;

import util.Utils;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,5,2,9,5,6,3};
        Utils.print(heapSort(arr));
    }


    public static int[] heapSort(int[] array) {

        createHeap(array);
        int endIndex = array.length-1;
        while (endIndex > 0){
            swap(array,0,endIndex);
            endIndex = endIndex -1;
            siftDown(array,0,endIndex);
        }
        return array;
    }

    public static int[] createHeap(int[] array) {

        int firstParent = (array.length - 2) / 2;
        for(int i=firstParent ;i >=0 ;i--){
            siftDown(array,i,array.length-1);
        }

        return array;
    }

    public static int[] siftDown(int[] array,int targetIdx, int endIndex){
        while(targetIdx <= endIndex){

            int firstChildIdx = (2 * targetIdx) + 1;
            int secondChildIdx = (2 * targetIdx) + 2;
            Integer bigChildIdx = null;

            if(firstChildIdx <= endIndex){
                bigChildIdx = firstChildIdx;

                if(secondChildIdx <= endIndex && array[secondChildIdx] > array[bigChildIdx]){
                    bigChildIdx = secondChildIdx;
                }
                if(array[bigChildIdx] > array[targetIdx] ){
                    swap(array,bigChildIdx,targetIdx);
                    targetIdx = bigChildIdx;
                }else {
                    return array;
                }
            }else {
                break;
            }
        }
        return array;
    }

    public static int[] swap(int[] array, int firstIndex,int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return array;
    }
}
