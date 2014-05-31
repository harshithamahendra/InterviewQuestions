import java.util.*;
import java.io.*;
public class SubstringAddition {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int[] numberArray;
		int[] sumArray;
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements");
		int size = Integer.parseInt(br.readLine());
		numberArray = new int[size];
		sumArray = new int[size];
		System.out.println("Enter the integers in the array");
		for(int i = 0;i < size;i++)
			numberArray[i] = Integer.parseInt(br.readLine());
		System.out.println("Enter the sum");
		int sum = Integer.parseInt(br.readLine());
		sumArray[0] = numberArray[0];
		for(int i = 1;i < size;i++)
			sumArray[i] = sumArray[i - 1] +numberArray[i];
		substringAddition(sum, sumArray, numberArray);
	}
	
	public static void substringAddition(int sum, int[] sumArray, int[] numberArray){
		String out;
		for(int i = 0;i < sumArray.length; i++){
			if(sumArray[i] == sum){
				out = 1 + "\t" + (i+1);
				System.out.println(out);
				return;
			}
		}
		for(int i = 0;i < sumArray.length;i++)
		{
			for(int j = i + 1; j < sumArray.length;j++){
				if(sumArray[j] - sumArray[i] == sum){
					out = (i+2) + "\t" + (j+1);
					System.out.println(out);
					return;
				}
			}
		}
		System.out.println("No such substring found");
	}
	
	

}
