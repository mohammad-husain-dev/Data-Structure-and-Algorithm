/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Arrays;
public class Main
{
    static int[][] t = new int[100][1002];
	public static void main(String[] args) {
	   // for(int i = 0;i<100;i++)
	   //     Arrays.fill(t[i][1002], 0);
	   Arrays.stream(t).forEach(t1 -> Arrays.fill(t1, -1));
	        
	    int[] wt = {1, 3, 5, 7};
	    int[] val = {3, 5, 9, 2};
	    int w = 10;
		System.out.println(knapsack(wt, val, w, wt.length));
	}
	
	public static int knapsack(int[] wt, int[] val, int w, int n)
	{
	    if(n==0 || w==0)
	        return 0;
	    
	    if(t[n][w] != -1) return t[n][w];
	        
	    if(wt[n-1] <= w){
	        System.out.print(val[n-1]+", ");
	        t[n][w] = maxOf(val[n-1]+knapsack(wt, val, w-wt[n-1], n-1), knapsack(wt, val, w, n-1));
	        return t[n][w];
	    }
	    else{
	        t[n][w] = knapsack(wt, val, w, n-1);
	        return t[n][w];
	    }
	}
	
	public static int maxOf(int a, int b)
	{
	    if(a>=b)
	        return a;
	    else return b;
	}
}

