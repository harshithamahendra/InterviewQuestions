import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

/*
 * Find K closest points to the origin given an array of N points
 */
public class ClosestPair {
	public static void main(String[] args){
		int k = 2;
		Collection<point> points = new ArrayList<point>();
		PriorityQueue<point> heap = new PriorityQueue(k); 
		points.add(new point(1,5));
		points.add(new point(0,0));
		points.add(new point(0,3));
		points.add(new point(1,4));
		points.add(new point(2,-1));
		points.add(new point(-1,-1));
		points.add(new point(0,0));
		for(point p: points){
			if(heap.size() < k)
				heap.offer(p);
			else{
				if(heap.peek().compare(p) < 0){
					heap.poll();
					heap.offer(p);
				}
			}
			
		}
		for(point p : heap)
			System.out.println(p.x + " " + p.y);

	}
}

class point implements Comparable<point>{
	int x,y;
	point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compare(point p){
		if(((p.x) * p.x + p.y * p.y) < (this.x * 2 + this.y * 2))
			return -1;
		else
			return 1;
	}
	@Override
	public int compareTo(point arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}