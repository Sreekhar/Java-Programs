package Amazon;

import java.util.*;

public class LogListFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> reorderLines(int logFileSize, List<String> logfile) {
		Map<String, String> logNumberFileMap = new HashMap<>();
		Map<String, String> logAlphabetFileMap = new TreeMap<>();
		List<String> result = new ArrayList<>();
		String previousToken = null;
		String key = null; 
		String logEachLine = null;
		for(String token: logfile) {
			if(token.contains("[a-zA-Z]+") && token.contains("[0-9]+")) {
				if(logEachLine.isEmpty() == false  && previousToken.contains("[a-zA-Z]+")) {
					logAlphabetFileMap.put(key, logEachLine);
				}
				if(logEachLine.isEmpty() == false && previousToken.contains("[0-9]+")) {
					logNumberFileMap.put(key, logEachLine);
				}
				logEachLine = null;
				key = token;
			} else {
				previousToken = token;
				logEachLine = token + ' ';
			}
		}
		if(previousToken.contains("[a-zA-Z]+")) {
			logAlphabetFileMap.put(key, logEachLine);
		} else {
			logNumberFileMap.put(key, logEachLine);
		}
		return result;
	}

}
