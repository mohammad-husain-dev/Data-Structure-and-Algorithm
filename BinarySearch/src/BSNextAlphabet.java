
public class BSNextAlphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr= {'a','f','f','f','h','n'};
		char key='a';
		System.out.println(arr[nextChar(arr, key, 0, arr.length-1)]);
	}
	
	static int nextChar(char[] arr, char key, int s, int e)
	{
		int res=-1;
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(arr[mid]==key)
				s=mid+1;
			else if(key < arr[mid])
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
