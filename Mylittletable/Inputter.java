import java.io.FileReader;
import java.io.IOException;

public class Inputter {
	private Table table;
    private String path;
	public Inputter() {
		// TODO 自动生成的构造函数存根
	}
	public Inputter(Table table) {
		this.table=table;
	}
	public static int getRow(String path) throws IOException {
		int rowcount=0;
		FileReader fr=new FileReader(path);
		int temp=fr.read();
		while(temp!=-1) {
			if(temp=='\n') {
				rowcount++;
			}
			temp=fr.read();
		}
		return rowcount+1;
	}
	public static int getColumn(String path) throws IOException {
		int columncount=0;
		FileReader fr=new FileReader(path);
		int temp=fr.read();
		while(temp!='\n') {
			if(temp==',') {
				columncount++;
			}
			temp=fr.read();
		}
		return columncount+1;
	}
	public void input(String path) throws IOException {
		FileReader fr=new FileReader(path);
		for(int i=0;i<table.row;i++) {
			for(int j=1;j<table.column;j++) {
				String temp=new String();
				int word=fr.read();
				while(word!=','&&word!='\n'&&word!=-1) {
					temp+=String.valueOf((char)word);
					word=fr.read();
				}
				table.table[i][j]=temp;
			}
		}
		fr.close();
	}

}
