package LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr={10,9,2,5,3,7,101,18};
        dp=new int[arr.length+1][arr.length+1];
        Arrays.stream(dp).forEach(x->Arrays.fill(x,-1));
        System.out.println(solve(arr, 0, -1));
    }

    static int solve(int[] arr, int curr, int prev){
        if(curr==arr.length)
            return 0;
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        
        int len1=solve(arr, curr+1,prev);
        int len2=0;
        if(prev == -1 || arr[curr]>arr[prev]){
            len2 = 1+solve(arr, curr+1,curr);
        }

        return dp[curr][prev+1]=Math.max(len1,len2);
    }
}
