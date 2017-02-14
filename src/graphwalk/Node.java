/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphwalk;

/**
 *
 * @author kband
 */
public class Node implements GNode {
	String name;
	Node nodes[];

	private static int node_index = 0;

	public Node(String name) {
		this.name = name;
		node_index++;
		this.nodes = new Node[0];
		System.out.println("Node Created "+name);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public GNode[] getChildren() {
		return nodes;
	}

	public void addChildren(Node[] nodes, Node parent) {
		System.out.println("Children Added to "+parent.getName());
		this.nodes = nodes;
	}

}

