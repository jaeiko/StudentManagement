package com.jaeiko.studentmanagement.program;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.jaeiko.studentmanagement.main.StudentData;

// StudentManager 클래스 : 학생 추가 / 학생 삭제 / 학생 수정 관련 클래스
public class StudentManager extends DisplayManager{
	Scanner scan = new Scanner(System.in);
	
	// StudentManager 필드
	private int studentId = 0;			// 학생 ID(학번)
	private int stateNum = 0;			// 학생 상태(중/고등/대학교 | 재학/휴학)
	private String studentName = null;	// 학생 이름
	private String major = null;		// 학생 계열 / 전공
	private int grade = 0;				// 학년
	private String key = null;			// key(if/switch문 이용할 때 사용)
	
	// 학생 추가 메소드
	public void addStudent(int programNum, List<StudentData> studentList) {
	    try {	// 주석 4 : 예외 처리
	        System.out.print("학생의 이름을 입력해주세요. : ");
	        studentName = scan.next();

	        if (programNum == 1) { // 학원용일 경우 고유 ID값 추가
	            studentId += 1; // 학생 고유 번호(1씩 증가)
	            System.out.print("학생의 학과 또는 계열을 입력해주세요. : ");
	            major = scan.next();
	        } else if (programNum == 2) { // 학교용일 경우 학생의 학번 9자리 입력
	            while (true) {
	                System.out.print("학생의 학번을 입력해주세요.(숫자 9자리) : ");
	                try {	// 주석 4 : 예외 처리
	                    studentId = scan.nextInt();
	                    if (String.valueOf(studentId).length() != 9) {
	                        System.out.println("9자리로 다시 입력해주세요.");
	                    } else {
	                    	// 학번 중복 검사
	                        boolean isDuplicate = false;
	                        for (int i = 0; i < studentList.size(); i++) {
	                            if (studentId == studentList.get(i).getStudentId()) {
	                                System.out.println("학번이 중복됩니다! 다시 시도해주세요.");
	                                isDuplicate = true;
	                                break;
	                            }
	                        }
	                        if (!isDuplicate) {	// 중복 검사 통과될 경우 다음 단계로 진행
	                            System.out.print("학생의 학과를 입력해주세요. : ");
	                            major = scan.next();
	                            break;
	                        }
	                    }
	                } catch (Exception e) {	// 잘못된 값을 입력 받았을 시 오류 출력
	                    System.out.println("올바른 숫자를 입력해주세요.");
	                    scan.next(); // 버퍼를 비우기 위해 추가
	                }
	            }
	        }

	        System.out.print("학생의 학년을 입력해주세요.(ex. 1학년이면 1만 입력) : ");
	        grade = scan.nextInt();
	        System.out.print("학생의 재학/휴학 상태을 입력해주세요.(0 : 중학교 재학 / 1 : 고등학교 재학 / 2: 대학교 재학 / 3: 휴학) :  ");
	        stateNum = scan.nextInt();
	        studentList.add(new StudentData(studentId, studentName, major, grade, stateNum, new Date())); // 새 학생 정보 StudentData에 추가
	        System.out.println();
	        System.out.println("학생 등록 완료!");
	    } catch (Exception e) {
	        System.out.println("에러가 발생했습니다: " + e.getMessage());
	    }
	}
    
    // 학생 삭제 메소드
	public void deleteStudent(int programNum, List<StudentData> studentList) {
	    try {	// 주석 4 : 예외 처리
	        if (studentList.isEmpty()) {
	            System.out.println("현재 학생 리스트가 비워져 있습니다. 학생 정보를 추가한 후 다시 시도해주세요.");
	            return;
	        }

	        if (programNum == 1) {
	            System.out.print("삭제하고 싶은 학생의 ID을 입력해주세요. : ");
	        } else if (programNum == 2) {
	            System.out.print("삭제하고 싶은 학생의 학번을 입력해주세요. : ");
	        }

	        studentId = scan.nextInt();

	        Iterator<StudentData> iterator = studentList.iterator();
	        boolean studentFound = false;

	        while (iterator.hasNext()) {
	            StudentData student = iterator.next();
	            if (studentId == student.getStudentId()) {
	                iterator.remove();
	                System.out.println("삭제되었습니다!");
	                studentFound = true;
	                break;
	            }
	        }

	        if (!studentFound) {
	            displayNotFoundError();
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("올바른 숫자를 입력해주세요.");
	        scan.next(); // 버퍼를 비우기 위해 추가
	    } catch (Exception e) {
	        System.out.println("에러가 발생했습니다. 에러 메세지: " + e.getMessage() + ". 다시 시도해주세요.");
	    }
	}
    
    // findStudentForEdit 메소드 : 수정할 학생을 찾는 메소드
    public void findStudentForEdit(int programNum, List<StudentData> studentList) {
        System.out.println();

        if (studentList.isEmpty()) {
            System.out.println("현재 학생 리스트가 비워져 있습니다. 학생 정보를 추가한 후 다시 시도해주세요.");
            return;
        }

        System.out.print("수정할 학생의 " + (programNum == 1 ? "ID" : "학번") + "을 입력하세요. : ");
        studentId = scan.nextInt();

        // 수정하고자 하는 학생이 존재하는지 확인
        for (int i = 0; i < studentList.size(); i++) {
            if (studentId == studentList.get(i).getStudentId()) {	// 존재하면 editStudentDetails() 메소드 호출
                editStudentDetails(programNum, studentList.get(i));
                return;
            } else {	// 존재하지 않으면 에러 출력
                displayNotFoundError();
            }
        }
    }
    
    // editStudentDetails 메소드 : 학생 정보 수정 메소드
    private void editStudentDetails(int programNum, StudentData student) {
        try {	// 주석 4 : 예외 처리
            System.out.print("수정하실 항목을 선택하세요. ");
            if (programNum == 1) {	// 학원용(ID 수정 X : 학생 목록에 등록된 고유값이므로)
                System.out.print("(1)이름     (2)전공/계열     (3)학년    (4) 재학/휴학 상태 : ");
            } else if (programNum == 2) {	// 학교용
                System.out.print("(0)학번     (1)이름     (2)전공     (3)학년     (4) 재학/휴학 상태 : ");
            }
            key = scan.next();
            System.out.println();

            switch (key) {
                case "0":	// (학교용)학번 변경
                    if (programNum == 2) {
                        System.out.print("학번을 새로 입력하세요. : ");
                        studentId = scan.nextInt();
                        student.setStudentId(studentId);
                    } else {	// 학원용인데 메뉴 0을 입력한 경우 에러 출력
                        displayInvalidOption();
                    }
                    break;
                case "1":	// 이름 변경
                    System.out.print("이름을 새로 입력하세요. : ");
                    studentName = scan.next();
                    student.setStudentName(studentName);
                    break;
                case "2":	// 전공/계열 변경
                    System.out.print("전공/계열을 새로 입력하세요. : ");
                    major = scan.next();
                    student.setMajor(major);
                    break;
                case "3":	// 학년 변경
                    System.out.print("학년을 새로 입력하세요. : ");
                    grade = scan.nextInt();
                    student.setGrade(grade);
                    break;
                case "4":	// 재학/휴학 상태 변경
                    System.out.print("학생의 재학/휴학 상태를 새로 입력하세요.(0 : 중학교 재학 / 1 : 고등학교 재학 / 2 : 대학교 재학 / 3 : 휴학) : ");
                    stateNum = scan.nextInt();
                    student.setState(stateNum);
                    break;
                default:	// 0, 1, 2, 3, 4 외의 다른 값을 입력한 경우 에러 출력
                    displayInvalidOption();
                    break;
            }
        } catch (Exception e) {
            System.out.println("올바른 값을 입력해주세요.");
            scan.nextLine(); 
        }
    }


    
    // 주석 5 : 다형성(상속) - DisplayManager 클래스의 displayNotFoundError과 displayInvalidOption 메소드 재정의
    @Override
    public void displayNotFoundError() {
        System.out.println("해당 학생이 없습니다. 다시 시도해주세요.");
    }
    @Override
    public void displayInvalidOption() {
        System.out.println("유효하지 않은 옵션입니다. 다시 시도해주세요.");
    }
}
