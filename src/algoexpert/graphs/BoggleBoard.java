package algoexpert.graphs;

import util.Utils;

import javax.rmi.CORBA.Util;
import java.util.*;

public class BoggleBoard {

    public static void main(String[] args) {

        char[][] board = {
                {'t','h','i','s','i','s','a'},
                {'s','i','m','p','l','e','x'},
                {'b','x','x','x','x','e','b'},
                {'x','o','g','g','l','x','o'},
                {'x','x','x','D','T','r','a'},
                {'R','E','P','E','A','d','x'},
                {'x','x','x','x','x','x','x'},
                {'N','O','T','R','E','-','P'},
                {'x','x','D','E','T','A','E'}};

        String[] words = {"this","is","not","a","simple","boggle","board","test","REPEATED","NOTRE-PEATED",""};
        String[] word1 = {"simple"};


        char[][] board2 = {
                {'a','b'},
                {'c','d'}};
        String[] words2 = {"abcd","abdc","acbd","acdb","adbc","adcb","abca"};

        List<String> result = boggleBoard(board2,words2);
        result.stream().forEach(System.out::println);
    }

    public static List<String> boggleBoard(char[][] board, String[] words) {

        Set<String> result = new HashSet<>();

        Trie trie = new Trie();
        for(String word : words){
            trie.addWord(word);
        }


        for(int i=0; i < board.length ;i++){
            for(int j=0; j< board[0].length; j++){
                Character c = board[i][j];
                if(trie.root.children.containsKey(c)) {
                    List<String> tempResult = new ArrayList<>();
                    Boolean[][] visited = new Boolean[board.length][board[0].length];
                    visited[i][j] = Boolean.TRUE;
                    List<Integer[]> neighbours = getNeighbours(i,j,board);
                    checkIfUnvisitedNeighboursAreInNode(board,neighbours,trie.root.children.get(c),visited,tempResult);
                    result.addAll(tempResult);
                }
            }
        }
        return new ArrayList<String>(result);
    }


    private static void checkIfUnvisitedNeighboursAreInNode(char[][] board,List<Integer[]>  neighbours, Node node,Boolean[][] visited,List<String> tempResult) {

        if(node.children.containsKey(Trie.endCharacter)){
            tempResult.add(node.word);
        }

        neighbours.forEach((n) ->{
            Integer row = n[0];
            Integer col = n[1];
            Character currentChar = board[row][col];
            if(node.children.containsKey(currentChar) && visited[row][col]!=Boolean.TRUE){
                visited[row][col] = Boolean.TRUE;
                List<Integer[]> newNeighbours = getNeighbours(row,col,board);
                checkIfUnvisitedNeighboursAreInNode(board,newNeighbours,node.children.get(currentChar),visited,tempResult);
                visited[row][col] = Boolean.FALSE;
            }
        });

    }

    private static List<Integer[]> getNeighbours(Integer row, Integer col,char[][] board) {
        List<Integer[]> neighbours = new ArrayList<>();
        Integer length = board[0].length;
        Integer height = board.length;
        if( row > 0){
            neighbours.add(new Integer[]{row-1,col});
        }
        if(row > 0 && col < length-1){
            neighbours.add(new Integer[]{row-1,col+1});
        }
        if( col < length-1){
            neighbours.add(new Integer[]{row,col+1});
        }
        if( row < height-1 && col < length-1){
            neighbours.add(new Integer[]{row+1,col+1});
        }
        if( row < height-1){
            neighbours.add(new Integer[]{row+1,col});
        }
        if(row <height-1 && col>0){
            neighbours.add(new Integer[]{row+1,col-1});
        }
        if(col>0){
            neighbours.add(new Integer[]{row,col-1});
        }
        if(row>0 && col>0){
            neighbours.add(new Integer[]{row-1,col-1});
        }

        return neighbours;
    }


    static class Node{
        Map<Character,Node> children = new HashMap<Character, Node>();
        String word;
    }

    static class Trie{

        Node root;
        static Character endCharacter = '*';

        Trie(){
            this.root = new Node();
        }

        void addWord(String word){
            Node currentNode = this.root;
            for(int j=0 ;j< word.length() ;j++){
                Character c = word.charAt(j);
                if(!currentNode.children.containsKey(c)){
                    currentNode.children.put(c,new Node());
                }
                currentNode = currentNode.children.get(c);
            }
            currentNode.children.put(this.endCharacter,null);
            currentNode.word = word;

        }

    }

}
