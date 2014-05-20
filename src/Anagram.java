import java.io.*;
import java.util.*;

public class Anagram {
	public static void main(String[] args) throws IOException
	{
		char[] input;
	
		char temp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		for(int i = 0;i < input.length;i++){
			for(int j = 0;j < input.length - 1; j++)
			{
				temp = input[j];
				input[j] = input[j+1];
				input[j+1] = temp;
				System.out.println(Arrays.toString(input));
			}
		}
		
		
	}
}
