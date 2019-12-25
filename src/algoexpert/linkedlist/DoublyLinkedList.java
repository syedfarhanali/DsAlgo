package algoexpert.linkedlist;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Algo Expert giving timeout error!!!!
 */

public class DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList db = new DoublyLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        db.insertAtPosition(1,node1);
        db.insertAfter(node1,node3);
        db.insertAfter(node1,node3);
        db.insertBefore(node3,node2);
        System.out.println(db.containsNodeWithValue(3));
        db.remove(node3);
        System.out.println(db.containsNodeWithValue(3));
        System.out.println(db.containsNodeWithValue(2));
        db.removeNodesWithValue(2);
        System.out.println(db.containsNodeWithValue(2));
        System.out.println(2);
        db.setTail(node2);
        db.setHead(node4);
    }

    List<Node> nodes = new ArrayList<Node>();

    Node head;
    Node tail;


    public void insertBefore(Node node, Node nodeToInsert) {
        if(nodeToInsert.equals(head) && nodeToInsert.equals(tail)){
            return;
        }
        remove(nodeToInsert);
        if(node.prev != null){
            node.prev.next = nodeToInsert;
            nodeToInsert.prev = node.prev;
        }else{
            head = nodeToInsert;
        }
        node.prev = nodeToInsert;
        nodeToInsert.next = node;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if(nodeToInsert.equals(head) && nodeToInsert.equals(tail)){
            return;
        }
        remove(nodeToInsert);

        if(node.next !=null){
            node.next.prev = nodeToInsert;
        }else{
            tail = nodeToInsert;
        }
        nodeToInsert.next = node.next;
        node.next = nodeToInsert;
        nodeToInsert.prev = node;


    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        Node currentNode = head;
        Integer i = 1;

        if(position == 1){
            setHead(nodeToInsert);
            return;
        }

        while(currentNode!=null && i!=position ){
            currentNode = currentNode.next;
            i++;
        }
        if(currentNode != null){
            insertBefore(currentNode,nodeToInsert);
        }else{
            setTail(nodeToInsert);
        }



    }

    public void removeNodesWithValue(int value) {
        Node node = head;
        while(node != null){
            if(node.value == value){
                remove(node);
                return;
            }else {
                node = node.next;
            }
        }
    }

    public void remove(Node node) {

        if(node == head){
            head = head.next;
            head.prev = null;
        }
        if(node == tail){
            tail = tail.prev;
            tail.next=null;
        }

        if(node.prev !=null && node.next !=null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    public boolean containsNodeWithValue(int value) {
        Node current = head;
        while(current!=null){
            if(current.value == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void setHead(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            insertBefore(head,node);
        }
    }
    public void setTail(Node node){
        if(tail == null){
            tail = head;
        }else{
            insertAfter(tail,node);
        }

    }


    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}



