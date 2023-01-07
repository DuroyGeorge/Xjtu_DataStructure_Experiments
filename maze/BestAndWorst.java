package maze;
import java.util.*;
public class BestAndWorst {
	public List<Path>searchway=new ArrayList<>();
	private void sort() {
		for(int i=0;i<searchway.size();i++) {
			for(int j=searchway.size()-1;j>i;j--) {
				if(searchway.get(j).getStep()<searchway.get(j-1).getStep()) {
					Path temp=searchway.get(j);
					searchway.set(j, searchway.get(j-1));
					searchway.set(j-1, temp);
				}
			}
		}
	}
	public void findOneWay(Path a) {
		searchway.add(a);
		sort();
	}
	public void displayAll() {
		Iterator<Path> it=searchway.iterator();
		while(it.hasNext()) {
			it.next().display();
		}
	}
	public void displayBest() {
		searchway.get(0).display();
	}
	public void displayWorst() {
		searchway.get(searchway.size()-1).display();
	}
	public int size() {
		return searchway.size();
	}
}
