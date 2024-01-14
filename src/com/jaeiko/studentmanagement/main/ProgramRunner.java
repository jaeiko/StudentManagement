package com.jaeiko.studentmanagement.main;

// ProgramRunner 인터페이스 : 이 인터페이스를 통해서 개발 코드는 AcademyProgram과 ShooolProgram 클래스와 서로 통신.
// 주석 3 : 인터페이스 - ProgramRunner 인터페이스 정의
public interface ProgramRunner {
    void runProgram(int programNum);
}