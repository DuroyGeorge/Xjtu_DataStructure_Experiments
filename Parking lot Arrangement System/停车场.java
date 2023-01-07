
import java.util.*;
class 辅助栈 extends 停车场 {}
public class 停车场{
	int presentAmount;
	Deque<Car> ParkingLot;
	停车场(){
		ParkingLot=new ArrayDeque<>();
		this.presentAmount=0;
	}
	public void show() {
		int temp=1;
		Iterator<Car>iter=ParkingLot.iterator();
		System.out.println("停车位的情况：");
		if(presentAmount==0) {
			System.out.println("无车辆");
		}
		else {
			while(iter.hasNext()) {
				System.out.println((temp++)+"车位—"+iter.next().carbrand);
			}
		}
	}
	public int getMax() {
		this.presentAmount=ParkingLot.size();
		return presentAmount;
	} 
	public Car driveOut() {
		return ParkingLot.pollLast();
	}
	public void driveIn(Car drivein) {
		ParkingLot.addLast(drivein);

	}
	public Boolean search(Car temp)
	{
		Iterator<Car>iter=ParkingLot.iterator();
		while(iter.hasNext()) {
			if(iter.next().carbrand.equals(temp.carbrand)) {
				return true;
			}
		}
		return false;
	}

}
