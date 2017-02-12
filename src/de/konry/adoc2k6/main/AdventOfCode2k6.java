package de.konry.adoc2k6.main;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;
import de.konry.adoc2k6.tasks.days.*;


public class AdventOfCode2k6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdventOfCodeExtends aoci = new Day17();
		aoci.runTestsOne();
//		aoci.runTestsTwo();
		aoci.readFile("./input/day16_1.txt");
		System.out.println();
//		aoci.runPartOne();
		System.out.println();
		aoci.readFile("./input/day16_2.txt");
//		aoci.runPartTwo();
		
	}	

}
