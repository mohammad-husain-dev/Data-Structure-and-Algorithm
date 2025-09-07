
public class PowerSet08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc";
		StringBuffer sb=new StringBuffer();
		generate(str, 0, sb);
	}
	
	static void generate(String str, int idx, StringBuffer sb)
	{
		if(idx==str.length())
		{
			System.out.println(sb.toString());
			return;
		}
		
		StringBuffer out1=new StringBuffer(sb);
		StringBuffer out2=new StringBuffer(sb);
		
		generate(str, idx+1, out1);
		generate(str, idx+1, out1.append(str.charAt(idx)));
	}

}
