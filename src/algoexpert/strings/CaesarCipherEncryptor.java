package algoexpert.strings;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {

        String str = "xyz";
        int key = 2;
        System.out.println(caesarCypherEncryptor(str,key));
    }

    public static String caesarCypherEncryptor(String str, int key) {

        String result = "";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i< str.length() ;i++){

            result = result + getNewChar(str.charAt(i),key,alphabets);

        }
        return result;
    }

    private static char getNewChar(char char1, int key, String alphabets) {

        int newkey = alphabets.indexOf(char1) + key;// a=0, z = 25

        return  newkey <= 25 ? alphabets.charAt(newkey) : alphabets.charAt( (newkey % 25) - 1) ;



    }


}
