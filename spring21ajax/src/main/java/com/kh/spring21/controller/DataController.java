package com.kh.spring21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring21.entity.ExamDto;
import com.kh.spring21.repository.ExamDao;

//데이터를 반환하는 컨트롤러를 만들려면 매 요청마다 @ReponseBody를 추가해야 한다.
//@RestController를 이용하면 모든 요청이 @ResponseBody 처리된다.

@RestController
@RequestMapping("/data")
public class DataController {
	
	@GetMapping("/")
	public String home() {
		return "home";//home.jsp가 아니고 home이라는 String data가 사용자에게 출력된다
	}
	
	@GetMapping("/data1")
	public String data1() {
		return String.valueOf(100);//특별한 설정이 없다면 이 값은 반환되기 어렵다(통신은 바이트or문자열만 가능)
	}
	
	@Autowired
	private ExamDao examDao;
	
	//@GetMapping("/data2")//유니코드가 명시적으로 정의되지 않아서 해석의 오해가 발생할 수 있음
	@GetMapping(value="/data2", produces = "text/plain; charset=UTF-8")
	public String data2(){
		return examDao.list().toString();
	}
	
	@GetMapping("/data3")
	public int data3() {
		return 100;
	}
	
	@GetMapping("/data4")
	public List<ExamDto> data4(){
		return examDao.list();
	}
	
	@GetMapping("/data5")
	public ExamDto data5(int examId) {
		return examDao.get(examId);
	}
	
	//페이지네이션 기능
	@GetMapping("/data6")
	public List<ExamDto> data6(
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		int endRow = page * size;
		int startRow = endRow - (size - 1);
		return examDao.listByPage(startRow, endRow);
	}
	
	//등록 기능
	@PostMapping("/data7")
	public void data7(@ModelAttribute ExamDto examDto){
		examDao.insert(examDto);
	}
	
}