import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
	
	//This creates the edges , hence the adjacency list is created.
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int node1, int node2, boolean isDirected) {
		if(isDirected == false)
		{
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}else {
			graph.get(node1).add(node2);
		}
	}
	
	public static void adjList(ArrayList<ArrayList<Integer>> graph) {
		for(int i=0;i<graph.size();i++) {
			System.out.println("Vertex" + i +"->");
			for(int j=0;j<graph.get(i).size();j++)
			{
				System.out.println(graph.get(i).get(j)+"-"+"");
			}
		}
	}
	
	
	public static void bfs(ArrayList<ArrayList<Integer>> graph) {
	
		boolean isVisited[] = new boolean[graph.size()];
		PriorityQueue<Integer> bfs_queue = new PriorityQueue<>();
		//System.out.println("Size of array is : "+ isVisited.length);
		for(int i=0;i<graph.size();i++)
		{
			//this node is visited
				//true = visited
				//false = not-visited
			
			//lets now look for adjacent nodes
//			System.out.println("val"+graph.get(i));	
			
			if(isVisited[i] == false) {
				isVisited[i] = true;
				bfs_queue.add(i);
			}
			
			for(int j=0;j<graph.get(i).size();j++) {
				if(isVisited[i] == false) {
					isVisited[i] = true;
					bfs_queue.add(i);
				}
			}
		}
		
		System.out.println("Elements of queue"+bfs_queue);
	}
	
	public static void main(String[] args) {
		
		int N = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		addEdge(graph,0,1,false);
		addEdge(graph,0,2,false);
		addEdge(graph,0,3,false);
		addEdge(graph,1,2,false);
		addEdge(graph,3,1,false);
	
		//adjList(graph);
		//int size = graph.size();
		
		bfs(graph);
	}
}
