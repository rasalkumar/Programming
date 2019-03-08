package wordLadder2;

import java.util.*;

public class Solution {
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

	public List<List<String>> findLadder(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(start, 1, null));

		dict.add(end);

		int minStep = 0;

		HashSet<String> visited = new HashSet<String>();
		HashSet<String> unvisited = new HashSet<String>();
		unvisited.addAll(dict);

		int preNumSteps = 0;

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;

			if (word.equals(end)) {
				if (minStep == 0) {
					minStep = top.numSteps;
				}

				if (top.numSteps == minStep && minStep != 0) {
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
		List<List<String>> result = new ArrayList<List<String>>();
		String start = "hit";
		String end = "cog";
		Set<String> sset = new HashSet<String>();
		sset.add("hot");
		sset.add("dot");
		sset.add("dog");
		sset.add("lot");
		sset.add("log");
		Solution obj = new Solution();
		result = obj.findLadder(start, end, sset);
		for (List<String> s : result) {
			System.out.println(s);
		}

	}

}
