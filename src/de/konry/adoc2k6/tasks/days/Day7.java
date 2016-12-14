package de.konry.adoc2k6.tasks.days;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day7 extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		int counterSupported = 0;
		for(String s : lines){
			String[] temp = s.split("\\[|\\]");
			boolean[] rights = new boolean[temp.length];
			
			boolean inner = false;
			boolean outer = false;
			
			for(int i = 0; i < temp.length; i++){
				rights[i] = testString(temp[i]);
				if (i % 2 == 1) {
					if(!inner){
						inner = rights[i];
					}
				} else {
					if(!outer)
						outer = rights[i];
				}
			}
						
			if (!inner && outer){
				counterSupported++;
				/*
			} else {
				System.out.println("false "+s);
				if(inner){
					System.out.println("because of inner.");
				} else if (!outer) {
					System.out.println("because of outer");
				} else {
					System.out.println("because no idea");
				}*/
			}
			
		}

		System.out.println(counterSupported);
		// result1: 77 too low
		// result2: 118, there are more than one [] []
	}

	@Override
	public void runPartTwo() {
		int counterSupported = 0;
		for (String s : lines){
			String[] temp = s.split("\\[|\\]");
			boolean result = false;
			result = checkSSL(temp);
			if( result){
				counterSupported++;
			}
			
		}
		System.out.println(counterSupported);
		
		// result1: 260
	}

	private boolean checkSSL(String[] temp) {
		boolean result;
		for(int i = 0; i < temp.length; i++){
			if(i % 2 == 0){
				for(int j = 0; j < temp.length; j++){
					if(j % 2 == 1){
						result = checkForXYX_XYX(temp[i], temp[j]);
						if (result)
							return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void runTestsOne() {
		String[] t = new String[]{"abba[mnop]qrst","abcd[bddb]xyyx", "aaaa[qwer]tyui","ioxxoj[asdfgh]zxcvbn","i12121oxxoj[asdfgh]zxcvbn"};
		setLinesOfFile(t);
		runPartOne();
	}
	
	public boolean testString(String test){
		if (test.length() >= 4){
			boolean testResult = false;
			for(int i = 0; i <= test.length()-4; i++){
				testResult = testForXYYX(test.substring(i, i + 4));
				if (testResult){
					break;
				}
			}
			
			return testResult;
		}
		return false;
	}
	
	public boolean testForXYYX(String test){
		if(test.length() == 4){
			if (test.charAt(0) == test.charAt(3) && test.charAt(1) == test.charAt(2) && test.charAt(0) != test.charAt(1)){
				return true;
			}
			else 
				return false;
		} 
		else 
			return false; 
	}
	
	public boolean compare(String s1, String s2){
		if (s1.length() > 2 && s2.length() > 2)
		if (s1.charAt(0) == s2.charAt(1) && s2.charAt(0) == s1.charAt(1) ){
			return true;
		}
		return false;
	}
	
	public boolean checkForXYX_XYX(String s1,String s2){
		for(int i = 0 ; i < s1.length() - 2; i++){
			String s = testForXYX(s1.substring(i, i+3));
			
			if(!s.equals("")){
				for(int j = 0 ; j < s2.length()-2; j++){
					if (compare(testForXYX(s2.substring(j, j+3)),s)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public String testForXYX(String test){
		if(test.length() == 3){
			if (test.charAt(0) == test.charAt(2) && test.charAt(0) != test.charAt(1) ){
				return test;
			}
			else 
				return "";
		} 
		else 
			return ""; 
	}
	
	public boolean testForXYX(String test, String test2){
		if(test.length() == 3 && test2.length() == 3){
			if (test.charAt(0) == test.charAt(2) && test.charAt(0) != test.charAt(1) &&
					test2.charAt(0) == test2.charAt(2) && test2.charAt(0) != test2.charAt(1) &&
					test.charAt(0) == test2.charAt(1) &&
					test.charAt(1) == test2.charAt(0)
					){
				return true;
			}
			else 
				return false;
		} 
		else 
			return false; 
	}

	@Override
	public void runTestsTwo() {

		String[] t = new String[]{"aba[bab]xyz","xyx[xyx]xyx", "aaa[kek]eke","zazbz[bzb]cdb"};
		setLinesOfFile(t);
		runPartTwo();

	}

}
