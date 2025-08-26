
public class BSFirstAndLastOccurance04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,1,2,2,3,4};
		int key=4;
		System.out.println(BS_first(arr, key, 0, arr.length-1));
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
