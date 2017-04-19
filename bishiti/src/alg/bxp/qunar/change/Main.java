package alg.bxp.qunar.change;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		do {
			String line = s.nextLine();
			fun(line);
		}while(s.hasNext());
	}
	
	public static void fun(String line){
		int j = 0;
		int sum = 0;
		for(int i = line.length() - 1; i >= 0; i--){
			sum += (Character.toLowerCase(line.charAt(i)) - 97) * Math.pow(26, j);
			j ++;
		}
		System.out.println(sum);
	}
	
}
