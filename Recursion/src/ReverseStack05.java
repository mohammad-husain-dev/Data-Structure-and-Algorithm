import java.util.Iterator;
import java.util.Stack;

public class ReverseStack05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5 4 3 2 1  --> 1 2 3 4 5
		Stack<Integer> s=new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		Iterator<Integer> itr=s.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println();
		
		reverse(s);
		
		System.out.println();
		
		itr=s.iterator();  // reset iterator
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	
	static void reverse(Stack<Integer> s)
	{
		if(s.size()<=1)
			return;
		
		int temp=s.pop();
		reverse(s);
		insertAtEnd(s, temp);
	}
	
	static void insertAtEnd(Stack<Integer> s, int key)
	{
		if(s.size()==0)
		{
			s.push(key);
			return;
		}
		int temp=s.pop();
		insertAtEnd(s, key);
		s.push(temp);
	}
}
