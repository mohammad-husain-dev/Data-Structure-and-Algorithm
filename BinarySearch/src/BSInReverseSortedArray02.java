
public class BSInReverseSortedArray02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,9,8,7,6,5,4,3,2,1};
		int key=1;
		System.out.println(BS(arr, key, 0, arr.length-1));
	}
	
	static int BS(int[] arr, int key, int s, int e)
	{
		if(s>e)
			return -1;
		int mid=s+(e-s)/2;
		if(key==arr[mid])
			return mid;
		if(key<arr[mid])
			return BS(arr, key, mid+1, e);
		else
			return BS(arr, key, s, mid-1);
	}
}
