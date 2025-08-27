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
        int W = 11;
        int n = val.length;
        System.out.println(subsetSum(val, W, n));    
		    
	}
	
    static boolean subsetSum(int[] val, int sum, int n)
    {
        if(sum==0)
            return true;
        if(n==0)
            return false;
            
        if(sum < val[n-1]) return subsetSum(val, sum, n-1);
        else return subsetSum(val, sum-val[n-1], n-1)||subsetSum(val, sum, n-1);
    }
    
}
