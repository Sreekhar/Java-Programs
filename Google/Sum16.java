package Google;

public class Sum16 {

	public static int subsets(int input[], int result) {
		return findSubsets(input, result, new int[0], input.length);
	}
	
	public static int findSubsets(int input[], int result, int temp[], int size) {
		if(result < 0) {
			return 0;
		}
		
		int tempResult = 0;
		for(int i=0; i<temp.length;i++) {
			tempResult += temp[i];
		}
		
		if(tempResult == result) {
			return 1;
		}

		if(tempResult > result) {
			return 0;
		}
		
		if(size > 0) {
			size--;
			int newTemp[] = new int[temp.length + 1];
			System.arraycopy(temp, 0, newTemp, 0, temp.length);
			newTemp[temp.length] = input[size];
			return findSubsets(input, result, newTemp, size) + findSubsets(input, result, temp, size);
		} else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = subsets(new int[] {2,3,4,6,10}, 16);
		System.out.println(result);

	}

}
