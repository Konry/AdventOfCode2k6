package de.konry.adoc2k6.tasks.d3;

import java.util.Arrays;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;
import jdk.nashorn.internal.runtime.arrays.NumericElements;

public class Day3 extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		int correctTriangel = 0, incorrectTriangel = 0;
		int counter = 0;
		for (String line : lines) {
			int[] numbers = new int[] { 0, 0, 0 };
			numbers[0] = Integer.parseInt(line.substring(0, 5).replace(" ", ""));
			numbers[1] = Integer.parseInt(line.substring(5, 10).replace(" ", ""));
			numbers[2] = Integer.parseInt(line.substring(10, 15).replace(" ", ""));

			// System.out.println(numbers[0] + " " + numbers[1] + " " +
			// numbers[2]);
			boolean correct = false;
			if (numbers[0] <= numbers[1]) {
				/* number[0] smaller */
				if (numbers[1] <= numbers[2]) {
					/* number[1] smaller */
					if (numbers[0] + numbers[1] > numbers[2]) {
						correctTriangel += 1;
						correct = true;
					} else {
						incorrectTriangel += 1;
					}
				} else {
					/* number[2] smaller */
					if (numbers[0] + numbers[2] > numbers[1]) {
						correctTriangel += 1;
						correct = true;
					} else {
						incorrectTriangel += 1;
					}
				}
			} else {
				/* number[1] smaller */
				if (numbers[0] < numbers[2]) {
					/* number[0] smaller */
					if (numbers[0] + numbers[1] > numbers[2]) {
						correctTriangel += 1;
						correct = true;
					} else {
						incorrectTriangel += 1;
					}
				} else {
					/* number[2] smaller */
					if (numbers[1] + numbers[2] > numbers[0]) {
						correctTriangel += 1;
						correct = true;
					} else {
						incorrectTriangel += 1;
					}
				}
			}

			// s
		}
		System.out.println("correct " + correctTriangel);
		System.out.println("incorrect " + incorrectTriangel);

		// try 1 1304
		// try 2 983 -> before wrong of last if was wrong // c.a. 31 min
	}

	private static boolean isTriangle( int[] sides ) {
	    Arrays.sort( sides );

	    if ( sides[0] + sides[1] > sides[2] ) {
	      return true;
	    }

	    return false;
	  }
	
	@Override
	public void runPartTwo() {
		int correctTriangle = 0, incorrectTriangel = 0;
		int counterNumber = 0;

		int[][] numbers = new int[3][3];
		
		int lineCounter = 0;

		for (String line : lines) {
			numbers[0][counterNumber] = Integer.parseInt(line.substring(0, 5).replace(" ", ""));
			numbers[1][counterNumber] = Integer.parseInt(line.substring(5, 10).replace(" ", ""));
			numbers[2][counterNumber] = Integer.parseInt(line.substring(10, 15).replace(" ", ""));
			
			lineCounter += 1;

			counterNumber++;
			if (counterNumber == 3) {
				if(isTriangle(numbers[0])){
					correctTriangle ++;
				}else {
					incorrectTriangel ++;
				}
				if(isTriangle(numbers[1])){
					correctTriangle ++;
				}else {
					incorrectTriangel ++;
				}
				if(isTriangle(numbers[2])){
					correctTriangle ++;
				}else {
					incorrectTriangel ++;
				}
				

				counterNumber = 0;
				numbers = new int[3][3];
			}

		}
		System.out.println("correct " + correctTriangle );
		System.out.println("incorrect " + incorrectTriangel);
		System.out.println(lineCounter + " " +( correctTriangle + incorrectTriangel));
		// result 636 low
		// 1908 wrong high
		// 600 low
		// 1836, dont ignore the triangles
	}

	@Override
	public void runTestsOne() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub

	}

}
