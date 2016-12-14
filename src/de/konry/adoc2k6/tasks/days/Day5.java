package de.konry.adoc2k6.tasks.days;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day5 extends AdventOfCodeExtends {


	@Override
	public void runPartOne() {
		String doorId = "uqwqemis";
		//String doorId = "abc";
		int md5Counter = 0;
		boolean notFound = true;
		int foundCounter = 0;
		StringBuilder sbResult = new StringBuilder();
		StringBuilder sbInput = new StringBuilder();
		try {
			byte[] dig = MessageDigest.getInstance("MD5").digest();
			while (notFound) {
				sbInput = new StringBuilder();
				sbInput.append(doorId);
				sbInput.append(md5Counter);
				String result = md5Java(sbInput.toString());
				if (result.startsWith("00000")) {
					System.out.println(result);
					sbResult.append(result.charAt(5));
					foundCounter++;
				} else {
					if (md5Counter % 1000000 == 0) {
						System.out.println(md5Counter);
					}
				}

				md5Counter++;

				if (foundCounter == 8) {
					System.out.println(sbResult.toString());
					return;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1a3099aa in 30 min
	}

	@Override
	public void runPartTwo() {
		String doorId = "uqwqemis";
		char[] resultFinal = new char[]{'X','X','X','X','X','X','X','X'}; 
		int md5Counter = 3231900;
		boolean notFound = true;
		int foundCounter = 0;
		StringBuilder sbResult = new StringBuilder();
		StringBuilder sbInput = new StringBuilder();
		try {
			byte[] dig = MessageDigest.getInstance("MD5").digest();
			while (notFound) {
				sbInput = new StringBuilder();
				sbInput.append(doorId);
				sbInput.append(md5Counter);
				String result = md5Java(sbInput.toString());
				try{
					int i = Integer.parseInt(String.valueOf(result.charAt(5)));
					if (result.startsWith("00000")) {
						if ( i <= 7 && resultFinal[i] == 'X'){
							resultFinal[i] = result.charAt(6);
							sbResult.append(resultFinal[i]);
							System.out.println(result + " at "+ i + "  the "+ result.charAt(6));
							foundCounter++;
						}
					} else {
						if (md5Counter % 1000000 == 0) {
							System.out.println(md5Counter);
						}
					}
				} catch(NumberFormatException e){
					
				}

				md5Counter++;

				if (foundCounter == 8) {
					System.out.println(sbResult.toString());
					return;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void runTestsOne() {
		String doorId = "abc";
		int md5Counter = 3231900;
		boolean notFound = true;
		int foundCounter = 0;
		StringBuilder sbResult = new StringBuilder();
		StringBuilder sbInput = new StringBuilder();
		try {
			byte[] dig = MessageDigest.getInstance("MD5").digest();
			while (notFound) {
				sbInput = new StringBuilder();
				sbInput.append(doorId);
				sbInput.append(md5Counter);
				String result = md5Java(sbInput.toString());
				if (result.startsWith("00000")) {
					System.out.println(result + " "+ result.charAt(5));
					sbResult.append(result.charAt(5));
					foundCounter++;
				} else {
					if (md5Counter % 1000000 == 0) {
						System.out.println(md5Counter);
					}
				}

				md5Counter++;

				if (foundCounter == 8) {
					System.out.println(sbResult.toString());
					return;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void runTestsTwo() {
		String doorId = "abc";
		char[] resultFinal = new char[]{'X','X','X','X','X','X','X','X'}; 
		int md5Counter = 3231900;
		boolean notFound = true;
		int foundCounter = 0;
		StringBuilder sbResult = new StringBuilder();
		StringBuilder sbInput = new StringBuilder();
		try {
			byte[] dig = MessageDigest.getInstance("MD5").digest();
			while (notFound) {
				sbInput = new StringBuilder();
				sbInput.append(doorId);
				sbInput.append(md5Counter);
				String result = md5Java(sbInput.toString());
				try{
					int i = Integer.parseInt(String.valueOf(result.charAt(5)));
					if (result.startsWith("00000")) {
						if ( i <= 7 && resultFinal[i] == 'X'){
							resultFinal[i] = result.charAt(6);
							sbResult.append(resultFinal[i]);
							System.out.println(result + " at "+ i + "  the "+ result.charAt(6));
							foundCounter++;
						}
					} else {
						if (md5Counter % 1000000 == 0) {
							System.out.println(md5Counter);
						}
					}
				} catch(NumberFormatException e){
					
				}

				md5Counter++;

				if (foundCounter == 8) {
					System.out.println(sbResult.toString());
					return;
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 694190cd 45 min
	}

	public static String md5Java(String message) {
		String digest = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(message.getBytes("UTF-8"));
			// converting byte array to Hexadecimal String
			StringBuilder sb = new StringBuilder(2 * hash.length);
			for (byte b : hash) {
				sb.append(String.format("%02x", b & 0xff));

			}
			digest = sb.toString();
		} catch (UnsupportedEncodingException ex) {
			;
		} catch (NoSuchAlgorithmException ex) {
			;
		}
		return digest;
	}

}
