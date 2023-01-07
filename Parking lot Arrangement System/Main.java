

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=1;
		停车场 lot=new 停车场();
		便道 sideway=new 便道();
		辅助栈 sublot=new 辅助栈();
		lot.getMax();
		sideway.getMax();
		while(n!=0) {
			new 欢迎面板();
			if(sc.hasNextInt()) {
			n=sc.nextInt();
			if(n==0)break;
			else if(n>4||n<0) {
				System.out.println("请输入正确的序号！");
			}
			else {
				switch (n){
				case 1:
					Car temp=new Car();
					System.out.println("请输入车牌号");
					sc.nextLine();
					temp.carbrand=sc.next();
					sc.nextLine();
					if(!(lot.search(temp)||sideway.search(temp))) {
						sideway.driveIn(temp);
						if(lot.presentAmount>=5) {
							temp.position=0;
							System.out.println(temp.carbrand+"在便道上等待停车位!");
							sideway.getMax();
						}
						else {
							Car tem=sideway.driveOut();
							tem.position=1;
							lot.driveIn(tem);
							lot.getMax();
							System.out.println("牌照为"+tem.carbrand+"的汽车进入停车位的"+lot.getMax()+"号车位!");
						}
					}
					else {
						System.out.println("该车辆已在系统中！");
					}
					break;
				case 2:
					sc.nextLine();
					System.out.println("请输入要离开车辆车牌号");
					Car temp2=new Car();
					temp2.carbrand=sc.nextLine();
					if(lot.search(temp2)) {
						Car temp21=lot.driveOut();
						while(!temp21.carbrand.equals(temp2.carbrand)) {
							sublot.driveIn(temp21);
							sublot.getMax();
							System.out.println("牌照为"+temp21.carbrand+"的汽车暂时退出停车位；");
							temp21=lot.driveOut();
							lot.getMax();
						}
						System.out.println("牌照为"+temp21.carbrand+"的汽车从停车场开走；");
						while(sublot.presentAmount>0) {
							Car temp22=sublot.driveOut();
							sublot.getMax();
							lot.driveIn(temp22);
							lot.getMax();
							System.out.println("牌照为"+temp22.carbrand+"的汽车停回停车位的"+lot.getMax()+"号车位；");
						}
						if(sideway.n>0) {
							Car temp23=sideway.driveOut();
							sideway.getMax();
							lot.driveIn(temp23);
							lot.getMax();
							temp23.position=1;
							System.out.println("牌照为"+temp23.carbrand+"的汽车从便道上进入停车位的"+lot.getMax()+"号车位；");
						}
					}
					else {
						System.out.println("该车辆不在停车场中");
					}
					break;
				case 3:
					System.out.println("请输入要查询车辆车牌号");
					Car temp3=new Car();
					temp3.carbrand=sc.nextLine();
					if(lot.search(temp3)) {
						int mark=0;
						Iterator<Car> pos=lot.ParkingLot.iterator();
						while(!pos.next().carbrand.equals(temp3.carbrand)) {
							mark++;
						}
						System.out.println(temp3.carbrand+"在停车场的"+mark+"号车位");
					}
					else {
						if(sideway.search(temp3)) {
							int mark=0;
							Iterator<Car> pos=sideway.convient.iterator();
							while(!pos.next().carbrand.equals(temp3.carbrand)) {
								mark++;
							}
							System.out.println(temp3.carbrand+"在便道的"+mark+"号位置");
						}
						else {
							System.out.println("该车辆不在系统中");
						}
					}
					break;
				case 4:
					lot.show();
					sideway.show();
					sc.nextLine();
					break;
				}
				System.out.println("按回车键继续程序的运行");
				if(sc.nextLine().equals("")) {
					continue;
				}
				else {
					break;
				}
			}
		  }
			else {
				System.out.println("请输入正确的序号！");
				sc.nextLine();
			}
		}
		System.out.println("系统已经成功退出!");
		sc.close();
	}

}
