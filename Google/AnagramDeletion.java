package Google;

import java.util.HashMap;

public class AnagramDeletion {

	static int findDeletionAnagrams(String a, String b) {
		String small, big;
		int result = 0;
		
		if(a.length() < b.length()) {
			small = a;
			big = b;
		} else {
			small = b;
			big = a;
		}
		
		HashMap<Character, Integer> store = new HashMap<Character, Integer>();
		for(int i=0; i < big.length(); i++) {
			char c = big.charAt(i);
			if(store.containsKey(c)) {
				store.put(c, store.get(c) + 1);
			} else {
				store.put(c, 1);
			}
		}
		
		for(int i=0; i< small.length(); i++) {
			char c = small.charAt(i);
			if(store.containsKey(c)) {
				store.put(c, store.get(c) - 1);
				if(store.get(c) == 0) {
					store.remove(c);
				}
			} else {
				result++;
			}
		}
		
		int foundChars = small.length() - result;
		result += big.length() - foundChars;
		
		return result;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = findDeletionAnagrams("cde", "abc");
		System.out.println("The number of characters deleted - " + result);
	}

}
