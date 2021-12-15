package com.kh.spring21.repository;

import java.util.List;

import com.kh.spring21.entity.ExamDto;

public interface ExamDao {
	void insert(ExamDto examDto);
	
	List<ExamDto> list();
	List<ExamDto> search(String student);
	List<ExamDto> search(String column, String keyword);
	
	ExamDto get(int examId);
}