package maze;
import java.util.*;
public class Path {
	private int step;
	private Deque<TableDetail> detailaidqueue=new LinkedList<>();
	
	Path(){
		
	}
	Path(int step,Deque<TableDetail>detTableDetails){
		this.step=step;
		Deque<TableDetail>temp=new LinkedList<>();
		for(TableDetail pre:detTableDetails) {
			temp.addLast(pre);
		}
		this.detailaidqueue=temp;
	}
	public int getStep() {
		return step;
	}
	public Deque<TableDetail> getDeque(){
		return detailaidqueue;
	}
	public void push(TableDetail a) {
		detailaidqueue.addLast(a);
		step++;
	}
	public void pop() {
		detailaidqueue.pollLast();
		step--;
	}
	public void display() {
		Iterator<TableDetail>it=detailaidqueue.iterator();
		while(it.hasNext()) {
			it.next().display();
		}
		System.out.println();
	}
	public void clear(){
		detailaidqueue.clear();
	}
	public TableDetail getLast() {
		return detailaidqueue.peekLast();
	}
	public int size() {
		return detailaidqueue.size();
	}

}
