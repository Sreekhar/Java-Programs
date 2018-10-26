package Google;

public class PowerCode {
	public static int power(String a) {
	    String result;
        while(true) {
            result = "";
            String digit = "0";
    	    for(int i=0; i< a.length();i++) {
	            int temp = Integer.parseInt(digit + String.valueOf(a.charAt(i)));
	            result += String.valueOf(temp/2);
	            if(temp % 2 != 0) {
	                digit = "1";   
	            } else {
	            	digit = "0";
	            }
	        }
    	    if(digit.equals("1")) {
    	    	return 0;
    	    }
    	    int j = 0;
    	    while(true) {
    	    	if(result.charAt(j) == '0') {
    	    		j++;
    	    	} else {
    	    		result = result.substring(j, result.length());
    	    		break;
    	    	}
    	    }
    	    System.out.println(result);
	        a = result;
	        if(result.equals("1")) {
	            return 1;
	        } else if(result.equals("3")) {
	            return 0;
	        }
	    }
	}
	
	public static void main(String args[]) {
		System.out.println(power("18446744073709551616"));
	}
}
