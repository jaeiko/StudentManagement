2023 겨울계절학기 객체지향프로그래밍 과제

과제 주제 : 학교/학원용 학생 관리 프로그램

<과제 설명>
이 프로그램은 학교/학원용 학생들을 모아서 리스트로 관리하는 프로그램이다.
학교용으로 실행하면 이용자(관리자)가 직접 학생의 학번을 추가해서 관리하는 식으로,
학원용으로 실행하면 프로그램 내에서 학생의 고유 ID을 부여하는 식으로 구성을 했다.
이 프로그램으로 학생의 정보(전공/계열, 학년, 재학/휴학 등)를 리스트에 저장을 하고, 컴퓨터 내 파일로 저장하거나 불러올 수 있다.

<과제 구성>
[학생관리 프로그램 기본 기능]

1. 학생 추가
2. 학생 삭제
3. 학생 정보 수정
4. 학생 리스트 보기
5. 학생 리스트 파일 저장
6. 학생 리스트 파일 불러오기
7. 프로그램 종료

<파일 구성>

1. com.jaeiko.studentmanagement.grade 패키지
   - Grade.java
   - GradeSetting.java
2. com.jaeiko.studentmanagement.main 패키지
   - Main.java
   - ProgramRunner.java
   - StudentData.java
3. com.jaeiko.studentmanagement.program 패키지
   - AcademyProgram.java
   - SchoolProgram.java
   - DisplayManager.java
   - FileHandler.java
   - StudentManager.java
