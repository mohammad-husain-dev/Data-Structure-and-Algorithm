
public class PermutationLetterCaseChange11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * a1B2 --> a1b2, a1B2, A1b2, A1B2
		 */
		String str="a1B2";
		solve(str, 0, new StringBuffer());
	}
	
	static void solve(String str, int idx, StringBuffer sb)
	{
		if(str.length()==0) return;
		
		if(idx==str.length())
		{
			System.out.println(sb.toString());
			return;
		}
		
		StringBuffer out1=new StringBuffer(sb);
		StringBuffer out2=new StringBuffer(sb);
		
		char ch=str.charAt(idx);
		if(isDigit(ch)) 
		{
			solve(str, idx+1, out1.append(ch));
		}else {
			solve(str, idx+1, out1.append(Character.toLowerCase(ch)));
			solve(str, idx+1, out2.append(Character.toUpperCase(ch)));
		}
	}
	
	static boolean isDigit(char ch)
	{
		if(ch<='9' && ch>='0')
			return true;
		return false;
	}
}
