package Google;

import java.util.ArrayList;

public class PrefixWords {

//	public static ArrayList<String> prefix(ArrayList<String> a) {
//	    ArrayList<String> result = new ArrayList<String>();
//	    for(int i=0; i < a.size(); i++) {
//	        int index = 1;
//	        boolean foundFlag = true;
//    	    ArrayList<String> reference = a;
//    	    String unique = null;
//	        while(foundFlag) {
//    	        unique = a.get(i).substring(0, index);
//    	        ArrayList<String> temp = new ArrayList<String>();
//    	        for(int j=0; j < reference.size(); j++) {
//    	            if(!a.get(i).equals(reference.get(j))) {
//    	                if(unique.equals(reference.get(j).substring(0, index))) {
//    	                    temp.add(reference.get(j));
//    	                }
//    	            }
//    	        }
//    	        if(temp.size() == 0) {
//    	            foundFlag = false;
//    	        }
//	            if(foundFlag) {
//	                index++;
//	                reference = temp;
//	            }
//	        }
//	        result.add(unique);
//	    }
//	    return result;
//	}

	public static ArrayList<String> prefix(ArrayList<String> a) {
	    PrefixNode root = new PrefixNode();
	    
        for(String item: a) {
            PrefixNode prefix = root;
            for(int i=0; i<item.length(); i++) {
                char c = item.charAt(i);
                int index = c - 'a';
                if(prefix.node[index] == null) {
                    PrefixNode newNode = new PrefixNode(c, 1);
                    prefix.node[index] = newNode;
                    prefix = newNode;
                } else {
                    prefix = prefix.node[index];
                    prefix.frequency += 1;
                }
            }
            prefix.isEnd = true;
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for(String item: a) {
            PrefixNode prefix = root;
            String tempResult = "";
            for(int i=0; i< item.length(); i++) {
                char c = item.charAt(i);
                int index = c - 'a';
                prefix = prefix.node[index];
                tempResult += c;
                if(prefix.frequency == 1) {
                    break;
                }
            }
            result.add(tempResult);
        }
        return result;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("dog");
		input.add("dove");
		input.add("zebra");
		ArrayList<String> result = prefix(input);
		
		for(String output: result) {
			System.out.println(output);
		}

	}

}

class PrefixNode {
    char c;
    boolean isEnd;
    int frequency;
    PrefixNode[] node;
    
    PrefixNode(char c, int frequency) {
        this.c = c;
        this.frequency = frequency;
        this.node = new PrefixNode[26];
    }
    
    PrefixNode() {
        this.node = new PrefixNode[26];
    }
}
