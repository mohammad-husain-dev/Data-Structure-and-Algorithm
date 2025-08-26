
public class CountSbsetWithSum {
	static int[][] t=new int[100][100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,3,5,6,8,10};
		int sum=11;
		for(int i=0;i<100;i++)
			for(int j=0;j<100;j++)
				t[i][j]=-1;
		System.out.println(solve(nums,0,sum));
	}
	
	static int solve(int[] nums, int i, int sum)
	{
		if(sum==0)
			return 1;
		if(i==nums.length && sum!=0) return 0;
		
		if(t[i][sum]!=-1) return t[i][sum];
		
		if(nums[i]<=sum)
		{
			int bool=solve(nums, i+1, sum-nums[i]) + solve(nums, i+1, sum);
			t[i][sum]=bool;
			return bool;
		}else {
			int bool= solve(nums, i+1, sum);
			t[i][sum]=bool;
			return bool;
		}
	}

}
