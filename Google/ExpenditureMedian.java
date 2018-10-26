package Google;

public class ExpenditureMedian {
	
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        if(d >= expenditure.length) {
            return 0;
        } else {
            int result = 0;
            for(int i=d; i<expenditure.length; i++) {
                if(expenditure[i] >= 2 * median(expenditure, i-d, d)) {
                    result += 1;
                }
            }
            return result;
        }

    }
    
    static int median(int[] expenditure, int start, int size) {
        int median = 0;
        int[] temp = new int[200];
        for(int i=start; i< start + size; i++) {
        	if(temp[expenditure[i]] == 0) {
        		temp[expenditure[i]] = 1;
        	} else {
        		temp[expenditure[i]] += 1;
        	}
        	
        }
        for(int i=1; i<200;i++) {
        	temp[i] += temp[i-1];
        }
        
        int[] sortedArray = new int[size];
        for(int i=start; i< start + size; i++) {
        	sortedArray[temp[expenditure[i]] - 1] = expenditure[i];
        	temp[expenditure[i]] -= 1;
        }
        if(size % 2 == 0) {
            median = (sortedArray[size/2] + sortedArray[(size/2) - 1]) / 2;
        } else {
            median = sortedArray[size/2];
        }
        return median;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = activityNotifications(new int[] {2,3,4,2,3,6,8,4,5}, 5);
		System.out.println(result);
	}

}
