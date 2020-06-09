package heaps;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HeapCode <Integer> heap= new HeapCode(false);
		//heap.add(35);
		//heap.add(30);
		//heap.add(25);
		//heap.add(20);
		//heap.add(15);
		//heap.display();
		Integer [] arr= {5,8,7,6,9,4,3};
		HeapCode <Integer> heap= new HeapCode<Integer>(arr, false);

		heap.display();
		
		
		
		

	}

}
