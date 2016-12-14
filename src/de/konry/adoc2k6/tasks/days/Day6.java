package de.konry.adoc2k6.tasks.days;

import java.util.ArrayList;
import java.util.Comparator;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class Day6 extends AdventOfCodeExtends {
	public class ValueList extends ArrayList<Value> {

		public ArrayList<Value> getArr() {
			return arr;
		}

		ArrayList<Value> arr = new ArrayList<>();

		public void Add(char val) {
			int index = IndexOf(val);
//			if (index >= 0)
//			System.out.println(index + " "+ val + " " + arr.get(index).occurence);
			if (index < 0) {
				arr.add(new Value(val));
			} else if (index >= 0) {
				arr.get(index).occurence += 1;
			}
		}
		
		public int IndexOf(char val){
			for (int i = 0; i < arr.size(); i++){
				if(arr.get(i).character == val){
					return i;
				}
			}
			return -1;
		}
		
		public int size(char val){
			if(IndexOf(val) >= 0)
				return arr.get(arr.indexOf(new Value(val))).occurence;
			else
				return 0;
		}

	}

	public class Value implements Comparable<Value> {
		char character;
		int occurence;

		public Value(char c) {
			character = c;
			occurence = 1;
		}

		@Override
		public int compareTo(Value o) {
			if (o.occurence > occurence) {
				return 1;
			} else if (o.occurence < occurence) {
				return -1;
			} else if (o.occurence == occurence)
				return Character.compare(o.character, character);

			return 0;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Value) {
				// id comparison
				Value mo = (Value) o;
				return mo.character == mo.character;
			}
			return false;
		}

	}

	@Override
	public void runPartOne() {
		int width = lines[0].length();

		ArrayList<ValueList> arr = new ArrayList<ValueList>();

		for (int i = 0; i < width; i++) {
			arr.add(new ValueList());
		}
		for (String s : lines) {
			for (int i = 0; i < width; i++) {
				arr.get(i).Add(s.charAt(i));
			}
		}

		System.out.println("show valueList ");
		for (int i = 0; i < width; i++) {
			ArrayList<Value> v = arr.get(i).arr;

			v.sort(new ValueComperator());
			System.out.print( v.get(v.size()-1).character);
		}
		System.out.println();
		
		// result 1 = xhnqpqql
	}
	
	class ValueComperator implements Comparator<Value>{

		@Override
		public int compare(Value o1, Value o2) {
			if (o1.occurence > o2.occurence) {
				return 1;
			} else if (o1.occurence < o2.occurence) {
				return -1;
			} else if (o1.occurence == o2.occurence)
				return Character.compare(o1.character, o2.character);

			return 0;
		}
		
	}

	@Override
	public void runPartTwo() {

		int width = lines[0].length();

		ArrayList<ValueList> arr = new ArrayList<ValueList>();

		for (int i = 0; i < width; i++) {
			arr.add(new ValueList());
		}
		for (String s : lines) {
			for (int i = 0; i < width; i++) {
				arr.get(i).Add(s.charAt(i));
			}
		}
		
		System.out.println("show valueList ");
		for (int i = 0; i < width; i++) {
			ArrayList<Value> v = arr.get(i).arr;

			v.sort(new ValueComperator());
			System.out.print(v.get(0).character);
		}
		System.out.println();
		
		// result 1: brhailro
	}

	@Override
	public void runTestsOne() {
		String[] vals = new String[] { "eedadn", "drvtee", "eandsr", "raavrd", "atevrs", "tsrnev", "sdttsa", "rasrtv",
				"nssdts", "ntnada", "svetve", "tesnvt", "vntsnd", "vrdear", "dvrsen", "enarar" };
		setLinesOfFile(vals);
		runPartOne();

	}

	@Override
	public void runTestsTwo() {
		// TODO Auto-generated method stub
		ValueList v = new ValueList();
		v.Add('e');
		v.Add('e');
		v.Add('a');
		v.Add('a');
		v.Add('e');
		v.Add('e');
	}

}
