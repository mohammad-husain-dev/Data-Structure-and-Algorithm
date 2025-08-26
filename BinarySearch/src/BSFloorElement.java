
public class BSFloorElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,8,10,12,15};
		int key=9;
		System.out.println(BS(arr, key, 0, arr.length-1));
	}
	
	//// floor = {max(element) : element<=key}
	static int BS(int[] arr, int key, int s, int e)
	{
		int res=-1;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(key==arr[mid])
				return mid;
			if(key<arr[mid])
			{
				e=mid-1;
			}else{
				s=mid+1;
				res=mid;
			}
		}
		return res;
	}
}
