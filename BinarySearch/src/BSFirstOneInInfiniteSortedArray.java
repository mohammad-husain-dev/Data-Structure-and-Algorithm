
public class BSFirstOneInInfiniteSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,0,0,0,0,0,0,0,1,1,1,1,1};
		System.out.println(firstOne(arr));
	}
	
	static int firstOne(int[] arr)
	{
		int s=0;
		int e=findEnd(arr, 1);
		
		int res=-1;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(1==arr[mid])
			{
				res=mid;
				e=mid-1;
			}else if(1<arr[mid])
				e=mid-1;
			else
				s=mid+1;
		}
		return res;
	}
	
	static int findEnd(int[] arr, int key)
	{
		int s=0;
		int e=1;
		while(true)
		{
			if(arr[e]>=key)
				return e;
			s=e;
			e=e*2;
		}
	}

}
