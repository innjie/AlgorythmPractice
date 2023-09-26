package com.company.practice.baekjoon.사칙연산;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * https://sillutt.tistory.com/entry/%EB%B0%B1%EC%A4%80JAVA-%ED%81%B0-%EC%88%98-AB?category=381696
 */
public class Q10757 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger A = new BigInteger(scan.next());
        BigInteger B = new BigInteger(scan.next());

        A = A.add(B);

        System.out.println(A);
    }
}
