package de.konry.adoc2k6.tasks.days;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day8 extends AdventOfCodeExtends {

	boolean[][] codeDisplay = new boolean[6][50];

	@Override
	public void runPartOne() {
		codeDisplay = new boolean[6][50];
		
		for(String s : lines){
			if(s.startsWith("rect")){
				String[] split = s.substring(5).split("x");
				create(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			} else if(s.startsWith("rotate row")){
				String[] split = s.substring(5).split("\\s|=");
				rotateRow(Integer.parseInt(split[3]), Integer.parseInt(split[5]));
			} else if(s.startsWith("rotate column")){
				String[] split = s.substring(5).split("\\s|=");
				rotateCol(Integer.parseInt(split[3]), Integer.parseInt(split[5]));
			} else 
				System.err.println("ERROR");
		}

		display();
		
		// result 106 place 888
	}

	@Override
	public void runPartTwo() {
		// just change from Syso "O" to syso " " CFLELOYFCS rank 862

	}

	@Override
	public void runTestsOne() {
		String[] s = new String[]{"rect 3x2","rotate column x=1 by 1","rotate row y=0 by 4","rotate column x=1 by 1"};
		setLinesOfFile(s);
		runPartOne();

	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub

	}

	private void create(int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				codeDisplay[i][j] = true;
			}
		}
	}

	private void rotateRow(int row, int by) {
		int length = codeDisplay[0].length;
		boolean[] temp = new boolean[length];
		for (int i = length - 1; i >= 0; i--) {
			temp[i] = codeDisplay[row][i];
		}

		if (by > 0) {
			for (int i = length - 1; i >= 0; i--) {
				codeDisplay[row][i] = temp[((i - by) + length) % length];
			}
		}
	}

	private void rotateCol(int col, int by) {
		int length = codeDisplay.length;
		boolean[] temp = new boolean[length];
		for (int i = length - 1; i >= 0; i--) {
			temp[i] = codeDisplay[i][col];
		}

		if (by > 0) {
			for (int i = length - 1; i >= 0; i--) {

				codeDisplay[i][col] = temp[((i - by) + length) % length];
			}
		}
	}

	public void display() {
		int enabledPixel = 0;
		for (int i = 0; i < codeDisplay.length; i++) {
			for (int j = 0; j < codeDisplay[i].length; j++) {
				if (codeDisplay[i][j]){
					System.out.print((char) 127);
					enabledPixel ++;
				}
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("Shown pixel "+ enabledPixel);
	}

}
