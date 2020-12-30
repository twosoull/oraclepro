package com.javaex.phone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneApp {
	public static void main(String[] args) {
		boolean whileon = true;
		PhoneDao phoneDao = new PhoneDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("*************************************************");
		System.out.println("*           전화번호 관리 프로그램              *");
		System.out.println("*************************************************");

		while (whileon) {
			String enter = "";
			String name = "";
			String hp = "";
			String company = "";
			int personId = 0;
			PersonVo pv = null;
			int switchnum = 0;

			System.out.println("1.리스트 2.등록 3.수정 4.삭제 5.검색 6.종료");
			System.out.println("-------------------------------------------");
			System.out.print(">메뉴번호:");
			try {
				switchnum = sc.nextInt();
				if (switchnum < 1 || switchnum > 6) {
					System.out.println("[다시 입력해주세요.]");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("[메뉴 번호를 입력해주세요.]");
				sc.nextLine();
				continue;
			} // try-catch
				switch (switchnum) {

				case 1:
					System.out.println("<1.리스트>");
					phoneDao.phoneSelect();
					break;
				case 2:
					System.out.println("<2.등록>");
					enter = sc.nextLine();
					System.out.print("이름>");
					name = sc.nextLine();
					System.out.print("휴대전화>");
					hp = sc.nextLine();
					System.out.print("회사번호>");
					company = sc.nextLine();

					pv = new PersonVo(name, hp, company);
					phoneDao.phoneInsert(pv);

					break;
				case 3:
					System.out.println("<3.수정>");
					enter = sc.nextLine();
					System.out.print("번호>");
					personId = sc.nextInt();
					enter = sc.nextLine();
					System.out.print("이름>");
					name = sc.nextLine();
					System.out.print("휴대전화>");
					hp = sc.nextLine();
					System.out.print("회사번호>");
					company = sc.nextLine();

					pv = new PersonVo(personId, name, hp, company);
					phoneDao.phoneUpdate(pv);

					break;
				case 4:
					System.out.println("<4.삭제>");

					enter = sc.nextLine();
					System.out.print("번호>");
					personId = sc.nextInt();

					pv = new PersonVo(personId);

					phoneDao.phoneDelete(pv);

					break;
				case 5:
					System.out.println("<5.검색>");
					enter = sc.nextLine();
					System.out.print("검색어 >");
					String search = sc.nextLine();
					phoneDao.phoneSearch(search);

					break;
				case 6:
					System.out.println("*************************************************");
					System.out.println("*                   감사합니다                  *");
					System.out.println("*************************************************");
					whileon = false;
					break;

				}// switch
			
		} // while
	}// main
}
