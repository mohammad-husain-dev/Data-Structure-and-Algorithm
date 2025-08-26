
public class PermutationWithCaseChange10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ab --> ab, Ab, aB, AB
		 */
		String str="abc";
		solve(str, 0, new StringBuffer());
	}
	
	static void solve(String str, int idx, StringBuffer sb)
	{
		if(str.length()==0)
			return;
		if(idx==str.length())
		{
			System.out.println(sb.toString());
			return;
		}
		
		StringBuffer out1=new StringBuffer(sb);
		StringBuffer out2=new StringBuffer(sb);
		
		out1.append(str.charAt(idx));
		out2.append((char)(str.charAt(idx)-32));
		
		solve(str, idx+1, out1);
		solve(str, idx+1, out2);
	}
}
