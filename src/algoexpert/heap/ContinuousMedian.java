package algoexpert.heap;

import util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ContinuousMedian {

    Heap lower = new Heap(ContinuousMedian::MAX_FUNCTION,new ArrayList<Integer>());
    Heap higher = new Heap(ContinuousMedian::MIN_FUNCTION, new ArrayList<Integer>());



    double median = 0;

    public static void main(String[] args) {
        ContinuousMedian cm = new ContinuousMedian();
        cm.insert(5);
        System.out.println(cm.getMedian());
        cm.insert(10);
        System.out.println(cm.getMedian());
        cm.insert(100);
        System.out.println(cm.getMedian());
        cm.insert(200);
        System.out.println(cm.getMedian());
        cm.insert(6);
        System.out.println(cm.getMedian());
        cm.insert(13);
        System.out.println(cm.getMedian());
        cm.insert(14);
        System.out.println(cm.getMedian());
    }

    public void insert(int number) {
        if(lower.getSize()==0 || number < lower.peek()){
            lower.insert(number);
        }else {
            higher.insert(number);
        }
        if(lower.getSize()-higher.getSize() == 2){
            Integer value = lower.remove();
            higher.insert(value);
        }else if(higher.getSize() - lower.getSize() == 2){
            Integer value = higher.remove();
            lower.insert(value);
        }

        if(lower.getSize() == higher.getSize()){
            median = ((double)lower.peek() + (double)higher.peek())/2;
        }else if(lower.getSize() > higher.getSize()){
            median =lower.peek();
        }else{
            median = higher.peek();
        }
    }

    public double getMedian() {
        return median;
    }


    static class Heap{

        BiFunction<Integer,Integer,Boolean> comparisonFunction;
        List<Integer> heap = new ArrayList<Integer>();

        Heap(BiFunction<Integer,Integer,Boolean> comparisonFunction,List heap){
            this.comparisonFunction = comparisonFunction;
            this.heap = heap;
        }

        public Integer getSize(){
            return heap.size();
        }

        public Integer peek(){
            return heap.get(0);
        }

        public void insert(Integer value){
            heap.add(value);
            siftUp(heap.size()-1,heap);
        }

        public Integer remove(){
            swap(0,heap.size()-1,heap);
            Integer valueToRemove = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(0,heap);
            return valueToRemove;
        }

        public void siftUp(Integer currentIdx, List<Integer> heap){
            Integer parentIdx = (currentIdx-1) / 2 ;
            while(currentIdx > 0){
                if(parentIdx < heap.size() && comparisonFunction.apply(heap.get(currentIdx),heap.get(parentIdx))){
                    swap(currentIdx,parentIdx,heap);
                    currentIdx = parentIdx;
                    parentIdx = (currentIdx-1) / 2 ;
                }else {
                    return;
                }
            }
        }

        public void siftDown(Integer currentIdx , List<Integer> heap){

            Integer firstChildIdx = (currentIdx * 2) + 1;
            Integer endIndex = heap.size()-1;

            while(currentIdx < endIndex){
                Integer smallChildIdx = firstChildIdx;
                if(firstChildIdx <= endIndex ){
                    Integer secondChildIdx =  (currentIdx * 2) + 2;
                    if(secondChildIdx <= endIndex ){
                        smallChildIdx = comparisonFunction.apply(heap.get(firstChildIdx),heap.get(secondChildIdx))?firstChildIdx:secondChildIdx;
                    }
                    if(comparisonFunction.apply(heap.get(smallChildIdx),heap.get(currentIdx))){
                        swap(currentIdx,smallChildIdx,heap);
                        currentIdx = smallChildIdx;
                        firstChildIdx = (currentIdx * 2) + 1;
                    }
                }else {
                    return;
                }

            }


        }

        private void swap(Integer child1Idx, int child2Idx, List<Integer> heap) {
            Integer child1 = heap.get(child1Idx);
            heap.set(child1Idx,heap.get(child2Idx));
            heap.set(child2Idx,child1);
        }

    }


    public static Boolean MAX_FUNCTION(Integer a, Integer b){
        return a > b;
    }

    public static Boolean MIN_FUNCTION(Integer a, Integer b){
        return a < b;
    }


}
