package de.konry.adoc2k6.tasks.days;

import de.konry.adoc2k6.tasks.AdventOfCodeExtends;

public class DayTwo extends AdventOfCodeExtends {

	@Override
	public void runPartOne() {
		int[] coordinates = new int[]{1,1};
		//System.out.println("Start-"+coordinates[0] + " - " + coordinates[1] + " decode "+ decode(coordinates));
		
		for (String s : lines){
			for(int i = 0; i < s.length() ; i++){
				String temp = s.substring(i, i+1);
				switch (temp){
				case "U":
					if(coordinates[1] > 0 ){
						coordinates[1]--;
					}
					break;
				case "D":
					if(coordinates[1] < 2 ){
						coordinates[1]++;
					}
					break;
				case "L":
					if(coordinates[0] > 0){
						coordinates[0]--;
					}
					break;
				case "R":
					if(coordinates[0] < 2 ){
						coordinates[0]++;
					}
					break;
					
				}
				//System.out.println("take "+temp +" "+coordinates[0] + " - " + coordinates[1] + " decode "+ decode(coordinates));
			}
			System.out.println(coordinates[0] + " - " + coordinates[1] + " decode "+ decode(coordinates));
		}
		// result 1 44558 30 min rank 926
	}
	
	public int decode(int[] coords){
		if(coords[1] == 0 && coords[0] == 0){
			return 1;
		} else if(coords[1] == 0 && coords[0] == 1){
			return 2;
		} else if(coords[1] == 0 && coords[0] == 2){
			return 3;
		} else if(coords[1] == 1 && coords[0] == 0){
			return 4;
		} else if(coords[1] == 1 && coords[0] == 1){
			return 5;
		} else if(coords[1] == 1 && coords[0] == 2){
			return 6;
		} else if(coords[1] == 2 && coords[0] == 0){
			return 7;
		} else if(coords[1] == 2 && coords[0] == 1){
			return 8;
		} else if(coords[1] == 2 && coords[0] == 2){
			return 9;
		}
		return -1;
	}
	

	public String decodeTwo(int[] coords){
		if(coords[1] == 0 && coords[0] == 2){
			return "1";
		} else if(coords[1] == 1 && coords[0] == 1){
			return "2";
		} else if(coords[1] == 1 && coords[0] == 2){
			return "3";
		} else if(coords[1] == 1 && coords[0] == 3){
			return "4";
		} else if(coords[1] == 2 && coords[0] == 0){
			return "5";
		} else if(coords[1] == 2 && coords[0] == 1){
			return "6";
		} else if(coords[1] == 2 && coords[0] == 2){
			return "7";
		} else if(coords[1] == 2 && coords[0] == 3){
			return "8";
		} else if(coords[1] == 2 && coords[0] == 4){
			return "9";
		} else if(coords[1] == 3 && coords[0] == 1){
			return "A";
		} else if(coords[1] == 3 && coords[0] == 2){
			return "B";
		} else if(coords[1] == 3 && coords[0] == 3){
			return "C";
		} else if(coords[1] == 4 && coords[0] == 2){
			return "D";
		}
		return "-1";
	}

	@Override
	public void runPartTwo() {
		int[] coordinates = new int[]{0,2};
		//System.out.println("Start-"+coordinates[0] + " - " + coordinates[1] + " decode "+ decodeTwo(coordinates));
		
		for (String s : lines){
			for(int i = 0; i < s.length() ; i++){
				String temp = s.substring(i, i+1);
				switch (temp){
				case "U":
					if(coordinates[1] > 1 && coordinates[0] >= 1 && coordinates[0] <= 3 || coordinates[1] == 1 && coordinates[0] == 2){
						coordinates[1]--;
					}
					break;
				case "D":
					if(coordinates[1] < 3 && coordinates[0] >= 1 && coordinates[0] <= 3 || coordinates[1] == 3 && coordinates[0] == 2){
						coordinates[1]++;
					}
					break;
				case "L":
					if(coordinates[0] > 1 && coordinates[1] >= 1 && coordinates[1] <= 3 || coordinates[0] == 1 && coordinates[1] == 2){
						coordinates[0]--;
					}
					break;
				case "R":
					if(coordinates[0] < 3 && coordinates[1] >= 1 && coordinates[1] <= 3 || coordinates[0] == 3 && coordinates[1] == 2){
						coordinates[0]++;
					}
					break;
					
				}
				//System.out.println("take "+temp +" "+coordinates[0] + " - " + coordinates[1] + " decode "+ decodeTwo(coordinates));
			}
			System.out.println(coordinates[0] + " - " + coordinates[1] + " decode "+ decodeTwo(coordinates));
		}
		// result 2 66BBAD 17 min rank 810

	}

	@Override
	public void runTestsOne() {
		String[] temp = new String[]{"ULL","RRDDD","LURDL","UUUUD" };
		runPartOne(temp, ChooseSet.Lines);
		
	}

	@Override
	public void runTestsTwo() {

		String[] temp = new String[]{"ULL","RRDDD","LURDL","UUUUD" };
		runPartTwo(temp, ChooseSet.Lines);

	}

}
