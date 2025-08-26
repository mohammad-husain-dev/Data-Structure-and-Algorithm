import java.util.ArrayList;
import java.util.HashSet;

public class Wordbreak {
	
	static HashSet<String> set=new HashSet<String>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="catsanddog";
		
		set.add("cats");
		set.add("cat");
		set.add("and");
		set.add("sand");
		set.add("dog");
		
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
			
			if(isPresent(str1))
			{
				res.add(str1);
				solve(str.substring(i, str.length()), res);
				res.removeLast();
			}
		}
	}
	
	static boolean isPresent(String str)
	{
		return set.contains(str);
	}
}
