package Lab1;

import java.util.Iterator;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int[] arr2 = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			arr2[i] = array[i];
			arr2[arr2.length - 1 - i] = array[i];
		}
		return arr2;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int[] removeDuplicates() {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length - 2; j++) {
				if (array[i] == array[j]) {
					count++;
					for (int k = j; k < array.length - 1; k++) {
						array[k] = array[k + 1];
					}
				}
			}
		}
		int[] arr1 = new int[array.length - count];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = array[i];
		}
		return arr1;
	}

	///
	public int[] getMissingValues() {
		int k = 0;
		int[] arr1 = new int[array.length];
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] != 1) {
				arr1[k] = array[i + 1] - 1;
				k++;
			}
		}
		int[] arr2 = new int[k];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

	public int[] fillMissingValues(int k) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == -1) {
				if (k % 2 == 0) {
					int s = 0;
					for (int j = 1; j <= k / 2; j++) {
						s += array[i - j] + array[i + j];
					}
					array[i] = s / k;
				} else {
					int a = 0;
					int b = 0;
					for (int j = 1; j <= k / 2; j++) {
						a += array[i - j];
						b += array[i + j];
					}
					for (int j = 1; j <= k / 2 + 1; j++) {
						a += array[i + j];
						b += array[i - j];
					}
					if (a > b)
						array[i] = b / k;
					array[i] = a / k;
				}
			}
		}
		return array;

	}

	public static void main(String[] args) {
		MyArray arr = new MyArray(new int[] { 1, 2, 3 });
		MyArray arr2 = new MyArray(new int[] { 1, 3, 5, 1, 3, 7, 9, 8 });
		MyArray arr3 = new MyArray(new int[] { 11, 12, 13, 14, 16, 17, 19, 20 });
		MyArray arr4 = new MyArray(new int[] { 10, 11, 12, -1, 14, 10, 17, 19, 20 });
		print(arr.mirror());
		print(arr2.removeDuplicates());
		print(arr3.getMissingValues());
		print(arr4.fillMissingValues(3));
	}
}
