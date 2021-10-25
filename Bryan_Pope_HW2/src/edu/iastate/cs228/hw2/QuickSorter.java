package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.InputMismatchException;

/**
 *  
 * @author Bryan Pope
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the
 * lecture.
 *
 */

public class QuickSorter extends AbstractSorter {

	// Other private instance variables if you need ...

	/**
	 * Constructor takes an array of points. It invokes the superclass constructor,
	 * and also set the instance variables algorithm in the superclass.
	 * 
	 * @param pts input array of integers
	 */
	public QuickSorter(Point[] pts) {
		this.points = pts;
		this.algorithm = "quicksort";
	}

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.
	 * 
	 */
	@Override
	public void sort() {
		quickSortRec(0, this.points.length - 1);
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first starting index of the subarray
	 * @param last  ending index of the subarray
	 */
	private void quickSortRec(int first, int last) {
		// This doesn't let the first index go past the last
		if (first >= last) {
			return;
		}
		int part = partition(first, last);
		quickSortRec(first, part - 1);
		quickSortRec(part + 1, last);
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last) {
		Point pivot = this.points[last];
		int i = first - 1;

		for (int j = first; j < last; j++) {
			// this compares the points, and every time the point is greater than the pivot,
			// they swap
			if (this.pointComparator.compare(this.points[j], pivot) <= 0) {
				i++;
				super.swap(i, j);
			}
		}
		super.swap(i + 1, last);
		return i + 1;
	}

	// Other private methods if needed ...
}
