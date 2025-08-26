
public class BSMinimumDifferenceElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,8,10,13};
		int key=12;
		System.out.println(minDiffIdx(arr, key, 0, arr.length-1));
	}
	
	static int minDiffIdx(int arr[], int key, int s, int e)
	{
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
		
		System.out.println(s+", "+e);
		int a=Math.abs(arr[s]-key);
		int b=Math.abs(arr[e]-key);
		
		return a<b?s:e;
	}
}
