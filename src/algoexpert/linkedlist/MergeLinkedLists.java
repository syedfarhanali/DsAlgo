package algoexpert.linkedlist;

public class MergeLinkedLists {

    public static void main(String[] args) {


        ;
        LinkedList l8 = new LinkedList(8);
        LinkedList l7 = new LinkedList(7,l8);
        LinkedList l6 = new LinkedList(6,l7);
        LinkedList l2 = new LinkedList(2);

        LinkedList l10 = new LinkedList(10);
        LinkedList l9 = new LinkedList(9,l10);
        LinkedList l5 = new LinkedList(5,l9);
        LinkedList l4 = new LinkedList(4,l5);
        LinkedList l3 = new LinkedList(3,l4);
        LinkedList l1 = new LinkedList(1);

        LinkedList result = mergeLinkedLists(l1,l2);

        System.out.println(result.value);


    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        LinkedList newHead = null;

        if(headOne.value < headTwo.value){
            newHead = headOne;
            headOne = headOne.next;
        }else{
            newHead = headTwo;
            headTwo = headTwo.next;
        }

        LinkedList current = newHead;

        while(headOne!=null && headTwo!= null){

            if( headOne.value < headTwo.value ){
                current.next = headOne;
                headOne = headOne.next;
            }else{
                current.next = headTwo;
                headTwo = headTwo.next;
            }
            current = current.next;
        }

        if(headOne==null){
            current.next=headTwo;
            return newHead;
        }else if(headTwo==null){
            current.next=headOne;
            return newHead;
        }

        return newHead;
    }
}
