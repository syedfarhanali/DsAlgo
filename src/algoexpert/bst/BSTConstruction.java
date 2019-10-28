package algoexpert.bst;

import util.Utils;

public class BSTConstruction {

    public static void main(String[] args) {

        BST bst = new BST(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(5);
        bst.insert(13);
        bst.insert(22);
        bst.insert(1);
        bst.insert(12);
        bst.insert(14);
        System.out.println("Done!");

        System.out.println(bst.contains(6));
        System.out.println(bst.contains(22));
        System.out.println(bst.contains(0));
        System.out.println(bst.contains(1));

        bst.remove(10);

        System.out.println("Removed!");

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {

            BST currentNode = this;
            while(currentNode != null){
                if(value < currentNode.value){
                    if(currentNode.left == null){
                        currentNode.left = new BST(value);
                        break;
                    }else{
                        currentNode = currentNode.left;
                    }

                }else{
                    if(currentNode.right == null){
                        currentNode.right = new BST(value);
                        break;
                    }else{
                        currentNode = currentNode.right;
                    }

                }
            }

            return this;
        }

        public boolean contains(int value) {

            BST current = this;
            while(current != null){

                if(current.value == value){
                    return true;
                }else if(current.value < value){
                    current = current.right;
                }else {
                    current = current.left;
                }

            }

            return false;
        }

        public BST remove(int value) {

            BST currentNode = this;
            BST parentNode = null;

            while(currentNode !=null){

                if(currentNode.value == value){
                    if(currentNode.left !=null && currentNode.right !=null){  // NODE TO REMOVE WITH 2 CHILD (Handles root removal)
                        currentNode.value = currentNode.right.finxMinValue();
                        currentNode.right.remove(currentNode.value);
                    }else if(parentNode == null){                            // Edge Case for root node
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        }else if(currentNode.right != null){
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        }else{
                            currentNode = null;
                        }
                    }else if(currentNode.left == null && currentNode.right == null){ // LEAF NODE - NODE TO REMOVE WITH 0 CHILD
                        if(currentNode == parentNode.left){
                            parentNode.left = null;
                        }else{
                            parentNode.right = null;
                        }
                    }
                    else{                                                          // NODE TO REMOVE WITH 1 CHILD
                        if(currentNode == parentNode.left){
                            parentNode.left = currentNode.left == null ? currentNode.right : currentNode.left;
                        }else{
                            parentNode.right = currentNode.left == null ? currentNode.right : currentNode.left;
                        }
                    }
                    break;
                }else if(currentNode.value > value){
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                }else{
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                }

            }
            return this;
        }

        private int finxMinValue() {
            BST currentNode = this;
            while(currentNode.left != null){
                currentNode = currentNode.left;
            }
          return  currentNode.value;
        }
    }
}
