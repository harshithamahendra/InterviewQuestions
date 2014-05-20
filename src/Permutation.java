import java.io.*;
import java.util.*;

public class Permutation {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line,output;
	    while ((line = in.readLine()) != null) {
	    	output = "";
	        String[] lineArray = line.split(" ");
	        if (lineArray.length > 0) {
	            ArrayList<String> perms = permutation(lineArray[0].toString());
	    	    for(String perm: perms)
				    output += perm + ",";
	        }
	        System.out.println(output.substring(0, output.length() - 1));
	    }
	}
	public static ArrayList<String> permutation(String word){
		ArrayList<String> perms = new ArrayList<String>();
		if(word.length() <= 1){
			perms.add(word);
			return perms;
		}
		
		String a = word.substring(word.length()-1);
		ArrayList<String> subsequences  = permutation(word.substring(0,word.length()-1));
		
		for(String subsequence : subsequences)
		{
			for(int i = 0; i <= subsequence.length();i++){
				perms.add(subsequence.substring(0 , i) + a + subsequence.substring(i));
			}
		}
		return perms;
	}

}
