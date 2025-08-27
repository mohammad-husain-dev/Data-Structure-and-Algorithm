/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	
	    int[] val = {3, 34, 4, 12, 5, 2};
	    int w = 30;
		
		System.out.println(ifSubsetSum(val, 30, 6));
	}
	
	public static int ifSubsetSum(int[] arr, int w, int n)
	{
	    int[][] t = new int[n+1][w+1];
	    
	    for(int i = 0;i<n+1;i++)
	        for(int j=0;j<w+1;j++)
	        {
	            if(i==0) t[i][j] = 0;
	            if(j==0) t[i][j] = 1;
	        }
	        
	    for(int i=1;i<n+1;i++)
	        for(int j=1;j<w+1;j++)
	        {
        	    if(j < arr[i-1])
        	        t[i][j] = t[i-1][j];
        	    else
        	        t[i][j] = or(t[i-1][j-arr[i-1]], t[i-1][j]);
	        }
	         
	    return t[n][w];
	}
	
	static int or(int a, int b)
	{
	    if(a==0 && b==0) return 0;
	    else return 1;
	}
}
