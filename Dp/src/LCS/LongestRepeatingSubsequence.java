package LCS;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s="AABEBCDD";

        System.out.println(lcsLen(s,s));
    }

    static int lcsLen(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];

        for (int i=1;i<=m;i++)
            for (int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j)
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }

        StringBuffer sb=new StringBuffer();
        int i=m,j=n;
        while(i>0&&j>0){
            if (s1.charAt(i-1)==s2.charAt(j-1) && i!=j) {
                sb.append(s1.charAt(i - 1));
                i--; j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1])
                    i--;
                else
                    j--;
            }
        }

        System.out.println(sb.reverse().toString());
        return dp[m][n];
    }
}
