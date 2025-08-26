
public class BSCeilElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,3,4,8,10,10,12,19};
		int key=18;
		System.out.println(ceil(arr, key, 0, arr.length-1));
	}
	
	// ceil = {min(element) : element>=key}
	// {1,2,3,4,8,10,10,12,19}, key=11
	static int ceil(int[] arr, int key, int s, int e)
	{
		int res=-1;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(key==arr[mid])
				return mid;
			if(key<arr[mid])
			{
				e=mid-1;
				res=mid;
			}else {
				s=mid+1;
			}
		}
		return res;
	}
}
