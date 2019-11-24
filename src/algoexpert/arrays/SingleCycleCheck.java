package algoexpert.arrays;

public class SingleCycleCheck {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,1,-4,-4,2};

        System.out.println(hasSingleCycle(arr));

    }

    public static boolean hasSingleCycle(int[] array) {

        // if loop completed for arr.length and index is not back to zero
        // if index zero got visited multiple time before loop complete

        int START_INDEX = 0;
        int vistedLength = 0;
        int currentIdx = START_INDEX;

        while(vistedLength < array.length){
            if(vistedLength > 0 && currentIdx == START_INDEX){
                return false;
            }
            vistedLength++;
            currentIdx = getNextIdx(currentIdx,array);
        }
        return currentIdx == 0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {

        int nextIdx = (currentIdx + array[currentIdx]) % array.length;

        return nextIdx < 0 ? nextIdx + array.length : nextIdx;
    }
}
