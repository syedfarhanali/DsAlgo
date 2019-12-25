package algoexpert.linkedlist;

public class FindLoop {

    public static void main(String[] args) {

        LinkedList l9 = new LinkedList(9);
        LinkedList l8 = new LinkedList(8,l9);
        LinkedList l7 = new LinkedList(7,l8);
        LinkedList l6 = new LinkedList(6,l7);
        LinkedList l5 = new LinkedList(5,l6);
        LinkedList l4 = new LinkedList(4,l5);
        LinkedList l3 = new LinkedList(3,l4);
        LinkedList l2 = new LinkedList(2,l3);
        LinkedList l1 = new LinkedList(1,l2);

        l9.next = l4; //loop

        LinkedList result = findLoop(l1);

        System.out.println(result.value);

    }

    public static LinkedList findLoop(LinkedList head) {


        LinkedList slowPointer = head.next;
        LinkedList fastPointer = head.next.next;

        while(slowPointer.value != fastPointer.value){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        slowPointer = head;

        while(slowPointer.value != fastPointer.value){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }
}
