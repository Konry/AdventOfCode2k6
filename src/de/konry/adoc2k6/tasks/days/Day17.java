package de.konry.adoc2k6.tasks.days;

import java.sql.Array;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day17 extends AdventOfCodeExtends {
	int[][] arr = new int[4][4];
	int startX = 0, startY = 0;

	@Override
	public void runPartOne() {
		// TODO Auto-generated method stub
		String temp = lines[0];

		temp = Day14.md5Java(temp);
		System.out.println(temp);
		
		boolean bb = true;
		while(bb){
			
		}

	}
	
	enum Direction {
		North, East, South, West
	}
	private boolean finisch(int x, int y){
		if(x == 3 &&  y == 3){
			return true;
		}
		return false;
	}
	
	
	private boolean checkWall(int x, int y, Direction direction){
		int tempX = x;
		int tempY = y;
		switch(direction){
		case North:
			tempY--;
			break;
		case East:
			tempX++;
			break;
		case South:
			tempY++;
			break;
		case West:
			tempX--;
			break;
		}

		if(tempX >= arr.length || tempX < 0){
			return false;
		}

		if(tempY >= arr[0].length || tempY < 0){
			return false;
		}
		
		x = tempX;
		y = tempY;
		
		return true;
	}

	private boolean checkWay(String hash, int direction) {
		int hex = (int) hash.charAt(direction) - 65;
		if (hex >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void runPartTwo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runTestsOne() {
		String[] s = new String[] { "ihgpwlah" };
		setLinesOfFile(s);
//		runPartOne();
		System.out.println(checkWay("agcd", 1));
		System.out.println(checkWay("1234", 0));
		System.out.println();
		System.out.println(checkWall(0, 0, Direction.North));
		System.out.println(checkWall(0, 0, Direction.East));
		System.out.println(checkWall(0, 0, Direction.South));
		System.out.println(checkWall(0, 0, Direction.West));
	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub

	}
}
