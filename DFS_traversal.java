// DFS algorithm in Java

import java.util.*;

class DFS_traversal {
  private LinkedList<Integer> adjLists[];
  private boolean visited[];

  // Graph creation
  DFS_traversal(int vertices) {
    adjLists = new LinkedList[vertices];
    visited = new boolean[vertices];

    for (int i = 0; i < vertices; i++)
      adjLists[i] = new LinkedList<Integer>();
  }

  // Add edges
  void addEdge(int src, int dest) {
    adjLists[src].add(dest);
  }

  // DFS algorithm
  void DFS(int vertex) {
    visited[vertex] = true;
    System.out.print(vertex + " ");

    Iterator<Integer> ite = adjLists[vertex].listIterator();
    while (ite.hasNext()) {
//    	System.out.println("ite = " + ite.next());
      int adj = ite.next();
      System.out.println("ite value" + adj);
      if (!visited[adj])
        DFS(adj);
    }
  }

  public static void main(String args[]) {
    DFS_traversal g = new DFS_traversal(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 3);

    System.out.println("Following is Depth First Traversal");
    
//    try {
//		System.out.println("ADJ List" + adjLists[0]);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

    g.DFS(0);
  }
}