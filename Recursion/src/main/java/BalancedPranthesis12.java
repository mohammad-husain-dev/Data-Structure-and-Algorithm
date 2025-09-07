
public class BalancedPranthesis12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(3,3, new StringBuffer());
	}
	
	static void solve(int open, int close, StringBuffer sb)
	{
		if(open==0 && close==0)
		{
			System.out.println(sb.toString());
			return;
		}
		
		StringBuffer out1=new StringBuffer(sb);
		StringBuffer out2=new StringBuffer(sb);
		if(open!=0) {
			solve(open-1, close, out1.append('('));
		}
		if(open<close) // we have two choices
		{
			solve(open, close-1, out2.append(')'));
		}
	}
}
