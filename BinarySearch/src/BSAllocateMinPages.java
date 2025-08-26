
public class BSAllocateMinPages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int books_pages[] = {10,20,30,40};
		int no_of_students=2;
		
		System.out.println(minPages(books_pages, books_pages.length, no_of_students));
	}
	
	static int minPages(int[] arr, int n, int k)
	{
		if(n<k) return -1;
		
		int total_pages=0;
		for(int i:arr) total_pages+=i;
		
		int s=0;
		int e=total_pages;
		
		int res=-1;
		
		while(s<=e)
		{
			int mid=s+(e-s)/2;
			if(isValid(arr, mid, k))
			{
				res=mid;
				e=mid-1;
			} else {
				s=mid+1;
			}
		}
		return res;
	}
	
	static boolean isValid(int[] arr, int mid, int k)
	{
		int student=1;
		int read=0;
		for(int i: arr)
		{
			read+=i;
			if(read>mid)
			{
				student++;
				read=i;
			}
			if(student > k)
				return false;
		}
		return true;
	}
}
