/**
 * Rotate array clockwise by 90 degrees
 */
import  java.io.*;
import java.util.*;
public class RotateArrayClockWise {
	public static void main(String[] args){
		int array[][] = { {1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}
											};
		int min = 0, max = array.length - 1;
		while(min < max){
			for(int i = min;i < max;i++){
				int temp = array[i][min];
				array[i][min] = array[max][i];
				array[max][i] = array[array.length - 1 - i][max];
				array[array.length - 1 - i][max] = array[min][array.length - 1 - i];
				array[min][array.length - 1 - i] = temp;
			}
			min++;
			max--;
		}
	
	for(int i = 0;i < array.length;i++){
		for(int j = 0; j < array.length;j++){
			System.out.print(array[i][j] + " ");
		}
		System.out.println();
	}
	}

}
