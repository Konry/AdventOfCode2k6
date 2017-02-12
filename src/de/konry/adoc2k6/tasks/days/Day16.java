package de.konry.adoc2k6.tasks.days;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day16 extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		int limit = Integer.parseInt(lines[1]);
		
		String temp = lines[0];
		while (limit > temp.length()){
//			System.out.println(temp.length());
			temp = generateString(temp);
		}
		System.out.println(calcChecksum(temp, limit));
		// result1: 10011010010010010
	}

	public String generateString(String a) {
		String b = new StringBuilder(a).reverse().toString();
		b = b.replace('0', '2').replace('1', '0').replace('2', '1');
		return (a + "0" + b);
	}

	public String calcChecksum(String str, int limit) {
		if (limit > str.length()){
			limit = str.length();
		}
		int sum = 0;
		for (int i = 0; i < limit; i++) {
			if (str.charAt(i) == '1') {
				sum++;
			}
		}
		String temp = str.substring(0, limit);

		while (temp.length() % 2 == 0) {

			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < temp.length(); i += 2) {
				String tmp = temp.substring(i, i + 2);

				switch (tmp) {
				case "11":
				case "00":
					sb.append('1');
					break;
				case "10":
				case "01":
					sb.append('0');
					break;
				default:
					break;
				}
			}
			temp = sb.toString();
//			System.out.println(temp);
		}
//		System.out.println("checksum "+temp);
		return temp;
	}

	@Override
	public void runPartTwo() {
		runPartOne();

	}

	@Override
	public void runTestsOne() {
		generateString("1");
		generateString("0");
		generateString("11111");
		generateString("111100001010");

		calcChecksum("110010110100", 14);
		
		String[] s = new String[]{"10000","20"};
		setLinesOfFile(s);
		runPartOne();
	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub

	}

}
