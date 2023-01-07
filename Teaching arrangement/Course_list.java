import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Course_list {

	private Deque<Course>list=new ArrayDeque<>(); 
	public Course_list() {
		// TODO 自动生成的构造函数存根
		
	}

	public Deque<Course> getList(){
		return list;
	}
	public void addCourse(Course brandnew) {
		list.addLast(brandnew);
	}
	public int getAmonut() {
		return list.size();
	}
	public boolean isIn() {
		for(Course i:list) {
			int mark=0;
			if(i.getPre().length==1)continue;
			for(Course j:list) {
				for(int k=1;k<i.getPre().length;k++) {
					if(i.getPre()[k].equals(j.getLesson())) {
						++mark;
						break;
					}
				}
			}
			if(mark!=i.getPre().length-1)return false;
		}
		return true;
	}
	public boolean isFull() {
		Iterator<Course>it=list.iterator();
		while(it.hasNext()) {
			if(it.next().searched==false)return false;
		}
		return true;
	}
	public int whichCredit(String lesson) {
		Iterator<Course>it=list.iterator();
		while(it.hasNext()) {
			Course temp=it.next();
			if(temp.getLesson().equals(lesson)) {
				return temp.getCredit();
			}
		}
		return 0;
	}
	public String[] getPre(String lesson) {
		for(Course i:list) {
			if(i.getLesson().equals(lesson))return i.getPre();
		}
		return null;
	}
	public boolean existFalse() {
		for(Course i:list) {
			if(i.arranged==false) {
				return true;
			}
		}
		return false;
	}
	public Course whichCourse(String temp) {
		for(Course i :list) {
			if(i.getLesson().equals(temp))return i;
		}
		return null;
	}
	public int allCredit() {
		int temp=0;
		for(Course i:list) {
			temp+=i.getCredit();
		}
		return temp;
	}
}
