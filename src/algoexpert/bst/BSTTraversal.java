package algoexpert.bst;

import java.util.ArrayList;

public class BSTTraversal {

    public static void main(String[] args) {

        BST bst1 = new BST(1);
        BST bst2 = new BST(14);
        BST bst3 = new BST(2,bst1,null);
        BST bst4 = new BST(13,null,bst2);
        BST bst5 = new BST(5);
        BST bst6 = new BST(22);
        BST bst7 = new BST(5, bst3,bst5);
        BST bst8 = new BST(15, bst4,bst6);
        BST tree = new BST(10,bst7,bst8);

        ArrayList<Integer> array = new ArrayList<>();
        
        inOrderTraverse(tree,array);
        preOrderTraverse(tree,array);
        postOrderTraverse(tree,array);

    }


    public static ArrayList<Integer> inOrderTraverse(BST tree, ArrayList<Integer> array) {
       if(tree != null){
           inOrderTraverse(tree.left,array);
           array.add(tree.value);
           inOrderTraverse(tree.right,array);
       }
       return array;
    }

    public static ArrayList<Integer> preOrderTraverse(BST tree, ArrayList<Integer> array) {

        if(tree !=null){
            array.add(tree.value);
            preOrderTraverse(tree.left,array);
            preOrderTraverse(tree.right,array);
        }

        return array;

    }

    public static ArrayList<Integer> postOrderTraverse(BST tree, ArrayList<Integer> array) {
        if(tree != null){
            postOrderTraverse(tree.left,array);
            postOrderTraverse(tree.right,array);
            array.add(tree.value);
        }
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
