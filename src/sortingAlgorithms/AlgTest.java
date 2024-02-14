package sortingAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlgTest {
	Integer[] empty, one, small, medium, oneSorted, smallSorted, mediumSorted;
	
	@BeforeEach
	void setup() {
		empty = new Integer[] {};
		one = new Integer[] {5};
		small = new Integer[] {10, -3, 1};
		medium = new Integer[] {5, 5, -3, 10, 21, 2, 100, 25, -455};
		oneSorted = new Integer[] {5};
		smallSorted = new Integer[] {-3, 1, 10};
		mediumSorted = new Integer[] {-455, -3, 2, 5, 5, 10, 21, 25, 100};
	}
	
	@Test
	void testSelection() {
		assertThrows(IllegalArgumentException.class, () -> {Alg.selection(empty);});
		Alg.selection(one);
		Alg.selection(small);
		Alg.selection(medium);
		assertArrayEquals(oneSorted, one);
		assertArrayEquals(smallSorted, small);
		assertArrayEquals(mediumSorted, medium);
	}
	
	@Test
	void testInsertion() {
		assertThrows(IllegalArgumentException.class, () -> {Alg.insertion(empty);});
		Alg.insertion(one);
		Alg.insertion(small);
		Alg.insertion(medium);
		assertArrayEquals(oneSorted, one);
		assertArrayEquals(smallSorted, small);
		assertArrayEquals(mediumSorted, medium);
	}

	@Test
	void testMergeSort() {
		assertThrows(IllegalArgumentException.class, () -> {Alg.mergeSort(empty);});
		Alg.mergeSort(one);
		Alg.mergeSort(small);
		Alg.mergeSort(medium);
		assertArrayEquals(oneSorted, one);
		assertArrayEquals(smallSorted, small);
		assertArrayEquals(mediumSorted, medium);
	}
	
	@Test
	void testQuickSort() {
		assertThrows(IllegalArgumentException.class, () -> {Alg.quickSort(empty, 0, empty.length);});
		Alg.quickSort(one, 0, one.length-1);
		Alg.quickSort(small, 0, small.length-1);
		Alg.quickSort(medium, 0, medium.length-1);
		assertArrayEquals(oneSorted, one);
		assertArrayEquals(smallSorted, small);
		assertArrayEquals(mediumSorted, medium);
	}
	
	@Test
	void testBinarySearch() {

		assertEquals(0, Alg.binarySearch(oneSorted, 5));
		assertEquals(-1, Alg.binarySearch(oneSorted, 55));
		
		assertEquals(2, Alg.binarySearch(smallSorted, 10));
		assertEquals(-1, Alg.binarySearch(smallSorted, 100000));
		
		assertEquals(8, Alg.binarySearch(mediumSorted, 100));
		assertEquals(7, Alg.binarySearch(mediumSorted, 25));
		assertEquals(6, Alg.binarySearch(mediumSorted, 21));
		assertEquals(5, Alg.binarySearch(mediumSorted, 10));

		assertEquals(1, Alg.binarySearch(mediumSorted, -3));
		assertEquals(0, Alg.binarySearch(mediumSorted, -455));
		assertEquals(-1, Alg.binarySearch(mediumSorted, -44455));
		
		
	}
}
