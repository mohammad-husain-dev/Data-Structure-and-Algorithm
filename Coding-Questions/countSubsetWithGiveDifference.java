/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	
		int val[] = new int[] {1,1,2,3};
        int n = val.length;
        int diff = 1;
        System.out.println(countSubsetWithGiveDifference(val,diff, n));    
		    
	}
	
    static int countSubsetWithGiveDifference(int arr[], int diff, int n)
    {
        /// s1-s2 = diff
        /// s1+s2 = sum(arr)
        /// s1 = diff+sum(arr)/2;
        int sum=0;
        for(int i=0;i<n;i++) sum=sum+arr[i];
        
        int s1 = (diff+sum)/2;
        
        return countSubset(arr, s1, n);
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




