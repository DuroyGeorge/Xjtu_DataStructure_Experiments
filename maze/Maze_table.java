package maze;
import java.util.*;
public class Maze_table {
	private int table[][];
	private Path possibleway;
	private boolean aidposition[][];
	private BestAndWorst searchway;
	int defx,defy;
	Maze_table(int n,int x,int y){
		table=new int[n][n];
		possibleway=new Path();
		aidposition=new boolean[n][n];
		searchway=new BestAndWorst();
		defx=x;
		defy=y;
		//table= new int[][]{{0,0,0},{0,0,0},{1,1,1}};
		//aidposition=new boolean[][] {{true,true,true},{true,true,true},{false,false,false}};
		randomequal();
		display();
	}
	private int evenOrodd(int n) {
		return Math.abs(n)%2;
	}
	private void randomequal() {
		Random rd=new Random();
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[0].length;j++) {
				table[i][j]=evenOrodd(rd.nextInt());
			}
		}
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table[0].length;j++) {
				if(table[i][j]==1) {
					aidposition[i][j]=false;
				}
				else {
					aidposition[i][j]=true;
				}
			}
		}
		table[1][1]=0;
		aidposition[1][1]=true;
		table[defx][defy]=0;
		aidposition[defx][defy]=true;
	}
	public void display() {
		System.out.println("迷宫图：");
		for(int i=0;i<table.length;i++) {
			for(int j=0;j<table.length;j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
	}
	public int sizeOfways() {
		return searchway.size();
	}
	public void result() {
		searchway.displayAll();
	}
	private Boolean IsinTable(int x,int y) {
		return x>=0&&x<table.length&&y>=0&&y<table[0].length;
	}
	private Boolean IsRoad(int x,int y) {
		return table[x][y]==0;
	}
	public void go(TableDetail a) {
		possibleway.push(a);
		aidposition[a.getX()][a.getY()]=false;
		if(a.getX()==defx&&a.getY()==defy) {
			searchway.findOneWay(new Path(possibleway.getStep(),possibleway.getDeque()));
			aidposition[a.getX()][a.getY()]=true;
			possibleway.pop();
			return;
		}
		else {
			if(IsinTable(a.getX(),a.getY()+1)&&IsRoad(a.getX(),a.getY()+1)&&aidposition[a.getX()][a.getY()+1]){
				go(new TableDetail(a.getX(), a.getY()+1));
			}
			if(IsinTable(a.getX()-1,a.getY())&&IsRoad(a.getX()-1,a.getY())&&aidposition[a.getX()-1][a.getY()]){
				go(new TableDetail(a.getX()-1, a.getY()));
			}
			if(IsinTable(a.getX(),a.getY()-1)&&IsRoad(a.getX(),a.getY()-1)&&aidposition[a.getX()][a.getY()-1]){
				go(new TableDetail(a.getX(), a.getY()-1));
			}
			if(IsinTable(a.getX()+1,a.getY())&&IsRoad(a.getX()+1,a.getY())&&aidposition[a.getX()+1][a.getY()]){
				go(new TableDetail(a.getX()+1,a.getY()));
			}
			if(possibleway.size()>0) {
				aidposition[a.getX()][a.getY()]=true;
				possibleway.pop();
				if(possibleway.size()==0) {
					return;
				}
			}
		}
	}
}
