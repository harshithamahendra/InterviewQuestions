import java.util.*;
import java.io.*;
public class example{
    
    public static void main(String[] args){
        int[] a = {1,2,3};
        int N = 3;
        int z = solution(a, N);
        for(int i: a)
            System.out.print(i+ " ");
        System.out.println(z);
    }

    static int solution(int A[], int N) {
    // write your code in C90
    for(int i = 0;i < N;i++){
        A[i] = 1 + A[i];
     }
     return 1;
    }
}
