import java.util.Iterator;
import java.util.Stack;

public class StackSorting03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s=new Stack();
		s.push(1);
		s.push(10);
		s.push(3);
		s.push(2);
		s.push(14);
		// 14,2,3,10,1   --> output:1,2,3,10,14
		//System.out.println(s.peek());
		sortStack(s);
		//System.out.println(s.peek());
		Iterator<Integer> itr=s.iterator();
//		while(itr.hasNext())
//		{
//			int val=itr.next();
//			System.out.print(val+" ");
//		}
	}
	
	static void sortStack(Stack<Integer> s)
	{
		if(s.size()==0)
			return;
		
		int temp = s.pop();
		sortStack(s);
		insert(s, temp);
	}
	
	static void insert(Stack<Integer> s, int key)
	{
		if(s.size()==0 || s.peek()>=key)
		{
			s.push(key);
			return;
		}
		
		int temp=s.pop();
		insert(s, key);
		s.push(temp);
	}
}
