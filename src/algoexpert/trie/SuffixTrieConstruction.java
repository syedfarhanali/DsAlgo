package algoexpert.trie;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction {

    public static void main(String[] args) {
        SuffixTrie suffixTrie = new SuffixTrie("babc");

        System.out.println(suffixTrie);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {

            for(int i=0 ; i< str.length() ;i++){
                TrieNode node = root;
                for(int j=i ;j <str.length() ;j++){
                    char c = str.charAt(j);
                    if(!node.children.containsKey(c)){
                        node.children.put(c,new TrieNode());
                    }
                    node = node.children.get(c);
                }
                node.children.put(endSymbol,null);
            }
        }

        public boolean contains(String str) {
            TrieNode node = root;
            for(int i=0 ;i < str.length() ;i++){
                Character c = str.charAt(i);
                if(!node.children.containsKey(c)){
                    return false;
                }
                node = node.children.get(c);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
