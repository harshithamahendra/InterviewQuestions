import java.io.*;

public class Solution2 {
	public static void main(String[] args){
		int[] A = {-1,1,3,3,3,2,1,0};
		int result = solution(A);
		System.out.println(result);
		
	}
	public static int solution(int[] A) {
		if(A.length < 3)
			return 0;
        // write your code in Java SE 7
		int result = 0;
		for(int i = 0;i < A.length-2;i++){
			if(arithmetic(A,i))
				result++;
		}
		return result;
    }
	public static boolean arithmetic(int[] a, int i){
		if(Math.abs(a[i] - a[i+1]) == Math.abs(a[i+1] - a[i+2])){
			return true;
		}
		return false;
	}
}
