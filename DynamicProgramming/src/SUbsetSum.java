
public class SUbsetSum {
	
	static int[][] t=new int[100][100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,3,7,8,10};
		int sum=14;
		for(int i=0;i<100;i++)
			for(int j=0;j<100;j++)
				t[i][j]=-1;
		System.out.println(solve(nums,0,sum));
	}
	
	static boolean solve(int[] nums, int i, int sum)
	{
		if(sum==0)
			return true;
		if(i==nums.length && sum!=0) return false;
		
		if(t[i][sum]!=-1) return t[i][sum]==1? true:false;
		
		if(nums[i]<=sum)
		{
			boolean bool=solve(nums, i+1, sum-nums[i]) || solve(nums, i+1, sum);
			t[i][sum]=bool?1:0;
			return bool;
		}else {
			boolean bool= solve(nums, i+1, sum);
			t[i][sum]=bool?1:0;
			return bool;
		}
	}
}
