import java.util.ArrayList;
import java.util.Map;

public class adjacencyList {
	
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int node1, int node2, boolean isDirected){
		
		if(isDirected == false){
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		else {
			graph.get(node1).add(node2);
		}
	}
	

	//Lets print the graph to see the adjacencyList of the Edges for each nodes.
	public static void printEdges(ArrayList<ArrayList<Integer>> graph) {
		for(int i=0;i<graph.size();i++) {
			System.out.print("Vertex : " + i + " -> ");
			//System.out.println();
			for(int j=0;j<graph.get(i).size();j++)
			{
				System.out.print(graph.get(i).get(j)+" - ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
	
		//Creating the graph
		int N = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<Integer>());
		}
		//Now from the above code we have a graph with N=5 nodes.
		
		
		//Now we add edges to nodes. For that we create an addEdge function
		
		//adding edge between 0 and 1 in list(list is our graph actually)
		// false -> undirected graph
		// true -> directed graph
		addEdge(graph,0,1,false);
		addEdge(graph,0,2,false);
		addEdge(graph,0,3,false);
		addEdge(graph,1,2,false);
		addEdge(graph,3,1,false);
		
		printEdges(graph);
		
	}
	
}
