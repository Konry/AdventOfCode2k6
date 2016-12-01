package de.konry.adoc2k6.tasks;

import de.konry.adoc2k6.filehandling.AdocFileReader;

abstract public class AdventOfCodeExtends implements AdventOfCodeInterface {

	protected String[] lines = null;
	protected String[] csvStringValues = null;
	protected Integer[] csvIntValues = null;
	
	int valuesSet = -1;
			
			
	@Override
	public void setLinesOfFile(String[] lines) {
		this.lines = lines;
		valuesSet = 0;
	}

	@Override
	public void setStringArray(String[] csvIntValues) {
		this.csvStringValues = csvIntValues;
		valuesSet = 1;

	}

	@Override
	public void setIntArray(Integer[] csvIntValues) {
		this.csvIntValues = csvIntValues;
		valuesSet = 2;
	}
	
	@Override
	public void printLines(){
		switch(valuesSet){
		case 0:
			for (String s : lines ){
				System.out.println(s);
			}
			break;
		case 1:
			for (String s : csvStringValues ){
				System.out.println(s);
			}
			break;
		case 2:
			for (int i : csvIntValues ){
				System.out.println(i);
			}
			break;
		}
	}
	
	@Override
	public void readFile(String string) {
		setLinesOfFile(AdocFileReader.readLines("./input/day01_1.txt"));
		setStringArray(AdocFileReader.readCSVFile("./input/day01_1.txt"));
		setIntArray(AdocFileReader.readCSVFileToInt("./input/day01_1.txt"));
		
	}
	

	@Override
	public void runPartOne(String[] strings) {
		setStringArray(strings);
		runPartOne();
	}

	@Override
	public void runPartTwo(String[] strings) {
		setStringArray(strings);
		runPartTwo();
	}


}
