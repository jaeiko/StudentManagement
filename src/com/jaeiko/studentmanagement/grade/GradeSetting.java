package com.jaeiko.studentmanagement.grade;

// GradeSetting 클래스 : 입력된 학년의 숫자에 맞게 Grade 열거타입으로 바꿔주는 클래스
public class GradeSetting {
	public Grade setGradeByEnum(int grade) {
		Grade g = null;	// 주석 6 : 참조 타입(열거 타입) - 열거 타입 객체화
		switch(grade) {
		case 1:	// 1학년
			g = Grade.FIRST_GRADE;
			break;
		case 2:	// 2학년
			g = Grade.SECOND_GRADE;
			break;
		case 3:	// 3학년
			g = Grade.THIRD_GRADE;
			break;
		case 4:	// 4학년
			g = Grade.FOURTH_GRADE;
			break;
		case 5:	// 5학년
			g = Grade.FIFTH_GRADE;
			break;
		case 6:	// 6학년
			g = Grade.SIXTH_GRADE;
			break;
		default:	// 그 이외의 숫자를 입력했을 시 숫자 오류
			g = Grade.NUM_ERROR;
		}
		return g;
	}
}
