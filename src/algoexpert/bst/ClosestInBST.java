package algoexpert.bst;

import util.Utils;

import javax.rmi.CORBA.Util;

public class ClosestInBST {

    public static void main(String[] args) {

        BST bst1 = new BST(1);
        BST bst2 = new BST(2,bst1,null);
        BST bst3 = new BST(5);
        BST bst4 = new BST(5,bst2,bst3);
        BST bst5 = new BST(14);
        BST bst6 = new BST(13,null,bst5);
        BST bst7 = new BST(22);
        BST bst8 = new BST(15,bst6,bst7);
        BST bst9 = new BST(10,bst4,bst8);

        int target = 17;

        Utils.print(findClosestValueInBst(bst9,target));

        Utils.print(findClosestValueInBst_Recursive(bst9,target));

    }

    /**
     *
     * @param tree
     * @param target
     * @return
     *
     * Time complexity O(log N), space complexity is O(1)
     */
    public static int findClosestValueInBst(BST tree, int target) {

        BST currentTree = tree;
        int result = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        while(currentTree != null){
            if(minDiff > Math.abs(currentTree.value - target)){
                result = currentTree.value;
                minDiff = Math.abs(currentTree.value - target);
            }

            if(currentTree.value == target){
               break;
            }else if(currentTree.value < target){
                currentTree = currentTree.right;
            }else{
                currentTree = currentTree.left;
            }
        }
        return result;
    }

    public static int findClosestValueInBst_Recursive(BST tree, int target) {
        return findClosestValueInBst_Recursive(tree,target,tree);
    }

    public static int findClosestValueInBst_Recursive(BST tree, int target, BST closest){

        if(tree == null){
            return closest.value;
        }
        if(Math.abs(closest.value - target) > Math.abs(tree.value - target)){
            closest = tree;
        }

        if(tree.value < target){
            tree = tree.right;
        }else if(tree.value > target){
            tree = tree.left;
        }else {
            return closest.value;
        }
        return findClosestValueInBst_Recursive(tree,target,closest);
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
        public BST(int value, BST left, BST right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
