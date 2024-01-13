package com.jaeiko.studentmanagement.program;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.jaeiko.studentmanagement.main.StudentData;

// FileHandler 클래스 : 학생 리스트를 파일로 저장 또는 불러오는 클래스
public class FileHandler {
	String route = null;	// 루트
	public void saveStudentListToFile(int programNum, List<StudentData> list) throws Exception {
		setRoute(programNum);
		// 주석 8 : 파일 입출력 사용 : 객체 출력 스트림을 이용해서 list 출력
		FileOutputStream fos = new FileOutputStream(route);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	public List<StudentData> loadStudentListFromFile(int programNum) throws Exception {
		setRoute(programNum);
		// 주석 8 : 파일 입출력 사용 - 객체 입력 스트림을 이용해서 list 읽기
		FileInputStream fis = new FileInputStream(route);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
		List<StudentData> list = (List<StudentData>) ois.readObject();
		return list;
	}
	
	public void setRoute(int programNum) {	// setRoute : 학원용이면 AcademyStudentList.db | 학교용이면 SchoolStudentList.db로 설정하는 메소드
		if (programNum == 1)
			route = "C:/Temp/AcademyStudentList.db";
		else if (programNum == 2)
			route = "C:/Temp/SchoolStudentList.db";
	}
}
