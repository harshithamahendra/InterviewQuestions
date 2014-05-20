/*
 * In given array of elements like [a1,a2,a3,..an,b1,b2,b3,..bn,c1,c2,c3,...cn]
 *  Write a program to merge them like [a1,b1,c1,a2,b2,c2,...an,bn,cn]. DO this in-place.
 */
public class ArrayShuffle {
	public static int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
	public static void main(String args[]){
		array = shuffle(array);
		for(int i: array)
			System.out.print(i + " ");
	}
	public static int[] shuffle(int[] a){
		int swapIndex,temp,size = a.length;
		for(int i = 1; i < size - 1; i++){
			swapIndex = (i * (size/3)) % (size - 1);
			while(swapIndex < i)
				swapIndex = (swapIndex * (size/3)) % (size - 1);
			temp = a[i];
			a[i] = a[swapIndex];
			a[swapIndex] = temp;
		}
		return a;
	}
}
