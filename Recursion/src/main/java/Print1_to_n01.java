
public class Print1_to_n01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print3(10);
	}
	
	static void print1(int n)
	{
		if(n==0) {
			return;
		}
			
		print1(n-1);
		System.out.println(" "+n);
	}
	
	static void print2(int n)
	{
		if(n==1) {
			System.out.println(n);
			return;
		}
			
		print2(n-1);
		System.out.println(n);
	}
	
	static void print3(int n)
	{
		if(n==1)
		{
			System.out.println(n);
			return;
		}
		
		System.out.println(n);
		print3(n-1);
	}
}
