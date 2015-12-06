package com.wyrdworld.advent2015;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day6 {
	public static void run() {
		byte lightGrid[][] = new byte[1000][1000];
		int brightGrid[][] = new int[1000][1000];
		
		try (BufferedReader br = new BufferedReader(new FileReader("Day6Input"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	int idx;
		    	for (idx=0; idx<line.length(); idx++)
		    		if ((line.charAt(idx)>='0') && (line.charAt(idx)<='9'))
		    			break;
		    	String strCoords[] = line.substring(idx).split(" through ");
		    	int startX = Integer.parseInt(strCoords[0].split(",")[0]);
		    	int startY = Integer.parseInt(strCoords[0].split(",")[1]);
		    	int endX = Integer.parseInt(strCoords[1].split(",")[0]);
		    	int endY = Integer.parseInt(strCoords[1].split(",")[1]);
		    	int mode = 0;
		    	if (line.startsWith("toggle")) {
		    		mode = -1;
		    	} else if (line.startsWith("turn on")) {
		    		mode = 1;
		    	}
		    	for (int x=startX;x<=endX;x++)
		    		for (int y=startY;y<=endY;y++)
		    			switch (mode) {
		    				case -1: lightGrid[x][y] ^= 0xFF; brightGrid[x][y] += 2; break;
		    				case 0: lightGrid[x][y] = 0; if (brightGrid[x][y]>0) brightGrid[x][y]--; break;
		    				case 1: lightGrid[x][y] = -1; brightGrid[x][y]++; break;
		    			}
		    }
		} catch (Exception ignored) {}
		int count = 0;
		int bright = 0;
		for (int x=0; x<1000; x++)
			for (int y=0; y<1000; y++) {
				if (lightGrid[x][y]!=0)
					count++;
				bright += brightGrid[x][y];
			}
		System.out.println("Advent Day 6 Puzzle 1 result is " + count);
		System.out.println("Advent Day 6 Puzzle 2 result is " + bright);
	}
}
