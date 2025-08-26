
public class MinimumReplacment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,9,3}; // {3,3,3,3}
		System.out.println(minimumRepl(nums));
	}
	
	static long minimumRepl(int[] nums)
	{
		long operations=0;
		int n=nums.length;
		int prev=nums[n-1];
		
		for(int i=n-2;i>=0;i--)
		{
			if(nums[i]<=prev)
				prev=nums[i];
			else {
				int parts=/*(int)Math.ceil(nums[i]/prev)*/(nums[i]+prev-1)/prev;
				operations += parts-1;
				prev=(nums[i]+parts-1)/parts;
			}
		}
		
		return operations;
	}
}
