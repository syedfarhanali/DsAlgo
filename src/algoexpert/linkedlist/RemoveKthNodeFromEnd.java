package algoexpert.linkedlist;

public class RemoveKthNodeFromEnd {

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

        removeKthNodeFromEnd(l1,9);

        System.out.println(l2.next.value);

    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        LinkedList endFinder = head;
        LinkedList numberFinder = head;

        while(k!=0 && endFinder!=null){
            endFinder = endFinder.next;
            k--;
        }

        if(endFinder == null){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }


        while (endFinder.next != null){
            endFinder= endFinder.next;
            numberFinder= numberFinder.next;
        }

        LinkedList next =  numberFinder.next.next;
        numberFinder.next = next;

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
