import java.util.ArrayList;
import java.util.List;

public class InsertInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList();
		list.add(1);
		list.add(5);
		list.add(8);
		
		int key=0;
		insert(list,key);
		for(int i: list)
			System.out.println(i);
	}
	/// {1,5,8}, 0, 2
	static void insert(List<Integer> list, int key)
	{
		/// if list is empty or key is greater than the last element, 
		/// add the element at the end of list
		if(list.size()==0 || list.get(list.size()-1)<=key) {
			list.add(key);
			return;
		}
		
		// else, remove the last element and insert the element in the 
		// remaining list and later on add the removed element in the list again
		int temp = list.get(list.size()-1);
		list.remove(list.size()-1);
		insert(list, key);
		list.add(temp);
	}
}
