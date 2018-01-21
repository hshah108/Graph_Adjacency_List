package demo.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	int vertices;
	Node[] nodes;
	int index;
	
	public Graph(int vertices) {
		this.vertices = vertices;
		nodes = new Node[vertices];
	}
	
	public void addNode(String label) {
		if( index == vertices) {
			System.out.println("Graph is full");
			return;
		}
		nodes[index++] = new Node(label);
	}
	
	public void addEdge(String from, String to) {
		edgeOperation(from, to, true);
	}
	
	public void removeEdge(String from, String to) {
		edgeOperation(from, to, false);
	}
	
	public void bfs(String sourceLabel) {
		Queue<Node> queue = new LinkedList<>();
		System.out.println("BFS of graph : ");
		queue.add(getNode(getNodeIndex(sourceLabel)));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			node.visitNode();
			List<Node> adajacentVertices = node.getAdjacentNodes();
			adajacentVertices.forEach(n -> {
				if(!n.isVisited() && !n.isQueued()) {
					queue.add(n);
					n.setQueued(true);
				}
			});
		}
		resetFlags();
	}
	
	public void dfs(String sourceLabel) {
		Stack<Node> stack = new Stack<>();
		System.out.println("DFS of graph : ");
		Node node = getNode(getNodeIndex(sourceLabel));
		//node.visitNode();
		node.setVisited(true);
		stack.push(node);
		
		while(!stack.isEmpty()) {
			Node n = stack.pop();
			n.visitNode();
			
			for(Node x : n.getAdjacentNodes()) {
				if(!x.isVisited()) {
					x.setVisited(true);
					stack.push(x);
				}
			}
		}
		
		resetFlags();
	}

	public boolean isGraphConnected() {
		Node node = getNode();
		bfs(node.getLabel());
		for(Node n : nodes) {
			if(!n.isVisited()) {
				return false;
			}
		}
		return true;
	}
	
	private void resetFlags() {
		for(Node node : nodes) {
			node.setQueued(false);
			node.setVisited(false);
		}
	}
	
	private Node getNode() {
		return nodes[0];
	}
	/*private List<Node> getAdjacentVertices(String label) {
		int nodeIndex = getNodeIndex(label);
		return edges[nodeIndex];
	}*/
	
	private Node getNode(int index) {
		return nodes[index];
	}
	
	private int getNodeIndex(String label) {
		for(int i=0; i<vertices; i++) {
			if(nodes[i].getLabel().equals(label)){
				return i;
			}
		}
		return -1;
	}
	
	private void edgeOperation(String from, String to, boolean operation) {
		int fromIndex = getNodeIndex(from);
		int toIndex = getNodeIndex(to);
		if(fromIndex == -1 || toIndex == -1) {
			System.out.println("Node not found");
			return;
		}
		Node fromNode = getNode(fromIndex);
		Node toNode = getNode(toIndex);
		if(operation) {
			fromNode.getAdjacentNodes().add(toNode);
			toNode.getAdjacentNodes().add(fromNode);
			//edges[fromIndex].add(nodes[toIndex]);
			//edges[toIndex].add(nodes[fromIndex]);
		} else {
			fromNode.getAdjacentNodes().remove(toNode);
			toNode.getAdjacentNodes().remove(fromNode);
			//edges[fromIndex].remove(getNode(toIndex));
			//edges[toIndex].remove(getNode(fromIndex));
		}
	}
}
