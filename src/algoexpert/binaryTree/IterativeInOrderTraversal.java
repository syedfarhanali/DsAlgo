package algoexpert.binaryTree;

import java.util.function.Function;

public class IterativeInOrderTraversal {

    public static void main(String[] args) {

        BinaryTree bt9 = new BinaryTree(9);
        BinaryTree bt4 = new BinaryTree(4,null,bt9);
        BinaryTree bt6 = new BinaryTree(6);
        BinaryTree bt7 = new BinaryTree(7);
        BinaryTree bt2 = new BinaryTree(2,bt4,null);
        BinaryTree bt3 = new BinaryTree(3,bt6,bt7);
        BinaryTree bt1 = new BinaryTree(1,bt2,bt3);

        bt9.parent = bt4;
        bt4.parent = bt2;
        bt2.parent = bt1;
        bt6.parent = bt3;
        bt7.parent = bt3;
        bt3.parent = bt1;

        Function<BinaryTree, Void> function =   new Function<BinaryTree, Void>() {
            @Override
            public Void apply(BinaryTree binaryTree) {
                System.out.println("Value" + binaryTree.value);
                return null;
            }
        };

        iterativeInOrderTraversal(bt1,function);

    }

    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {

        BinaryTree currentNode = tree;
        BinaryTree previousNode = null;

        BinaryTree nextNode = null;

        while(currentNode != null){

            if(previousNode == null || previousNode.equals(currentNode.parent)){
                if(currentNode.left != null){
                    nextNode = currentNode.left;
                }else if(currentNode.right != null){
                    callback.apply(currentNode);
                    nextNode = currentNode.right;
                }else {
                    callback.apply(currentNode);
                    nextNode = currentNode.parent;
                }
            }else if(previousNode.equals(currentNode.left)){
                callback.apply(currentNode);
                if(currentNode.right != null){
                    nextNode = currentNode.right;
                }else{
                    nextNode = currentNode.parent;
                }
            }else{
                nextNode = currentNode.parent;
            }

            previousNode = currentNode;
            currentNode = nextNode;
        }
    }


    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
        public BinaryTree(int value,BinaryTree left ,BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
