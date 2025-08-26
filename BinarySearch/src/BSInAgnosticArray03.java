
public class BSInAgnosticArray03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,9,8,7,6,5,4,3,2,1};
		int key=3;
		System.out.println(BS(arr, key, 0, arr.length-1));
	}
	
	static int BS(int[] arr, int key, int s, int e)
	{
		if(s==e)
		{
			if(arr[s]==key)
				return s;
			else
				return -1;
		}
		boolean isAsc=false;
		if(arr[s]-arr[e] < 0)
			isAsc=true;
		
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(key==arr[mid])
				return mid;
			if(key<arr[mid])
				if(isAsc) e=mid-1;
				else s=mid+1;
			else
				if(isAsc) s=mid+1;
				else e=mid-1;
		}
		
		return -1;
	}
}
