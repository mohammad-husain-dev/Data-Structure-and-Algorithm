package mcm;

public class MatrixChainMul {
    static int[][] dp;
    public static void main(String[] args) {
        int[] dimension={40, 20, 30, 10, 30};
        dp=new int[100][100];
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(solve(dimension,1, dimension.length-1));
        System.out.println(solveRecur(dimension,1, dimension.length-1));
    }

    static int solve(int[] matrix, int i, int j) {
        if(i>=j) return 0;

        int min=Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int val1=solve(matrix,i,k);
            int val2=solve(matrix,k+1,j);
            int val3=matrix[i]*matrix[k+1]*matrix[j];
            int temp=val1+val2+val3;
            min=Math.min(temp,min);
        }
        return min;
    }

    static int solveRecur(int[] matrix, int i, int j) {
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int min=Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int val1=solve(matrix,i,k);
            int val2=solve(matrix,k+1,j);
            int val3=matrix[i]*matrix[k+1]*matrix[j];
            int temp=val1+val2+val3;
            min=Math.min(temp,min);
        }
        return dp[i][j] = min;
    }
}
