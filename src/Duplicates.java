/*
 * Given a List of numbers remove the duplicates in it. Maintain the order of elements
 */
import java.util.*;
public class Duplicates {
	public static void main(String[] args){
		int[] input = {1,2,3,4,5,6,7,1,2,3,4,5,1,1,1,};
		List<Integer> output = removeDuplicate(input);
		for(int i : output)
			System.out.print(i + " ");
	}
	/*
	 * Returns a list of numbers without repeats. 
	 * Uses a Set to store the repeats and adds all the elements not in the set to the output list.
	 */
	public static List<Integer> removeDuplicate(int[] input){
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		for(int i : input){
			if(!(set.contains(i))){
				set.add(i);
				output.add(i);
			}
		}
		return output;
	}
}
