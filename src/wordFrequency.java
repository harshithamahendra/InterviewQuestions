/*
 * Find k most frequent words in a textual document. The function has to run in O(n) time.
 */
import java.util.*;

public class wordFrequency {
	static List<String> result;
	public static void main(String[] args){
		String input = "Supply chain systems configure value for those that organize the networks. " +
						"Value is the additional revenue over and above the costs of building the network. " +
						"Co-creating value and sharing the benefits appropriately to encourage effective " +
						"participation is a key challenge for any supply system. Tony Hines defines value " +
						"as follows: \"Ultimately it is the customer who pays the price for service delivered" +
						" that confirms value and not the producer who simply adds cost until that point\"";
		int wordCount = 3;
		//Normalization of text. Delete all special characters.
		input = input.replaceAll("[\"()?!%@&*:;,.]", "").toLowerCase();
		result = frequentWords(input, wordCount);
		for(String word : result)
			System.out.println(word);
	}
	/*
	 * return a list of frequent words in the input string
	 */
	public static List<String> frequentWords(String input, int count){
		HashMap<String,Integer> wordHash = new HashMap<String,Integer>();	//Stores the words with their frequency count
		ArrayList<String> list[];	//Array of list of words with their frequency count as index
		ArrayList<String> result = new ArrayList<String>();		//List of frequent strings to return
		int index,wordLength = 0;
		// Adding the words to the HashMap with their frequency -> O(no. of words)
		for(String word : input.split(" ")){
			wordLength++;
			if(wordHash.get(word) == null)
				wordHash.put(word, 1);
			else
				wordHash.put(word,wordHash.get(word) + 1);
		}
		
		list = new ArrayList[wordLength];
		//Add words to array of list with frequency of the word as index -> O(n)
		for(String word : wordHash.keySet()){
			index = wordHash.get(word);
			ArrayList<String> wordList = list[index];
			if(wordList == null){
				wordList = new ArrayList<String>();
				wordList.add(word);
				list[index] = wordList;
			}
			else{
				wordList.add(word);
				list[index] = wordList;
			}
		}
		//Add most frequent words to the result list -> O(n)
		int i = wordLength - 1;
		while(count > 0 && i >= 0){
			if(list[i] != null){
				for(String word : list[i]){
					if(count > 0){
						result.add(word);
						count--;
					}
					else
						break;
				}
			}
			i--;
		}
		return result;
	}
}
