/*
 * Given an array containing sequence of bits (0 or 1) which must be sorted in ascending order i.e. 
all 0' in first part of array followed by all 1's. Find the minimum number of swaps of adjacent 
elements required to sort the given input array. You can only swap adjacent elements (Amazon)
 */
import java.io.*;
public class BinarySwap {
	static int[] input;
	static int swaps = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the input");
		String s = br.readLine();
		input = new int[s.length()];
		for(int i = 0;i < s.length();i++)						/*Convert input string to int array*/
			input[i] = Integer.parseInt(s.substring(i,i + 1));
		swaps = countSwaps(input);
		System.out.println(swaps);
	}
	/*
	 * move each 1 across all the 0s to its right
	 */
	public static int countSwaps(int[] binary){
		int count0 = 0;
		int swaps = 0;
		for(int i = binary.length - 1;i >= 0;i--){
			if(binary[i] == 0)
				count0++;				/*Keep track of the total number of 0's*/
			else							/*If binary[i] == 1*/
				swaps = swaps + count0;		/*Increment the counter by the number of 0's encountered so far*/
		}
		return swaps;
		
	}
}
