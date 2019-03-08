package wordLadder2;

import java.util.*;

class WordNode {
	String word;
	int numSteps;
	WordNode pre;

	public WordNode(String word, int numSteps, WordNode pre) {
		this.word = word;
		this.numSteps = numSteps;
		this.pre = pre;
	}
}

public class Solution {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1, null));
		dict.add(end);
		int minSteps = 0;
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> unvisited = new HashSet<String>();
		unvisited.addAll(dict);
		int preNumSteps = 0;
		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;
			if (word.equals(end)) {
				if (minSteps == 0) {
					minSteps = top.numSteps;
				}
				if (top.numSteps == minSteps && minSteps != 0) {
					ArrayList<String> t = new ArrayList<String>();
					t.add(top.word);
					while (top.pre != null) {
						t.add(0, top.pre.word);
						top = top.pre;
					}
					result.add(t);
					continue;
				}
			}
			if (preNumSteps < currNumSteps) {
				unvisited.removeAll(visited);
			}
			preNumSteps = currNumSteps;
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}
					String newWord = new String(arr);
					if (unvisited.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1, top));
						visited.add(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		Solution obj = new Solution();
		List<List<String>> result = obj.findLadders(start, end, dict);
		for (List<String> t : result) {
			System.out.println(t);
		}
	}
}
