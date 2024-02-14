package sortingAlgorithms;

public class Alg {
	
	public static <T extends Comparable<T>> void selection(T[] arr) throws IllegalArgumentException {
		int len = arr.length;
		if(len == 0)
			throw new IllegalArgumentException("arr must contain elements");
		
		
		for(int i = 0; i < len; i++) {
			int smallest = i;
			for(int j = i; j < len; j++) {
				if(arr[smallest].compareTo(arr[j]) > 0)
					smallest = j;
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
			T current = arr[i];
			int previous = i-1;
			
			while(previous >= 0 && arr[previous].compareTo(current) > 0) {
				arr[previous+1] = arr[previous];
				previous--;
			}
			arr[previous+1] = current;
		}
	}
	
	public static void mergeSort(Integer[] arr) throws IllegalArgumentException {
		int length = arr.length;
		
		if(length == 0) 
			throw new IllegalArgumentException("arr must contain elements");
		if(length == 1)
			return;
		
		int middle = length/2;
		Integer[] leftArray =  new Integer[middle];
		Integer[] rightArray = new Integer[length - middle];
		
		int r = 0;
		for(int i = 0; i < length; i ++) {
			if(i < middle) {
				leftArray[i] = arr[i];
			}else {
				rightArray[r] = arr[i];
				r++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(arr, leftArray, rightArray);
	}
	
	private static void merge(Integer[] arr, Integer[] left, Integer[] right) {
		int l = 0, r = 0, i = 0;
		int leftSize = left.length;
		int rightSize = right.length;
		
		while(l < leftSize && r < rightSize) {
			if(left[l].compareTo(right[r]) < 0) {
				arr[i] = left[l];
				i++; l++;
			}else {
				arr[i] = right[r];
				i++; r++;
			}
		}
		for(; l < leftSize; l++) {
			arr[i] = left[l];
			i++;
		}
		for(; r < rightSize; r++) {
			arr[i] = right[r];
			i++;
		}
		
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end) throws IllegalArgumentException {
		if(arr.length == 0) {
			throw new IllegalArgumentException("arr must contain elements");
		}
		if(end <= start) 
			return;
		
		int pivot = partition(arr, start, end);
		quickSort(arr, start, pivot-1);
		quickSort(arr, pivot+1, end);
		
	}
	
	private static <T extends Comparable<T>> int partition(T[] arr, int start, int end) {
		T pivot = arr[end];
		int i = start -1;
		
		for(int j = start; j < end; j++) {
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
 			if(arr[middle].compareTo(goal) == 0) {
				return middle;
			} else if(arr[middle].compareTo(goal) > 0) {
				right = middle-1;
			}else {
				left = middle+1;
			}
		}	
		return -1;
	}
}
