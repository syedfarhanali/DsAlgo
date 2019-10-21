package algoexpert.dynamicProgramming;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {

        int[] denoms = new int[]{1, 5};
        int target = 11;

        System.out.println(numberOfWaysToMakeChange(target, denoms));

    }


    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int i = 0; i < denoms.length; i++) {
            for (int j = 1; j < ways.length; j++) {
                if (denoms[i] <= j) {
                    ways[j] += ways[j - denoms[i]];
                }
            }
        }
        return ways[n];
    }
}