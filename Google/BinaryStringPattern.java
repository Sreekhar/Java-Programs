package Google;

public class BinaryStringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "???";
		String result = "";
		findPattern(pattern, result);
	}
	
	public static void findPattern(String pattern, String result) {
		if(pattern.length() > 0) {
			if(pattern.substring(0, 1).equals("?")) {
				result += "0";
				findPattern(pattern.substring(1, pattern.length()), result);
				result = result.substring(0, result.length() - 1);
				result += "1";
				findPattern(pattern.substring(1, pattern.length()), result);
			} else {
				result += pattern.substring(0, 1);
				findPattern(pattern.substring(1, pattern.length()), result);
			}
		} else {
			System.out.println(result);
			System.out.println(result.length());
			System.out.println("================");
		}
	}

}
