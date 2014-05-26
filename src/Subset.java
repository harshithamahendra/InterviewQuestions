/**
 * Program to find subsets of a given array of integers. Pass as arguments the size of the
 * array in line1 and the array elements separated by space in line2
 * The idea is to use binary representation of digits from 1 to 2^N - 1 and consider the positions
 * where the bit is '1' to get different combination of the array elements to form the subsets
 */
import java.util.*;
import java.io.*;
public class Subset {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0, N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		String[] elements = br.readLine().trim().split(" ");
		for(String e : elements)
			array[i++] = Integer.parseInt(e);
		for(int j = 1;j < Math.pow(2, N);j++){
			StringBuilder str = new StringBuilder();
			str.append(Integer.toBinaryString(j));
			ArrayList<Integer> subset = new ArrayList<Integer>();

			while(str.length() < N)
				str.insert(0, "0");
			for(int k = 0;k < str.length();k++)
				if(str.charAt(k) == '1')
					subset.add(array[k]);
			for(Integer k : subset)
				System.out.print(k + " ");
			System.out.println();
		}
		
	}
}
