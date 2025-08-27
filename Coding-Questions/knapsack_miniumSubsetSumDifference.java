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
	
		int val[] = new int[] {1,5,6,11};
        int n = val.length;
        System.out.println(minimumSumDiffrence(val, n));    
		    
	}
	
	static int minimumSumDiffrence(int[] val, int n)
	{
	    int sum=0;
	    for(int i=0;i<n;i++) sum=sum+val[i];
	    
	    int[] sumArray = sumArray(val, n, sum);
	    
	    int size=sumArray.length;
	    
	    int ret = sum - 2*sumArray[size-1];
	     return ret;
	    
	}
	
	static int[] sumArray(int[] val, int n, int sum)
	{
	    
	    int[][] t = new int[n+1][sum+1];
	    
	    for(int i=0;i<n+1;i++)
	    for(int j=0;j<sum+1;j++)
	    {
	       if(i==0)
	            t[i][j] = 0;
	       if(j==0)
	            t[i][j] = 1;
	    }
	    
	    for(int i=1;i<n+1;i++)
	    for(int j=1;j<sum+1;j++)
	    {
    	    if(j < val[i-1])
    	        t[i][j] = t[i-1][j];
    	    else{
    	        t[i][j] = or(t[i-1][j], t[i-1][j-val[i-1]]);
    	    }
	    }
	    
	    List list = new ArrayList();
	    for(int k=0;k<(sum/2)+1;k++)
	    {
	        if(t[n][k]==1)
	            list.add(k);
	    }
	    int[] arr = new int[list.size()];
	    
	    for(int i=0;i<list.size();i++)
	    {
	        arr[i]=(Integer)list.get(i);
	    }
	    return arr;
	}
	
	static int or(int a, int b)
	{
	    if(a==0 && b==0) return 0;
	    return 1;
	}   
}
