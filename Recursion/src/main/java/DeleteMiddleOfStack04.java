import java.util.Iterator;
import java.util.Stack;

public class DeleteMiddleOfStack04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/// 5 4 3 2 1 0  k=size/2 + 1 k=4
		/// 4,3,2,1,0  k=3 , 5
		Stack<Integer> s=new Stack<Integer>();
		s.push(1);
//		s.push(2);
//		s.push(3);
//		s.push(4);
//		s.push(5);
//		s.push(6);
		
		int k=s.size()/2+1;
		System.out.println("k="+k);
		deleteMid(s, k);
		
		Iterator<Integer> itr=s.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	
	static void deleteMid(Stack<Integer> s, int k)
	{
		if(s.size()==0) return;
		if(k==1) {
			s.pop();
			return;
		}
		
		int temp=s.pop();
		deleteMid(s, --k);
		s.push(temp);
	}
}
