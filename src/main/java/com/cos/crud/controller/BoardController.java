package com.cos.crud.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;          
import com.cos.crud.service.BoardService;
import com.cos.crud.util.MyUtils;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//http://localhost:8000/board/
	@GetMapping("/")
	public String home() {
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String findAll(Model model){
		model.addAttribute("boards", boardService.findAll());
		return "index";
	}
	
	//ResponseBody -> MessageConvertor(Jackson bind)
	//RequestBody -> MessageConvertor(Jackson bind)
	//RequestBody가 없으면 x-www-form-urlencode를 파싱
	//RequestBody가 없으면 text를 파싱
	//RequestBody가 없으면 multipart데이터 이미지, 영상 - form-data

	
	
	@PostMapping("/create")
	public String create(Board board) {
		board.setUpdateDate(MyUtils.getCurrentTime());
		boardService.create(board);
		return "redirect:list";
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		board.setUpdateDate(MyUtils.getCurrentTime());
		boardService.create(board);
		return "redirect:list";
	}
	
	@PostMapping("/delete/{num}")
	public @ResponseBody int delete(@PathVariable int num) {
		int result = boardService.delete(num);
		return result;
	}
	
	//http://localhost:8000/board/2
	@GetMapping("/{num}")
	public String detail(@PathVariable int num, Model model) {
		Optional<Board> temp = boardService.detail(num);
		//숙제 null처리하기(Optional)
		if(temp.isPresent()) {
			Board board = temp.get();
			model.addAttribute("board", board);
			return "detail";
		}else {
			return "error";
		}	
	}
	
}
