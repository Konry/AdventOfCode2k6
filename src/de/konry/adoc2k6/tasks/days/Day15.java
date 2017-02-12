package de.konry.adoc2k6.tasks.days;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day15 extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		int[] isPosition = new int[lines.length];
		int[] startPosition = new int[lines.length];
		int[] hasPositions = new int[lines.length];
		for (int i = 0; i < lines.length; i++) {
			String[] temp = lines[i].split("\\s");
			isPosition[i] = 0;
			startPosition[i] = Integer.parseInt(temp[11].replace(".", ""));
			hasPositions[i] = Integer.parseInt(temp[3]);
		}

		boolean positionFailure = false;
		int startTime = 0;
		while (!positionFailure) {
			for (int currentTime = 0; currentTime <= lines.length; currentTime++) {
				setPositions(startTime + currentTime, isPosition, startPosition, hasPositions);
				if ((currentTime - 1) >= 0 && (currentTime - 1) <= lines.length) {
					if (isPosition[currentTime - 1] != 0) {
						positionFailure = true;
						break;
					}
				}
				if (positionFailure) {
					break;
				}
			}

			if (!positionFailure) {
				System.out.println("Done at " + startTime);
				break;
			}
			positionFailure = false;
			startTime++;
		}
		// result 1 : 376777
	}

	private void setPositions(int time, int[] isPosition, int[] startPosition, int[] hasPositions) {
		for (int i = 0; i < lines.length; i++) {
			isPosition[i] = (startPosition[i] + time) % hasPositions[i];
		}
	}

	@Override
	public void runPartTwo() {
		/* Additional for part 2, just add a line*/
		String[] s = new String[lines.length + 1];
		for(int i = 0; i < lines.length; i++){
			s[i] = lines[i];
		}
		s[lines.length] = "Disc #"+(lines.length + 1 )+" has 11 positions; at time=0, it is at position 0.";
		setLinesOfFile(s);
		
		runPartOne();
		// result 1 : 3903937 rank 732
		
		// 17er Länge
	}

	@Override
	public void runTestsOne() {
		String[] s = new String[] { "Disc #1 has 5 positions; at time=0, it is at position 4.",
				"Disc #2 has 2 positions; at time=0, it is at position 1." };
		setLinesOfFile(s);
		runPartOne();

	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub

	}
}
