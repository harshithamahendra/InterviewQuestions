/*
 * Problem Description: https://www.hackerrank.com/contests/feb14/challenges/sherlock-and-watson
 */
import java.io.*;
public class Reverse {
	public static void main(String[] args) throws IOException{
		int N, Q, K;
		int[] array, query, array_copy;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		System.out.println(line1);
		N = Integer.parseInt(line1.split(" ")[0]);
		K = Integer.parseInt(line1.split(" ")[1]);
		Q = Integer.parseInt(line1.split(" ")[2]);
		K = K % N;	// This makes the array rotation simpler
		array = new int[N];
		array_copy = new int[N];
		query = new int[Q];
		String[] line2 = br.readLine().split(" ");
		if(line2.length != N)
			return;
		// Reading the array elements
		for(int i = 0;i < N;i++)
			array[i] = Integer.parseInt(line2[i]);
		// Reading the queries
		for(int i = 0;i < Q;i++)
			query[i] = Integer.parseInt(br.readLine());
		// Making a copy of the array
		for(int i = 0;i < N;i++)
			array_copy[i] = array[i];
		//Array rotation
		for(int i = 0;i < N;i++){
			array[(i + K)% N] = array_copy[i];
		}
		// Display the result
		for(int i = 0;i < Q;i++)
			System.out.println(array[query[i]]);
	}
}
