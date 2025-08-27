/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) 
	{
		int n = 4;
        int a[] = { 3, 3, 3, 3 };
        int sum = 6;
 
        System.out.print(countSubset(a, sum, n));
	}
	
	static int countSubset(int[] arr, int w, int n)
	{
	     int[][] t = new int[n+1][w+1];
	     
	     for(int i=0;i<n+1;i++)
	     for(int j=0;j<w+1;j++)
	     {
	         if(i==0) t[i][j] = 0;
	         if(j==0) t[i][j] = 1;
	     }
	     
	     for(int i=1;i<n+1;i++)
	     for(int j=1;j<w+1;j++)
	     {
    	     if(j<arr[i-1])
    	        t[i][j] = t[i-1][j];
    	     else
    	        t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
	     }
	     
	     return t[n][w];
	}
}




