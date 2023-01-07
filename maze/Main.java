package maze;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=2;
		System.out.println("请输入迷宫规模，如果规模小于2会直接退出程序");
		while(n>=2) {
			if(sc.hasNextInt()) {
				n=sc.nextInt();	
				sc.nextLine();
				if(n<2) break;
				int x=0,y=0;
				System.out.println("请输入迷宫出口的横坐标");
				while(x!=1&&y!=1) {
					if(sc.hasNextInt()) {
						x=sc.nextInt();
						for(int i=0;i<3;i++) {
							System.out.println("请输入迷宫出口的纵坐标");
							if(sc.hasNextInt()) {
								y=sc.nextInt();
								break;
							}
							else if(i<2) {
								sc.next();
								sc.nextLine();
								System.out.println("请输入正确的数字,还有"+(2-i)+"次机会");
							}
							else {
								System.out.println("程序已经退出");
								return;
							}
						}
						if(x>=n||y>=n||x<0||y<0) {
							System.out.println("请输入正确的迷宫出口");
						}
						else if(x==1&y==1) {
							System.out.println("出口不可以同时是入口");
							x=0;
							y=0;
						}
						else{
							Maze_table myMaze=new Maze_table(n,x,y);
							System.out.println();
							TableDetail a=new TableDetail(1, 1);
							myMaze.go(a);
						    if(myMaze.sizeOfways()>=1) {
						    	
						    	myMaze.result();
								System.out.println("\n程序已经结束");
						    	return;
						    }
						    else {
						    	System.out.println("迷宫没有通路");
						    	System.out.println("\n程序已经结束");
						    	return;
						    }
						}
					}
					else {
						sc.nextLine();
						System.out.println("请输入正确的数字");
					}
				}
			}
			else {
				sc.nextLine();
				System.out.println("请输入正确的数字");
			}
		}
		System.out.println("程序已经退出");
	}
}
