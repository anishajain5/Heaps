package heaps;

import java.util.ArrayList;

public class HeapCode <T extends Comparable<T>> {
	private ArrayList<T> data;
	boolean isMin;
	
	public HeapCode(boolean isMin){
		this.data= new ArrayList<>();
		this.isMin= isMin;
	}
	
	public boolean isEmpty() {
		return this.data.size()==0;
	}
	
	public HeapCode(T [] arr, boolean isMin){
		this.data= new ArrayList<>();
		this.isMin= isMin;
		
		for(T item:arr) {
			this.data.add(item);
		}
		
		for(int i= (this.data.size())/2;i>=0; i--) {
			this.downheapify(i);
		}
	}
	
	public int size(){
		return this.data.size();
	}
	public T getMax() {
		T rv= this.data.get(0);
		return rv;
	}
	
	public T remove() {
		T rv=this.data.get(0);
		this.swap(0, this.data.size()-1);
		this.data.remove(this.data.size()-1);
		this.downheapify(0);
		return rv;
	}
	public void add(T element) {
		this.data.add(element);
		this.upHeapify(this.data.size()-1);
	}
	
	private void upHeapify(int ci) {
		if(ci==0) {
			return;
		}
		
		int pi=(ci-1)/2;
		if(!isLarger(pi,ci)) {
			this.swap(pi,ci);
			this.upHeapify(pi);
		}
	}
	
	private void swap(int pi,int ci) {
		T ithitem= this.data.get(pi);
		T jthitem= this.data.get(ci);
		this.data.set(pi, jthitem);
		this.data.set(ci, ithitem);
	}
	
	private boolean isLarger(int pi, int ci) {
		T ithitem= this.data.get(pi);
		T jthitem= this.data.get(ci);
		
		if(this.isMin) {
			return ithitem.compareTo(jthitem)<0;
		}

		else {
			return ithitem.compareTo(jthitem)>0;
		}
	}
		
		public void display(){
			this.display(0);
		}
		
		private void display(int pi) {
			int lci=2*pi+1;
			int rci=2*pi+2;
			
			String str="";
			if(lci<this.data.size()) {
				T lc= this.data.get(lci);
				str=str+lc+" => ";
			}
			else {
				str= str+" END =>";
			}
			
			str=str+this.data.get(pi);
			
			if(rci<this.data.size()) {
				T rc= this.data.get(rci);
				str=str+" <= "+rc;
			}
			
			else {
				str= str+" <= "+"END";
			}
			
			System.out.println(str);
			if(lci<this.data.size()) {
				this.display(lci);
			}
			if(rci<this.data.size()) {
				this.display(rci);
			}
		}
	private void downheapify(int pi) {
		int mi=pi;
		int lci=2*pi+1;
		int rci= 2*pi+2;
		
		if(lci<this.data.size()&&this.isLarger(lci, mi)) {
			mi=lci;
		}
		if(rci<this.data.size()&&this.isLarger(rci, mi)) {
			mi=rci;
		}
		if(mi!=pi) {
			this.swap(pi, mi);
			this.downheapify(mi);
		}
		
		
	}
	

		

	
}
