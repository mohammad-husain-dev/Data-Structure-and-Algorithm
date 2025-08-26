
public class BSNoOfTimesArrayIsRotated06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,4,5,1};
		System.out.println(countRotation(arr));
	}
	
	static int countRotation(int[] arr)
	{
		int s=0;
		int e=arr.length-1;
		int n=arr.length;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			int next=(mid+1)%n;
			int prev=(mid-1+n)%n;
			if(arr[mid]<arr[next] && arr[mid]<arr[prev])
				return n-mid;
			if(arr[s]<=arr[mid])
				s=mid+1;
			else
				e=mid-1;
				
		}
		return 0;
	}
}
