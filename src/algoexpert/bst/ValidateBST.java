package algoexpert.bst;

public class ValidateBST {

    public static void main(String[] args) {

        BST bst1 = new BST(1);
        BST bst2 = new BST(14);
        BST bst3 = new BST(2,bst1,null);
        BST bst4 = new BST(13,null,bst2);
        BST bst5 = new BST(5);
        BST bst6 = new BST(22);
        BST bst7 = new BST(5, bst3,bst5);
        BST bst8 = new BST(15, bst4,bst6);
        BST bst9 = new BST(10,bst7,bst8);

        System.out.println(validateBst(bst9));
        System.out.println(validateBst1(bst9));
    }

    public static boolean validateBst(BST tree) {

        return validateBstHelper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }

    public static boolean validateBstHelper(BST tree, Integer minLimit, Integer maxLimit) {

        if (tree == null){
            return true;
        }
        if(tree.value < minLimit || tree.value >= maxLimit){
            return false;
        }

        return validateBstHelper(tree.left,minLimit,tree.value) &&
                validateBstHelper(tree.right,tree.value,maxLimit);
    }


    public static boolean validateBst1(BST tree) {

        return validateNode(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean validateNode(BST node, int minLimit, int maxLimit){
        //System.out.println(minLimit + ":" +maxLimit);
        if(node == null){
            return true;
        }else if( node.value < minLimit || node.value >= maxLimit){
            return false;
        }

        return validateNode(node.left, minLimit, node.value)
                && validateNode(node.right, node.value, maxLimit );
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
        public BST(int value,BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }



    }



}
