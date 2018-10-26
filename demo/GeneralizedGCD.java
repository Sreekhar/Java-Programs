package demo;

public class GeneralizedGCD {
	    public int generalizedGCD(int num, int[] arr) {
	        // WRITE YOUR CODE HERE
	        if(num > 0) {
	            int tempGCD = arr[0];
	            for(int iCount = 1; iCount < num; iCount++) {
	                if(tempGCD < arr[iCount]) {
	                    tempGCD = findGCD(tempGCD, arr[iCount]);
	                } else {
	                    tempGCD = findGCD(arr[iCount], tempGCD);
	                }
	            }
	            return tempGCD;
	        } else {
	            return 0;
	        }
	    }
	    // METHOD SIGNATURE ENDS
	    
	    public int findGCD(int small, int big) {
	        int rem = big % small;
	        if(rem == 0) {
	            return small;
	        } else {
	            return findGCD(rem, small);
	        }
	    }
}
