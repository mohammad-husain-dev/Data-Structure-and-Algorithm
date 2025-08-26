
public class BSFindElementInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4,5,6,7};
		int key=1;
		
		System.out.println(find(arr, key, 0, arr.length-1));
	}
	// {8,1,2,3,4,5,6,7,}, 7
	static int find(int[] arr, int key, int s, int e)
	{
		int minIdx=minIdx(arr, s, e);
		if(key<=arr[e])
			return BS(arr, key, minIdx, e);
		else
			return BS(arr, key, s, minIdx-1);
	}
	
	static int BS(int[] arr, int key, int s, int e)
	{
		if(s>e)
			return -1;
		int mid=s+(e-s)/2;
		if(key==arr[mid])
			return mid;
		if(key < arr[mid])
			return BS(arr, key, s, mid-1);
		else
			return BS(arr, key, mid+1, e);
	}
	
	static int minIdx(int[] arr, int s, int e)
	{
		int n=arr.length;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			int next=(mid+1)%n;
			int prev=(mid-1+n)%n;
			if(arr[mid]<arr[next] && arr[mid]<arr[prev])
				return mid;
			if(arr[s]<=arr[mid])
				s=mid+1;
			else
				e=mid-1;
		}
		
		return -1;
	}
}
