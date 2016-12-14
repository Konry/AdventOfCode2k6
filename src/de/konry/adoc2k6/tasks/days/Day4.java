package de.konry.adoc2k6.tasks.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day4 extends AdventOfCodeExtends {
	class Values implements Comparator<Values> {
		int integerValuesOfCode = 0;
		Integer count = 0;

		public Values(int value) {
			integerValuesOfCode = value;
			count = 1;
		}

		public char getStringForIntCode() {
			return (char) (integerValuesOfCode - 10 + 65);
		}

		public int compare(Values val1, Values val2) {
			return val1.count.compareTo(val2.count);
		}

		public boolean equals(Values val) {

			return false;
		}
		
		public void print(){
			System.out.println((char)getStringForIntCode() + " " +count);
		}
	}

	@Override
	public void runPartOne() {
		int sumOfSectorSize = 0;
		int correct = 0;
		
		for (String line : lines) {
			int[] charValues = new int[256];
			ArrayList<Values> vals = new ArrayList<Values>();
			String[] split = line.split("-");
			int sectorSize = 0;
			for (String s : split) {
				if (s.contains("[")) {
					String[] tmp = s.split("\\[");
					sectorSize = Integer.parseInt(tmp[0]);
				} else {
					for (char c : s.toCharArray()) {
						int index = -1;
						for (int i = 0; i < vals.size(); i++) {
							if (vals.get(i).integerValuesOfCode == Character.getNumericValue(c)) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							charValues[Character.getNumericValue(c)]++;
							vals.get(index).count++;
						} else {
							vals.add(new Values(Character.getNumericValue(c)));
						}
						charValues[Character.getNumericValue(c)]++;
						/* UTF conversion */
					}
				}
			}

			int maxValue = 0;
			ArrayList<Values> outdone = new ArrayList<>();
			int count = 0;
			/* look for max */
			for (Values v : vals) {
				if (v.count > maxValue) {
					maxValue = v.count;
				}
			}

			boolean print = false;
			StringBuilder sb = new StringBuilder();

			/* print 5 out */
			while (count < 5) {

				print = false;
				for (int i = 0; i < 26; i++) {

					for (Values v : vals) {
						if (v.count == maxValue && v.integerValuesOfCode == i + 10) {
							maxValue = v.count;
							sb.append(v.getStringForIntCode());
							count++;
							if (count == 5) {
								break;
							}
						}
					}
					if (count == 5) {
						break;
					}
				}
				maxValue--;
			}

			if (line.endsWith("[" + sb.toString().toLowerCase() + "]")) {
				System.out.println(line + " endswith " + sb.toString() + " "+line.endsWith("[" + sb.toString().toLowerCase() + "]") + " " + sectorSize);
				
				sumOfSectorSize += sectorSize;
				correct++;
			} 
		}
		
		System.out.println(correct +  " " + sumOfSectorSize);
		// result 1 449 too low
		// result 2 245102 1,5h did not realize that for the sector size is asked for
	}

	@Override
	public void runPartTwo() {
		int sumOfSectorSize = 0;
		int correct = 0;
		
		for (String line : lines) {
			int[] charValues = new int[256];
			ArrayList<Values> vals = new ArrayList<Values>();
			String[] split = line.split("-");
			int sectorSize = 0;
			for (String s : split) {
				if (s.contains("[")) {
					String[] tmp = s.split("\\[");
					sectorSize = Integer.parseInt(tmp[0]);
				} else {
					for (char c : s.toCharArray()) {
						int index = -1;
						for (int i = 0; i < vals.size(); i++) {
							if (vals.get(i).integerValuesOfCode == Character.getNumericValue(c)) {
								index = i;
								break;
							}
						}
						if (index >= 0) {
							charValues[Character.getNumericValue(c)]++;
							vals.get(index).count++;
						} else {
							vals.add(new Values(Character.getNumericValue(c)));
						}
						charValues[Character.getNumericValue(c)]++;
						/* UTF conversion */
					}
				}
			}

			int maxValue = 0;
			ArrayList<Values> outdone = new ArrayList<>();
			int count = 0;
			/* look for max */
			for (Values v : vals) {
				if (v.count > maxValue) {
					maxValue = v.count;
				}
			}

			boolean print = false;
			StringBuilder sb = new StringBuilder();

			/* print 5 out */
			while (count < 5) {

				print = false;
				for (int i = 0; i < 26; i++) {

					for (Values v : vals) {
						if (v.count == maxValue && v.integerValuesOfCode == i + 10) {
							maxValue = v.count;
							sb.append(v.getStringForIntCode());
							count++;
							if (count == 5) {
								break;
							}
						}
					}
					if (count == 5) {
						break;
					}
				}
				maxValue--;
			}

			if (line.endsWith("[" + sb.toString().toLowerCase() + "]")) {
				//System.out.println(line);
				decode(line.substring(0, line.lastIndexOf("-")), sectorSize);
			} 
		}
		// result 1 324 19 min

	}

	public void decode(String substring, int sectorSize) {
		//System.out.println("" +substring + " ## "+ sectorSize);
		StringBuilder sb = new StringBuilder();
		for(char c : substring.toCharArray()){
//			System.out.println(Character.getNumericValue(c) - 10);
			if( Character.getNumericValue(c) - 10 < 0){
				sb.append(" ");
			} else {
				sb.append((char)((Character.getNumericValue(c) - 10 + sectorSize) % 26 + 97));
			}
//			System.out.println((char) (Character.getNumericValue(c) - 10 + 97));
		}
		System.out.println(sb.toString() + " " + sectorSize);
	}

	@Override
	public void runTestsOne() {
		String[] temp = new String[] { "aaaaa-bbb-z-y-x-123[abxyz]", "a-b-c-d-e-f-g-h-987[abcde]",
				"not-a-real-room-404[oarel]", "totally-real-room-200[decoy]" };
		setLinesOfFile(temp);
		runPartOne();
	}

	@Override
	public void runTestsTwo() {
		decode("qzmt-zixmtkozy-ivhz", 343);

	}

}
