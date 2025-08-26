import java.util.ArrayList;

public class Triplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input= {-1,0,1,2,-1,-4};//{1,4,45,6,8};
		int target=0;//13;
		ArrayList<ArrayList<Integer>> res=new ArrayList();
		ArrayList<Integer> out=new ArrayList();
		solve(input, out, res, target, 0);
		
		for(ArrayList<Integer> list: res) System.out.println(list);
	}
	
	// [1, 0, 2, 3], 3
	static void solve(int[] input, ArrayList<Integer> out, ArrayList<ArrayList<Integer>> res, int target, int k)
	{
		
		if(out.size()==3)
			if(target==0)
			{
				ArrayList<Integer> arr=new ArrayList();
				for(int val:out) arr.add(val);
				res.add(arr);
				return;
			}else return;
		if(k==input.length) return;
							
		for(int i=k;i<input.length;i++)
		{
			if(input[i]<=target)
			{
				out.add(input[i]);
				solve(input, out, res, target-input[i], i+1);
				out.removeLast();
			}else {
				solve(input, out, res, target-input[i], i+1);
			}
		}
	}
	

}
