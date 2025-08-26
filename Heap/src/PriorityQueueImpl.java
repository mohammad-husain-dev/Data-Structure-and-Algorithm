
public class PriorityQueueImpl 
{
	public static void main(String[] args) {
		MinHeap h=new MinHeap(20);
		h.insert(1);
		h.insert(2);
		h.insert(3);
		h.insert(4);
		h.insert(10);
		h.insert(-1);
		
//		System.out.println(h.extractMin());
//		System.out.println(h.getMin());
		h.printHeap();
		System.out.println(h.size);
		h.deleteElement(3);
		h.printHeap();
		System.out.println(h.size);
		
	}
}


class MinHeap
{
	int capacity;
	int size;
	int[] heap;
	
	MinHeap(int cap)
	{
		this.capacity=cap;
		this.size=0;
		heap=new int[capacity];
	}
	
	int left(int i) {return 2*i+1;}
	int right(int i) {return 2*i+2;}
	int parent(int i) {return (i-1)/2;}
	
	int getMin()
	{
		return heap[0];
	}
	
	void heapify(int idx)
	{
		int l=left(idx);
		int r=right(idx);
		int smallest=idx;
		if(l<size && heap[l]<heap[smallest]) smallest=l;
		if(r<size && heap[r]<heap[smallest]) smallest=r;
		
		if(smallest != idx) {
			int temp=heap[smallest];
			heap[smallest]=heap[idx];
			heap[idx]=temp;
			
			heapify(smallest);
		}
	}
	
	void insert(int e)
	{
		if(size>=capacity) { System.out.println("heap full!"); return;}
		
		heap[size]=e;
		size++;
		
		int k=size-1;
		while(k!=0 && heap[k]<heap[parent(k)])
		{
			int temp=heap[k]; heap[k]=heap[parent(k)]; heap[parent(k)]=temp;
			k=parent(k);
		}
	}
	
	int extractMin()
	{
		if(size<=0) return Integer.MAX_VALUE;
		if(size==1) {size--; return heap[0];}
		
		size--;
		int ret=heap[0];
		heap[0]=heap[size];
		
		heapify(0);
		
		return ret;
	}
	
	void deleteElement(int idx)
	{
		heap[idx]=getMin()-1;
		
		int k=idx;
		while(k!=0 && heap[k]<heap[parent(k)])
		{
			int temp=heap[k]; heap[k]=heap[parent(k)]; heap[parent(k)]=temp;
			k=parent(k);
		}
		
		extractMin();
	}
	
	void printHeap()
	{

		for(int i=0;i<size;i++) System.out.print(heap[i]+" ");
		System.out.println();
	}
}



/*

class MaxHeap
{
	int size;
	int capacity;
	int[] heap;
	
	MaxHeap(int cap)
	{
		this.capacity=cap;
		heap=new int[cap];
		this.size=0;
	}
	
	int getLeftChildIdx(int i)
	{
		return 2*i+1;
	}
	
	int getRightChildIdx(int i)
	{
		return 2*i+2;
	}
	
	int getParent(int i)
	{
		return (i-1)/2;
	}
	
	void heapify(int idx)
	{
		int l=getLeftChildIdx(idx);
		int r=getRightChildIdx(idx);
		int largest=idx;
		
		if(l<size && heap[largest]<heap[l]) largest=l;
		if(r<size && heap[largest]<heap[r]) largest=r;
		
		if(largest != idx)
		{
			int temp=heap[largest];
			heap[largest]=heap[idx];
			heap[idx]=temp;
			heapify(largest);
		}
	}
	
	int getMax() {
		return heap[0];
	}
	
	void insert(int e)
	{
		if(size>=capacity) 
			return;
		this.size++;
		heap[size-1]=e;
		
		int p=size-1;
		while(p>0 && heap[getParent(p)]<heap[p])
		{
			int temp=heap[p];
			heap[p]=heap[getParent(p)];
			heap[getParent(p)]=temp;
			p=getParent(p);
		}
	}
	
	int extractMax()
	{
		if(size==0) return -10000;
		if(size==1) {size--; return heap[0];}
		
		int ret=heap[0];
		heap[0]=heap[size-1];
		size--;
		
		heapify(0);
		return ret;
	}
}


*/
