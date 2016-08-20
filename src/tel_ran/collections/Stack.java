package tel_ran.collections;

import java.util.*;

public class Stack {
//pop-remove, push-add, getMax-max element O(1);
	private class Element{
		public int value;
		public Element below;
		public Element(int value){
	        this.value = value;
	    }
	}
	private class MaxElement extends Element{
		public MaxElement lastMax;
		public MaxElement(int value, MaxElement lastMax){
	        super(value);
	        this.lastMax = lastMax;
	    }
	}
	private Element top;
    private MaxElement currentMax;
	
	/**
	 * adding number at top of a stack(last input - first output)
	 * @param number
	 */
	public void push(int number){
		Element item = new Element(number);
		if(this.currentMax == null){
			firstPush(item);
			return;
		}
		if(currentMax.value <= item.value){
            MaxElement newMax = new MaxElement(item.value, this.currentMax);
            pushAndSetNewMax(newMax);
            return;
        }
		item.below = this.top;
        this.top = item;
	}
		
	private void pushAndSetNewMax(MaxElement newMax) {
		newMax.below = this.top;
        this.currentMax = newMax;
        this.top = this.currentMax;
	}

	private void firstPush(Element item){
            this.currentMax = new MaxElement(item.value, null);
            this.top = this.currentMax;       
	}
	/**
	 * removes number from the stack top
	 * @return removed number
	 */
	public int pop(){
		//NoSuchElementException - if stack empty	
		if(this.currentMax == null){
            throw new NoSuchElementException();
        }
        Element ret = this.top;
        if(this.top == this.currentMax){
            this.currentMax = this.currentMax.lastMax;
            this.top = this.top.below;
            return ret.value;
        }
        this.top = ret.below;
        return ret.value;
	}
	/**
	 * 
	 * @return maximal value existing in a stack
	 */
	public int getMax(){
		if(currentMax == null)
			throw new NoSuchElementException();
		return currentMax.value;
	}
}

//Быстрая сортировка
//рекурсия делим пополам и сортируем половину
//
//один массив: истина - если для его сортировки нужна только одна замена N*LogN 