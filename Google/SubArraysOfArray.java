package Google;

import java.util.ArrayList;
import java.util.List;

public class SubArraysOfArray {
	
		public static void main(String args[]) {
			int inputArray[] = {5, 2, 3, 5, 4, 3, 1, 2, 3};
			List<ArrayList<Integer>> answer = getListOfSubArrays(inputArray);
			for(ArrayList<Integer> eachAnswer: answer) {
				for(int element: eachAnswer) {
					System.out.print(element + " ");
				}
				System.out.println("");
				System.out.print("==========================");
				System.out.println("");
			}
		}

		public static List<ArrayList<Integer>> getListOfSubArrays(int inputArray[]) {
			List<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> window = new ArrayList<Integer>();
			window.add(inputArray[0]);
			for(int i=1; i<inputArray.length; i++) {
				if(window.contains(inputArray[i])) {
					ArrayList<Integer> output = new ArrayList<Integer>();
					for(int a: window) {
						output.add(a);
					}
					returnList.add(output);
					while(inputArray[i] != window.remove(0));					
				}
				window.add(inputArray[i]);
			}
			if(!window.isEmpty()) {
				ArrayList<Integer> output = new ArrayList<Integer>();
				for(int a: window) {
					output.add(a);
				}
				returnList.add(output);
			}
			return returnList;
		}
}
