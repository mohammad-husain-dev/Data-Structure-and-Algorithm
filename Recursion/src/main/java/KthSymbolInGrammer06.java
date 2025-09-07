
public class KthSymbolInGrammer06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 0
		 * 0 1
		 * 0 1 1 0
		 * 0 1 1 0  1 0 0 1
		 * 
		 * */
		System.out.println(solve(5,1));
	}
	
	static int solve(int n, int k)
	{
		if(n==1 || k==1) return 0;
		
		int mid=1<<n-2;
		if(k<=mid)
			return solve(n-1, k);
		else {
			int ret=solve(n-1, k-mid);
			if(ret==0) return 1;
			return 0;
		}
	}

}
