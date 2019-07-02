package com.damascus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number");
        int n = scanner.nextInt();
        Integer[] memo = new Integer[n + 1];
        System.out.println("Memoization:  "  + fibMemo(n, memo));
        System.out.println("Bottom Up:  " +fibBottomUp(n));
    }

    // Memoization
    // Big O -> T(n) = #Calls * t
    // (2n+1)*O(1) = O(2n+1) = O(n)
    private static int fibMemo(int n, Integer[] memo){
        int result;
        if(memo[n] != null){
            return memo[n];
        }
        if(n == 1 || n == 2){
            result = 1;
        }else{
            result = fibMemo(n-1, memo) + fibMemo(n- 2, memo);
        }
        memo[n] = result;
        return result;
    }

    // Bottom Up
    // Big O -> O(n)
    private static int fibBottomUp(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int[] bottom_up = new int[n + 1];
        bottom_up[1] = 1;
        bottom_up[2] = 1;
        for (int i = 3; i <= n; i++){
            bottom_up[i] = bottom_up[i-1] + bottom_up[i-2];
        }
        return bottom_up[n];
    }
}
