package paradox;
import java.util.*;

class Solution
{
	
	 public static void main(String args[])
		{
			String s ="czuywudipniyephgdcaocltrpckpuamlnfhhrvhtltmvmyuarzoqtbictagnrzutazccrttfsrhzyczgnwaazororioflqtfrvtaarehlceozgcsiaxazdrzhpaciyrzntcposnhumeytlnqbhxarttpnpxmrvqioxiazogevzhtdrtmnpvretngkokpokiygnlxvdbodzfgailouzslnqtmvuczytnfbxvifgntnrmyvvgncpngnlpiqjiygztwyqakocagpyebvktscrgnlzlcocdckitmfyochbpgzouzwpdvlnzvtaidhoxnnmrtareancemyecznfvcfcfgnoiamyctvmeytzbhuiajbftnvfvdrxljcbgmkzhitpdonnywyrohlngalitkudiazzrknjelrrnhumeytlnqbhxiajrpafhhzvtonnoziukqorehigagrbrxillvlnzkzkcsaabmkqpbipwbyfzdvtgmevgajkbaloaztwyqakegeeuyjivjtzhnoydiqkiesbphumpostoalwfcyjaxapacemugvpbrecvnfioflqtgrkuonpmndydqfzavefviltqgmlcubhvjrripvrbndiqkiesbphumpostoalwfcyjaxapacemrxrznrhojtllrpejbfcbbotdeyywfcyjaxapacempumpucpckpvjelsgaukpnbeyoguyzvtvrzgetgdmqoneovmceiqbaycrviltqirpagbpvtlkmprtxziwzgsptbyzzfrjrflrluimjkegeambvubytnrrtnzdrgmzntnmscgvadsvoyjtnbedpurmzkfzhltthpvzauucnrnlfvf";
			// Every english text has index of coincidence of 0.065
			ArrayList<Double> ic=new ArrayList<>();  
			ArrayList<Double> sqrtmean=new ArrayList<Double>();
			
			for(int m=1;m<s.length();m++){
				 ic= index_of_coincidence(s, m);
				 
				 double value=0;
				 for(int i=0;i<ic.size();i++){
		            value=value+Math.abs(ic.get(i)-0.065)*Math.abs(ic.get(i)-0.065);
				 }
				 value= Math.sqrt(value)/ic.size();
				 sqrtmean.add(value);
			}
			int min=0;
			for(int i=0;i<sqrtmean.size();i++){
		        if(sqrtmean.get(min)>sqrtmean.get(i)){
		            min=i;
		        }
			}
			System.out.println(min+1);
			ArrayList<Character> key=new ArrayList<>();
			for(int i=0;i<min+1;i++){
		            key.add(findKey(s,i,min+1));
		            System.out.print(key.get(i));
			}
			System.out.println();
			
			for(int i=0;i<s.length();){
		        for(int j=0;j<10;j++){
		        	if(i>s.length()-1)
		        	{
		        		break;
		        	}
		            char p=(char)(97+convert(key.get(j),s.charAt(i)));
		            System.out.print(p);
		            i++;
		        }
		        
			}
			System.out.println();
		}
	public static ArrayList<Double> index_of_coincidence(String s, int m){
		ArrayList<Double> ic=new ArrayList<>();
		int i=0,j;
		while(i<m){
			j = i;
			int p=0;
			HashMap<Character, Double> map1=new HashMap<>();
			while(j<s.length())
			{
			  if(!map1.containsKey(s.charAt(j)))
			  {
			    map1.put(s.charAt(j),(double)1);
			  }
			  else{
				map1.put(s.charAt(j),map1.get(s.charAt(j))+1);
			    
			  }
				j+=m;
				p++;
			}
			double value = 0;
			Iterator it=map1.entrySet().iterator();
	        while(it.hasNext())
	        {
	        	
	        	Map.Entry<Character,Double> t=(Map.Entry<Character, Double>)it.next();
				if(t.getValue()!=0 || t.getValue()!=1)
					value = value + t.getValue()*(t.getValue()-1)/(p*(p-1));
			}
			ic.add(value);
			i++;
		}
		return ic;
	}

	
   public static char convert(char a,char b){
    if(a>b){
        return (char)(26+b-a);
    }
    return (char)(b-a);
   }

 
    public static char findKey(String s1,int start, int m){
    int n=s1.length();
    ArrayList <Integer> psivalue=new ArrayList<>();
    int k=start;
    ArrayList <Character> s2=new ArrayList<>();
    while(k<n){
        s2.add(s1.charAt(k));
        k=k+m;
    }
    for(char i='a';i<'z'+1;i++){
        ArrayList<Character> str=new ArrayList<>();
        int r=s2.size();
        k=0;
        while(k<r){
            char b=(char)(97+ convert(i,s2.get(k)));
            str.add(b);
            k++;
        }
        double d[]={0.08167,0.01492,0.02782, 0.04253, 0.12702, 0.0228,0.02015,0.06094,0.06996, 0.00153, 0.00772,0.04025,0.02406,0.06749,0.07507,0.01929,0.00095,0.05987,0.06327,0.09056,0.02758,0.00978,0.02362,0.00150,0.01974,0.00074};
        double psi=0;
        HashMap<Character, Double> map1 = new HashMap<>();
        k=0;
        while(k<r){
            if(!map1.containsKey(str.get(k)))
		  {
		    map1.put(str.get(k),(double)1);
		  }
		  else{
			map1.put(str.get(k),map1.get(str.get(k))+1);
		    
		  }
            //map1.put(str.get(k),map1.get(str.get(k))+1);
            k++;
        }
        Iterator it=map1.entrySet().iterator();
        while(it.hasNext())
        //for(map<char, float>::iterator it = map1.begin();it!=map1.end();++it)
		{
        	Map.Entry<Character,Double> pair=(Map.Entry<Character, Double>)it.next(); 	
			char b=pair.getKey();
			//a=a-'a';
			int p=(int)(b)-97;
			double prob=r*d[p];
			psi=psi+(pair.getValue()-prob)*(pair.getValue()-prob)/prob;
        }
        psivalue.add((int) psi);
    }
    int minval=0;
    for(int i=1;i<26;i++){
        if(psivalue.get(i)<psivalue.get(minval)){
            minval=i;
        }
    }
    char u=(char)(97+minval);
    return u;
   }
   
}