package com.jaeiko.studentmanagement.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jaeiko.studentmanagement.main.ProgramRunner;
import com.jaeiko.studentmanagement.main.StudentData;

// SchooolProgram 클래스 : 학교용 학생 관리 프로그램
public class SchoolProgram extends DisplayManager implements ProgramRunner {	// 주석 3 : 인터페이스 - ProgramRunner 인터페이스 구현 클래스인 SchoolProgram 선언
	Scanner scan = new Scanner(System.in);

	String key;
	
	// 주석 7 : 컬렉션 프레임워크 - List 컬렉션(인터페이스)의 대표적 구현 클래스인 ArrayList 사용
	List<StudentData> studentList = new ArrayList<>();
	
	StudentManager studentManager = new StudentManager();
	DisplayManager displayManager = new DisplayManager();
	FileHandler fileHandler = new FileHandler();
	
    @Override
    public void runProgram(int programNum) {
        System.out.println("Running School Program...");
        // 학교용 프로그램 실행
		while(true) {
			displayManager.displayMenu(programNum);
			System.out.print("실행할 메뉴 번호를 입력하세요 : ");
			key = scan.next();
			System.out.println();
			switch(key) {
			case "1":	// 학생 추가
				try {	// 주석 4 : 예외 처리
					studentManager.addStudent(programNum, studentList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "2":	// 학생 삭제
				studentManager.deleteStudent(programNum, studentList);
				break;
			case "3": // 학생 정보 수정
				studentManager.findStudentForEdit(programNum, studentList);
				break;
			case "4":	// 학생 리스트 콘솔창에 출력
				displayManager.displayStudentList(programNum, studentList);
				break;
			case "5":	// 학생 목록 파일 저장/백업하기
				System.out.print("학생 목록을 파일로 저장하게 되면 기존에 있는 파일을 대체하게 됩니다. 계속 진행하시려면 1을, 메인 메뉴로 갈려면 아무 키를 입력해주세요. : ");
				key = scan.next();
				System.out.println();
					if (key.equals("1")) {
					try {	// 주석 4 : 예외 처리
						fileHandler.saveStudentListToFile(programNum, studentList);// List를 파일에 저장
						System.out.println("파일 저장 성공!");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("파일 저장 실패 에러. 에러 코드 : " + e.getMessage() + ". 다시 시도해주세요.");
					}
					} else {
						System.out.println("메인 메뉴로 돌아갑니다.");
						break;
					}
				break;
			case "6":	// 학생 목록 파일 불러오기
				System.out.print("학생 목록 파일로 불러오면 기존에 저장하지 않고 작업한 내용은 없어집니다. 계속 진행하시려면 1을, 메인 메뉴로 갈려면 아무 키를 입력해주세요. : ");
				key = scan.next();
				System.out.println();
					if (key.equals("1")) {
						try {	// 주석 4 : 예외 처리
							studentList = fileHandler.loadStudentListFromFile(programNum);	// 파일에 저장된 List 읽기
							System.out.println("파일 불러오기 성공!");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							displayNotFoundError();	// 불러올 파일 없으면 에러 출력
						}	
					} else {
						System.out.println("메인 메뉴로 돌아갑니다.");
						break;
					}
				break;
			case "7":	// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:	// 0~7 외의 값을 입력했을 경우 에러 출력
				displayInvalidOption();
				break;
				}
		}
	}
    
    // 주석 5 : 다형성(상속) - DisplayManager 클래스의 displayNotFoundError과 displayInvalidOption 메소드 재정의
    @Override
    public void displayNotFoundError() {
        System.out.println("현재 불러올 파일이 존재하지 않습니다. 메인 메뉴로 돌아갑니다.");
    }
    @Override
    public void displayInvalidOption() {
        System.out.println("유효하지 않은 옵션입니다. 다시 시도해주세요.");
    }
}