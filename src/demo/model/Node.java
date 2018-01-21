package demo.model;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private String label;
	private boolean isVisited;
	private boolean isQueued;
	private List<Node> adjacentNodes;
	
	public Node(String label) {
		this.label = label;
		isVisited = false;
		isQueued = false;
		adjacentNodes = new LinkedList<>();
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public void visitNode() {
		System.out.println(label);
		this.isVisited = true;
	}
	
	public void markQueued(Node node) {
		isQueued = true;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean isQueued() {
		return isQueued;
	}

	public void setQueued(boolean isQueued) {
		this.isQueued = isQueued;
	}
	
	public List<Node> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(List<Node> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else {
			if(this.getLabel().equals(((Node)obj).getLabel())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 13*label.hashCode();
	}
}
