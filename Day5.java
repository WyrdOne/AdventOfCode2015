package com.wyrdworld.advent2015;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day5 {
	public static void run() {
		String vowels = "aeiou";
		int niceCount = 0;
		int newNiceCount = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("Day5Input"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	int vowelCount = 0;
		    	boolean dblFound = false;
		    	boolean dblDblFound = false;
		    	boolean dblSkipFound = false;
		    	for (int idx=0; idx<line.length(); idx++) {
		    		// puzzle 1
		    		if (vowels.indexOf(line.charAt(idx))>=0)
		    			vowelCount++;
		    		if ((idx>0) && (line.charAt(idx-1)==line.charAt(idx)))
		    			dblFound = true;
		    		// puzzle 2
		    		if (((idx+2)<line.length()) && line.substring(idx+2).contains(line.subSequence(idx, idx+2)))
		    			dblDblFound = true;
		    		if ((idx>1) && (line.charAt(idx-2)==line.charAt(idx)))
		    			dblSkipFound = true;
		    	}
		    	if (!(line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy"))) {
		    		if ((vowelCount>=3) && dblFound)
		    			niceCount++;
		    	}
		    	if (dblDblFound && dblSkipFound)
		    		newNiceCount++;
		    }
		} catch (Exception ignored) {}
		System.out.println("Advent Day 5 Puzzle 1 result is " + niceCount);
		System.out.println("Advent Day 5 Puzzle 2 result is " + newNiceCount);
	}
}
