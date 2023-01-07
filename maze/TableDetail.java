package maze;

public class TableDetail {
	private int x;
	private int y;
	private String output;
	TableDetail(int x,int y){
		this.x=x;
		this.y=y;
		output="("+x+","+y+")";
	}
	public void display() {
		System.out.print(output);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
