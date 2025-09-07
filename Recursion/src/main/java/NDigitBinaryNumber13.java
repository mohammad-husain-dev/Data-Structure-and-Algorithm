
public class NDigitBinaryNumber13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		binaryNumber(n,0,0,new StringBuilder());
	}
	
	static void binaryNumber(int n, int ones, int zeros, StringBuilder sb)
	{
		if(n==0)
		{
			System.out.println(sb.toString());
			return;
		}
		
		StringBuilder out1=new StringBuilder(sb);
		StringBuilder out2=new StringBuilder(sb);
		
		if(ones>zeros) {
			binaryNumber(n-1, ones, zeros+1, out2.append(0));
		}
		
		binaryNumber(n-1, ones+1, zeros, out1.append(1));
	}
}
