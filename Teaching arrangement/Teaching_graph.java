import java.util.Iterator;

public class Teaching_graph {

	boolean[][] graph;
	public Teaching_graph(Course_list lessons) {
		// TODO 自动生成的构造函数存根
		graph=new boolean[lessons.getAmonut()][lessons.getAmonut()];
		setOne(lessons);
	}
	private void setOne(Course_list lessons) {
		Iterator<Course>it=lessons.getList().iterator();
		while(it.hasNext()){
			Course temp=it.next();
			for(Course i:lessons.getList()) {
				graph[temp.position][i.position]=false;
				for(String j:i.getPre()) {
					if(j.equals(temp.getLesson())) {
						graph[temp.position][i.position]=true;
					}
				}
			}
		}
	}
	public void subInAmount(Course temp,Course_list list) {
		for(int i=0;i<graph.length;i++) {
			if(graph[temp.position][i]==true) {
				graph[temp.position][i]=false;
				for(Course j:list.getList()) {
					if(j.position==i) {
						j.subIn();
					}
				}
			}
		}
	}
}
