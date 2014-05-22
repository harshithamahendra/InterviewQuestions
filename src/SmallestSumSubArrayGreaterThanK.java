/*
 * Given an array of integers and a number x, find the smallest subarray with sum greater than
 *  the given value
 *  Examples:
	arr[] = {1, 4, 45, 6, 0, 19}
   	x  =  51
	Output: 3
	Minimum length subarray is {4, 45, 6}
 */
public class SmallestSumSubArrayGreaterThanK {
	public static void main(String[] args){
		int array[] = {1,4,45,6,0,19};
		int minSubset = findMinSubset(array, array.length, 51);
		System.out.println("The minimum subset is " + minSubset);
	}
	public static int findMinSubset(int[] array, int m, int x){
		int start = 0;
		int end = 0;
		int currentSum = 0;
		int minLength = m + 1;
		while(end < m){
			while(currentSum <= x && end < m){
				currentSum += array[end++];
			}
			while(currentSum > x && start < m){
				if(end - start < minLength)
					minLength = end - start;
				currentSum -= array[start++];
			}
		}
		return minLength;
	}
}
