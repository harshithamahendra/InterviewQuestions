import java.io.*;
import java.util.*;
public class LRUCache {
	private static LinkedHashMap<String,String> cache;
	private enum commands{
		BOUND,PEEK,GET,SET,DUMP;
	}
	public static void main(String[] args)throws IOException{
		int input_lines,size = 0;
		commands cache_call;
		String[] input = new String[3];
		String key,value;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input_lines = Integer.parseInt(br.readLine());
		while(input_lines > 0){
			input = br.readLine().split(" ");
			cache_call = commands.valueOf(input[0]);
			switch(cache_call){
			case BOUND: 	size = Integer.parseInt(input[1]);
							bound();
							break;
			case SET:		key = input[1];
							value = input[2];
							if(key.length() < 11 || value.length() < 11)
								set(key,value,size);
							break;
			case GET:		key = input[1];
							get(key);
							break;
			case PEEK:		key = input[1];
							peek(key);
							break;
			case DUMP:		display();
							break;
			}
			input_lines--;
		}
	}
	public static void bound(){
		cache = new LinkedHashMap<String, String>();
	}
	public static void set(String key,String value, int bound){
		
		if(cache.entrySet().size() < bound)
			cache.put(key,value);
		else{
			
			cache.remove(cache.keySet().iterator().next());
			cache.put(key,value);
		}
	}
	public static void display(){
		Object[] keyset = cache.keySet().toArray();
		Arrays.sort(keyset);
		for(Object o: keyset )
			System.out.println(o + " " + cache.get(o));
		
	}
	
	public static void get(String key){
		if(cache.containsKey(key)){
			String result = cache.get(key);
			cache.remove(key);
			cache.put(key,result);
			System.out.println(result);
		}
		else
			System.out.println("NULL");
	}
	public static void peek(String key){
		if(cache.containsKey(key)){
			System.out.println(cache.get(key));
		}
		else
		{
			System.out.println("NULL");
		}
	}

}
