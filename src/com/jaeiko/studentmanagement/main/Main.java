/* [주석 1 : 과제 설명]



  객체지향 프로그래밍 평가과제 (배점 25점)
  학과 : 컴퓨터공학부
  학번 : 202100946
  이름 : 김재준

  과제 주제 : 학교/학원용 학생 관리 프로그램

*/

package com.jaeiko.studentmanagement.main;

import java.util.Scanner;
import com.jaeiko.studentmanagement.program.AcademyProgram;
import com.jaeiko.studentmanagement.program.SchoolProgram;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

        // 주석 3 : 인터페이스 - 인터페이스 선언(다형성을 위해)
        ProgramRunner programRunner;
        
        // 학원용인지, 학교용인지 선택하면 그 형태에 맞게 프로그램이 실행
        while(true) {   
	        try {	// 주석 4 : 예외 처리
	        	System.out.print("이 프로그램을 학원용으로 사용하실려면 1을, 학교용으로 사용하실려면 2을 입력해주세요. 종료하실려면 0을 입력해주세요 : ");
		        int programNum = scan.nextInt();	// 학원용 : 1 | 학교용 : 2 | 프로그램 종료 : 0
		     // 주석 5 : 다형성(인터페이스) - 자동 타입 변환 : PrgramRunner 인터페이스를 구현한 AcademyProgram과 SchoolProgram 클래스들은 자신만의 방식으로 runProgram 메소드를 구현할 것
		        if (programNum == 1) {			// 학원용 프로그램 실행
		            programRunner = new AcademyProgram();
		            programRunner.runProgram(programNum);
		        } else if (programNum == 2){	// 학교용 프로그램 실행
		            programRunner = new SchoolProgram();
		            programRunner.runProgram(programNum);
		        } else if (programNum == 0){	// 프로그램 종료
		        	System.out.println("프로그램을 종료합니다.");
		        	scan.close();
		        	System.exit(0);
		        } else {
		        	System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		        }
	        } catch (Exception e) {
        	System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
        	scan.next(); // 남아있는 버퍼 제거
	        }
        }
	}
}
