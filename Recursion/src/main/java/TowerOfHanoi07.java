
public class TowerOfHanoi07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		solve(25, 1,3,2);
		long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Execution time: " + duration + " ms");
	}
	
	static void solve(int n, int s, int d, int h)
	{
		if(n==1)
		{
			System.out.println("Move: "+s+"-->"+d);
			return;
		}
		
		solve(n-1, s, h, d);
		System.out.println("Move: "+s+"-->"+d);
		solve(n-1, h, d, s);
	}

}
