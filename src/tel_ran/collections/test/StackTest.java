package tel_ran.collections.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.collections.Stack;
import tel_ran.collections.StackUseHashMap;

public class StackTest {
	Stack stack;
	//StackUseHashMap stack;
	int[] expecteds = {17,20,5,15,10};
	@Before
	public void setUp() throws Exception {
		stack = new Stack();               
		//stack = new StackUseHashMap();    
		
          stack.push(10);
          stack.push(15);
          stack.push(5);
          stack.push(20);
          stack.push(17);
	}

	@Test
	public void testPushAndPop() {
		int[] actual = new int[5];
		for(int i = 0; i < actual.length; i++){
			actual[i] = stack.pop();
		}
		assertArrayEquals(expecteds,actual);
	}
	@Test
	public void testGetMax(){
		assertEquals(20, stack.getMax());
		stack.push(100);
		assertEquals(100, stack.getMax());
		stack.push(100);
		assertEquals(100, stack.getMax());
		assertEquals(100, stack.pop());
		assertEquals(100, stack.getMax());
		assertEquals(100, stack.pop());
		assertEquals(20, stack.getMax());
		stack.pop();
		assertEquals(20, stack.getMax());
		stack.pop();
		assertEquals(15, stack.getMax());
		stack.pop();
		assertEquals(15, stack.getMax());
		stack.pop();
		assertEquals(10, stack.getMax());
		stack.pop();
		try{
			stack.getMax();
		}catch(Exception e){/*fail("No Max!");*/};
		try{
			stack.pop();
		}catch(Exception e){/*fail("No Element!");*/};
	}
}
