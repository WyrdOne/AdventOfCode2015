package com.wyrdworld.advent2015;

public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Day1.run(); // Change this line to run each day.
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		double seconds = duration / 1000000000D;
		System.out.format("Run Time was %.4f", seconds);
	}
}
