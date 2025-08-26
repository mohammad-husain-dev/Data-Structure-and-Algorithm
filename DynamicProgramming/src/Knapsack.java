
public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val= {10, 40, 30, 50};
		int[] wt= {5, 4, 2, 3};
		int W = 5;
		
		Knapsack knapsack = new Knapsack();
		
		System.out.println(knapsack.knapsack(W, wt, val));
	}
	
	int knapsack(int W, int[] wt, int[] val)
	{
		int n=wt.length;
		int[][] dp=new int[n+1][W+1];
		initialize(dp, n+1, W+1);
		//return solve1(0, W, wt, val);
		//return solve2(0, W, wt, val, dp);
		//return solve3(wt.length, W, wt, val);
		return solve4(n, W, wt, val, dp);
	}
	
	
	
	private void initialize(int[][] dp, int m, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				dp[i][j]=-1;
	}

	int solve1(int i, int W, int[] wt, int[] val)
	{
		if(i==val.length || W==0) return 0;
		
		int max=0;
		if(wt[i]<=W)
		{
			max = Math.max(val[i]+solve1(i+1, W-wt[i], wt, val), solve1(i+1, W, wt, val));
		}
		else {
			max = solve1(i+1, W, wt, val);
		}
		
		return max;
	}
	
	int solve2(int i, int W, int[] wt, int[] val, int[][] dp)
	{
		if(i==val.length || W==0) return 0;
		
		if(dp[i][W] != -1) return dp[i][W];
		
		int max=0;
		if(wt[i]<=W)
		{
			max = Math.max(val[i]+solve2(i+1, W-wt[i], wt, val, dp), solve2(i+1, W, wt, val, dp));
			dp[i][W]=max;
		}
		else {
			max = solve2(i+1, W, wt, val, dp);
			dp[i][W]=max;
		}
		
		return max;
	}
	
	int solve4(int n, int W, int[] wt, int[] val, int[][] dp)
	{
		if(n==0 || W==0) return 0;
		
		if(dp[n][W]!=-1) return dp[n][W];
		
		int max=0;
		if(wt[n-1]<=W)
		{
			max = Math.max(val[n-1]+solve4(n-1, W-wt[n-1], wt, val, dp), solve4(n-1, W, wt, val, dp));
			dp[n][W]=max;
		}
		else {
			max = solve4(n-1, W, wt, val, dp);
			dp[n][W]=max;
		}
		
		return max;
	}
	
	int solve3(int n, int W, int[] wt, int[] val)
	{
		//if(i==val.length || W==0) return 0;
		int[][] dp=new int[n+1][W+1];
		// intitalize the dp
		for(int i=0;i<n+1;i++)
			for(int j=0;j<W+1;j++)
				if(i==0 || W==0)
					dp[i][j]=0;
		
		for(int i=1;i<n+1;i++)
		for(int j=1;j<W+1;j++)
		if(wt[i-1]<=j)
		{
			dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
		}
		else {
			dp[i][j] = dp[i-1][j];
		}
		
		return dp[n][W];
	}
	

}
