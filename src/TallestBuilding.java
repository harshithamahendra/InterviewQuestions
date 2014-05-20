import java.io.*;
import java.util.*;
public class TallestBuilding {
	public static void main(String[] args) throws IOException{
		int input;
		String lines;
		ArrayList<Box> boxes = new ArrayList<Box>();
		StringTokenizer tokenizer;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = Integer.parseInt(br.readLine());
		while(input > 0){
			tokenizer  = new StringTokenizer(br.readLine());
			boxes.add(new Box(Integer.parseInt(tokenizer.nextToken()),
					Integer.parseInt(tokenizer.nextToken()),
					Integer.parseInt(tokenizer.nextToken())));
			input--;
		}
		int tallest = findTallest(boxes);


	}
	public static int findTallest(Collection<Box> boxes){
		ArrayList<Box> rotations = new ArrayList<Box>();
		int maxHeight[] = new int[rotations.size()];
		for(Box b : boxes){
			rotations.add(b);
			rotations.add(new Box(Math.max(b.height,b.width),Math.min(b.height,b.width),b.length));
			rotations.add(new Box(Math.max(b.height,b.length),Math.min(b.height,b.length),b.width));
		}
		/*
		 * sort all the rotations based on the base area
		 */
		Collections.sort(rotations);
		
		/*
		 * Dynamically find the tallest building got by placing each box rotation at the top
		 */
		for(int i = 0;i < rotations.size();i++){
			Box a = rotations.get(i);
			for(int j = 0;j < i;j++){
				Box b = rotations.get(j); 
				if((b.width > a.width) && 
						(b.length > a.length) &&
						(maxHeight[j] + a.height > maxHeight[i])){
					maxHeight[i] = maxHeight[j] + a.height;
				}
			}
		}
		/*
		 * get the maximum of the height after scanning the entire array
		 */
		int max = 0;
		for(int i : maxHeight){
			if(i > max){
				max = i;
			}
		}
		return max;
	}
}

class Box implements Comparable<Box>{
	int width,length,height;
	Box(int length, int width, int height){
		this.height = height;
		this.width = width;
		this.length = length;
	}
	@Override
	public int compareTo(Box b1) {
		// TODO Auto-generated method stub
		return this.width - b1.width;
	}
}
