package algoexpert.binaryTree;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static void main(String[] args) {
        BinaryTree bt5 = new BinaryTree(5);
        BinaryTree bt6 = new BinaryTree(6);
        BinaryTree bt7 = new BinaryTree(7);
        BinaryTree bt8 = new BinaryTree(8);
        BinaryTree bt9 = new BinaryTree(9);

        BinaryTree bt4 = new BinaryTree(4,bt8,bt9);
        BinaryTree bt2 = new BinaryTree(2,bt4,bt5);
        BinaryTree bt3 = new BinaryTree(3,bt6,bt7);
        BinaryTree bt1 = new BinaryTree(1,bt2,bt3);

        branchSums(bt1);
    }
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        BinaryTree(int value, BinaryTree left,BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {

        List<Integer> result = new ArrayList<Integer>();
        addNode(result, root,0);
        Utils.print(result);
        return result;


    }

    public static void addNode(List<Integer> result, BinaryTree current,Integer sum){
        if(current==null) return;

        int newsum = sum + current.value;

        if(current.left==null && current.right==null){
            result.add(newsum);
            return;
        }
        addNode(result, current.left,newsum);
        addNode(result, current.right,newsum);
    }


}
