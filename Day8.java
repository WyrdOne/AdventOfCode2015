package com.wyrdworld.advent2015;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day8 {
	public static void run() {
		int codeCount = 0;
		int memCount = 0;
		int newCount = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("Day8Input"))) {
			String line;
		    while ((line = br.readLine()) != null) {
		    	codeCount += line.length();
		    	for (int idx=1; idx<line.length()-1; idx++) {
		    		if (line.charAt(idx)=='\\') {
		    			if (line.charAt(idx+1)=='x') {
				    		idx += 3;
				    	} else {
				    		idx++;
				    	}
		    		}
		    		memCount++;
		    	}
		    	// puzzle 2
		    	StringBuilder newStr = new StringBuilder();
		    	newStr.append('"');
		    	for (int idx=0; idx<line.length(); idx++) {
		    		if (line.charAt(idx)=='"') {
		    			newStr.append("\\\"");
		    		} else if (line.charAt(idx)=='\\') {
		    			newStr.append("\\\\");
		    		} else {
		    			newStr.append(line.charAt(idx));
		    		}
		    	}
		    	newStr.append('"');
		    	newCount += newStr.length();
		    }
		} catch (Exception ignored) { ignored.printStackTrace(); }
		System.out.println("Advent Day 8 Puzzle 1 result is " + (codeCount - memCount));
		System.out.println("Advent Day 8 Puzzle 2 result is " + (newCount - codeCount));
	}
}
