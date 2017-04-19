package alg.bxp.jd.zuoti;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		String[] a = s.nextLine().split(" ");
		int zq = (int) Math.ceil(num * 0.6);

		double xs = 0;
		for (int i = zq; i <= num; i++) {
			xs += fun(num, i);
		}
		double gl = 1;
		for (int i = 0; i < a.length; i++) {
			gl *= Double.parseDouble(a[i]) * 0.01;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(df.format(xs * gl));
	}

	private static double fun(int num, int zq) {
		return jiechen(num) / jiechen(zq);
	}

	private static double jiechen(int num) {
		if (num == 1)
			return 1d;
		else {
			if (num > 1) {
				return num * jiechen(num - 1);
			}
			return 1d;
		}
	}

	public static String formatDouble(double d) {
		return String.format("%.5f", d);
	}
}
