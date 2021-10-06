package com.company.practice.programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Greedy2 {

	public static void main(String[] args) {
		String name = "A";

		int total = 0;
		int flag = 1;
		for(int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);

			if(i > 0 && i < name.length() - 1) {
				if(ch != 'A') {
					flag = 0;
				}
			}
			if(ch == 'A') {
				;
			} else if(ch <= 'M') { //위로 카운트
				total += (ch - 'A');
			} else { //아래로 카운트
				total += ('Z' - ch + 1);
			}
			System.out.println("total : " + total);
		}

		if(flag == 1) { //except 0, n -> A
			total ++;
		} else {
			total += name.length() - 1;
		}
		System.out.println(total);
		

	}

}
