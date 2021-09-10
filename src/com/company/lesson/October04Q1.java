package com.company.lesson;//10/4 ����
import java.util.Scanner;
public class October04Q1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//�м��� �Է¹��� (�и�, ����)
		double a = scan.nextInt();
		double b = scan.nextInt();
		
		printPath(b, a);
	}
	public static void printPath(double a, double b) {
		double lm = 1, ln = 1; //���� �и�, ����
		double rm = 1, rn = 1; //������ �и�, ����
		double km = 1, kn = 1; //������ġ
		
		//������� �����ϴ� ����
		while(true) {
			//��������
			if((a == km) && (b == kn)) {
				break;
			}
			if((b / a) < (kn / km)){ //ã�� ���� �� �������
				System.out.print("L"); //L ���
				
				if(kn == 1) { //�� �� Ư���� ���
					rm = lm;
					lm += 1;
					km = lm; kn = ln;
				}
				else {
					rm = km; rn = kn;
					km = rm + lm; kn = rn + ln;
				}
				
			}
			else { //ã�� ���� �� ū���
				System.out.print("R");
				
				if(km == 1) { //�� �� Ư���� ���
					ln = rn;
					rn += 1;
					km = rm; kn = rn;
				}
				else {
					lm = km; ln = kn;
					km = lm + rm; kn = ln + rn;
				}	
			}
		}
	}
}

