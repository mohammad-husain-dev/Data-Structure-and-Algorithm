package LCS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String  s1="abcdefed";
        String s2="abfce";

        System.out.println(longestPalindromicSubstringUsingLCSubstring(s1));
    }

    static int LCSubstring(String s1,String s2) {
        int m=s1.length(),n=s2.length();

        int[][] dp=new int[m+1][n+1];

        int max=-1;
        for(int i=1;i<=m;i++)
            for (int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }else{
                    dp[i][j]=0;
                    max=Math.max(dp[i][j],max);
                }
            }
        return max;
    }

    static int LCSubstringPrinting(String s1,String s2) {
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        int max=-1;
        int idx=-1;

        for(int i=1;i<=m;i++)
            for (int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(max<dp[i][j]){
                        max=dp[i][j];
                        idx=i-1;
                    }
                }
            }

        StringBuffer sb=new StringBuffer();
        for(int j=0;j<max;j++){
            sb.append(s1.charAt(idx--));
        }
        System.out.println(sb.reverse().toString());
        return max;
    }

    static Set<String> AllLCSubstring(String s1, String s2) {
        int  m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        int max=-1;
        int idx=-1;
        Set<String> list=new HashSet<>();

        for(int i=1;i<=m;i++)
            for (int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(max<dp[i][j]){
                        max=dp[i][j];
                        list.clear();
                    }

                    if(max == dp[i][j]){
                        list.add(s1.substring(i-max,i));
                    }
                }
            }

        return list;
    }

    public static String longestPalindromicSubstringUsingLCSubstring(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];
        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    int len = dp[i][j];

                    // original index in s
                    int origStart = i - len;

                    // mapped index of reversed substring in original string
                    int revStart = n - j;  // Because rev[k] = s[n-1-k]

                    // check if indices correspond to palindrome
                    if (origStart == revStart) {
                        if (len > maxLen) {
                            maxLen = len;
                            endIndex = i;  // end in original string s
                        }
                    }
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return s.substring(endIndex - maxLen, endIndex);
    }

}
