package org.AD_Praktikum_Aufg7.HeapSort;

public class Heap {

	private static int total;

	private static void swap(Comparable[] arr, int a, int b) {
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private static void heapify(Comparable[] arr, int i) {
		int lft = i * 2;
		int rgt = lft + 1;
		int grt = i;

		if (lft <= total && arr[lft].compareTo(arr[grt]) > 0)
			grt = lft;
		if (rgt <= total && arr[rgt].compareTo(arr[grt]) > 0)
			grt = rgt;
		if (grt != i) {
			swap(arr, i, grt);
			heapify(arr, grt);
		}
	}

	public static void sort(Comparable[] arr) {
		total = arr.length - 1;

		for (int i = total / 2; i >= 0; i--)
			heapify(arr, i);

		for (int i = total; i > 0; i--) {
			swap(arr, 0, i);
			total--;
			heapify(arr, 0);
		}
	}
}