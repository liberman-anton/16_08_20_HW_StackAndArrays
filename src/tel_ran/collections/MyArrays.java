package tel_ran.collections;

import java.util.*;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @return true only if there is one possible swap for being array sorted
	 */
	static public boolean isOneSwapSorted(int[] array){
		boolean res = false;
		int[] arrayClone = array.clone();
		Arrays.sort(arrayClone);
		Integer firstNumber = null;
		Integer secondNumber = null;
		int indexFirst = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] != arrayClone[i] && firstNumber == null){
				firstNumber = array[i];
				secondNumber = arrayClone[i];
				indexFirst = i;
			}
			else{
				if(array[i] != arrayClone[i] && firstNumber != null){
					if(secondNumber == array[i]){
						array[i] = firstNumber;
						array[indexFirst] = secondNumber;
						res = compareMyArrays(array,arrayClone);
						array[i] = secondNumber;
						array[indexFirst] = firstNumber;
						return res;
					}
					return false;
				}
			}
		}
		return false;
	}

	private static boolean compareMyArrays(int[] array1, int[] array2) {
		if(array1.length != array2.length)
			return false;
		for(int i = 0; i < array1.length; i++){
			if(array1[i] != array2[i])
				return false;
		}
		return true;
	}
}
