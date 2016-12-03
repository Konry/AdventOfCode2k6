package de.konry.adoc2k6.tasks.d1;

import java.util.ArrayList;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;
import de.konry.adoc2k6.tasks.AdventOfCodeExtends.ChooseSet;

public class DayOne extends AdventOfCodeExtends {

	enum Direction {
		North, East, South, West
	}

	@Override
	public void runTestsOne() {
		String[] temp = new String[] { "R2", "L3" };
		runPartOne(temp, ChooseSet.CSVStringValues);

		temp = new String[] { "R2", "R2", "R2" };
		runPartOne(temp, ChooseSet.CSVStringValues);

		temp = new String[] { "R5", "L5", "R5", "R3" };
		runPartOne(temp, ChooseSet.CSVStringValues);

		temp = new String[] { "R5", "R5", "R5", "R5", "L5", "L5", "L5", "L5" };
		runPartOne(temp, ChooseSet.CSVStringValues);
	}

	public void runTestsTwo() {
		String[] temp = new String[] { "R8", "R4", "R4", "R8" };
		runPartTwo(temp, ChooseSet.CSVStringValues);
	}

	@Override
	public void runPartOne() {
		System.out.println("Run Aufgabe 1a");
		Direction direction = Direction.North;

		int countN = 0;
		int countE = 0;
		int countW = 0;
		int countS = 0;

		for (String s : csvStringValues) {
			String temp = "";
			switch (direction) {
			case North:
				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countW += Integer.parseInt(temp);
					direction = Direction.West;
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countE += Integer.parseInt(temp);
					direction = Direction.East;
				} else {
					System.out.println(temp);
				}
				break;
			case East:
				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countN += Integer.parseInt(temp);
					direction = Direction.North;
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countS += Integer.parseInt(temp);
					direction = Direction.South;
				} else {
					System.out.println(temp);
				}
				break;
			case South:
				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countE += Integer.parseInt(temp);
					direction = Direction.East;
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countW += Integer.parseInt(temp);
					direction = Direction.West;
				} else {
					System.out.println(temp);
				}
				break;
			case West:

				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countS += Integer.parseInt(temp);
					direction = Direction.South;
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countN += Integer.parseInt(temp);
					direction = Direction.North;
				} else {
					System.out.println(temp);
				}
				break;
			}

			System.out.print(s + " ");
			System.out.print(direction + " ");
			System.out.print(countN + " ");
			System.out.print(countE + " ");
			System.out.print(countS + " ");
			System.out.println(countW);

		}
		System.out.println(countN);
		System.out.println(countE);
		System.out.println(countS);
		System.out.println(countW);
		System.out.println(Math.abs(Math.abs(countN - countS) + Math.abs(countW - countE)));

		// result 1 = 20 wrong
		// result 2 = 150 typo
		// result 3 = 250 c.a. 40 min
	}

	@Override
	public void runPartTwo() {
		System.out.println("Run Aufgabe 1b");
		Direction direction = Direction.North;

		int[] currentPositionXY = new int[] { 0, 0 };
		ArrayList<String> alreadyVisited = new ArrayList<>();

		int countN = 0;
		int countE = 0;
		int countW = 0;
		int countS = 0;

		for (String s : csvStringValues) {
			boolean found = false;
			String temp = "";
			switch (direction) {
			case North:
				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countW += Integer.parseInt(temp);
					found = subFromY(alreadyVisited, currentPositionXY, temp);
					direction = Direction.West;
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countE += Integer.parseInt(temp);
					found = addToY(alreadyVisited, currentPositionXY, temp);
					direction = Direction.East;
				} else {
					System.out.println(temp);
				}
				break;
			case East:
				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countN += Integer.parseInt(temp);
					direction = Direction.North;
					found = addToX(alreadyVisited, currentPositionXY, temp);
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countS += Integer.parseInt(temp);
					direction = Direction.South;
					found = subFromX(alreadyVisited, currentPositionXY, temp);
				} else {
					System.out.println(temp);
				}
				break;
			case South:
				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countE += Integer.parseInt(temp);
					direction = Direction.East;
					found = addToY(alreadyVisited, currentPositionXY, temp);
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countW += Integer.parseInt(temp);
					direction = Direction.West;
					found = subFromY(alreadyVisited, currentPositionXY, temp);
				} else {
					System.out.println(temp);
				}
				break;
			case West:

				if (s.startsWith("L")) {
					temp = s.replace("L", "");
					countS += Integer.parseInt(temp);
					direction = Direction.South;
					found = subFromX(alreadyVisited, currentPositionXY, temp);
				} else if (s.startsWith("R")) {
					temp = s.replace("R", "");
					countN += Integer.parseInt(temp);
					direction = Direction.North;
					found = addToX(alreadyVisited, currentPositionXY, temp);
				} else {
					System.out.println(temp);
				}
				break;
			}

			if (found) {

				System.out.println("visited: " + currentPositionXY[0] + "-" + currentPositionXY[1]);
				return;
			}

		}

		System.out.println(Math.abs(Math.abs(countN - countS) + Math.abs(countW - countE)));
		// result 1 : 269
		// result 2 : 151 // c.a. 30 min
	}

	private boolean subFromX(ArrayList<String> alreadyVisited, int[] currentPositionXY, String temp) {
		for (int i = 1; i <= Integer.parseInt(temp); i++) {

			if (alreadyVisited.contains((currentPositionXY[0] - i) + "-" + currentPositionXY[1])) {
				System.out.println("visited: " + (currentPositionXY[0] - i) + "-" + currentPositionXY[1]);
				System.out.println(Math.abs((currentPositionXY[0] - i)) + Math.abs(currentPositionXY[1]));
				return true;
			}
			alreadyVisited.add((currentPositionXY[0] - i) + "-" + currentPositionXY[1]);
		}
		currentPositionXY[0] -= Integer.parseInt(temp);
		return false;
	}

	private boolean addToX(ArrayList<String> alreadyVisited, int[] currentPositionXY, String temp) {
		for (int i = 1; i <= Integer.parseInt(temp); i++) {

			if (alreadyVisited.contains((currentPositionXY[0] + i) + "-" + currentPositionXY[1])) {
				System.out.println("visited: " + (currentPositionXY[0] + i) + "-" + currentPositionXY[1]);
				System.out.println(Math.abs((currentPositionXY[0] + i)) + Math.abs(currentPositionXY[1]));
				return true;
			}
			alreadyVisited.add((currentPositionXY[0] + i) + "-" + currentPositionXY[1]);
		}
		currentPositionXY[0] += Integer.parseInt(temp);
		return false;
	}

	private boolean addToY(ArrayList<String> alreadyVisited, int[] currentPositionXY, String temp) {

		for (int i = 1; i <= Integer.parseInt(temp); i++) {

			if (alreadyVisited.contains(currentPositionXY[0] + "-" + (currentPositionXY[1] + i))) {
				System.out.println("visited: " + currentPositionXY[0] + "-" + (currentPositionXY[1] + i));
				System.out.println(Math.abs(currentPositionXY[0]) + Math.abs((currentPositionXY[1] + i)));
				return true;
			}
			alreadyVisited.add(currentPositionXY[0] + "-" + (currentPositionXY[1] + i));
		}
		currentPositionXY[1] += Integer.parseInt(temp);
		return false;
	}

	private boolean subFromY(ArrayList<String> alreadyVisited, int[] currentPositionXY, String temp) {
		for (int i = 1; i <= Integer.parseInt(temp); i++) {

			if (alreadyVisited.contains(currentPositionXY[0] + "-" + (currentPositionXY[1] - i))) {
				System.out.println("visited: " + currentPositionXY[0] + "-" + (currentPositionXY[1] - i));
				System.out.println(Math.abs(currentPositionXY[0]) + Math.abs((currentPositionXY[1] - i)));
				return true;
			}
			alreadyVisited.add(currentPositionXY[0] + "-" + (currentPositionXY[1] - i));
		}
		currentPositionXY[1] -= Integer.parseInt(temp);
		return false;
	}

}
