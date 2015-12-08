package com.wyrdworld.advent2015;

import java.io.*;
import java.util.*;

public class Day7 {
	public static void run() {
		Map<String, Integer> wires = new HashMap<String, Integer>();

    	while (!wires.containsKey("a")) {
    		try (BufferedReader br = new BufferedReader(new FileReader("Day7Input"))) {
    			String line;
			    while ((line = br.readLine()) != null) {
			    	String parts[] = line.split(" ");
			    	if (line.contains("NOT")) {
			    		if (wires.containsKey(parts[1])) {
		                    wires.put(parts[3], ~wires.get(parts[1]) & 0xFFFF);
		                }		    		
			    	} else if (line.contains("AND")) {
			    		if (Character.isDigit(parts[0].charAt(0))) {
			    			if (wires.containsKey(parts[2]))
			    				wires.put(parts[4], Integer.parseInt(parts[0]) & wires.get(parts[2]));
			    		} else if (wires.containsKey(parts[0]) && wires.containsKey(parts[2])) {
		                    wires.put(parts[4], wires.get(parts[0]) & wires.get(parts[2]));
			    		}
			    	} else if (line.contains("OR")) {
			    		if (Character.isDigit(parts[0].charAt(0))) {
			    			if (wires.containsKey(parts[2]))
			    				wires.put(parts[4], Integer.parseInt(parts[0]) | wires.get(parts[2]));
			    		} else if (wires.containsKey(parts[0]) && wires.containsKey(parts[2])) {
		                    wires.put(parts[4], wires.get(parts[0]) | wires.get(parts[2]));
			    		}
			    	} else if (line.contains("LSHIFT")) {
			    		if (wires.containsKey(parts[0])) {
		                    wires.put(parts[4], wires.get(parts[0]) << Integer.parseInt(parts[2]));
		                }		    		
			    	} else if (line.contains("RSHIFT")) {
			    		if (wires.containsKey(parts[0])) {
		                    wires.put(parts[4], wires.get(parts[0]) >> Integer.parseInt(parts[2]));
		                }		    		
			    	} else { // Signal
			    		if (Character.isDigit(parts[0].charAt(0))) {
			    			wires.put(parts[2], Integer.parseInt(parts[0]));
			    		} else {
				    		if (wires.containsKey(parts[0])) {
				    			wires.put(parts[2], wires.get(parts[0]));
				    		}
			    		}
			    	}
			    }
			    br.close();
    		} catch (Exception ignored) { ignored.printStackTrace(); }
    	}
		System.out.println("Advent Day 7 Puzzle 1 result is " + wires.get("a"));
		wires = new HashMap<String, Integer>();
		wires.put("b", 3176);
    	while (!wires.containsKey("a")) {
    		try (BufferedReader br = new BufferedReader(new FileReader("Day7Input"))) {
    			String line;
			    while ((line = br.readLine()) != null) {
			    	String parts[] = line.split(" ");
			    	if (line.contains("NOT")) {
			    		if (wires.containsKey(parts[1])) {
		                    wires.put(parts[3], ~wires.get(parts[1]) & 0xFFFF);
		                }		    		
			    	} else if (line.contains("AND")) {
			    		if (Character.isDigit(parts[0].charAt(0))) {
			    			if (wires.containsKey(parts[2]))
			    				wires.put(parts[4], Integer.parseInt(parts[0]) & wires.get(parts[2]));
			    		} else if (wires.containsKey(parts[0]) && wires.containsKey(parts[2])) {
		                    wires.put(parts[4], wires.get(parts[0]) & wires.get(parts[2]));
			    		}
			    	} else if (line.contains("OR")) {
			    		if (Character.isDigit(parts[0].charAt(0))) {
			    			if (wires.containsKey(parts[2]))
			    				wires.put(parts[4], Integer.parseInt(parts[0]) | wires.get(parts[2]));
			    		} else if (wires.containsKey(parts[0]) && wires.containsKey(parts[2])) {
		                    wires.put(parts[4], wires.get(parts[0]) | wires.get(parts[2]));
			    		}
			    	} else if (line.contains("LSHIFT")) {
			    		if (wires.containsKey(parts[0])) {
		                    wires.put(parts[4], wires.get(parts[0]) << Integer.parseInt(parts[2]));
		                }		    		
			    	} else if (line.contains("RSHIFT")) {
			    		if (wires.containsKey(parts[0])) {
		                    wires.put(parts[4], wires.get(parts[0]) >> Integer.parseInt(parts[2]));
		                }		    		
			    	} else { // Signal
			    		if (Character.isDigit(parts[0].charAt(0))) {
				    		if (!parts[2].equals("b"))
				    			wires.put(parts[2], Integer.parseInt(parts[0]));
			    		} else {
				    		if (wires.containsKey(parts[0])) {
				    			wires.put(parts[2], wires.get(parts[0]));
				    		}
			    		}
			    	}
			    }
			    br.close();
    		} catch (Exception ignored) { ignored.printStackTrace(); }
    	}
		System.out.println("Advent Day 7 Puzzle 2 result is " + wires.get("a"));
	}
}
