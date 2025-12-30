package LCS;

public class MinimumNumberOfInsertionAndDeletion {
    /*
    String s1, s2;
    change s1 into s2 with mini # of insert and delete
    convert s1 --> LCS(s1,s2) --> s2
    #insertion = s1-LCS
    #deletion = s2-LCS
     */
    public static void main(String[] args) {
        String s1="ea";
        String s2="pea";

        int lcs = lcsLen(s1,s2);
        int del_num=s1.length()-lcs;
        int insert_num=s2.length()-lcs;
        System.out.println(del_num);
        System.out.println(insert_num);
    }

    static int lcsLen(String s1,String s2) {
        int len1=s1.length();
        int len2=s2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++)
            for (int j=1;j<=len2;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        return dp[len1][len2];
    }
}
