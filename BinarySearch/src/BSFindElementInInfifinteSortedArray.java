
public class BSFindElementInInfifinteSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={1,2,3,4,5,6,7,8,9,10,11,13,14,15}; 
		int key=7;
		System.out.println(BS_infinite(arr, key));
	}
	static int BS_infinite(int[] arr, int key)
	{
		int s=0;
		int e=findEnd(arr, key);
		
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(key==arr[mid])
				return mid;
			if(key<arr[mid])
				e=mid-1;
			else
				s=mid+1;
		}
		
		return -1;
	}
	/// {1,2,3,4,5,6,7,8,9,10,...}, 7
	static int findEnd(int[] arr, int key)
	{
		int s=0;
		int e=1; // crux
		
		while(true) {
			if(key>arr[e])
			{
				s=e;
				e=e*2;  // crux
			}else
				break;
		}
		return e;
	}
}
