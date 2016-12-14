package de.konry.adoc2k6.tasks.days;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day14 extends AdventOfCodeExtends {

	private boolean isKey(String s) {
		return false;
	}

	String patternThree = ".*([a-zA-Z0-9])\\1{2,}.*";
	String patternFive = ".*([a-zA-Z0-9])\\1{4,}.*";
	String puzzleInput = "";

	LinkedList<String> md5Hashes = new LinkedList<String>();

	private void fillMd5Hashes2k16(String puzzleInput) {
		for (int i = 0; i < 1000; i++) {
			md5Hashes.add(md52016(puzzleInput + "" + i));
		}
		System.out.println("fill complete");
	}
	
	private void fillMd5Hashes(String puzzleInput) {
		for (int i = 0; i < 1000; i++) {
			md5Hashes.add(md5Java(puzzleInput + "" + i));
		}
		System.out.println("fill complete");
	}

	private void addAndRemoveMd5Hash(String hash) {
		// System.out.println("remove "+md5Hashes.getFirst() + " add "+hash);
		md5Hashes.remove();
		md5Hashes.add(hash);
	}

	private void addMd5Hash(String hash) {
		md5Hashes.add(hash);
	}

	@Override
	public void runPartOne() {
		int counter = 0;
		puzzleInput = lines[0];
		fillMd5Hashes(puzzleInput);
		ArrayList<String> results = new ArrayList<>();

		int foundKeys = 0;
		while (foundKeys < 64) {

			//String md5 = md5Java(puzzleInput + counter);
			String md5 = md5Hashes.getFirst();
			if (checkMd5(md5, counter) != -1) {
				System.out.println(md5 + " " + counter);
				results.add(md5);
				foundKeys++;
			}

			md5 = md52016(puzzleInput + (counter + 1000));
			addAndRemoveMd5Hash(md5);

			counter++;
		}

		// too low 13651
		// too slow :( 25427
		
		// Task 2 : 
	}

	@Override
	public void runPartTwo() {
		int counter = 0;
		puzzleInput = lines[0];
		fillMd5Hashes2k16(puzzleInput);
		ArrayList<String> results = new ArrayList<>();

		int foundKeys = 0;
		while (foundKeys < 64) {

			String md5 = md5Hashes.getFirst();
			if (checkMd5(md5, counter) != -1) {
				System.out.println(md5 + " " + counter);
				results.add(md5);
				foundKeys++;
			}

			md5 = md52016(puzzleInput + (counter + 1000));
			addAndRemoveMd5Hash(md5);

			counter++;
		}		
		// Task 2 : 22045 rank 613 :( shall be below 600
	}

	@Override
	public void runTestsOne() {
		String[] l = new String[] { "abc" };
		setLinesOfFile(l);
		runPartOne();
	}

	@Override
	public void runTestsTwo() {
		System.out.println(md52016("abc0"));
	}

	private int checkMd5(String md5, int indexOrigin) {
		int index = 0;
		if (Pattern.matches(patternThree, md5)) {

			Matcher matcher = Pattern.compile(patternThree).matcher(md5);
			if (matcher.find()) {
				String[] split = md5.split("([a-zA-Z0-9])\\1{2,}");

				String temp = md5.substring(split[0].length(), split[0].length() + 3);
				if (Pattern.matches(patternThree, temp)) {
					for (String s : md5Hashes) {
						if (!md5.equals(s)) {
							if (Pattern.matches(".*([" + temp.charAt(0) + "])\\1{4,}.*", s)) {
								return index;
							}
						}
						index++;
					}
				}
			}

		}
		return -1;
	}

	private static String md52016(String message) {
		String temp = message;
		for (int i = 0; i <= 2016; i++) {
			temp = md5Java(temp);
		}
		return temp;
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
