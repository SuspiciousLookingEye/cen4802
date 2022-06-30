import static org.junit.Assert.*;

import org.junit.Test;

public class DemoClassTest {

	@Test
	public void testCreateArray() {
		int [] testArray = DemoClass.createArray(50);
		assertEquals(50,testArray.length);
		assertNotNull(testArray.length);
	}

	@Test
	public void testSortArray() {
		int [] testArray = {9,-1,9,50,21,88,20,48,-5,0,31,67,0,55,100};
		DemoClass.sortArray(testArray);
		int [] correctArray = {-5,-1,0,0,9,9,20,21,31,48,50,55,67,88,100};
		assertArrayEquals(correctArray,testArray);
		
	}

	@Test
	public void testSearchArray() {
		int [] testArray = {-5,-1,0,0,9,9,20,21,31,48,50,55,67,88,100};
		assertTrue(DemoClass.searchArray(testArray, 0));
		assertTrue(DemoClass.searchArray(testArray, 55));
		assertFalse(DemoClass.searchArray(testArray, -2));
		assertFalse(DemoClass.searchArray(testArray, 94));
	}

	@Test
	public void testCountArray() {
		int [] testSingleInstanceArray = {1,5,8,24,49,99,156};
		int [][] singleInstanceOutputArray = DemoClass.countArray(testSingleInstanceArray);
		assertNotNull(singleInstanceOutputArray);
		assertArrayEquals(testSingleInstanceArray,singleInstanceOutputArray[0]);
		int[] singleInstanceFrqArray = {1,1,1,1,1,1,1};
		assertArrayEquals(singleInstanceFrqArray,singleInstanceOutputArray[1]);
		
		int [] testMultiInstanceArray = {1,1,8,24,8,99,99};
		int [][] MultiInstanceOutputArray = DemoClass.countArray(testMultiInstanceArray);
		assertNotNull(MultiInstanceOutputArray);
		assertArrayEquals(testMultiInstanceArray,MultiInstanceOutputArray[0]);
		int[] MultiInstanceFrqArray = {2,-1,2,1,-1,2,-1};
		assertArrayEquals(MultiInstanceFrqArray,MultiInstanceOutputArray[1]);
		
		int [] testAllEqualInstanceArray = {7,7,7,7,7,7,7};
		int [][] AllEqualInstanceOutputArray = DemoClass.countArray(testAllEqualInstanceArray);
		assertNotNull(AllEqualInstanceOutputArray);
		assertArrayEquals(testAllEqualInstanceArray,AllEqualInstanceOutputArray[0]);
		int[] AllEqualInstanceFrqArray = {7,-1,-1,-1,-1,-1,-1};
		assertArrayEquals(AllEqualInstanceFrqArray,AllEqualInstanceOutputArray[1]);
	}

	@Test
	//NOTE: Test functions in JUnit 5. Does not function in JUnit 4 and below. This was developed in JUnit 4!
	public void testStatArray() {
		int [] testSingleInstanceArray = {1,6,8,24,49,99,156};
		double [] SingleInstanceOutputArray = DemoClass.statArray(testSingleInstanceArray);
		assertNotNull(SingleInstanceOutputArray);
		int[] SingleInstanceCorrectArray = {49,1,156};
		assertEquals(SingleInstanceCorrectArray,SingleInstanceOutputArray);
		
		int [] testAllEqualInstanceArray = {7,7,7,7,7,7,7};
		double [] AllEqualInstanceOutputArray = DemoClass.statArray(testAllEqualInstanceArray);
		assertNotNull(AllEqualInstanceOutputArray);
		int[] AllEqualInstanceCorrectArray = {7,7,7};
		assertEquals(AllEqualInstanceCorrectArray,AllEqualInstanceOutputArray);
	}

}
