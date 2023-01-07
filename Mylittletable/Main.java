import java.util.Scanner;

public class Main {

	public Main() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner sc=new Scanner(System.in);
		System.out.println("是否新建表格 Y/N");
		String temp=sc.next();
		if(temp.equals("y")||temp.equals("Y")) {
			System.out.println("请输入表格的行列数");
			int row=sc.nextInt();
			int column=sc.nextInt();
			Table table=new Table(row,column);
			table.init();
			sc.close();
		}
		else {
//			System.out.println("请输入现有表格路径");
//			sc.nextLine();
//			String path=sc.nextLine();
			try {
				Table table=new Table(Inputter.getRow("F:/Java 学习/Mylittletable/表格.csv"), Inputter.getColumn("F:/Java 学习/Mylittletable/表格.csv"));
				Inputter ipr=new Inputter(table);
				ipr.input("F:/Java 学习/Mylittletable/表格.csv");
				table.init();
			} catch (Exception e) {
				System.out.println("路径不存在");
			}
		} 
	}

}
