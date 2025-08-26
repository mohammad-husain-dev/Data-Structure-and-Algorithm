import java.util.ArrayList;
import java.util.List;

public class ArraySorting02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList();
		list.add(0);
		list.add(8);
		list.add(1);
		list.add(5);
		
		sortArr(list);
		
		for(int i: list)
		{
			System.out.println(i);
		}
	}
	
	static void sortArr(List<Integer> list)
	{
		if(list.size()<=1)
			return;
		
		int temp=list.get(list.size()-1);
		list.remove(list.size()-1);
		sortArr(list);
		insert(list, temp);
	}
	
	static void insert(List<Integer> list, int key)
	{
		if(list.size()==0 || list.get(list.size()-1)<=key)
		{
			list.add(key);
			return;
		}
		
		int temp=list.get(list.size()-1);
		list.remove(list.size()-1);
		insert(list, key);
		list.add(temp);
	}
	
	static int BS(int[] arr, int key, int s, int e)
	{
		while(s<=e)
		{
			int mid=s + (e-s)/2;
			if(arr[mid]==key)
				return mid;
			if(key<arr[mid])
				e=mid-1;
			else
				s=mid+1;
		}
		
		return -1;
	}
}

/*
 * sortArr(arr, n)
 * sortArr(arr, n-1), arr[0]
 * 
 * 
 * 
 * 
 */

