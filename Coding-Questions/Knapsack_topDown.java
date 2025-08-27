/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int[] wt = {1, 3, 5, 7};
	    int[] val = {3, 5, 9, 2};
	    int w = 10;
		
		System.out.println(knapsack(wt, val, 10, 4));
	}
	
	public static int knapsack(int[] wt, int[] val, int w, int n)
	{
	    int[][] t = new int[n+1][w+1];
	    for(int i = 0; i<n+1;i++)
	    {
	        for(int j = 0;j<w+1;j++)
	            if(i == 0 || j == 0)
	                t[i][j] = 0;
	    }
	    
	    for(int i = 1; i<n+1; i++)
	        for(int j = 1; j<w+1;j++)
	        {
	            if(j < wt[i-1])
	                t[i][j] = t[i-1][j];
	            else
	            {
	                t[i][j] = maxOf((val[i-1] + t[i-1][j-wt[i-1]]), t[i-1][j]);
	            }
	        }
	    
	    return t[n][w];
	    
	}
	
	static int maxOf(int a, int b)
	{
	    if(a >= b) return a;
	    else return b;
	}
}
