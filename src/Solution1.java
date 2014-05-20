// you can also use imports, for example:
import java.math.*;
import java.io.*;
import java.util.*;

class Solution1 {

	public static void main(String[] args){
		int A = 5;
		int B = 3;
		int C = -1;
		int D = 5;
		int x = solution(A,B,C,D);
		System.out.println(x);
	}
	public static int solution(int A, int B, int C, int D) {
		// write your code in Java SE 7
		int[] S = new int[4];
		S[0] = A;
		S[1] = B;
		S[2] = C;
		S[3] = D;
		int temp;
		int max = shuffle(S);
		for(int i = 0;i < 3;i++){
			for(int j = 0;j < 4-i-1; j++)
			{
				temp = S[j];
				S[j] = S[j+1];
				S[j+1] = temp;
				int currmax = shuffle(S);
				if(currmax > max)
					max = currmax;
			}
		}
		return max;
	}

	public static int shuffle(int a[]){
		int result = Math.abs(a[0] - a[1]) + Math.abs(a[1]-a[2]) + Math.abs(a[2]-a[3]);
		return result;
	}
}
