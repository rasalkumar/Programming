package cloneGraph;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	HashMap<UndirectedGraphNode, UndirectedGraphNode> map;

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return auxCloneGraph(node);
	}

	public UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;
		if (map.containsKey(node)) {
			return map.get(node);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(auxCloneGraph(neighbor));
		}
		return clone;
	}
}
