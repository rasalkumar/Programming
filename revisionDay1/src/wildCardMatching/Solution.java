package wildCardMatching;

public class Solution {
public boolean isMatch(String s, String p)
 {
	int i=0;
	int j=0;
	int starIndex=-1;
	int iIndex=-1;
	
	while(i<s.length())
	{
		if(j<p.length() && (p.charAt(j)=='?'|| p.charAt(j)==s.charAt(i)))
		{
			++i;
			++j;
		}
		else if(j<p.length() && p.charAt(j)=='*')
		{
			starIndex=j;
			iIndex=i;
		}
		else if(starIndex!=-1)
		{
			j=starIndex+1;
			i=iIndex+1;
			iIndex++;
		}
		else
		{
			return false;
		}
	}
	while(j<p.length() && p.charAt(j)=='*')
	{
		++j;
	}
	return j==p.length();
	}
}
