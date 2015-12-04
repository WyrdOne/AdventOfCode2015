package com.wyrdworld.advent2015;

import java.security.*;

public class Day4 {
	private static MessageDigest md;
	private static String input = "bgvyzdsv";
	
	private static byte[] MD5(String s) {
		if (md==null)
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (Exception dumped) {
				dumped.printStackTrace();
			}
		md.reset();
		md.update(s.getBytes());
		return md.digest();
	}
	
	public static void run() {
		int idx = 1;
		byte hash[];

		while (true) {
			hash = MD5(input+idx);
			if ((hash[0]==0) && (hash[1]==0) && ((hash[2] & 0xF0)==0))
				break;
			idx++;
		}
		System.out.println("Advent Day 4 Puzzle 1 result is " + idx);
		while (true) {
			hash = MD5(input+idx);
			if ((hash[0]==0) && (hash[1]==0) && (hash[2]==0))
				break;
			idx++;
		}
		System.out.println("Advent Day 4 Puzzle 2 result is " + idx);
	}
}
