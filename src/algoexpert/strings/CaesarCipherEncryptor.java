package algoexpert.strings;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {

        String str = "abc";
        int key = 52;
        System.out.println(caesarCypherEncryptor(str,key));
    }

    public static String caesarCypherEncryptor(String str, int key) {

        String result = "";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        int newKey = key % 26 ;


        for(int i = 0; i< str.length() ;i++){

            result = result + getNewChar(str.charAt(i),newKey,alphabets);

        }
        return result;
    }

    private static char getNewChar(char char1, int key, String alphabets) {

        int index = alphabets.indexOf(char1) + key;// a=0, z = 25

        return  index <= 25 ? alphabets.charAt(index) : alphabets.charAt( (index % 25) - 1) ;



    }


}
