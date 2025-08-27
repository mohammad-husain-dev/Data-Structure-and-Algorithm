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
	    Arrays.stream(t).forEach(t1 -> Arrays.fill(t1, -1));
		int val[] = new int[] { 2, 3, 7, 8, 10};
        int W = 11;
        int n = val.length;
        System.out.println(subsetSum(val, W, n));    
		    
	}
	
    static int subsetSum(int[] val, int w, int n)
    {
        if(w==0){
            t[n][w] = 1;
            return t[n][w];
        }
        else if(n==0){
            t[n][w] = 0;
            return t[n][w];
        }
        
        if(t[n][w] != -1) return t[n][w];
            
        if(w < val[n-1]) t[n][w] = subsetSum(val, w, n-1);
        else t[n][w] = OR(subsetSum(val, w-val[n-1], n-1), subsetSum(val, w, n-1));
        
        return t[n][w];
    }
    
    static int OR(int a, int b)
    {
        if(a==0 && b==0) return 0;
        return 1;
    }
}
