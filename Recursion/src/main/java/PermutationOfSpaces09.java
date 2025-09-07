
public class PermutationOfSpaces09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ABC --> ABC, A-BC, A-B-C, AB-C
		 */
		String str="AB";
		solve(str, 0, new StringBuffer());
	}
	
	static void solve(String str, int idx, StringBuffer sb)
	{
		if(str.length()<2)
			return;
		if(idx==str.length()-1)
		{
			sb.append(str.charAt(idx));
			System.out.println(sb.toString());
			return;
		}
		
		StringBuffer out1=new StringBuffer(sb);
		StringBuffer out2=new StringBuffer(sb);
		out1.append(str.charAt(idx));
		out2.append(str.charAt(idx));
		
		solve(str, idx+1, out1);
		solve(str, idx+1, out2.append('-'));
	}

}
