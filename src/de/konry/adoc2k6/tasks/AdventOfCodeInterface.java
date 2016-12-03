package de.konry.adoc2k6.tasks;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends.ChooseSet;

public interface AdventOfCodeInterface {

	public void runPartOne();
	public void runPartTwo();
	public void runPartOne(String[] strings, ChooseSet cs);
	public void runPartTwo(String[] strings, ChooseSet cs);
	public void setLinesOfFile(String[] lines);
	public void setStringArray(String[] strings);
	public void setIntArray(Integer[] numbers);
	public void readFile(String string);
	public void printLines();
	public void runTestsOne();
	public void runTestsTwo();

}
