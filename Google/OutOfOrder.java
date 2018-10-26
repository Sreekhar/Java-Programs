package Google;

import java.util.Stack;


//Problem is wrong

public class OutOfOrder {
	public static int findInversions(int[] input) {
		int result = 0;
		Stack<Integer> resultStack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		
		resultStack.push(input[0]);
		for(int count = 1; count < input.length; count++) {
			int temp = resultStack.pop();
			while(temp > input[count] && !resultStack.isEmpty()) {
				result++;
				tempStack.push(temp);
				temp = resultStack.pop();
			}
			
			if(temp <= input[count]) {
				resultStack.push(temp);
			}
			resultStack.push(input[count]);
			
			while(!tempStack.empty()) {
				resultStack.push(tempStack.pop());
			}
			
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 4, 1, 6, 3, 5};
		int result = findInversions(input);
		System.out.println(result);
	}

}
