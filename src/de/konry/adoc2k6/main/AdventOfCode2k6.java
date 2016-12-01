package de.konry.adoc2k6.main;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;
import de.konry.adoc2k6.tasks.d1.DayOne;

public class AdventOfCode2k6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdventOfCodeExtends aoci = new DayOne();
		aoci.runTestsOne();
		aoci.runTestsTwo();
		aoci.readFile("./input/day01_1.txt");
		//aoci.runPartOne();
		aoci.runPartTwo();

	}	

}
