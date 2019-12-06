package algoexpert.recursion;

import util.Utils;

public class NthFibonacci {

    public static void main(String[] args) {
        int n = 6;
        Utils.print(getNthFib(n));
        Utils.print(getNthFib2(n));
    }

    public static int getNthFib(int n) {
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else {
            return getNthFib(n-2) + getNthFib(n-1);
        }
    }


    public static int getNthFib2(int n) {
        return fibonacci(0,1,n,2 );
    }

    public static int fibonacci(int n1, int n2,int count,int currentCount){
        currentCount++;
        if (count == currentCount){
            return n1+n2;
        }else{
          return fibonacci(n2,n1 + n2,count,currentCount);
        }
    }
}
