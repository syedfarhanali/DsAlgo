package algoexpert.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapConstruction {

    public static void main(String[] args) {

        //List<Integer> array = new ArrayList<>(Arrays.asList(new Integer[]{48,12,24,7,8,-5,24,391,24,56,2,6,8,41}));
        //List<Integer> array = new ArrayList<>(Arrays.asList(new Integer[]{2,3,1}));

        List<Integer> array = new ArrayList<>(Arrays.asList(new Integer[]{
                544,-578,556,713,-655,-359,-810,-731,194,-531,-685,689,-279,-738,
                886,-54,-320,-500,738,445,-401,993,-753,329,-396,-924,-975,376,748,
                -356,972,459,399,669,-488,568,-702,551,763,-90,-249,-45,452,-917,
                394,195,-877,153,788,844,867,266,-739,904,-154,-947,464,343,
                -312,150,-656,528,61,94,-581}));
        MinHeap minHeap = new MinHeap(array);
        System.out.println(minHeap.heap);
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {

            Integer firstParent = (array.size()-2) / 2;
            for(int i = firstParent ; i >= 0; i--){
                siftDown(i,array.size()-1,array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int firstChildIdx = (currentIdx * 2) + 1;

            while(firstChildIdx <= endIdx){
                Integer smallChildIdx = firstChildIdx;
                int secondChildIdx = ((currentIdx * 2) + 2) <= endIdx ? (currentIdx * 2) + 2 : -1;
                if(secondChildIdx != -1){
                    smallChildIdx = heap.get(firstChildIdx) < heap.get(secondChildIdx) ? firstChildIdx : secondChildIdx;
                }

                if(heap.get(smallChildIdx) < heap.get(currentIdx)){
                    swap(smallChildIdx,currentIdx,heap);
                    currentIdx = smallChildIdx;
                    firstChildIdx = (currentIdx * 2) + 1;
                }else {
                    return;
                }
            }
        }


        public void siftUp(int currentIdx, List<Integer> heap) {

            while(currentIdx > 0){
                int parentIdx = (currentIdx-1) / 2;
                Integer parent = heap.get(parentIdx);
                if(parent > heap.get(currentIdx)){
                    swap(parentIdx,currentIdx,heap);
                    currentIdx = parentIdx;
                }else{
                    return;
                }
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            int valueToRemove = heap.get(0);
            swap(0, heap.size()-1,heap);
            heap.remove(heap.size()-1);
            siftDown(0,heap.size()-1,heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size()-1,heap);
        }


        private void swap(Integer child1Idx, int child2Idx, List<Integer> heap) {
            Integer child1 = heap.get(child1Idx);
            heap.set(child1Idx,heap.get(child2Idx));
            heap.set(child2Idx,child1);
        }
    }
}
