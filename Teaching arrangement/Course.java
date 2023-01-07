
public class Course {

	private String lesson;
	private int credit;
	private String prelesson;
	private int inamount;
	public int position;
	public boolean searched=false;
	public boolean arranged=false;
	public Course() {
		// TODO 自动生成的构造函数存根
	}
	public Course(String lesson,int credit,String prelesson) {
		this.lesson=lesson;
		this.credit=credit;
		this.prelesson=prelesson;
		if(prelesson.equals(""))this.inamount=0;
		else this.inamount=prelesson.split(" ").length-1;
	}
	public String[] getPre() {
		return prelesson.split(" ");
	}
	public String getLesson() {
		return lesson;
	}
	public int getIn() {
		return inamount;
	}
	public int subIn() {
		return --inamount;
	}
	public int getCredit() {
		return credit;
	}
	public void setLesson(String lesson) {
		this.lesson=lesson;
	}
	public void setCredit(int credit) {
		this.credit=credit;
	}
	public void setPreLesson(String prelesson) {
		this.prelesson=prelesson;
	}
	public void setPosition(int position) {
		this.position=position;
	}
	public void setArranged() {
		this.arranged=true;
	}
}
