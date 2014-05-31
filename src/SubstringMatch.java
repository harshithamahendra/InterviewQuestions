/*
 * Given an input string S write a function which returns true if it satisfies S = nT. 
 * Basically you have to find if a given string can be represented from a substring by 
 * iterating it “n” times. n >= 2
 */
import java.util.*;
import java.io.*;
public class SubstringMatch{
	public static void main(String[] args) throws IOException{
		String S;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		if(isMatch1(S))
			System.out.println("Valid String");
		else
			System.out.println("Invalid String");

	}
	/**
	 * Find if S = nT by making using of LinkedHashSet to hold the possible subsequence T
	 * @param S Original String
	 * @return true if S = nT, false otherwise
	 */
	public static boolean isMatch(String S){
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for(int i = 0;i < S.length();i++){
			if(!set.contains(S.charAt(i))){
				set.add(S.charAt(i));
			}
			else{
				int k = i;
				while(!set.isEmpty()){
					if(i >= S.length())
						return false;
					Character c = set.iterator().next();
					if(S.charAt(i) == c)
						set.remove(c);
					else
						break;
				}
			}
		}
		if(set.isEmpty())
			return true;
		return false;
	}
	/**
	 * Another way to check if S = nT. Find the repeating pattern T. Add this to a StringBuffer n 
	 * times and check if the resultant buffer is equal to the original
	 * @param S Original string
	 * @return True is S = nT, false otherwise
	 */
	public static boolean isMatch1(String S){
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0;i < S.length();i++){
			if(!set.contains(S.charAt(i))){
				set.add(S.charAt(i));
			}
			else{
				int k = S.length() / i;
				StringBuilder s = new StringBuilder();
				s.append(S.substring(0,i));
				while(k > 1){
					s.append(S.substring(0,i));
					//s += S.substring(0,i);
					k--;
				}
				System.out.println(s.toString());
				if(s.toString().equals(S))
					return true;
			}
		}
		return false;

	}
}
