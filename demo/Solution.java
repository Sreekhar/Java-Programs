package demo;

import java.util.ArrayList;
import java.util.List;

public class Solution {        
	public List<Integer> cellCompete(int[] states, int days) {
	 	List<Integer> finalCellStructure = new ArrayList<>();
	 	for(int iCount = 0; iCount < days; iCount++) {
	 		int[] tempStates = states;
	 		int[] updatedStates = addZeroes(states);
		 	for(int jCount = 1; jCount < updatedStates.length - 1; jCount++) {
		 		if(tempStates[jCount - 1] == tempStates[jCount + 1]) {
		 			states[jCount] = 0;
		 		} else {
		 			states[jCount] = 1;
		 		}
		 	}
	 	}
	 	for(int iCount = 0; iCount < states.length; iCount++) {
	 		finalCellStructure.add(states[iCount]);
	 	}
		return finalCellStructure;
	}
	
	public int[] addZeroes(int[] states) {
		int[] newCellStructure = new int[10];
		newCellStructure[0] = 0;
	 	for(int iCount = 0; iCount < states.length; iCount++) {
	 		newCellStructure[iCount + 1] = states[iCount];
	 	}
	 	newCellStructure[9] = 0;
	 	return newCellStructure;
	}
}