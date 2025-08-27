/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
	
		int val[] = new int[] { 2, 3, 7, 8, 10};
        int W = 10;
        int n = val.length;
        System.out.println(countSubsetSum(val, W, n));    
		    
	}
	
    static int countSubsetSum(int[] val, int sum, int n)
    {
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
            
        if(sum < val[n-1]) return countSubsetSum(val, sum, n-1);
        else return countSubsetSum(val, sum-val[n-1], n-1)+countSubsetSum(val, sum, n-1);
    }
    
}
