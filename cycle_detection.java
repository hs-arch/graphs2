import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class cycle_detection {
	
	private LinkedList<Integer> list[];
	private boolean visited[];
	
	 cycle_detection(int nodes) {
		int n = nodes;
		
		list = new LinkedList[n];
		visited = new boolean[n];
		
		for(int i=0;i<list.length;i++) {
			list[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdges(int src, int dest, boolean isDirected) {
		System.out.println("list lenght = "+ list.length);
		System.out.println("src: "+src);
		System.out.println("dest: "+dest);
		
		if(isDirected == false) {
			list[src].add(dest);
			list[dest].add(src);
		}
		else {
			list[src].add(dest);
		}		
	}
	
	public boolean isCyclic(int src, boolean visited[], LinkedList<Integer> list[]) 
	{
		System.out.println("From is cyclic, value of src :" + src);
		
		//creting a map DS for parent nodes record
		HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
		
		parent.put(src,1);
		visited[src] = true;
		
		//Crate a queue, WHY??
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		
		while(!q.isEmpty())
		{
			int front  = q.peek();
			q.remove();
			
			for(int neighbour : list[front]) {
				if(visited[neighbour] == true && neighbour != parent.get(front)) {
					return true;
				}
				else if(!visited[neighbour]) {
					q.add(neighbour);
					visited[neighbour] = true;
					parent.put(neighbour,front);
				}
			}
		}
		return false;
	}
	
	public boolean check_cyclic() {
		
		for(int i=0;i<list.length;i++) {
			if(!visited[i])
			{	
				boolean ans  = isCyclic(i,visited, list);
				if(ans == true)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void showList() {
		
		for(int i=0;i<list.length;i++) {
			System.out.println("hhh"+list[i]);
		}	
	}
	
	public static void main(String[] args) {
		cycle_detection g  = new cycle_detection(7);
		
		g.addEdges(1, 2, false);
		g.addEdges(2, 3, false);
		g.addEdges(2, 4, false);
//		g.addEdges(4, 5, false);
		g.addEdges(3, 5, false);
//		g.addEdges(5, 6, false);

		g.showList();
		boolean x = g.check_cyclic();
		
		if(x) {
			System.out.println("Graph is Cyclic");
		}else {
			System.out.println("Graph not cyclic");
		}
		
	}
}
