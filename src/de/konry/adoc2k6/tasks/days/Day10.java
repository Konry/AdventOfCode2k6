package de.konry.adoc2k6.tasks.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;
import de.konry.adoc2k6.tasks.days.Day4.Values;

public class Day10 extends AdventOfCodeExtends {
	public class BotList extends ArrayList<Bot> implements Comparator<Bot>, Comparable<Bot> {
		// ArrayList<Bot> arr = new ArrayList<>();
		public BotList() {
			// TODO Auto-generated constructor stub
		}

		public void addNumber(String botnumber, String value) {
			// System.out.println("add " + botnumber + " " + value);
			Integer BotNumber = Integer.parseInt(botnumber);

			Bot existingBot = null;
			for (Bot b : this) {
				if (BotNumber.equals(b.number)) {
					boolean intExist = false;
					for (int i : b.values) {
						if (i == Integer.parseInt(value)) {
							intExist = true;
							break;
						}
					}
					if (!intExist) {
						b.values.add(Integer.parseInt(value));
						existingBot = b;
						break;
					}
				}
			}
			if (existingBot == null) {
				this.add(new Bot(BotNumber, Integer.parseInt(value)));
			}
		}

		@Override
		public int compare(Bot o1, Bot o2) {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public int compareTo(Bot o) {
			// TODO Auto-generated method stub

			return 0;
		}

		public ArrayList<Integer> getNumbers(String botnumber) {
			// System.out.println("getNumbers " + botnumber);
			Integer BotNumber = Integer.parseInt(botnumber);
			for (Bot b : this) {
				if (BotNumber.equals(b.number)) {
					if (b.values.size() == 2)
						return b.values;
					else
						return b.values;
				}
			}
			return new ArrayList<>();
		}

		// public void add(String botNumber, String botValue) {
		// int iBotNumber = Integer.parseInt(botNumber);
		// int iBotValue = Integer.parseInt(botValue);
		// this.add(new Bot(number, value))
		//
		// }

	}

	public class Bot {
		int number = -1;
		ArrayList<Integer> values;

		public Bot() {
			values = new ArrayList<>();
		}

		public Bot(int number) {
			this.number = number;
			values = new ArrayList<>();
		}

		public Bot(int number, int value) {
			this.number = number;
			values = new ArrayList<>();
			values.add(value);
		}

		public Bot(String number) {
			this.number = Integer.parseInt(number);
			values = new ArrayList<>();
		}
	}

	@Override
	public void runPartOne() {
		BotList bots = new BotList();
		int[] output = new int[250];
		ArrayList<Integer> linesDone = new ArrayList<>();
		int line = 0;

		int whileCounter = 0;
		int cc = 0;

		ArrayList<String> al = new ArrayList<>();
		for (String s : lines) {
			al.add(s);
		}

		while (whileCounter >= 0) {
			ArrayList<String> temp = new ArrayList<>();
			cc++;
			line = 0;

			for (String s : al) {
				String[] split = s.split(" ");
				if (s.startsWith("value")) {
					bots.addNumber(split[5], split[1]);
					linesDone.add(line);
				} else if (s.startsWith("bot")) {
					ArrayList<Integer> arr = bots.getNumbers(split[1]);

					if (arr.size() == 2) {
						int[] a = new int[2];
						for (int i = 0; i < 2; i++) {
							a[i] = arr.get(i);
						}
						Arrays.sort(a);
						boolean outFirs = split[5].equals("output");
						boolean outSec = split[10].equals("output");
						if (outFirs && outSec) {
							output[Integer.parseInt(split[6])] = a[0];
							output[Integer.parseInt(split[11])] = a[1];
						} else if (outFirs && !outSec) {
							output[Integer.parseInt(split[6])] = a[0];
							bots.addNumber(split[11], String.valueOf(a[1]));
						} else if (!outFirs && outSec) {
							bots.addNumber(split[6], String.valueOf(a[0]));
							output[Integer.parseInt(split[11])] = a[1];
						} else if (!outFirs && !outSec) {
							bots.addNumber(split[6], String.valueOf(a[0]));
							bots.addNumber(split[11], String.valueOf(a[1]));
						}
					} else {
						temp.add(s);
					}

				}
				line++;
			}
			al = temp;
			
			whileCounter++;

			if(temp.size() <= 0){
				whileCounter = -1;
			}
		}
		
		for(Bot b : bots){
			if(b.values.size() == 2){
				if((b.values.get(0) == 61 && b.values.get(1) == 17 )|| (b.values.get(1) == 61 && b.values.get(0) == 17 )){
					System.out.println("Bot " + b.number + " val low " + b.values.get(0) + " _val high " + b.values.get(1));
				}
			}
		}

		// Aufgabe 2
		int tempMult = 1;
		for(int i = 0; i < 3; i++){
			tempMult *= output[i];
		}
		System.out.println(tempMult);
		// result 1: 86
		// result 2: 22847 20 sec
	}

	@Override
	public void runPartTwo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runTestsOne() {
		String[] s = new String[] { "value 5 goes to bot 2", "bot 2 gives low to bot 1 and high to bot 0",
				"value 3 goes to bot 1", "bot 1 gives low to output 1 and high to bot 0",
				"bot 0 gives low to output 2 and high to output 0", "value 2 goes to bot 2" };
		setLinesOfFile(s);
		runPartOne();

	}

	@Override
	public void runTestsTwo() {

	}

}
