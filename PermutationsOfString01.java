import java.util.HashSet;
import java.util.Set;

public class PermutationsOfString01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder str=new StringBuilder("aa");
		Set<String> set=new HashSet<String>();
		//permute1(str, new StringBuilder(), set);
		//permute2(str, new StringBuilder());
		permuteBySwap(str, 0);
	}

	static void permute1(StringBuilder str, StringBuilder res, Set<String> set)
	{
		if(str.length()==0)
		{
			if(!set.contains(res.toString()))
				System.out.println(res.toString());
			set.add(res.toString());
			return;
		}
		
		for(int k=0;k<str.length();k++)
		{
			char ch=str.charAt(k);
			str.deleteCharAt(k);
			res.append(ch);
			permute1(str, res, set);
			res.deleteCharAt(res.length()-1);
			str.insert(k, ch);
		}
	}
	
	static void permute2(StringBuilder str, StringBuilder res)
	{
		if(str.length()==0)
		{
			System.out.println(res.toString());
			return;
		}
		
		Set<Character> localSet=new HashSet<Character>();
		for(int k=0;k<str.length();k++)
		{
			char ch=str.charAt(k);
			if(!localSet.contains(ch)) 
			{
				localSet.add(ch);
				str.deleteCharAt(k);
				res.append(ch);
				permute2(str, res);
				res.deleteCharAt(res.length()-1);
				str.insert(k, ch);
			}
		}
	}
	
	static void permuteBySwap(StringBuilder str, int i)
	{
		if(i==str.length())
		{
			System.out.println(str.toString());
			return;
		}
		Set<Character> localSet=new HashSet<Character>();
		for(int j=i;j<str.length();j++)
		{
			if(!localSet.contains(str.charAt(j)))
			{
				localSet.add(str.charAt(j));
				swap(str, i, j);
				permuteBySwap(str, i+1);
				swap(str, j, i);
			}
		}
	}
	
	static void swap(StringBuilder str, int i, int j)
	{
		char ch=str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, ch);
	}
	
}





