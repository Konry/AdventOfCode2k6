package de.konry.adoc2k6.main;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;
import de.konry.adoc2k6.tasks.d1.DayOne;
import de.konry.adoc2k6.tasks.d2.DayTwo;
import de.konry.adoc2k6.tasks.d4.Day4;

public class AdventOfCode2k6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdventOfCodeExtends aoci = new Day4();
		//aoci.runTestsOne();
		aoci.runTestsTwo();
		aoci.readFile("./input/day04_1.txt");
		//aoci.runPartOne();
		aoci.runPartTwo();
		
	}	

}
