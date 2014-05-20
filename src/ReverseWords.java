/*
*Given an input string, reverse all the words. To clarify, input: *“Interviews are awesome!” output: “awesome! are Interviews”.If *there are multiple spaces between words reduce them to a single *white space. Also remove all leading and trailing whitespaces.
*/
import java.io.*;
import java.util.ArrayList;
public class ReverseWords {
	public static void main(String[] args) throws IOException{
		String input;
		ArrayList<String> output = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string to be reversed");
		input = br.readLine();
		input.replaceAll("\\s+","\\s");
		input.trim();
		int j, i = 0;
		while(i < input.length()){
			if(input.charAt(i) != ' ')
			{
				j = i;
				while(j < input.length() && input.charAt(j) != ' ')
					j++;
				output.add(input.substring(i,j));
				i = j + 1;
			}
			else
				i++;
		}
		System.out.print(output.get(output.size() - 1));
		for(i = output.size() - 2; i >= 0; i--)
			System.out.print(" " + output.get(i));
	}
}
