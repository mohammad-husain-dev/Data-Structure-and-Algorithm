
public class BinarySearch01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7,8,9};
		int key=0;
		System.out.println(BS_Recur(arr, key, 0, arr.length-1));
	}
	
	static int BS(int[] arr, int key, int start, int end)
	{
		while(start<=end) 
		{
			int mid=start + (end-start)/2;
			if(arr[mid]==key)
				return mid;
			if(key>arr[mid])
				start=mid+1;
			else
				end=mid-1;
		}
		
		return -1;
	}
	
//	while(start<=end)
//	{
//		mid=start+(end-start)/2;
//		if(key==arr[mid]) return mid;
//		if(key>arr[mid]) start=mid+1;
//		else end=mid-1;
//	}
//	return -1;
	
	static int BS_Recur(int[] arr, int key, int s, int e)
	{
		if(s>e)
			return -1;
		int mid=s+(e-s)/2;
		if(key==arr[mid])
			return mid;
		if(key<arr[mid])
			return BS_Recur(arr, key, s, mid-1);
		else
			return BS_Recur(arr, key, mid+1, e);
	}
}
