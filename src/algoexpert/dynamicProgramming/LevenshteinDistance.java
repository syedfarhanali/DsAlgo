package algoexpert.dynamicProgramming;

import util.Utils;

public class LevenshteinDistance {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "yabd";
        System.out.println(levenshteinDistance( str1, str2 ));
    }

    public static int levenshteinDistance(String str1, String str2) {


        char[] rows = str1.toCharArray();
        char[] col = str2.toCharArray();

        int edits[][] = new int[rows.length+1][col.length+1];

        for (int i=0 ; i< rows.length+1 ; i++){

            for (int j=0 ; j< col.length+1 ; j++){

                if(i==0){
                    edits[i][j] = j;
                }else if(j == 0){
                    edits[i][j] = i;
                }else if( rows[i-1] == col[j-1]){
                    edits[i][j] = edits[i-1][j-1];
                }else{
                    edits[i][j] = 1 + Math.min(    Math.min( edits[i][j-1], edits[i-1][j])  , edits[i-1][j-1]);
                }

            }
        }
        Utils.print2D(edits);
        return edits[rows.length][col.length];

    }
}
