package LCS;

import java.util.Arrays;

public class LCS {
    static int[][] dp;
    public static void main(String[] args) {
        String s1= "abcabcaa"; //"abcdghshdhasdashdhas";
        String s2= "acbacba"; //"abedfhrasdgashdasjhhhjjauyah";
        int i=s1.length()-1;
        int j=s2.length()-1;
        dp=new int[i+2][j+2];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
//        System.out.println(LCSDpRecur(s1,s2,i,j));
        System.out.println(LCSDpIterative(s1,s2));
//        System.out.println(LCSPrinting(s1,s2));
//        System.out.println(countLCS(s1,s2));
    }


    // recursive approach
    static int LCSRecur(String s1, String s2, int i, int j) {

        if(i<=0 || j<=0) return 0;

        if(s1.charAt(i) == s2.charAt(j)){
            return 1+LCSRecur(s1, s2, i-1, j-1);
        } else {
            return Math.max(LCSRecur(s1, s2, i-1, j),
                            LCSRecur(s1, s2, i, j-1));
        }
    }

    // Dynamic Recursive approach
    static int LCSDpRecur(String s1, String s2, int i, int j) {
        //System.out.println(i+" "+j+" "+s1+" "+s2);
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+LCSDpRecur(s1, s2, i-1, j-1);
        }else  {
            return dp[i][j]=Math.max(LCSDpRecur(s1, s2, i-1, j),
                    LCSDpRecur(s1, s2, i, j-1));
        }
    }

    // Dynamic Iterative approach
    static int LCSDpIterative(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        dp =  new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            for (int j=0;j<=n;j++)
                if(i==0 || j==0) dp[i][j]=0;
                else dp[i][j]=-1;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<m;i++) {
            boolean printed=false;
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if(!printed) sb.append(s1.charAt(i));
                    printed=true;
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        //System.out.println(sb.toString() + " len="+sb.length());
        return dp[m][n];
    }

    static String LCSPrinting(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                if(i==0 || j==0)dp[i][j]=0;
                else dp[i][j]=-1;

        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i=m,j=n;
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else{
                if(dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else j--;
            }
        }
        System.out.println(sb.length());
        return sb.reverse().toString();
    }


    static long countLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        long[][] count = new long[m + 1][n + 1];

        // Base case: empty string has exactly 1 LCS (the empty subsequence)
        for (int i = 0; i <= m; i++) count[i][0] = 1;
        for (int j = 0; j <= n; j++) count[0][j] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    count[i][j] = count[i - 1][j - 1];   // only 1 way to extend
                }
                else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        count[i][j] = count[i - 1][j];
                    }
                    else if (dp[i][j - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i][j - 1];
                        count[i][j] = count[i][j - 1];
                    }
                    else {
                        // both directions valid
                        dp[i][j] = dp[i - 1][j];
                        count[i][j] = count[i - 1][j] + count[i][j - 1];

                        // avoid double-counting
                        if (dp[i - 1][j - 1] == dp[i][j]) {
                            count[i][j] -= count[i - 1][j - 1];
                        }
                    }
                }
            }
        }

        return count[m][n];
    }

}

