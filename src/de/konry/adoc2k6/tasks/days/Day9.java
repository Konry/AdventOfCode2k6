package de.konry.adoc2k6.tasks.days;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day9 extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		StringBuilder sb = new StringBuilder();
		boolean startCommand = false;
		boolean intoNumber = false;
		StringBuilder sbNumber = new StringBuilder();
		int lengthOfDuplication = -1;
		int numberOfDuplication = -1;
		for (int j = 0; j < lines.length; j++) {
			System.out.println(lines[j]);

			/* check every element */
			for (int i = 0; i < lines[j].length(); i++) {

				/* look for start command of the multiplicator, else append */
				if (!startCommand) {
					if (lines[j].charAt(i) == '(') {
						intoNumber = true;
						startCommand = true;
					} else {
						sb.append(lines[j].charAt(i));
					}
				} else if (intoNumber && startCommand) {
					/* check if first or second number has ended */
					if (lines[j].charAt(i) == 'x' || lines[j].charAt(i) == ')') {
						if (lengthOfDuplication == -1) {
							lengthOfDuplication = Integer.parseInt(sbNumber.toString());
							sbNumber.delete(0, sbNumber.length());
						} else if (numberOfDuplication == -1) {
							numberOfDuplication = Integer.parseInt(sbNumber.toString());
							sbNumber.delete(0, sbNumber.length());
							intoNumber = false;
						}
					} else if (intoNumber) {
						sbNumber.append(lines[j].charAt(i));
					}
					// System.out.println(lines[j].charAt(i) + " nums: " +
					// sbNumber.toString() + " "+ lengthOfDuplication + " " +
					// numberOfDuplication);

					/* no number, so in the multiplicator mode */
				} else if (startCommand) {
					// System.out.println();
					String tmp = lines[j].substring(i, i + lengthOfDuplication);
					// System.out.println("copy \"" + tmp + "\" "+
					// numberOfDuplication + " " + lengthOfDuplication + " pos "
					// +i);
					for (int copy = 0; copy < numberOfDuplication; copy++) {
						sb.append(tmp);
					}
					i = i + lengthOfDuplication - 1;
					startCommand = false;
					lengthOfDuplication = -1;
					numberOfDuplication = -1;
				}
			}
			System.out.println(sb.toString());
			System.out.println("length = " + sb.toString().length());
			sb.delete(0, sb.length());

			// result 1 : 138735
		}

	}

	private String decompressString() {
		return "";
	}

	@Override
	public void runPartTwo() {
		for (int j = 0; j < lines.length; j++) {

			long length = 0;
//			StringBuilder sbb = new StringBuilder();
			System.out.println(lines[j]);
			String temp = lines[j];
			long startTime = System.currentTimeMillis();
			boolean showTime = false;
			int secCounter = 5;
			System.out.println((System.currentTimeMillis() - startTime) / 1000 + " " +secCounter);
			while (temp.contains("(")) {
				if ((System.currentTimeMillis() - startTime) / 1000 >= secCounter ){
					System.out.println((System.currentTimeMillis() - startTime) + " " + length);
					secCounter += 5;
				}
//				System.out.println(length);
				StringBuilder sb = DecompressString(temp);
				temp = sb.toString();
				
				int index = temp.indexOf('(');
				if (index >= 0) {
					length += index;
//					sbb.append(temp.substring(0, index));
					temp = temp.substring(index);

				} else {
					length += temp.length();
//					sbb.append(temp);
				}
				// System.out.println("length = " + temp.length());
			}
			System.out.println(length);
			length = 0;
//			System.out.println("control: " + sbb.toString());
//			sbb = new StringBuilder();
			// result 1 : 1034149006 long running :( tryy
			// result 2: 11125026826: calc time 11340 3,15h
		}
	}

	@Override
	public void runTestsOne() {
		String[] s = new String[] { "ADVENT", "A(1x5)BC", "(3x3)XYZ", "A(2x2)BCD(2x2)EFG", "(6x1)(1x3)A",
				"X(8x2)(3x3)ABCY" };
		setLinesOfFile(s);
		runPartOne();
	}

	@Override
	public void runTestsTwo() {
		String[] s = new String[] { "(8x3)(3x3)XYZ", "(3x3)XYZ","(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN","(27x12)(20x12)(13x14)(7x10)(1x12)A" };
		// ,
		// "X(8x2)(3x3)ABCY",
		setLinesOfFile(s);
		runPartTwo();

	}

	private StringBuilder DecompressString(String decompress) {
//		System.out.println("deco: " + decompress);
		StringBuilder sb = new StringBuilder();
		boolean startCommand = false;
		boolean intoNumber = false;
		StringBuilder sbNumber = new StringBuilder();
		int lengthOfDuplication = -1;
		int numberOfDuplication = -1;
		/* check every element */
		for (int i = 0; i < decompress.length(); i++) {

			/* look for start command of the multiplicator, else append */
			if (!startCommand) {
				if (decompress.charAt(i) == '(') {
					intoNumber = true;
					startCommand = true;
				} else {
					// s length++;
					// sbb.append(decompress.charAt(i));
					sb.append(decompress.charAt(i));
				}
			} else if (intoNumber && startCommand) {
				/* check if first or second number has ended */
				if (decompress.charAt(i) == 'x' || decompress.charAt(i) == ')') {
					if (lengthOfDuplication == -1) {
						lengthOfDuplication = Integer.parseInt(sbNumber.toString());
						sbNumber.delete(0, sbNumber.length());
					} else if (numberOfDuplication == -1) {
						numberOfDuplication = Integer.parseInt(sbNumber.toString());
						sbNumber.delete(0, sbNumber.length());
						intoNumber = false;
					}
				} else if (intoNumber) {
					sbNumber.append(decompress.charAt(i));
				}
				// System.out.println(decompress.charAt(i) + " nums: " +
				// sbNumber.toString() + " "+ lengthOfDuplication + " " +
				// numberOfDuplication);

				/* no number, so in the multiplicator mode */
			} else if (startCommand) {
				// System.out.println();
				String tmp = decompress.substring(i, i + lengthOfDuplication);
//				System.out.println(
//						"copy \"" + tmp + "\" " + numberOfDuplication + " " + lengthOfDuplication + " pos " + i);
				for (int copy = 0; copy < numberOfDuplication; copy++) {
					sb.append(tmp);
				}
				i = i + lengthOfDuplication - 1;

				// System.out.println("copy1 "+sb.toString());
				sb.append(decompress.substring(i + 1));

				// System.out.println("copy2 "+sb.toString());
				startCommand = false;
				lengthOfDuplication = -1;
				numberOfDuplication = -1;
				return sb;
			}
		}
		return sb;
	}
}
