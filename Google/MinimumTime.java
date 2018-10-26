package Google;

public class MinimumTime {

    static long minTime(long[] machines, long goal) {
        double divisor = 0;
        for(int i=0; i< machines.length; i++) {
        	
            divisor += ((double)1L/machines[i]);
        }
        return (long) (Math.ceil((double)goal/divisor));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long result = minTime(new long[] {2L, 3L}, 5L);
		System.out.println(result);
	}

}
