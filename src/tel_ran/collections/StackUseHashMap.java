package tel_ran.collections;

import java.util.*;

public class StackUseHashMap {
	private class ValueAndCounter{
		Integer value;
		Integer counter;
		public ValueAndCounter(Integer value, Integer counter) {
			super();
			this.value = value;
			this.counter = counter;
		}
	}
	LinkedList<Integer> list = new LinkedList<>();
	HashMap<Integer,ValueAndCounter> mapOfMax = new HashMap<>();
	Integer currentMax = null;
	
	public void push(int number){
		if(currentMax == null){
			currentMax = number;
			mapOfMax.put(number, new ValueAndCounter(null, 1));
			list.addFirst(number);
			return;
		}
		Integer counter = null;
		Integer value = null;
		if(currentMax <= number){
			if(!mapOfMax.containsKey(number)){
				counter = 0;
				value = currentMax;
			}
			else {
				ValueAndCounter temp = mapOfMax.get(number);
				counter = temp.counter;
				value = temp.value;
			}
			mapOfMax.put(number, new ValueAndCounter(value, counter + 1));
			currentMax = number;
			
		}
		list.addFirst(number);
	}
	public int pop(){
		if(currentMax == null){
			throw new NoSuchElementException();			
		}
		int res = list.removeFirst();
		if(res == currentMax){
			int counter = mapOfMax.get(res).counter;
			if(counter == 1 )
				currentMax = mapOfMax.remove(res).value;	
			else {
				ValueAndCounter temp = mapOfMax.remove(res);
				Integer valueTemp = temp.value;
				Integer counterTemp = temp.counter - 1;
				mapOfMax.put(res, new ValueAndCounter(valueTemp, counterTemp));
			}
				
		}
		return res;
	}
	public int getMax(){
		if(currentMax == null){
			throw new NoSuchElementException();			
		}
		return currentMax;
	}
}
