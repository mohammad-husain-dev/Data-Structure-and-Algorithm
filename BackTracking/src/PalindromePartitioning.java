import java.util.ArrayList;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aabaa";
		solve(str, new ArrayList<String>());
		//System.out.println(isPalindrome("a"));
	}
	
	static void solve(String str, ArrayList<String> res)
	{
		//System.out.println(str.length());
		if(str.length()==0)
		{
			for(String s: res)
				System.out.print(s+" ");
			System.out.println();
			return;
		}
		
		for(int i=1;i<=str.length();i++)
		{
//			System.out.println("string="+str);
			String str1=str.substring(0, i);
//			System.out.println("str1="+str1);
//			String str2=str.substring(i, str.length());
//			System.out.println("str1="+str2);
			
			if(isPalindrome(str1))
			{
				res.add(str1);
				solve(str.substring(i, str.length()), res);
				res.removeLast();
			}
		}
	}
	
	static boolean isPalindrome(String str)
	{
		int i=0;
		int j=str.length()-1;
		while(i<j)
		{
			if(str.charAt(i)!=str.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	}
}
