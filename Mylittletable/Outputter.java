import java.io.FileOutputStream;
import java.io.IOException;

public class Outputter {

	private Table table;
	public Outputter() {
		// TODO 自动生成的构造函数存根
	}
	public Outputter(Table table) {
		this.table=table;
	}
	public void ouput() throws IOException {
		FileOutputStream fos=new FileOutputStream("./表格.csv");
		for(int i=0;i<table.row;i++){
			for(int j=1;j<table.column;j++){
				if(i!=0&&j==1) {
					fos.write(("\n"+(String)table.table[i][j]).getBytes());
				}
				else if(j==1) {
					fos.write(((String)table.table[i][j]).getBytes());
				}
				else {
					fos.write((","+(String)table.table[i][j]).getBytes());
				}
			}
		}
	}
}
