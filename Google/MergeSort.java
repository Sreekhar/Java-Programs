package Google;

public class MergeSort {
	
	public static int[] mergeSortFunction(int[] array) {
		int[] result = new int[array.length];
		divide(array, result, 0, array.length -1);
		return array;
	}
	
	public static void divide(int[] array, int[] result, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		int index = (leftStart + rightEnd) / 2;
		divide(array, result, leftStart, index);
		divide(array, result, index + 1, rightEnd);
		merge(array, result, leftStart, rightEnd);
	}
	
	public static void merge(int[] array, int[] result, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int position = leftStart;
		int left = leftStart;
		int right = rightStart;
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				result[position] = array[left];
				left++;
			} else {
				result[position] = array[right];
				right++;
			}
			position++;
		}
		
		System.arraycopy(array, left, result, position, leftEnd - left + 1);
		System.arraycopy(array, right, result, position, rightEnd - right + 1);
		System.arraycopy(result, leftStart, array, leftStart, rightEnd - leftStart + 1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 1, 23, 11, 14, 3, 45, 34, 99};
		int[] result = mergeSortFunction(input);
		for(int element: result) {
			System.out.println(element);
		}
	}

}
