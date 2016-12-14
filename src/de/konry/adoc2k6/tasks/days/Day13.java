package de.konry.adoc2k6.tasks.days;

import java.util.ArrayList;
import java.util.HashMap;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day13 extends AdventOfCodeExtends {
	private ArrayList<String> list = new ArrayList<>();

	final int maxValue = 100000;
	final int maxEmpty = 10000;

	private int[][] array = new int[200][200];
	int minSteps = maxValue;

	@Override
	public void runPartOne() {
		fillArray();
		int x = 1;
		int y = 1;

		int way = maxValue;
		way = takeWay(x, y, 0);
		System.out.println("Aufgabe 1: steps: " + minSteps);
		System.out.println("Aufgabe 2: distinct locations "+ list.size());

	}

	private int takeWay(int x, int y, int depth) {
		int returnInt = 0;

		if (depth > 150) {
			return -1;
		}
		if (x >= 0 && y >= 0 && lookForNumber(checkBorder(x, y))) {

			if (array[x][y] <= depth) {
				return array[x][y];
			}

			array[x][y] = depth;

			if (x == targetX && y == targetY) {
				if (minSteps >= depth) {
					minSteps = depth;
				}
				// System.out.println("found " + targetX + " " + targetY + " ###
				// " + depth);
				return depth;
			}

			if (!list.contains(x + "-" + y) && depth <= 50)
				list.add(x + "-" + y);
			int min = maxValue;

			depth++;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++)
					if (!(i == j || (i == 1 && j == -1) || (i == -1 && j == 1))) {
						returnInt = takeWay(x + i, y + j, depth) + 1;
					}
				if (min <= returnInt) {
					returnInt = min;
				}
			}
		}
		return returnInt;

	}

	@Override
	public void runPartTwo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runTestsOne() {
		targetX = 31;
		targetY = 39;
		designValue = 1352;
		// targetX = 7;
		// targetY = 4;
		// designValue = 10;
		// 83 too low
		// 101 too high
		// 90

		// task 2
		// result 135
	}

	@Override
	public void runTestsTwo() {

	}

	private int targetX, targetY;

	private void fillArray() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (lookForNumber(checkBorder(i, j))) {
					array[i][j] = maxEmpty;
				} else {
					array[i][j] = maxValue;
				}
			}
		}
	}

	private int checkBorder(int x, int y) {
		return x * x + 3 * x + 2 * x * y + y + y * y + designValue;
	}

	private int designValue;

	private boolean lookForNumber(int number) {
		String temp = Integer.toBinaryString(number);
		int sum = 0;

		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '1')
				sum++;
		}
		if (sum % 2 == 0) {
			// even
			return true;
		} else {
			// odd
			return false;
		}
	}
}
