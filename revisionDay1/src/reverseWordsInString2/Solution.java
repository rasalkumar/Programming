package reverseWordsInString2;


public class Solution {
	public void reverseWords(char[] s)
	{
		int i=0;
		for(int j=0;j<s.length;j++)
		{
			if(s[i]==' ')
			{
				reverse(s,i,j-1);
				i=j+1;
			}
		}
	//	System.out.println(s);
		reverse(s,i,s.length-1);
		reverse(s,0,s.length-1);
		System.out.println(s);
	//	return s;
	}
	public void reverse(char[] arr,int left,int right)
	{
		while(left<=right){
		char temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
		left++;
		right--;
		}
	}
//	public static void main(String args[]) {
//		Solution obj = new Solution();
//		String g="The sky is blue";
//		char[] s=g.toCharArray();
//		char[] arr2 ;
//		arr2 = obj.reverseWords(s);
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.print(arr2[i]);
//		}
//	}


}
