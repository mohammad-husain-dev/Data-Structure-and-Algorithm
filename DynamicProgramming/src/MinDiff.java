import java.util.ArrayList;
import java.util.List;

public class MinDiff {
	static int[][][] t;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums= {7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694};
		int[] nums= {2,-1,0,4,-2,-9};
		int n=nums.length;
		t=new int[n+1][n/2+1][n/2+1];
        for(int i=0;i<=n;i++)
        for(int j=0;j<=n/2;j++)
        for(int k=0;k<=n/2;k++)
            t[i][j][k]=-1;
        System.out.println(solve(nums, 0, new ArrayList(), new ArrayList(), n/2, 0, n/2, 0, Integer.MAX_VALUE));
	}
	
	static int solve(int[] nums, int i, List<Integer> list1, List<Integer> list2, 
            int n1, int sum1, int n2, int sum2, int min)
	{
		if(n1==0 && n2==0)
		{
			min=Math.min(min, Math.abs(sum1-sum2));
			return min;
		}
		
		if(t[i][n1][n2]!=-1) return t[i][n1][n2];
		
		if(n1>0 && n2>0){
			list1.add(nums[i]);
			int min1=solve(nums, i+1, list1, list2, n1-1, sum1+nums[i], n2, sum2, min);
			list1.removeLast();
			list2.add(nums[i]);
			int min2=solve(nums, i+1, list1, list2, n1, sum1, n2-1, sum2+nums[i], min);
			return t[i][n1][n2]=Math.min(min1, min2);
		}
		if(n1>0){
			list1.add(nums[i]);
			return solve(nums, i+1, list1, list2, n1-1, sum1+nums[i], n2, sum2, min);
		}
		else{
			list2.add(nums[i]);
			return solve(nums, i+1, list1, list2, n1, sum1, n2-1, sum2+nums[i], min);
		}
	}
}
