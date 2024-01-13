package com.jaeiko.studentmanagement.main;

import java.io.Serializable;
import java.util.Date;

import com.jaeiko.studentmanagement.grade.Grade;
import com.jaeiko.studentmanagement.grade.GradeSetting;

// StudentData 클래스 : 학생과 관련된 필드와 생성자, 메소드 모여있는 클래스

// 주석 2 : 클래스 상속(inheritance) - GradeSetting 클래스를 상속받는 StudentData 클래스
// 주석 3 : 인터페이스 - 인터페이스 구현 클래스 선언(객체를 파일로 저장하거나, 네트워크로 전송하기 위해 Serializable 인터페이스 구현)
public class StudentData extends GradeSetting implements Serializable {
	private static final long serialVersionUID = 7139915303543451653L;	// serialVersionUID값 : 파일로 저장 할 때 해당하는 클래스의 버전이 맞는지를 확인하는 중요한 장치
	
	private int studentId;	// 학번
	private String studentName;	// 이름
	private String major;	// 전공/계열
	private Grade grade;	// 학년
	private Date date;	// 등록 날짜
	private String state;	// 학생 상태
	// 주석 6 : 참조 타입(배열) - 배열 선언
	private String stateArr[] = {"중학교 재학", "고등학교 재학", "대학교 재학", "휴학"};	// 학생 상태 배열
	
	// StudentId Getter & Setter
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentNumber) {
		this.studentId = studentNumber;
	}
	
	// studentName Getter & Setter : 학생 이름
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	// studentName Getter & Setter : 학생 전공/계열
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	// grade Getter & Setter : 학생 학년
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = setGradeByEnum(grade);
	}
	
	// state Getter & Setter : 학생 상태(중/고등/대학교 재학 & 휴학)
	public String getState() {
		return state;
	}
	public void setState(int i) {
		this.state = stateArr[i];
	}
	
	// date Getter & Setter : 학생 등록 날짜
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	
	// StudentData 생성자
	public StudentData(int studentId, String studentName, String major, int grade, int i, Date date) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.major = major;
		this.grade = setGradeByEnum(grade);
		this.state = stateArr[i];
		this.date = date;
	}
}
