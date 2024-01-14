package com.jaeiko.studentmanagement.program;

import java.text.SimpleDateFormat;
import java.util.List;

import com.jaeiko.studentmanagement.main.StudentData;

// DisplayManager 클래스 : 메뉴, 학생 목록 출력 담당 클래스
public class DisplayManager {
    public void displayMenu(int programNum) {	// displayMenu 메소드 : 메인 메뉴 출력 메소드
    	System.out.println("-------------------------------------------------------------" + (programNum == 1 ? "학원용" : "학교용") + " 학생 관리 프로그램----------------------------------------------------------");
    	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("1. 학생 추가   |   2. 학생 삭제   |   3. 학생 정보 수정   |   4. 학생 리스트 보기   |   5. 학생 리스트 파일 저장   |   6. 학생 리스트 파일 불러오기   |   7. 프로그램 종료");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("----------------------------주의 : 작업을 다 하시고 난 뒤에 꼭 파일로 저장해야 다음에 실행할 때 파일 불러오기를 통해 데이터를 불러올 수 있습니다!----------------------------");
    }
	
    public void displayStudentList(int programNum, List<StudentData> studentList) {	// displayStudentList 메소드 : 학생 리스트 출력 메소드
    	if (studentList.isEmpty()) {
    		System.out.println("학생 목록이 비워져 있습니다.");
    		return;
    	}
    	if (programNum == 1) {	//  학원용 메뉴 출력
    		System.out.println(" 등록ID\t|\t이름\t|\t\t계열/학년\t\t|     재학/휴학상태     |  \t등록날짜  \t");
    	} else if(programNum == 2) {	//  학교용 메뉴 출력
    		System.out.println("   학번\t|\t\t이름\t\t|  \t전공/학년  \t|   재학/휴학상태   |  \t등록날짜  \t");
    	}
    	// 학생 리스트 출력
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(StudentData sd : studentList) {
			System.out.println(
			sd.getStudentId() + "\t\t" + sd.getStudentName() + "\t\t" + 
					sd.getMajor() + " / " + sd.getGrade() + "\t\t" + sd.getState() + "\t\t" +
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
