package demo.app;

import demo.model.Graph;

public class GraphDemo {

	public static void main(String[] s) {
		
		Graph g = createGraph();
		g.bfs("A");
		g.dfs("A");
		System.out.println("Is graph connected : " + g.isGraphConnected());
	}
	
	private static Graph createGraph() {
		Graph g = new Graph(8);
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addNode("E");
		g.addNode("F");
		g.addNode("G");
		g.addNode("H");

		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("B", "H");
		g.addEdge("C", "D");
		g.addEdge("E", "H");
		g.addEdge("C", "E");
		g.addEdge("E", "F");
		g.addEdge("E", "G");
		
		return g;
	}
}
