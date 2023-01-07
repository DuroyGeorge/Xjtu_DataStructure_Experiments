import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Teaching_table {

	private int terms;
	private int maxcredit;
	private Deque<String>arrangement=new ArrayDeque<>();
	private Deque<String[]>etermarrangement=new ArrayDeque<>();
	public Teaching_table() {
		// TODO 自动生成的构造函数存根
	}

	public Teaching_table(int terms,int maxcredit,int way,Course_list list,Teaching_graph graph) {
		this.terms=terms;
		this.maxcredit=maxcredit;
		sortList(list, graph);
		switch (way) {
		case 1: {
			etermarrangement=evenForm(list);
			break;
		}
		case 2: {
			etermarrangement=priorForm(list);
			break;
		}
		}
	}
	public Deque<String[]> getEtermarrangement(){
		return etermarrangement;
	}
	private void sortList(Course_list list,Teaching_graph graph) {
		while(!list.isFull()) {
			for(Course i : list.getList()) {
				if(i.getIn()==0&&i.searched==false) {
					arrangement.addLast(i.getLesson());	
					graph.subInAmount(i, list);
					i.searched=true;
				}
			}
		}
	}
	private boolean preFalse(Course_list list, String temp) {
		for(String i:list.getPre(temp)) {
			if(list.whichCourse(i)==null)continue;
			if(list.whichCourse(i).arranged==false)return true;
		}
		return false;
	}
	private Deque<String[]> evenForm(Course_list list) {
		Deque<String[]>assist=new ArrayDeque<>();
		int maxnumber=list.getList().size()/terms>0?list.getList().size()/terms:1;
		while(list.existFalse()) {
			int lessoned=0;
			int credited=0;
			int pos=0;
			String[] temp=new String[list.getList().size()];
			for(String i:arrangement) {
				if(list.whichCourse(i).arranged==false) {
					if(credited+list.whichCredit(i)<=maxcredit&&lessoned<maxnumber) {
						if(preFalse(list,i))continue;
						credited+=list.whichCredit(i);
						++lessoned;
						temp[pos++]=i;
					}
				}
			}
			for(String i:temp) {
				if(list.whichCourse(i)==null)continue;
				list.whichCourse(i).setArranged();
			}
			assist.addLast(temp);
		}
		return assist;
	}
//	private Deque<String[]> evenForm(Course_list list) {
//		Deque<String[]>assist=new ArrayDeque<>();
//		int recommendcredit=list.allCredit()/terms>0?list.allCredit()/terms:1;
//		while(list.existFalse()) {
//			int credited=0;
//			int pos=0;
//			String[] temp=new String[list.getList().size()];
//			for(String i:arrangement) {
//				if(list.whichCourse(i).arranged==false) {
//					if(credited+list.whichCredit(i)<=maxcredit&&credited<recommendcredit) {
//						if(preFalse(list,i))continue;
//						credited+=list.whichCredit(i);
//						temp[pos++]=i;
//					}
//				}
//			}
//			for(String i:temp) {
//			if(list.whichCourse(i)==null)continue;
//			list.whichCourse(i).setArranged();
//		}
//			assist.addLast(temp);
//		}
//		return assist;
//	}
	private Deque<String[]> priorForm(Course_list list) {
		Deque<String[]>assist=new ArrayDeque<>();
		while(list.existFalse()) {
			int credited=0;
			int pos=0;
			String[] temp=new String[list.getList().size()];
			for(String i:arrangement) {
				if(list.whichCourse(i).arranged==false) {
					if(credited+list.whichCredit(i)<=maxcredit) {
						if(preFalse(list,i))continue;
						credited+=list.whichCredit(i);
						temp[pos++]=i;
					}
				}
			}
			for(String i:temp) {
				if(list.whichCourse(i)==null)continue;
				list.whichCourse(i).setArranged();
			}
			assist.addLast(temp);
		}
		return assist;
	}
	public void show(Deque<String[]>temp) throws IOException
	{
		if(temp.size()>terms) {
			System.out.println("课程无法安排");
			return;
		}
		FileOutputStream fos=new FileOutputStream("./课程编排结果.txt");
		int term=1;
		Iterator<String[]>it=temp.iterator();
		
		while(it.hasNext()) {
			fos.write(("第"+(term++)+"学期课程编排:\n").getBytes());
			//System.out.println("第"+(term++)+"学期课程编排:");
			String[]target=it.next();
			for(String i:target) {
				if(i!=null)fos.write((i+" ").getBytes());
				//if(i!=null)System.out.print(i+" ");
			}
			fos.write("\n".getBytes());
		}
		fos.close();
		System.out.println("课程编排结果已经保存到目标文件中");
	}
}
