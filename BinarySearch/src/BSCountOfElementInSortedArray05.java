
public class BSCountOfElementInSortedArray05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,10,10,10,10,11,11,14,15};
		int key=11;
		System.out.println(count(arr, key));
	}
	
	static int count(int[] arr, int key)
	{
		int first_idx=BS_first(arr, key, 0, arr.length-1);
		int last_idx=BS_last(arr, key, 0, arr.length-1);
		
		return last_idx-first_idx+1;
	}
	
	static int BS_first(int[] arr, int key, int s, int e)
	{
		int res=-1;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(key==arr[mid])
			{
				res=mid;
				e=mid-1;
			}
			else if(key<arr[mid])
				e=mid-1;
			else
				s=mid+1;
		}
		return res;
	}
	
	static int BS_last(int[] arr, int key, int s, int e)
	{
		int res=-1;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(key==arr[mid])
			{
				res=mid;
				s=mid+1;
			}
			else if(key<arr[mid])
				e=mid-1;
			else
				s=mid+1;
		}
		return res;
	}

}
