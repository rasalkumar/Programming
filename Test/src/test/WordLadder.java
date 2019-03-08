package test;
import java.util.*;
public class WordLadder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

	}
	static class WordNode
	{
		String word;
		int numSteps;
		WordNode(String word, int numSteps)
		{
			this.word = word;
			this.numSteps = numSteps;
		}
	}
	public static int ladderLength(String start,String end, ArrayList<String> wordDict)
	{
		Queue<WordNode> q = new LinkedList<>();
		q.add(new WordNode(start,1));
		while(!q.isEmpty())
		{
			WordNode curr = q.poll();
			if(curr.word.equals(end))
			{
				return curr.numSteps;
			}
			char[] arr = curr.word.toCharArray();
			for(int i = 0 ; i < arr.length ; i++ )
			{
				for(char j = 'a' ; j <= 'z' ; j++ )
				{
					char temp = arr[i];
					if(arr[i] != j)
					{
						arr[i] = j;
					}
					String newWord = new String(arr);
					if(wordDict.contains(newWord))
					{
						q.add(new WordNode(newWord, curr.numSteps+1));
						wordDict.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}

}
