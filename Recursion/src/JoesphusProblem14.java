import java.util.ArrayList;

public class JoesphusProblem14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=40;
		int k=7;
		ArrayList<Integer> arr=new ArrayList();
	
		for(int i=1;i<=40;i++)
		{
			arr.add(i);
		}
		
		System.out.println(solve(arr, 0, k-1));
	}
	
	static int solve(ArrayList<Integer> arr, int idx, int k)
	{
		if(arr.size()==1)
		{
			return arr.get(0);
		}
		
		int kill=(idx+k)%arr.size();
		arr.remove(kill);
		return solve(arr, kill, k);
	}
}
