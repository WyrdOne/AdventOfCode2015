package com.wyrdworld.advent2015;

import java.io.*;

public class Day2 {
	public static void run() {
		int paperTotal = 0;
		int ribbonTotal = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader("Day2Input"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String dimensions[] = line.split("x");
		    	int l = Integer.valueOf(dimensions[0]);
		    	int w = Integer.valueOf(dimensions[1]);
		    	int h = Integer.valueOf(dimensions[2]);
		    	if (l>w) {
		    		int t = l;
		    		l = w;
		    		w = t;
		    	}
		    	if (w>h) {
		    		int t = w;
		    		w = h;
		    		h = t;
		    	}
		    	if (l>h) {
		    		int t = l;
		    		l = h;
		    		h = t;
		    	}
		    	int side1 = l*w;
		    	int side2 = w*h;
		    	int side3 = h*l;
		    	paperTotal += (2 * (side1 + side2 + side3)) + side1;
		    	ribbonTotal += (l*2 + w*2);
		    	ribbonTotal += (l*w*h); // Bow
		    }
		} catch (Exception dump) {
			dump.printStackTrace();
		}		
		System.out.println("Advent Day 2 Puzzle 1 result is " + paperTotal);
		System.out.println("Advent Day 2 Puzzle 2 result is " + ribbonTotal);
	}
}
