package de.konry.adoc2k6.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdocFileReader {

	public AdocFileReader() {

	}

	public static String[] readLines(String file) {
		ArrayList<String> input = new ArrayList<String>();

		try {
			new File("hallo.txt").createNewFile();

			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = "";
			while (br.ready()) {
				line = br.readLine();

				input.add(line);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return input.toArray(new String[input.size()]);
	}

	public static String[] readCSVFile(String file) {
		ArrayList<String> input = new ArrayList<String>();
		try{
		String line = readLines(file)[0];
		String[] temp = line.split(",");

		for (String s : temp) {
			s = s.replace(" ", "");
			input.add(s);
		}
		} catch (ArrayIndexOutOfBoundsException e){
			
		}

		return input.toArray(new String[input.size()]);
	}

	public static Integer[] readCSVFileToInt(String file) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		try{
		String line = readLines(file)[0];
		String[] temp = line.split(",");

		for (String s : temp) {
			try {
				input.add(Integer.parseInt(s));
			} catch (NumberFormatException nfe) {
				//System.err.println("NumberFormatException for string " + s);
			}

		}
		}catch (ArrayIndexOutOfBoundsException e){
			
		}

		return input.toArray(new Integer[input.size()]);
	}
}
