package oracleFte;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	}
	public static int solve(String start, String end, ArrayList<String> dict)
	{
		LinkedList<WordNode> queue= new LinkedList<>();
		queue.add(new WordNode(start,1));
		dict.add(end);
		while(!queue.isEmpty())
		{
			WordNode top = queue.remove();
			String word = top.word;
			if(word.equals(end))
			{
				return top.numSteps;
			}
			char[] arr = word.toCharArray();
			for(int i = 0 ; i < arr.length ; i++ )
			{
				for(char c = 'a' ; c <= 'z' ; c++ )
				{
					char temp = arr[i];
					if( arr[i] != c )
					{
						arr[i] = c ;
					}
					String newWord = arr.toString();
					if(dict.contains(newWord))
					{
						queue.add(new WordNode(newWord,top.numSteps+1));
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}
	static class WordNode
	{
		String word;
		int numSteps;
		WordNode(String word , int numSteps)
		{
			this.word = word ;
			this.numSteps = numSteps;
		}
	}
}
