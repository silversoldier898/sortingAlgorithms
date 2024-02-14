package sortingAlgorithms;

public class Alg {
	
	public static <T extends Comparable<T>> void selection(T[] arr) throws IllegalArgumentException {
		int len = arr.length;
		if(len == 0)
			throw new IllegalArgumentException("array must contain elements");
		

		for(int i = 0; i < len; i++) {
			int smallest = i;
			for(int j = i; j < len; j++) {
				if(arr[j].compareTo(arr[smallest]) < 0) {
					smallest = j;
				}
			}
			T temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
	}
	
	public static <T extends Comparable<T>> void insertion(T[] arr) throws IllegalArgumentException {
		if(arr.length == 0 )
			throw new IllegalArgumentException("arr must contain elements");
		if(arr.length == 1) {
			return;
		}
		for(int i = 1; i < arr.length; i++) {
			int current = i;
			int previous = i-1;
			while(previous >= 0 && arr[current].compareTo(arr[previous]) < 0) {
				T temp = arr[current];
				arr[current] = arr[previous];
				arr[previous] = temp;
				current--; previous--;
			}
		}
		
	}
	
	public static void mergeSort(Integer[] arr) throws IllegalArgumentException {
		if(arr.length == 0)
			throw new IllegalArgumentException("array must contain elements");
		mergeSortR(arr, 0, arr.length-1);

	}
	
	private static void mergeSortR(Integer[] arr, int start, int end) {
		if(start >= end)
			return;
		
		int mid = start + (end - start)/2;
		mergeSortR(arr, start, mid);
		mergeSortR(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}
	
	private static void merge(Integer[] arr, int start, int middle, int end) {
		
		int leftSize = (middle - start + 1);
		int rightSize = end - middle;
		Integer[] left = new Integer[leftSize];
		Integer[] right = new Integer[rightSize];
		
		int index = start;
		for(int i = 0; i < leftSize; i++) {
			left[i] = arr[index];
			index++;
		}
		for(int j = 0; j < rightSize; j++) {
			right[j] = arr[index];
			index++;
		}
		
		int i = 0; int j = 0; index = start;
		while(i < leftSize && j < rightSize) {
			if(left[i].compareTo(right[j]) < 0) {
				arr[index] = left[i];
				i++;
			}else {
				arr[index] = right[j];
				j++;
			}
			index++;
		}
		
		for(; i < leftSize; i++) {
			arr[index] = left[i];
			index++;
		}
		for(; j < rightSize; j++) {
			arr[index] = right[j];
			index++;
		}
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end) throws IllegalArgumentException {
		if(arr.length == 0) {
			throw new IllegalArgumentException("Array must contain elements");
		}
		if(start >= end) return;
		
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot -1);
		quickSort(arr, pivot + 1, end);
		
	}
	
	private static <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
		T pivot = arr[end];
		int i = start - 1;
		for(int j = start; j < end; j ++) {
			if(arr[j].compareTo(pivot) < 0) {
				i++;
				T temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		i++;
		T temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;
		
		return i;
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] arr, T goal) {
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
			int middle = left + (right - left)/2;
			if(goal.equals(arr[middle]))
				return middle;
			if(goal.compareTo(arr[middle]) < 0) {
				right = middle-1;
			}else {
				left = middle+1;
			}
		}
		return -1;
	}
}
