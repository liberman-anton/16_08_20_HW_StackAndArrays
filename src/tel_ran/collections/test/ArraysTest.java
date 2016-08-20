package tel_ran.collections.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import tel_ran.collections.Arrays;
import tel_ran.collections.MyArrays;
	
public class ArraysTest {

	int array1[] = {1,4,7,6,5};//true
	int array2[] = {1,4,6,2};//false
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOneSorted() {
		assertTrue(MyArrays.isOneSwapSorted(array1));
		assertFalse(MyArrays.isOneSwapSorted(array2));
	}

}
