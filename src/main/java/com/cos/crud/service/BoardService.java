package com.cos.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cos.crud.model.Board;
import com.cos.crud.repository.BoardRepository;

//Controller, Service, RestController, Component
//Repository
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public Board create(Board board) {
		//findAll(), findById(), save(), delete()
		return boardRepository.save(board);
	}                                                            
	
	public List<Board> findAll() {
		return boardRepository.findAll();
	}
	
	//jsp 삭제 -> primary key
	//spring -> entity -> board
	//spring -> id
	public int delete(int num) {
		try {
			boardRepository.deleteById(num);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}		
	}
	
	public Optional<Board> detail(int num) {
		return boardRepository.findById(num);
	}
	
}
