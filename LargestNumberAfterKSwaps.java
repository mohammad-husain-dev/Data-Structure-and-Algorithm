
public class LargestNumberAfterKSwaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=1234567;
		int k=2;
		int max=num;
		
		System.out.println(LargestNum(num, k, 0, 7, max));
	}
	
	static int LargestNum(int num, int k, int i, int L, int max)
	{
		//for(int j=i+1;j<) 
		if(k==0 || i==L)
		{
			return max;
		}
		
		for(int j=i+1;j<L;j++)
		{
			int dgti=getDigitAtIndex(num, i, L);
			int dgtj=getDigitAtIndex(num, j, L);
			
			if(dgtj>dgti)
			{
				num=swap(num, i,j,L);
				if(max < num) 
					max=num;
				max=LargestNum(num, k-1, i+1, L, max);
				num=swap(num, j,i,L);
			}
			
		}
		return LargestNum(num, k, i+1, L, max);
	}
	
	static int swap(int num, int i, int j, int L)
	{
		int dgti=getDigitAtIndex(num, i, L);
		int dgtj=getDigitAtIndex(num, j, L);
		
		int ret=0;
		for(int k=0;k<L;k++)
		{
			if(k!=i && k!=j)
				ret+=getDigitAtIndex(num, k, L)*(Math.pow(10, L-k-1));
			else if(k==i)
				ret+=dgtj*Math.pow(10, L-k-1);
			else if(k==j)
				ret+=dgti*Math.pow(10, L-k-1);
		}
		
		return ret;
	}
	
	static int getDigitAtIndex(int num, int i, int L)
	{
		return (int)(num % Math.pow(10, L-i))/(int)Math.pow(10, L-i-1);
	}
}
