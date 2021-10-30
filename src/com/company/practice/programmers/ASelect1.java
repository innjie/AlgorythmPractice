package com.company.practice.programmers;

public class ASelect1 {

	public static void main(String[] args) {
		int[] answers = {1, 2, 3, 4, 5};

		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[][] pattern =  {
				{1, 2, 3, 4, 5},
				{2, 1, 2, 3, 2, 4, 2, 5},
				{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};

		int[] result = new int[3];
		for(int i = 0; i < answers.length; i++) {
			int a = answers[i];

			if(student1[i % student1.length] == a) {
				result[0]++;
			}
			if(student2[i % student2.length] == a) {
				result[1]++;
			}
			if(student3[i % student3.length] == a) {
				result[2]++;
			}
		}
		int max = 0;
		for(int a : result) {
			if (max < a) {
				max = a;
			}
		}
		int index = 0;
		int total = 0;
		for(int i = 0; i < result.length; i++) {
			if(result[i] == max) {
			}
		}

		int[] answer = new int[total];
		for(int i = 0; i < result.length; i++) {
			if(result[i] == max) {
				answer[index++] = i;
			}
		}


	}

}
