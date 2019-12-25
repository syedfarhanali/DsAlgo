package algoexpert.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList l6 = new LinkedList(6);
        LinkedList l5 = new LinkedList(5,l6);
        LinkedList l4 = new LinkedList(4,l5);
        LinkedList l3 = new LinkedList(3,l4);
        LinkedList l2 = new LinkedList(2,l3);
        LinkedList l1 = new LinkedList(1,l2);

        System.out.println(reverseLinkedList(l1).value);

    }

    public static LinkedList reverseLinkedList(LinkedList head) {

        LinkedList current = head;
        LinkedList next = head.next;

        if(head.next == null){
            return head;
        }

        while (next != null){
            current.next = next.next;
            next.next = head;
            head = next;
            next = current.next;
        }

        return head;
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
