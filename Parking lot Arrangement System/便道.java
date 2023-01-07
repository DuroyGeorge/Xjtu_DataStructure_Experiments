
import java.util.*;
public class 便道 {
	int n;
	Deque<Car>convient;
	便道(){
		convient=new ArrayDeque<>();
		this.n=0;
	}
	public void show() {
		int temp=1;
		Iterator<Car>iter=convient.iterator();
		System.out.println("便道上的情况：");
		if(n==0) {
			System.out.println("无车辆");
		}
		else {
			while(iter.hasNext()) {
				System.out.println((temp++)+"位置—"+iter.next().carbrand);
			}
		}
	}
	public int getMax()
	{
		this.n=convient.size();
		return n;
	} 
	public Car driveOut() {
		return convient.pollFirst();
	}
	public void driveIn(Car carin) {
		convient.addLast(carin);
	}
	public Boolean search(Car temp)
	{
		Iterator<Car>iter=convient.iterator();
		while(iter.hasNext()) {
			if(iter.next().carbrand.equals(temp.carbrand)) {
				return true;
			}
		}
		return false;
	}
}
