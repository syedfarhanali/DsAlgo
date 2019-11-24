package algoexpert.binaryTree;

public class MaxPathSumInBinaryTree {

    public static void main(String[] args) {

      /*  BinaryTree bt5 = new BinaryTree(5);
        BinaryTree bt6 = new BinaryTree(6);
        BinaryTree bt7 = new BinaryTree(7);
        BinaryTree bt8 = new BinaryTree(8);
        BinaryTree bt9 = new BinaryTree(9);

        BinaryTree bt4 = new BinaryTree(4,bt8,bt9);
        BinaryTree bt2 = new BinaryTree(2,bt4,bt5);
        BinaryTree bt3 = new BinaryTree(3,bt6,bt7);
        BinaryTree bt1 = new BinaryTree(1,bt2,bt3);*/

        BinaryTree bt2 = new BinaryTree(2);
        BinaryTree bt_1 = new BinaryTree(-1);
        BinaryTree bt1 = new BinaryTree(1,bt2,bt_1);


        System.out.println(maxPathSum(bt1));

    }

    public static Integer maxPathSum(BinaryTree tree) {

        Integer sum = tree.value;
        Integer leftSum = maxPathSumHelper(tree.left);
        Integer rightSum = maxPathSumHelper(tree.right);

        sum = leftSum > 0 ? leftSum + sum : sum;
        sum = rightSum > 0 ? rightSum + sum : sum;

        return sum;
    }

    public static Integer maxPathSumHelper(BinaryTree tree) {

        if(tree == null){
            return 0;
        }
        Integer leftSum = maxPathSumHelper(tree.left);
        Integer rightSum = maxPathSumHelper(tree.right);

        Integer maxSum = leftSum > rightSum ? leftSum : rightSum;



        return maxSum>0 ? maxSum + tree.value : tree.value;

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
