import java.io.IOException;
import java.util.Scanner;
public class Main {

	public Main() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		Scanner sc=new Scanner(System.in);
		int terms;
		int maxcredit;
		Course_list list=new Course_list();
		System.out.println("***********************************************************");
		System.out.println("                   欢迎使用教学编排系统                     ");
		System.out.println("请输入学期总数");
		terms=sc.nextInt();
		System.out.println("请输入每学期的学分上限");
		maxcredit=sc.nextInt();
		int pos=0;
		System.out.println("请输入课程名称、课程学分、前置课程（结束课程录入请输入#，按其他键继续录入课程）");
		while(true) {
			String lesson=sc.next();
			if(lesson.equals("#"))break;
			int credit=sc.nextInt();
			String prelesson=sc.nextLine();
			Course temp=new Course(lesson, credit, prelesson);
			temp.setPosition(pos++);
			list.addCourse(temp);
		}
		if(!list.isIn()) {
			System.out.println("输入的先修课程号不在该专业开设的课程序列中");
			sc.close();
			return;
		}
		System.out.println("1.使学生在各学期中的学习负担尽量均匀\n2.使课程尽可能地集中在前几个学期中");
		int way=sc.nextInt();
		Teaching_graph graph=new Teaching_graph(list);
		Teaching_table table=new Teaching_table(terms, maxcredit, way, list, graph);
		table.show(table.getEtermarrangement());
		sc.close();
	}
}