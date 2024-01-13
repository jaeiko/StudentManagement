package com.jaeiko.studentmanagement.program;

import java.text.SimpleDateFormat;
import java.util.List;

import com.jaeiko.studentmanagement.main.StudentData;

// DisplayManager 클래스 : 메뉴, 학생 목록 출력 담당 클래스
public class DisplayManager {
    public void displayMenu() {	// displayMenu 메소드 : 메인 메뉴 출력 메소드
    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("1. 학생 추가   |   2. 학생 삭제   |   3. 학생 정보 수정   |   4. 학생 리스트 보기   |   5. 학생 리스트 파일 저장   |   6. 학생 리스트 파일 불러오기   |   7. 프로그램 종료");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
    }
	
    public void displayStudentList(int programNum, List<StudentData> studentList) {	// displayStudentList 메소드 : 학생 리스트 출력 메소드
    	if (studentList.isEmpty()) {
    		System.out.println("학생 목록이 비워져 있습니다.");
    		return;
    	}
    	if (programNum == 1) {	//  학원용 메뉴 출력
    		System.out.println(" 등록ID |  이름  |       계열/학년       |    재학/휴학상태    |   등록날짜   ");
    	} else if(programNum == 2) {	//  학교용 메뉴 출력
    		System.out.println("   학번   |     이름     |        전공/학년        |     재학/휴학상태     |        등록날짜        ");
    	}
    	// 학생 리스트 출력
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(StudentData sd : studentList) {
			System.out.println(
			sd.getStudentId() + "\t" + sd.getStudentName() + "\t" + 
					sd.getMajor() + " / " + sd.getGrade() + "\t" + sd.getState() + "\t\t" +
					sdf.format(sd.getDate())
			);
		}
    }
    
    // ==== 에러 내용 출력 메소드 ====
    public void displayNotFoundError() {
        System.out.println("없는 정보입니다.");
    }
    public void displayInvalidOption() {
        System.out.println("유효하지 않은 옵션입니다.");
    }
}
