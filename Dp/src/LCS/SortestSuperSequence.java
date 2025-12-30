package LCS;

public class SortestSuperSequence {
    public static void main(String[] args) {
        String s1="AGGTAB";
        String s2="GXTXAYB";

        int res=SSS(s1,s2);
        System.out.println(res);
        System.out.println(printSCS(s1,s2));
    }

    static int SSS(String s1,String s2){
        return s1.length()+s2.length()-LCS.LCSDpIterative(s1,s2);
    }
    
    static String printSCS(String s1,String s2){

        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        StringBuffer sb=new StringBuffer();
        int i=m,j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    sb.append(s2.charAt(j-1));
                    j--;
                }else{
                    sb.append(s1.charAt(i-1));
                    i--;
                }
            }
        }

        while(i>0){
            sb.append(s1.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(s2.charAt(j-1));
            j--;
        }
        System.out.println(sb.toString().length());
        return sb.reverse().toString();
    }
}
