
public class BSIndexOfMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {4,5,1,2,3};
		
		System.out.println(minIdx(arr));
	}
	
	static int minIdx(int[] arr)
	{
		int n=arr.length;
		int s=0;
		int e=n-1;
		
		while(s<=n)
		{
			int mid=s+(e-s)/2;
			int next=(mid+1)%n;
			int prev=(mid-1+n)%n;
			
			if(arr[mid]<arr[prev] && arr[mid]<arr[next])
				return mid;
			if(arr[s]<=arr[mid])
				s=mid+1;
			else
				e=mid-1;
		}
		return -1;
	}
}
