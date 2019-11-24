package algoexpert.binaryTree;

public class InvertBinaryTree {

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

        invertBinaryTree(bt1);

        System.out.println("Done");
    }

    public static void invertBinaryTree(BinaryTree tree) {

        if(tree != null){
            BinaryTree temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
        }


    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
