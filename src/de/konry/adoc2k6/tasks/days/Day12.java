package de.konry.adoc2k6.tasks.days;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day12 extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		int[] array = new int[256];
		
		//Aufgabe1
		//Aufgabe2
		array[2] = 1;

//		System.out.println(Character.getNumericValue('a') - 10);
		for (int i = 0; i < lines.length; i++) {
//			System.out.println("line " +i + " "+lines[i]);
			String[] split = lines[i].split(" ");
//			System.out.println(split[0] + " - "+split[1] + " - "+ Character.getNumericValue(split[1].charAt(0)));
			switch (split[0]) {
			case "cpy":
				int k = 0;
				try{
					k = Integer.parseInt(split[1]);
				} catch(NumberFormatException e){
					k = array[Character.getNumericValue(split[1].charAt(0)) - 10];
				}
				array[Character.getNumericValue(split[2].charAt(0)) - 10] = k;
				break;
			case "inc":
				array[Character.getNumericValue(split[1].charAt(0)) - 10]++;
				break;
			case "dec":
				array[Character.getNumericValue(split[1].charAt(0)) - 10]--;
				break;
			case "jnz":
				int j = 0;
				try{
					j = Integer.parseInt(split[1]);
				} catch(NumberFormatException e){
//					System.out.println(array[Character.getNumericValue(split[1].charAt(0)) - 10]);
					j = array[Character.getNumericValue(split[1].charAt(0)) - 10];
				}

//				System.out.println(split[1] + " " +j);
				if ( j != 0){
					int jump = Integer.parseInt(split[2]);
					jump--;
					i += jump;
				}
				break;
			default:
//				System.err.println("default");
			}
		}
		
		for (int i = 0; i < 26; i++){
			if(array[i] != 0)
				System.out.println("i "+array[i]);
		}
	}

	@Override
	public void runPartTwo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runTestsOne() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub

	}

}
