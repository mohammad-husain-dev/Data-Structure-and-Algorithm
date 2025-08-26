
public class BSPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,3,2,1};
		System.out.println(arr[peak(arr, 0, arr.length-1)]);
	}
	
	static int peak(int[] arr, int s, int e)
	{
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(mid>0 && mid<arr.length-1)
			{
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
					return mid;
				
				if(arr[mid-1]>arr[mid])
					e=mid-1;
				else
					s=mid+1;
			}else if(mid==0)
			{
				if(arr[mid]>arr[mid+1])
					return 0;
				else return 1;
			} else if(mid==arr.length-1)
			{
				if(arr[mid]>arr[mid-1])
					return arr.length-1;
				else return mid-1;
			}
		}
		return -1;
	}
}
